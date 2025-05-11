// Bryan THIRIMANNA & Gabriel BREMME
// Projet Java - Semestre 4 
// EPF Engineering School

package pfiches;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.UIManager;
import ptraitement.Main.Session;


public class FAccueil extends javax.swing.JFrame {

    static Object mailEntreprise;
    public static String nomEntreprise, telEntreprise, adresseEntreprise, mdpEntreprise;


public FAccueil() {
    initComponents();
    this.setSize(1980, 1080);

    File fichierUtilisateurs = new File("utilisateurs.txt");
    File fichierDemandes = new File("demandes.txt");
    File fichierDepots = new File("depots.txt");

    try {
        if (!fichierUtilisateurs.exists()) fichierUtilisateurs.createNewFile();
        if (!fichierDemandes.exists()) fichierDemandes.createNewFile();
        if (!fichierDepots.exists()) fichierDepots.createNewFile();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la création des fichiers.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Nettoyage des lignes invalides dans utilisateurs.txt
    try {
        File tempUtilisateurs = new File("temp_utilisateurs.txt");
        BufferedReader reader = new BufferedReader(new FileReader(fichierUtilisateurs));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempUtilisateurs));

        String ligne;
        while ((ligne = reader.readLine()) != null) {
            if (ligne.startsWith("CENTRE;") || ligne.startsWith("ENTREPRISE;") || ligne.startsWith("PARTICULIER;")) {
                writer.write(ligne + "\n");
            }
        }

        reader.close();
        writer.close();
        fichierUtilisateurs.delete();
        tempUtilisateurs.renameTo(fichierUtilisateurs);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur lors du nettoyage du fichier utilisateurs.txt", "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    // Ajout des centres s'il n'y en a aucun
    try (BufferedReader reader = new BufferedReader(new FileReader(fichierUtilisateurs))) {
        String line;
        boolean centresExistants = false;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("CENTRE")) {
                centresExistants = true;
                break;
            }
        }

        if (!centresExistants) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichierUtilisateurs, true))) {
                String[] centres = {
                    "CENTRE;Ecolophi;ecolophi@epf.fr;mdp1234;54 Avenue du Président Wilson;0141130151;07:00;22:00;100;Plastique;Organique;Papier;",
                    "CENTRE;RecyTech;recycle@technique.org;mdp5678;25 Boulevard du Recyclage;0140115275;09:00;19:00;150;Electronique;Batteries;Métaux;",
                    "CENTRE;GreenCycle;green@energies.fr;mdp91011;3 Avenue Verte;0147258369;08:30;17:30;200;Carton;Verre;Textile;"
                };

                for (String centre : centres) {
                    writer.write(centre + "\n");
                }
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la lecture du fichier utilisateurs.txt.", "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    // Vérification des statuts des demandes
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();

        File tempDemandes = new File("temp_demandes.txt");
        BufferedWriter writer;
        try (BufferedReader reader = new BufferedReader(new FileReader(fichierDemandes))) {
            writer = new BufferedWriter(new FileWriter(tempDemandes));
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.split(";");
                String[] parts = ligne.split(";", -1); // pour conserver les champs vides
                String statut = parts[4].trim();
                String dateStr = parts[3].trim();
                
                List<String> statutsValid = Arrays.asList("En attente", "À venir", "Accepté", "Planifié", "Refusé");
                if (!statutsValid.contains(statut)) continue;
                
                try {
                    Date dateDemande = sdf.parse(dateStr);
                    
                if (statut.equals("À venir") && !dateDemande.after(currentDate)) {
                    parts[5] = "En attente";
                } else if (statut.equals("Planifié") && !dateDemande.after(currentDate)) {
                 parts[5] = "Accepté";
                }

                    
                    writer.write(String.join(";", parts) + "\n");
                } catch (IOException | ParseException e) {
                    // Date invalide => ignorer
                }
            }
        }
        writer.close();
        fichierDemandes.delete();
        tempDemandes.renameTo(fichierDemandes);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur lors du traitement des statuts des demandes.", "Erreur", JOptionPane.ERROR_MESSAGE);
    }
}
private void afficherMenuAdmin() {
    UIManager.put("OptionPane.background", Color.WHITE);
    UIManager.put("Panel.background", Color.WHITE);

    JDialog menuDialog = new JDialog(this, "Portail Admin - Choix de base de données", true);
    menuDialog.setSize(500, 250);
    menuDialog.setLayout(new GridLayout(4, 1, 10, 10));

    JButton btnUtilisateurs = new JButton("Gestion utilisateurs");
    JButton btnDemandes = new JButton("Gestion demandes");
    JButton btnDepots = new JButton("Gestion dépôts");
    JButton btnQuitter = new JButton("Fermer le menu");

    btnUtilisateurs.setBackground(new Color(70, 130, 180));
    btnUtilisateurs.setForeground(Color.WHITE);

    btnDemandes.setBackground(new Color(34, 139, 34));
    btnDemandes.setForeground(Color.WHITE);

    btnDepots.setBackground(new Color(218, 165, 32));
    btnDepots.setForeground(Color.WHITE);

    btnQuitter.setBackground(Color.LIGHT_GRAY);

    btnUtilisateurs.addActionListener(e -> {
        menuDialog.setVisible(false);
        afficherChoixTypeUtilisateur();
        menuDialog.setVisible(true);
    });
    btnDemandes.addActionListener(e -> {
        menuDialog.setVisible(false);
        afficherTableauDepuisFichier("demandes.txt", "Demandes");
        menuDialog.setVisible(true);

    });
    btnDepots.addActionListener(e -> {
        menuDialog.setVisible(false);
        afficherTableauDepuisFichier("depots.txt", "Dépôts");
        menuDialog.setVisible(true);

    });
    btnQuitter.addActionListener(e -> menuDialog.dispose());

    menuDialog.add(btnUtilisateurs);
    menuDialog.add(btnDemandes);
    menuDialog.add(btnDepots);
    menuDialog.add(btnQuitter);
    menuDialog.setLocationRelativeTo(this);
    menuDialog.setVisible(true);

    // Reset UI changes
    UIManager.put("OptionPane.background", null);
    UIManager.put("Panel.background", null);
}

