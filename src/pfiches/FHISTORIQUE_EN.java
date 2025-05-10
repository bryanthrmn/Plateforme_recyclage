// Bryan THIRIMANNA & Gabriel BREMME
// Projet Java - Semestre 4 
// EPF Engineering School

package pfiches;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class FHISTORIQUE_EN extends javax.swing.JFrame {
    public FHISTORIQUE_EN() {
        initComponents();
        this.setSize(1980, 1080); // taille manuelle (adapter selon ton design)
        afficherDemandesAvecFiltre();
}
    private void afficherDemandesAvecFiltre() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Réinitialise le tableau

    String filtre = (String) jComboBox1.getSelectedItem();
    List<Object[]> lignes = new ArrayList<>();
    boolean found = false;

    try (BufferedReader br = new BufferedReader(new FileReader("demandes.txt"))) {
        String ligne;
        while ((ligne = br.readLine()) != null) {
            String[] parts = ligne.split(";");
            if (parts.length >= 5) {
                String email = parts[0].trim();
                String type = parts[1].trim();
                String poids = parts[2].trim();
                String date = parts[3].trim();
                String statut = parts[4].trim();
                String comment = (parts.length >= 6) ? parts[5].trim() : "";

                if (email.equals(FAccueil.mailEntreprise)) {
                    lignes.add(new Object[]{date, type, poids + " kg", statut, comment});
                    found = true;
                }
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur de lecture du fichier demandes.txt", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Appliquer le tri selon le filtre
    switch (filtre) {
        case "Date croissant" -> lignes.sort(Comparator.comparing(o -> o[0].toString())); // Date
        case "Date décroissant" -> lignes.sort((o1, o2) -> o2[0].toString().compareTo(o1[0].toString()));
        case "Type de déchet" -> lignes.sort(Comparator.comparing(o -> o[1].toString().toLowerCase()));
        case "Poids" -> lignes.sort(Comparator.comparingDouble(o -> Double.valueOf(o[2].toString().replace(" kg", ""))));
        case "Statut" -> lignes.sort(Comparator.comparing(o -> o[3].toString().toLowerCase()));
        default -> {
            }
    }
        // "Tous" ou autre

    // Afficher les lignes triées
    for (Object[] ligne : lignes) {
        model.addRow(ligne);
    }

    if (found) {
        jButton1.setVisible(true);
        jPanel1.setVisible(true);
    } else {
        model.addRow(new Object[]{"Aucune demande effectuée", "", "", "", ""});
        jButton1.setVisible(false);
        jPanel1.setVisible(false);
    }
}

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel_Background = new javax.swing.JPanel();
        jfirst_font = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel_LOGO = new javax.swing.JLabel();
        jButton_retour = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_Background.setBackground(new java.awt.Color(0, 0, 0));
        jPanel_Background.setPreferredSize(new java.awt.Dimension(1280, 1024));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("HISTORIQUE DE COLLECTES");
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

        jTable1.setBackground(new java.awt.Color(204, 255, 255));
        jTable1.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Type de déchet", "Poids (KG)", "Statut", "Commentaire"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Informations du centre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel1.setText("Filtrer par Type");

        jButton2.setBackground(new java.awt.Color(0, 102, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Rechercher");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tous", "Date croissant", "Date décroissant", "Type de déchet", "Poids", "Statut" }));

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

        jButton3.setBackground(new java.awt.Color(0, 102, 204));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Supprimer une demande");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                .addGap(43, 43, 43)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(403, 403, 403))
            .addGroup(jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_BackgroundLayout.createSequentialGroup()
                    .addContainerGap(1302, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(404, 404, 404)))
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
                        .addGap(208, 208, 208)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                .addComponent(jButton_retour, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
            .addGroup(jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                    .addGap(463, 463, 463)
                    .addComponent(jButton3)
                    .addContainerGap(557, Short.MAX_VALUE)))
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
    }

    private void jButton_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_retourActionPerformed
    this.dispose();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
int selectedRow = jTable1.getSelectedRow();
if (selectedRow == -1) {
    JOptionPane.showMessageDialog(this, "Veuillez sélectionner une demande.", "Aucune sélection", JOptionPane.WARNING_MESSAGE);
    return;
}

String date = jTable1.getValueAt(selectedRow, 0).toString();
String type = jTable1.getValueAt(selectedRow, 1).toString();
String poids = jTable1.getValueAt(selectedRow, 2).toString().replace(" kg", "");
String statut = jTable1.getValueAt(selectedRow, 3).toString();

if (!(statut.equalsIgnoreCase("Accepté") || statut.equalsIgnoreCase("Refusé") || statut.equalsIgnoreCase("Planifié"))) {
    JOptionPane.showMessageDialog(this, "Aucune entreprise n'est liée à cette demande pour le moment.", "Statut non traité", JOptionPane.INFORMATION_MESSAGE);
    return;
}

String mailCentre = null;

try (BufferedReader br = new BufferedReader(new FileReader("demandes.txt"))) {
    String ligne;
    while ((ligne = br.readLine()) != null) {
        String[] parts = ligne.split(";");
        if (parts.length >= 7) {
            String mailParticulier = parts[0].trim();
            String typeF = parts[1].trim();
            String poidsF = parts[2].trim();
            String dateF = parts[3].trim();
            String statutF = parts[4].trim();
            String commentaireF = parts[5].trim();
            String centreF = parts[6].trim(); // mail du centre

            if (date.equals(dateF) && type.equals(typeF) && poids.equals(poidsF) && statut.equalsIgnoreCase(statutF)) {
                mailCentre = centreF;
                break;
            }
        }
    }
} catch (IOException e) {
    JOptionPane.showMessageDialog(this, "Erreur lors de la lecture de demandes.txt", "Erreur", JOptionPane.ERROR_MESSAGE);
    return;
}

if (mailCentre == null || mailCentre.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Impossible de trouver le centre lié à cette demande.", "Erreur", JOptionPane.ERROR_MESSAGE);
    return;
}

try (BufferedReader br = new BufferedReader(new FileReader("utilisateurs.txt"))) {
    String ligne;
    while ((ligne = br.readLine()) != null) {
        String[] parts = ligne.split(";");
        if (parts.length >= 9 && parts[0].equals("CENTRE") && parts[2].equals(mailCentre)) {
            String nom = parts[1];
            String emailCentre = parts[2];
            String adresse = parts[4];
            String telephone = parts[5];
            String heureOuverture = parts[6];
            String heureFermeture = parts[7];
            String capacite = parts[8];

            StringBuilder typesDechets = new StringBuilder();
            for (int i = 9; i < parts.length; i++) {
                typesDechets.append(parts[i]);
                if (i != parts.length - 1) typesDechets.append(", ");
            }

            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Nom Responsable : " + nom));
            panel.add(new JLabel("Adresse : " + adresse));
            panel.add(new JLabel("Téléphone : " + telephone));
            panel.add(new JLabel("Email : " + emailCentre));
            panel.add(new JLabel("Heure d'Ouverture : " + heureOuverture));
            panel.add(new JLabel("Heure de Fermeture : " + heureFermeture));
            panel.add(new JLabel("Capacité : " + capacite + " kg"));
            panel.add(new JLabel("Types de déchets acceptés : " + typesDechets.toString()));

            JOptionPane.showMessageDialog(this, panel, "Informations sur le Centre", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }
} catch (IOException e) {
    JOptionPane.showMessageDialog(this, "Erreur lors de la lecture de utilisateurs.txt", "Erreur", JOptionPane.ERROR_MESSAGE);
}

JOptionPane.showMessageDialog(this, "Informations sur le centre non trouvées.", "Erreur", JOptionPane.ERROR_MESSAGE);

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Veuillez sélectionner une demande.", "Aucune sélection", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String date = jTable1.getValueAt(selectedRow, 0).toString();
    String type = jTable1.getValueAt(selectedRow, 1).toString();
    String poids = jTable1.getValueAt(selectedRow, 2).toString().replace(" kg", "");
    String statut = jTable1.getValueAt(selectedRow, 3).toString();

    if (!(statut.equalsIgnoreCase("En attente") || statut.equalsIgnoreCase("À venir") || statut.equalsIgnoreCase("Planifié"))) {
        JOptionPane.showMessageDialog(this, "Seules les demandes en statut 'En attente', 'À venir' ou 'Planifié' peuvent être supprimées.", "Suppression non autorisée", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer cette demande ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    File inputFile = new File("demandes.txt");
    File tempFile = new File("temp_demandes.txt");

    boolean deleted = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
        
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            String[] parts = currentLine.split(";");
            if (parts.length >= 5) {
                String email = parts[0].trim();
                String ligneType = parts[1].trim();
                String lignePoids = parts[2].trim();
                String ligneDate = parts[3].trim();
                String ligneStatut = parts[4].trim();

                boolean match = email.equals(FAccueil.mailEntreprise) &&
                                ligneType.equals(type) &&
                                lignePoids.equals(poids) &&
                                ligneDate.equals(date) &&
                                ligneStatut.equalsIgnoreCase(statut);

                if (match && !deleted) {
                    deleted = true; // On supprime une seule ligne correspondante
                    continue;
                }
            }
            writer.write(currentLine);
            writer.newLine();
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la suppression de la demande.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Remplace le fichier original par le fichier temporaire
    if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la mise à jour du fichier.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    JOptionPane.showMessageDialog(this, "Demande supprimée avec succès.", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);
afficherDemandesAvecFiltre();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
afficherDemandesAvecFiltre();
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FHISTORIQUE_EN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FHISTORIQUE_EN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FHISTORIQUE_EN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FHISTORIQUE_EN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FHISTORIQUE_EN().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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


