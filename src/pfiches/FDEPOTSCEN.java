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
public class FDEPOTSCEN extends javax.swing.JFrame {
public FDEPOTSCEN() {
    initComponents();
    this.setSize(1980, 1080); 
    mettreAJourAffichageDepots();
}

private void mettreAJourAffichageDepots() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Réinitialise le tableau

    // Lecture des types de déchets acceptés par le centre
    ArrayList<String> typesAcceptes = new ArrayList<>();
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

    String filtre = (String) jComboBox1.getSelectedItem();

    // Classe Demande avec le champ téléphone ajouté
    class Demande {
        String nom, prenom, adresse, mail, telephone, date, type, poids;

        public Demande(String nom, String prenom, String adresse, String mail, String telephone, String date, String type, String poids) {
            this.nom = nom;
            this.prenom = prenom;
            this.adresse = adresse;
            this.mail = mail;
            this.telephone = telephone;
            this.date = date;
            this.type = type;
            this.poids = poids;
        }
    }

    ArrayList<Demande> listeDemandes = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("depots.txt"), StandardCharsets.UTF_8))) {
        String ligne;
        while ((ligne = br.readLine()) != null) {
            String[] parts = ligne.split(";");
            if (parts.length >= 5) {
                String mailUtilisateur = parts[0].trim();
                String type = parts[1].trim();
                String poids = parts[2].trim();
                String date = parts[3].trim();
                String mailCentre = parts[4].trim();

                String nom = "", prenom = "", adresse = "", telephone = "";

                try (BufferedReader brUtilisateur = new BufferedReader(new InputStreamReader(new FileInputStream("utilisateurs.txt"), StandardCharsets.UTF_8))) {
                    String ligneUtilisateur;
                    while ((ligneUtilisateur = brUtilisateur.readLine()) != null) {
                        String[] partsUtilisateur = ligneUtilisateur.split(";");
                        if (partsUtilisateur.length >= 7 && partsUtilisateur[2].equals(mailUtilisateur)) {
                            String typeCompte = partsUtilisateur[0].trim();
                            nom = partsUtilisateur[1].trim();
                            adresse = partsUtilisateur[4].trim();
                            telephone = partsUtilisateur[5].trim();

                            if (typeCompte.equals("PARTICULIER") && partsUtilisateur.length >= 7) {
                                prenom = partsUtilisateur[6].trim(); // Prénom stocké en index 6
                            } else {
                                prenom = ""; // Pas de prénom pour CENTRE/ENTREPRISE
                            }
                            break;
                        }
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Erreur lors de la lecture de utilisateurs.txt pour les utilisateurs", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                listeDemandes.add(new Demande(nom, prenom, adresse, mailUtilisateur, telephone, date, type, poids));
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur de lecture du fichier depots.txt", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Appliquer les filtres
    if (!"Tous".equals(filtre)) {
        Comparator<Demande> comparator = switch (filtre) {
            case "Nom" -> Comparator.comparing(d -> d.nom.toLowerCase());
            case "Date croissant" -> Comparator.comparing(d -> LocalDate.parse(d.date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            case "Date décroissant" -> Comparator.comparing((Demande d) -> LocalDate.parse(d.date, DateTimeFormatter.ofPattern("dd/MM/yyyy"))).reversed();
            case "Poids" -> Comparator.comparingDouble(d -> Double.valueOf(d.poids));
            case "Type de déchet" -> Comparator.comparing(d -> d.type.toLowerCase());
            case "Prénom" -> Comparator.comparing(d -> d.prenom.toLowerCase());
            case "Adresse" -> Comparator.comparing(d -> d.adresse.toLowerCase());
            case "Mail" -> Comparator.comparing(d -> d.mail.toLowerCase());
            default -> null;
        };
        if (comparator != null) listeDemandes.sort(comparator);
    }

    // Ajouter les données au tableau (avec colonne téléphone)
    for (Demande d : listeDemandes) {
        model.addRow(new Object[]{d.date, d.type, d.poids + " kg", d.nom, d.prenom, d.adresse, d.mail, d.telephone});
    }

    if (model.getRowCount() == 0) {
        model.addRow(new Object[]{"Aucun dépôt trouvé", "", "", "", "", "", "", ""});
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
        jButton1 = new javax.swing.JButton();

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
        jTable1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Type de déchets", "Capacité", "Nom", "Prénom", "Adresse", "Mail", "Téléphone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(50);
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
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tous", "Date croissant", "Date décroissant", "Type de déchet", "Poids", "Nom", "Prénom", "Adresse", "Mail" }));
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

        jButton1.setBackground(new java.awt.Color(51, 204, 0));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Obtenir des informations");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addGap(47, 47, 47)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(399, 399, 399))
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
                        .addGap(194, 194, 194)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    mettreAJourAffichageDepots();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne.", "Aucune sélection", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String nom = jTable1.getValueAt(selectedRow, 3).toString();
    String prenom = jTable1.getValueAt(selectedRow, 4).toString();
    String adresse = jTable1.getValueAt(selectedRow, 5).toString();
    String mail = jTable1.getValueAt(selectedRow, 6).toString();
    String date = jTable1.getValueAt(selectedRow, 0).toString();
    String type = jTable1.getValueAt(selectedRow, 1).toString();
    String poids = jTable1.getValueAt(selectedRow, 2).toString().replace(" kg", "");

    String tel = "";

    // Recherche des infos du particulier dans utilisateurs.txt
    try (BufferedReader br = new BufferedReader(new FileReader("utilisateurs.txt"))) {
        String ligne;
        while ((ligne = br.readLine()) != null) {
            String[] parts = ligne.split(";");
            if (parts.length >= 6 && parts[2].equals(mail)) {
                tel = parts[5];
                break;
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la lecture de utilisateurs.txt", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Création du panneau d'information
    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(new JLabel("Nom : " + nom));
    panel.add(new JLabel("Prénom : " + prenom));
    panel.add(new JLabel("Adresse : " + adresse));
    panel.add(new JLabel("Téléphone : " + tel));
    panel.add(new JLabel("Mail : " + mail));
    panel.add(new JLabel("Date de dépôt : " + date));
    panel.add(new JLabel("Poids : " + poids + " kg"));
    panel.add(new JLabel("Type de déchet : " + type));

    JButton btnHistorique = new JButton("Voir l'historique");
    panel.add(btnHistorique);

    final String mailFinal = mail; // pour l'utiliser dans le lambda

    btnHistorique.addActionListener((ActionEvent e) -> {
        StringBuilder historique = new StringBuilder("Historique des dépôts de " + prenom + " " + nom + " :\n\n");
        try (BufferedReader br = new BufferedReader(new FileReader("depots.txt"))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split(";");
                if (parts.length >= 5 && parts[0].equals(mailFinal)) {
                    String typeD = parts[1];
                    String poidsD = parts[2];
                    String dateD = parts[3];
                    String mailCentre = parts[4];
                    historique.append("• Date : ").append(dateD)
                              .append(" | Type : ").append(typeD)
                              .append(" | Poids : ").append(poidsD).append(" kg")
                              .append(" | Centre : ").append(mailCentre).append("\n");
                }
            }

            JTextArea textArea = new JTextArea(historique.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(600, 300));
            JOptionPane.showMessageDialog(null, scrollPane, "Historique", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erreur lecture historique", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    });

    JOptionPane.showMessageDialog(this, panel, "Informations sur le particulier", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FDEPOTSCEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FDEPOTSCEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FDEPOTSCEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FDEPOTSCEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
            new FDEPOTSCEN().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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