private void afficherChoixTypeUtilisateur() {
    JDialog choixDialog = new JDialog(this, "Choix du type d'utilisateur", true);
    choixDialog.setSize(400, 200);
    choixDialog.setLayout(new GridLayout(4, 1));

    JButton btnParticuliers = new JButton("Particuliers");
    JButton btnEntreprises = new JButton("Entreprises");
    JButton btnCentres = new JButton("Centres de recyclage");
    JButton btnRetour = new JButton("Retour");
    btnParticuliers.setBackground(RED);
    btnParticuliers.setForeground(Color.WHITE);
    
    btnEntreprises.setBackground(BLUE);
    btnEntreprises.setForeground(Color.WHITE);
    
    btnCentres.setBackground(GREEN);
    btnCentres.setForeground(Color.WHITE);
    
    btnParticuliers.addActionListener(e -> {
    choixDialog.setVisible(false);
        afficherTableauUtilisateurs("PARTICULIER");
            choixDialog.setVisible(true);

    });
    btnEntreprises.addActionListener(e -> {
    choixDialog.setVisible(false);
        afficherTableauUtilisateurs("ENTREPRISE");
            choixDialog.setVisible(true);

    });
    btnCentres.addActionListener(e -> {
    choixDialog.setVisible(false);
        afficherTableauUtilisateurs("CENTRE");
            choixDialog.setVisible(true);

    });
    btnRetour.addActionListener(e -> {
        choixDialog.dispose();
        afficherMenuAdmin();
    });

    choixDialog.add(btnParticuliers);
    choixDialog.add(btnEntreprises);
    choixDialog.add(btnCentres);
    choixDialog.add(btnRetour);

    choixDialog.setLocationRelativeTo(this);
    choixDialog.setVisible(true);
}

