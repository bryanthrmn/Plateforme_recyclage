/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pfiches;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Bryan
 */
public class FCOLLECTE extends javax.swing.JFrame {
public FCOLLECTE() {
    initComponents();
    this.setSize(1980, 1080); 
    mettreAJourAffichageDemandes();
}

private void mettreAJourAffichageDemandes() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Réinitialise le tableau

    ArrayList<String> typesAcceptes = new ArrayList<>();

    // Lecture des types de déchets acceptés par le centre
    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("utilisateurs.txt"), StandardCharsets.UTF_8))) {
        String ligne;
        while ((ligne = br.readLine()) != null) {
            String[] parts = ligne.split(";");
            if (ligne.startsWith("CENTRE") && parts.length > 9 && parts[2].equals(FAccueil.mailEntreprise)) {
                for (int i = 9; i < parts.length; i++) {
                    typesAcceptes.add(parts[i].trim());
                }
                break;
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la lecture de utilisateurs.txt", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    ArrayList<Integer> lignesAGriser = new ArrayList<>();
    String filtre = (String) jComboBox1.getSelectedItem();

    class Demande {
        String nom, date, statut, adresse, type, poids, commentaire;
        public Demande(String nom, String date, String statut, String adresse, String type, String poids, String commentaire) {
            this.nom = nom;
            this.date = date;
            this.statut = statut;
            this.adresse = adresse;
            this.type = type;
            this.poids = poids;
            this.commentaire = commentaire;
        }
    }

    ArrayList<Demande> listeDemandes = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("demandes.txt"), StandardCharsets.UTF_8))) {
        String ligne;
        while ((ligne = br.readLine()) != null) {
            String[] parts = ligne.split(";");
            if (parts.length >= 5) {
                String email = parts[0].trim();
                String type = parts[1].trim();
                String poids = parts[2].trim();
                String date = parts[3].trim();
                String statut = parts[4].trim();
                String commentaire = (parts.length >= 6) ? parts[5].trim() : "";

                if (typesAcceptes.stream().noneMatch(t -> t.equalsIgnoreCase(type))) continue;

                // Infos entreprise
                String nomEntreprise = "Inconnu";
                String adresseEntreprise = "";
                try (BufferedReader brU = new BufferedReader(new InputStreamReader(new FileInputStream("utilisateurs.txt"), StandardCharsets.UTF_8))) {
                    String ligneU;
                    while ((ligneU = brU.readLine()) != null) {
                        if (ligneU.startsWith("ENTREPRISE")) {
                            String[] partsU = ligneU.split(";");
                            if (partsU.length >= 3 && partsU[2].trim().equals(email)) {
                                nomEntreprise = partsU[1].trim();
                                if (partsU.length >= 5) {
                                    adresseEntreprise = partsU[4].trim();
                                }
                                break;
                            }
                        }
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Erreur de lecture utilisateurs.txt (entreprises)", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

                listeDemandes.add(new Demande(nomEntreprise, date, statut, adresseEntreprise, type, poids, commentaire));
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur de lecture du fichier demandes.txt", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Tri si nécessaire
    if (!"Tous".equals(filtre)) {
        Comparator<Demande> comparator = switch (filtre) {
            case "Nom" -> Comparator.comparing(d -> d.nom.toLowerCase());
            case "Date croissant" -> Comparator.comparing(d -> LocalDate.parse(d.date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            case "Date décroissant" -> Comparator.comparing((Demande d) -> LocalDate.parse(d.date, DateTimeFormatter.ofPattern("dd/MM/yyyy"))).reversed();
            case "Poids" -> Comparator.comparingDouble(d -> Double.valueOf(d.poids.replace(" kg", "")));
            default -> null;
        };
        if (comparator != null) listeDemandes.sort(comparator);
    }

    // Ajout au tableau avec filtrage
    for (Demande d : listeDemandes) {
        if ("Statut".equals(filtre) && (d.statut.equalsIgnoreCase("Accepté") || d.statut.equalsIgnoreCase("Refusé"))) continue;
        if ("Type de déchet".equals(filtre) && typesAcceptes.stream().noneMatch(t -> t.equalsIgnoreCase(d.type))) continue;

        model.addRow(new Object[]{d.nom, d.date, d.statut, d.adresse, d.type, d.poids + " kg", d.commentaire});

        if (d.statut.equalsIgnoreCase("À venir") || d.statut.equalsIgnoreCase("Planifié")) {
            lignesAGriser.add(model.getRowCount() - 1);
        }
    }

    // Renderer pour griser certaines lignes
    jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setForeground(lignesAGriser.contains(row) ? Color.GRAY : Color.BLACK);
            c.setBackground(isSelected ? new Color(184, 207, 229) : Color.WHITE);
            return c;
        }
    });

    // Affichage ou message si aucune demande
    if (model.getRowCount() > 0) {
        jButton3.setVisible(true);
        jButton4.setVisible(true);
    } else {
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        model.addRow(new Object[]{"Aucune demande", "", "", "", "", "", ""});
    }

    jTable1.repaint();
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Background = new javax.swing.JPanel();
        jfirst_font = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel_LOGO = new javax.swing.JLabel();
        jButton_retour = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_Background.setBackground(new java.awt.Color(0, 0, 0));
        jPanel_Background.setPreferredSize(new java.awt.Dimension(1280, 1024));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("GESTION DES DEMANDES");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jfirst_fontLayout = new javax.swing.GroupLayout(jfirst_font);
        jfirst_font.setLayout(jfirst_fontLayout);
        jfirst_fontLayout.setHorizontalGroup(
            jfirst_fontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfirst_fontLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
        );
        jfirst_fontLayout.setVerticalGroup(
            jfirst_fontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfirst_fontLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel_LOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pfiches/EPF_LOGO (2).png"))); // NOI18N

        jButton_retour.setBackground(new java.awt.Color(255, 0, 51));
        jButton_retour.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton_retour.setForeground(new java.awt.Color(255, 255, 255));
        jButton_retour.setText("Retour");
        jButton_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_retourActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 255, 204));
        jTable1.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Entreprise", "Date", "Statut", "Adresse", "Type de déchet", "Poids (KG)", "Commentaire"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel1.setText("Filtrer par Type");

        jButton2.setBackground(new java.awt.Color(0, 204, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Rechercher");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tous", "Nom", "Date croissant", "Date décroissant", "Type de déchet", "Statut", "Poids" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
        );

        jButton3.setBackground(new java.awt.Color(51, 204, 0));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Obtenir des informations");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 204, 0));
        jButton4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Gérer une demande");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_BackgroundLayout = new javax.swing.GroupLayout(jPanel_Background);
        jPanel_Background.setLayout(jPanel_BackgroundLayout);
        jPanel_BackgroundLayout.setHorizontalGroup(
            jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_BackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jfirst_font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(398, 398, 398)
                .addComponent(jLabel_LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(383, 383, 383))
            .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                .addGroup(jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton_retour, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addGroup(jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                            .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(48, 48, 48)
                .addGroup(jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(398, 398, 398))
        );
        jPanel_BackgroundLayout.setVerticalGroup(
            jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                .addGroup(jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jfirst_font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel_LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                .addComponent(jButton_retour, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_Background, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_retourActionPerformed
    this.dispose();
    }//GEN-LAST:event_jButton_retourActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne.", "Aucune sélection", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String nomEntreprise = jTable1.getValueAt(selectedRow, 0).toString();
    String date = jTable1.getValueAt(selectedRow, 1).toString();
    String statut = jTable1.getValueAt(selectedRow, 2).toString();
    String adresse = jTable1.getValueAt(selectedRow, 3).toString();
    String type = jTable1.getValueAt(selectedRow, 4).toString();
    String poids = jTable1.getValueAt(selectedRow, 5).toString().replace(" kg", "");
    String commentaire = jTable1.getValueAt(selectedRow, 6).toString();

    String mail = "";
    String tel = "";

    // Recherche des infos entreprise
    try (BufferedReader br = new BufferedReader(new FileReader("utilisateurs.txt"))) {
        String ligne;
        while ((ligne = br.readLine()) != null) {
            if (ligne.startsWith("ENTREPRISE")) {
                String[] parts = ligne.split(";");
                if (parts.length >= 6 && parts[1].equals(nomEntreprise)) {
                    mail = parts[2];
                    tel = parts[5];
                    break;
                }
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la lecture de utilisateurs.txt", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Création du panneau d'information
    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(new JLabel("Nom : " + nomEntreprise));
    panel.add(new JLabel("Adresse : " + adresse));
    panel.add(new JLabel("Téléphone : " + tel));
    panel.add(new JLabel("Mail : " + mail));
    panel.add(new JLabel("Date de demande : " + date));
    panel.add(new JLabel("Statut : " + statut));
    panel.add(new JLabel("Poids : " + poids + " kg"));
    panel.add(new JLabel("Type de déchet : " + type));
    panel.add(new JLabel("Commentaire : " + commentaire));

    JButton btnHistorique = new JButton("Voir l'historique");
    panel.add(btnHistorique);

    final String mailFinal = mail; // pour l'utiliser dans le lambda

    btnHistorique.addActionListener((ActionEvent e) -> {
        StringBuilder historique = new StringBuilder("Historique des demandes de " + nomEntreprise + " :\n\n");
        try (BufferedReader br = new BufferedReader(new FileReader("demandes.txt"))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split(";");
                if (parts.length >= 5 && parts[0].equals(mailFinal)) {
                    String type1 = parts[1];
                    String poids1 = parts[2];
                    String date1 = parts[3];
                    String statut1 = parts[4];
                    String commentaire1 = (parts.length >= 6) ? parts[5] : "";
                    String entrepriseDecision = (parts.length >= 7) ? parts[6] : ""; // pour qui a pris la décision (si ajouté)
                    historique.append("• Date : ").append(date1).append(" | Type : ").append(type1).append(" | Charge : ").append(poids1).append(" kg").append(" | Statut : ").append(statut1);
                    if (statut1.equalsIgnoreCase("Accepté") || statut1.equalsIgnoreCase("Refusé")) {
                        historique.append(" | Décision par : ").append(entrepriseDecision);
                    }
                    if (!commentaire1.isEmpty()) {
                        historique.append(" | Commentaire : ").append(commentaire1);
                    }
                    historique.append("\n");
                }
            }
            JTextArea textArea = new JTextArea(historique.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(600, 300));
            JOptionPane.showMessageDialog(null, scrollPane, "Historique", JOptionPane.INFORMATION_MESSAGE);
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erreur lecture historique", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    });

    JOptionPane.showMessageDialog(this, panel, "Informations sur l'entreprise", JOptionPane.INFORMATION_MESSAGE);    }//GEN-LAST:event_jButton3ActionPerformed

@SuppressWarnings("empty-statement")
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Veuillez sélectionner une demande.");
        return;
    }

    String nom = jTable1.getValueAt(selectedRow, 0).toString();
    String date = jTable1.getValueAt(selectedRow, 1).toString();
    String statut = jTable1.getValueAt(selectedRow, 2).toString();
    String type = jTable1.getValueAt(selectedRow, 4).toString();
    String poids = jTable1.getValueAt(selectedRow, 5).toString().replace(" kg", "");
    String commentaire = jTable1.getValueAt(selectedRow, 6).toString();

    if (statut.equalsIgnoreCase("Accepté") || statut.equalsIgnoreCase("Refusé")) {
        JOptionPane.showMessageDialog(null, "Cette demande a déjà été traitée.");
        return;
    }

    String nomCentre = FAccueil.nomEntreprise;
    String tmpMailCentre = "";
    String tmpMailDemandeur = "";
    double capaciteEntreprise = -1;

    try (BufferedReader br = new BufferedReader(new FileReader("utilisateurs.txt"))) {
        String ligne;
        while ((ligne = br.readLine()) != null) {
            String[] parts = ligne.split(";");
            if (ligne.startsWith("CENTRE") && parts.length >= 9 && parts[1].equals(nomCentre)) {
                tmpMailCentre = parts[2].trim();
                capaciteEntreprise = Double.parseDouble(parts[8].trim());
            } else if (ligne.startsWith("ENTREPRISE") && parts.length >= 3 && parts[1].equals(nom)) {
                tmpMailDemandeur = parts[2].trim();
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Erreur de lecture du fichier utilisateurs.txt");
        return;
    }

    final String mailCentreFinal = tmpMailCentre;
    final String mailDemandeurFinal = tmpMailDemandeur;

    // Composants UI
    JComboBox<String> decisionBox = new JComboBox<>(new String[]{"Accepter", "Refuser", "Planifier"});
    JComboBox<String> motifBox = new JComboBox<>(new String[]{"Veuillez sélectionner (facultatif)","Capacité trop grande", "Demande incorrecte", "Autre (personnalisé)"});
    JTextField dateField = new JTextField(10);
    JTextArea commentaireField = new JTextArea(5, 25);
    commentaireField.setLineWrap(true);
    commentaireField.setWrapStyleWord(true);

    JScrollPane commentaireScroll = new JScrollPane(commentaireField);

    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(8, 8, 8, 8);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    int row = 0;

    gbc.gridx = 0; gbc.gridy = row;
    panel.add(new JLabel("Décision :"), gbc);
    gbc.gridx = 1;
    panel.add(decisionBox, gbc);

    gbc.gridx = 0; gbc.gridy = ++row;
    JLabel motifLabel = new JLabel("Motif de refus :");
    panel.add(motifLabel, gbc);
    gbc.gridx = 1;
    panel.add(motifBox, gbc);

    gbc.gridx = 0; gbc.gridy = ++row;
    JLabel dateLabel = new JLabel("Date planifiée (jj/mm/aaaa) :");
    panel.add(dateLabel, gbc);
    gbc.gridx = 1;
    panel.add(dateField, gbc);

    gbc.gridx = 0; gbc.gridy = ++row;
    gbc.gridwidth = 2;
    panel.add(new JLabel("Commentaire :"), gbc);

    gbc.gridy = ++row;
    panel.add(commentaireScroll, gbc);

    // Apparence dynamique
    motifBox.setVisible(false);
    motifLabel.setVisible(false);
    dateField.setVisible(false);
    dateLabel.setVisible(false);
    commentaireField.setEditable(true);

    decisionBox.addActionListener(e -> {
        String sel = (String) decisionBox.getSelectedItem();
        boolean isRefus = "Refuser".equals(sel);
        boolean isPlanif = "Planifier".equals(sel);

        motifBox.setVisible(isRefus);
        motifLabel.setVisible(isRefus);
        dateField.setVisible(isPlanif);
        dateLabel.setVisible(isPlanif);

        commentaireField.setEditable(isRefus && "Autre (personnalisé)".equals(motifBox.getSelectedItem()) || isPlanif);
    });

    motifBox.addActionListener(e -> {
        commentaireField.setEditable("Autre (personnalisé)".equals(motifBox.getSelectedItem()));
    });

    // Restrictions pour statut planifié
    if (statut.equalsIgnoreCase("À venir") || statut.equalsIgnoreCase("Planifié")) {
        decisionBox.setSelectedItem("Planifier");
        decisionBox.setEnabled(false);
        motifBox.setVisible(false);
        motifLabel.setVisible(false);
        commentaireField.setEditable(true);

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridy++;
        panel.add(new JLabel("Date actuelle : " + date), gbc);
    }

    // Sauvegarde des anciennes couleurs
    Object oldOkText = UIManager.get("OptionPane.okButtonText");
    Color oldBg = UIManager.getColor("Button.background");
    Color oldFg = UIManager.getColor("Button.foreground");

    // Apparence boutons boîte de dialogue
    UIManager.put("OptionPane.okButtonText", "Enregistrer");
    UIManager.put("OptionPane.cancelButtonText", "Annuler");
    UIManager.put("Button.background", new Color(0, 128, 0));
    UIManager.put("Button.foreground", Color.WHITE);

    int result = JOptionPane.showConfirmDialog(null, panel, "Gérer la demande", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    // Restaurer anciennes couleurs
    UIManager.put("Button.background", oldBg);
    UIManager.put("Button.foreground", oldFg);
    UIManager.put("OptionPane.okButtonText", oldOkText);

    if (result != JOptionPane.OK_OPTION) return;

    String decision = (String) decisionBox.getSelectedItem();
    String commentaireFinal = commentaireField.getText().trim();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate today = LocalDate.now();

    String nouvelleDate = date;
    String nouveauStatut = statut;

    try {
        switch (decision) {
            case "Accepter" -> {
                double poidsDemande = Double.parseDouble(poids);
                if (capaciteEntreprise > 0 && poidsDemande > capaciteEntreprise) {
                    JOptionPane.showMessageDialog(null, "Capacité dépassée !");
                    return;
                }
                nouveauStatut = "Accepté";
                commentaireFinal = commentaireFinal.isEmpty() ? "Accepté par " + nomCentre : commentaireFinal;
                nouvelleDate = today.format(formatter);
            }
            case "Refuser" -> {
                nouveauStatut = "Refusé";
                String motif = (String) motifBox.getSelectedItem();
                if ("Autre (personnalisé)".equals(motif) || "Veuillez sélectionner (facultatif)".equals(motif)) {
                    if (commentaireFinal.isEmpty()) {
                    commentaireFinal = "Refusé par " + nomCentre;
                    }
                } else {
                    commentaireFinal = motif;
                }
                nouvelleDate = today.format(formatter);
            }
            case "Planifier" -> {
                String saisie = dateField.getText().trim();
                LocalDate nouvelle = LocalDate.parse(saisie, formatter);
                LocalDate actuelle = LocalDate.parse(date, formatter);

                if (!nouvelle.isAfter(actuelle) || nouvelle.isBefore(today)) {
                    JOptionPane.showMessageDialog(null, "Date invalide.");
                    return;
                }

                nouvelleDate = saisie;
                nouveauStatut = "Planifié";
                if (commentaireFinal.isEmpty()) {
                    commentaireFinal = "Planifié par " + nomCentre + " pour le " + saisie;
                }
            }
        }

        // Modifier fichier
        List<String> lignes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("demandes.txt"))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split(";");
                if (parts.length >= 4 && parts[0].trim().equals(mailDemandeurFinal) &&
                        parts[1].trim().equals(type) && parts[2].trim().equals(poids) && parts[3].trim().equals(date)) {
                    lignes.add(mailDemandeurFinal + ";" + type + ";" + poids + ";" + nouvelleDate + ";" + nouveauStatut + ";" + commentaireFinal + ";" + mailCentreFinal);
                } else {
                    lignes.add(ligne);
                }
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("demandes.txt", false))) {
            for (String l : lignes) {
                bw.write(l);
                bw.newLine();
            }
        }

        JOptionPane.showMessageDialog(null, "Décision enregistrée.");
        mettreAJourAffichageDemandes();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage());
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    mettreAJourAffichageDemandes();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FCOLLECTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FCOLLECTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FCOLLECTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FCOLLECTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FCOLLECTE().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_retour;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_LOGO;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Background;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel jfirst_font;
    // End of variables declaration//GEN-END:variables

}