private void afficherTableauUtilisateurs(String type) {
    List<String[]> lignes = new ArrayList<>();
    String[] colonnes = null;
    try (BufferedReader reader = new BufferedReader(new FileReader("utilisateurs.txt"))) {
        String ligne;
        while ((ligne = reader.readLine()) != null) {
            if (ligne.startsWith(type + ";")) {
                String[] parts = ligne.split(";");
                lignes.add(parts);
                if (colonnes == null) {
                    colonnes = new String[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        colonnes[i] = "Champ " + (i + 1);
                    }
                }
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur lecture fichier utilisateurs.txt");
        return;
    }
    if (lignes.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Aucune donnée trouvée pour " + type);
        afficherChoixTypeUtilisateur();
        return;
    }
    afficherTableauGenerique("utilisateurs.txt", type + "s", (ArrayList<String[]>) lignes, colonnes);
}

private void afficherTableauDepuisFichier(String fichier, String titre) {
    ArrayList<String[]> lignes = new ArrayList<>();
    String[] colonnes;

    try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
        String ligne;
        while ((ligne = reader.readLine()) != null) {
            lignes.add(ligne.split(";"));
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Erreur de lecture du fichier : " + ex.getMessage());
        return;
    }

        // Déterminer les colonnes en fonction du fichier
        colonnes = switch (fichier) {
            case "utilisateurs.txt" -> new String[] {"Nom", "Prénom", "Email", "Mot de passe", "Adresse", "Téléphone", "Type", "Capacité (si centre)"};
            case "demandes.txt" -> new String[] {"Mail particulier", "Type de déchet", "Poids", "Date", "Mail centre", "Statut", "Décision", "Commentaire"};
            case "depots.txt" -> new String[] {"Mail particulier", "Type de déchet", "Poids", "Date", "Mail centre"};
            default -> new String[] {"Colonnes inconnues"};
        };

    if (lignes.isEmpty()) {
        colonnes = new String[] {"Information"};
        lignes.add(new String[] {"Aucune donnée"});
    }

    afficherTableauGenerique(fichier, titre, lignes, colonnes);
}

private void afficherTableauGenerique(String fichier, String titre, ArrayList<String[]> lignes, String[] colonnes) {
    JDialog tableauDialog = new JDialog(this, titre, true);
    tableauDialog.setSize(800, 600);
    tableauDialog.setLocationRelativeTo(this);

    String[][] donnees = lignes.toArray(String[][]::new);
    JTable table = new JTable(donnees, colonnes);
    JScrollPane scrollPane = new JScrollPane(table);

    JButton btnSupprimer = new JButton("Supprimer");
    JButton btnModifier = new JButton("Modifier");
    JButton btnFermer = new JButton("Fermer");

    btnSupprimer.addActionListener(e -> {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1 || lignes.get(selectedRow)[0].equals("Aucune donnée")) {
            JOptionPane.showMessageDialog(tableauDialog, "Veuillez sélectionner une ligne à supprimer.");
            return;
        }
        String ligneASupprimer = String.join(";", lignes.get(selectedRow));
        supprimerLigneFichier(fichier, ligneASupprimer);
        tableauDialog.dispose();
        afficherTableauDepuisFichier(fichier, titre);
    });

    btnModifier.addActionListener(e -> {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1 || lignes.get(selectedRow)[0].equals("Aucune donnée")) {
            JOptionPane.showMessageDialog(tableauDialog, "Veuillez sélectionner une ligne à modifier.");
            return;
        }
        String[] ligne = lignes.get(selectedRow);
        String ancienne = String.join(";", ligne);
        String nouvelle = JOptionPane.showInputDialog(this, "Modifier la ligne :", ancienne);
        if (nouvelle != null && !nouvelle.trim().isEmpty()) {
            modifierLigneFichier(fichier, ancienne, nouvelle);
            tableauDialog.dispose();
            afficherTableauDepuisFichier(fichier, titre);
        }
    });

    btnFermer.addActionListener(e -> tableauDialog.dispose());

    JPanel panelBoutons = new JPanel();
    panelBoutons.add(btnModifier);
    panelBoutons.add(btnSupprimer);
    panelBoutons.add(btnFermer);

    tableauDialog.add(scrollPane, BorderLayout.CENTER);
    tableauDialog.add(panelBoutons, BorderLayout.SOUTH);
    tableauDialog.setVisible(true);
}

private void supprimerLigneFichier(String fichier, String ligneASupprimer) {
    try {
        File inputFile = new File(fichier);
        File tempFile = new File("temp.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                if (!ligne.trim().equals(ligneASupprimer.trim())) {
                    writer.write(ligne + System.lineSeparator());
                }
            }
        }
        inputFile.delete();
        tempFile.renameTo(inputFile);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la suppression");
    }
}

private void modifierLigneFichier(String fichier, String ancienne, String nouvelle) {
    try {
        File inputFile = new File(fichier);
        File tempFile = new File("temp.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                if (ligne.trim().equals(ancienne.trim())) {
                    writer.write(nouvelle + System.lineSeparator());
                } else {
                    writer.write(ligne + System.lineSeparator());
                }
            }
        }
        inputFile.delete();
        tempFile.renameTo(inputFile);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la modification");
    }
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel_Background = new javax.swing.JPanel();
        jfirst_font = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel_LOGO = new javax.swing.JLabel();
        jButton_inscription = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_Background.setBackground(new java.awt.Color(0, 0, 0));
        jPanel_Background.setPreferredSize(new java.awt.Dimension(1280, 1024));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("PLATEFORME DE RECYCLAGE");
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
        jLabel_LOGO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_LOGOMouseClicked(evt);
            }
        });

        jButton_inscription.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton_inscription.setText("Nouvel utilisateur?");
        jButton_inscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_inscriptionActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Identifiez-vous");
        jTextField2.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 255));
        jButton1.setText("Mot de passe oublié ?");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextField3.setText("Mot de Passe");

        jTextField4.setText(" ");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("LOG IN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextField5.setText("Identifiant");
        jTextField5.setMinimumSize(new java.awt.Dimension(80, 25));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );

        javax.swing.GroupLayout jPanel_BackgroundLayout = new javax.swing.GroupLayout(jPanel_Background);
        jPanel_Background.setLayout(jPanel_BackgroundLayout);
        jPanel_BackgroundLayout.setHorizontalGroup(
            jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jButton_inscription, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                .addGroup(jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jfirst_font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(385, 385, 385))
                    .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)))
                .addComponent(jLabel_LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(399, 399, 399))
        );
        jPanel_BackgroundLayout.setVerticalGroup(
            jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel_LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(491, 491, 491)
                        .addComponent(jButton_inscription, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_BackgroundLayout.createSequentialGroup()
                        .addComponent(jfirst_font, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(335, Short.MAX_VALUE))
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

    private void jButton_inscriptionActionPerformed(java.awt.event.ActionEvent evt) {                                                    
    this.dispose(); // ferme FAccueil
    new FInscription(null, true).setVisible(true); // pas besoin du parent    
    }                                                                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    String email = jTextField4.getText().trim();
    String motDePasse = new String(jPasswordField1.getPassword());

    // Vérification que les champs ne sont pas vides
    if (email.isEmpty() || motDePasse.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Veuillez remplir les champs d'email et de mot de passe.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (email.equals("Admin") && motDePasse.equals("Admin2005")) {
    afficherMenuAdmin();
    return;
}
    

    // Lecture du fichier utilisateurs.txt pour vérifier les identifiants
    try (BufferedReader br = new BufferedReader(new FileReader("utilisateurs.txt"))) {
        String line;
        boolean utilisateurTrouve = false;

        while ((line = br.readLine()) != null) {
            // Séparer la ligne par le séparateur ";"
            String[] parts = line.split(";");

            // Vérifier qu'il y a au moins 4 champs (évite les erreurs d'indice)
            if (parts.length < 4) continue;

            String emailEnregistrement = parts[2].trim();
            String mdpEnregistrement = parts[3].trim();
            

            if (emailEnregistrement.equals(email) && mdpEnregistrement.equals(motDePasse)) {
                utilisateurTrouve = true;
                Session.mailEntreprise = email;
                mailEntreprise = email;
                nomEntreprise = parts[1].trim();
                mdpEntreprise =parts[3].trim();
                adresseEntreprise=parts[4].trim();
                telEntreprise = parts[5].trim();
                String typeUtilisateur = parts[0];

                switch (typeUtilisateur) {
                    case "PARTICULIER" -> {
                        FMENUPART menuPart = new FMENUPART();
                        menuPart.setLocationRelativeTo(null);
                        menuPart.setVisible(true);
                    }
                    case "ENTREPRISE" -> {
                        FMenuEN menuEn = new FMenuEN();
                        menuEn.setLocationRelativeTo(null);
                        menuEn.setVisible(true);
                    }
                    case "CENTRE" -> {
                        FMenuCENTRE menuCentre = new FMenuCENTRE();
                        menuCentre.setLocationRelativeTo(null);
                        menuCentre.setVisible(true);
                    }
                    default -> JOptionPane.showMessageDialog(this, "Type d'utilisateur inconnu.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

                // Ferme la fenêtre d'accueil
                this.dispose();
                break;
            }
        }

        if (!utilisateurTrouve) {
            JOptionPane.showMessageDialog(this, "Identifiants incorrects.", "Erreur", JOptionPane.ERROR_MESSAGE);
            
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la lecture du fichier utilisateurs.txt.", "Erreur", JOptionPane.ERROR_MESSAGE);
    }
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Demande l'email via une boîte de dialogue
    String emailOublie = JOptionPane.showInputDialog(this, "Entrez votre email pour récupérer votre mot de passe:");

    if (emailOublie != null && !emailOublie.isEmpty()) {
        // Vérifie si l'email existe dans le fichier
        boolean emailTrouve = false;
        String motDePasseTrouve = "";

        try (BufferedReader reader = new BufferedReader(new FileReader("utilisateurs.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Séparer la ligne par le séparateur ";"
                String[] parts = line.split(";");

                if (parts.length >= 3) {
                    String emailDansFichier = parts[2].trim(); // email enregistré dans le fichier
                    String motDePasseDansFichier = parts[3].trim(); // mot de passe associé

                    // Vérifier si l'email correspond à celui saisi
                    if (emailDansFichier.equals(emailOublie)) {
                        emailTrouve = true;
                        motDePasseTrouve = motDePasseDansFichier;
                        break;  // Sort de la boucle dès qu'on trouve l'email
                    }
                }
            }

            if (emailTrouve) {
                // Affiche le mot de passe trouvé
                JOptionPane.showMessageDialog(this, "Votre mot de passe est : " + motDePasseTrouve, "Mot de passe trouvé", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Affiche un message d'erreur si l'email n'est pas trouvé
                JOptionPane.showMessageDialog(this, "Email incorrect. Veuillez réessayer.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException e) {
            // Gérer l'erreur d'ouverture du fichier
            JOptionPane.showMessageDialog(this, "Erreur lors de la lecture du fichier utilisateurs.txt.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Veuillez entrer un email.", "Erreur", JOptionPane.ERROR_MESSAGE);
    }    }                                        

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    jPasswordField1.requestFocusInWindow();    }                                           

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {                                           
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Appel à l'action de ton bouton
            jButton2ActionPerformed(null); // Appelle la méthode d'action du bouton
        }    }                                          

    private void jLabel_LOGOMouseClicked(java.awt.event.MouseEvent evt) {                                         
// EASTER EGG POUR LES CREDITS!
JDialog popupCredits = new JDialog(this, "Crédits", true);
popupCredits.setSize(600, 400);
popupCredits.setLayout(new BorderLayout());
popupCredits.setLocation(0, 0); // Positionne la popup en haut à gauche de l'écran
popupCredits.setResizable(false); // Empêche le redimensionnement de la popup

// Panel avec un fond personnalisé et animation
JPanel panelCredits = new JPanel() {
    private List<Object[]> circles = new ArrayList<>(); // Liste des cercles à dessiner
    private Random random = new Random();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Ajouter des cercles de manière continue
        if (circles.size() < 100) {  // Limiter à 100 cercles au maximum
            int diameter = random.nextInt(100) + 20; // Taille aléatoire entre 20 et 120
            int x = random.nextInt(getWidth());
            int y = random.nextInt(getHeight());
            Color circleColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            circles.add(new Object[]{x, y, diameter, circleColor}); // Ajouter un cercle à la liste
        }

        // Dessiner tous les cercles existants
        for (Object[] circle : circles) {
            g.setColor((Color) circle[3]);
            g.fillOval((Integer) circle[0], (Integer) circle[1], (Integer) circle[2], (Integer) circle[2]);
        }

        // Redessiner les crédits au premier plan
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Projet Semestre 4 - Conception Programmation Objet", 20, getHeight() - 110);

        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Gabriel BREMME & Bryan THIRIMANNA", 20, getHeight() - 80);
        g.drawString("Mai 2025", 20, getHeight() - 50);
        g.drawString("EPF - Engineering School", 20, getHeight() - 20);
    }
};

panelCredits.setBackground(Color.BLACK);
popupCredits.add(panelCredits, BorderLayout.CENTER);

// Ajouter un timer pour redessiner l'animation des cercles
Timer timer = new Timer(30, (ActionEvent e) -> {
    panelCredits.repaint(); // Redessine le panel pour l'animation
});
timer.start();

// Créer un bouton transparent pour le lien GitHub
JButton btnGitHub = new JButton("<html><u style='color: blue;'>Voir GitHub</u></html>");
btnGitHub.setOpaque(false); // Fond transparent
btnGitHub.setContentAreaFilled(false); // Aire de contenu transparente
btnGitHub.setBorderPainted(false); // Pas de bordure
btnGitHub.setFont(new Font("Arial", Font.PLAIN, 16));
btnGitHub.setForeground(Color.BLUE);
btnGitHub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

// Action pour ouvrir le lien GitHub
btnGitHub.addActionListener((ActionEvent e) -> {
    try {
        Desktop.getDesktop().browse(new URI("https://github.com/bryanthrmn/Plateforme_recyclage"));
    } catch (IOException | URISyntaxException ex) {
        ex.printStackTrace();
    }
});

// Panel pour le bouton GitHub
JPanel panelTexte = new JPanel(new FlowLayout(FlowLayout.LEFT));
panelTexte.setBackground(Color.BLACK);
panelTexte.add(btnGitHub);
popupCredits.add(panelTexte, BorderLayout.SOUTH); // Ajout en bas

// Afficher la popup
popupCredits.setVisible(true);

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
            java.util.logging.Logger.getLogger(FAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FAccueil().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_inscription;
    private javax.swing.JLabel jLabel_LOGO;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_Background;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JPanel jfirst_font;
    // End of variables declaration                   
}
