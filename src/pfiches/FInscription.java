// Bryan THIRIMANNA & Gabriel BREMME
// Projet Java - Semestre 4 
// EPF Engineering School

package pfiches;

import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class FInscription extends javax.swing.JDialog {
private CardLayout cl;

    public FInscription(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(1980, 1080); // taille manuelle (adapter selon ton design)
        this.setLocationRelativeTo(null); // pour centrer
        mainPanel.setVisible(false);
        jButton2.setVisible(false);
        OPTIONS_TYPE.setVisible(false);
        cl = (CardLayout) mainPanel.getLayout();
        

    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        BOUTTON_PARTICULIER = new javax.swing.JRadioButton();
        BOUTON_ENTREPRISE = new javax.swing.JRadioButton();
        BOUTON_CENTRE = new javax.swing.JRadioButton();
        PANEL_VOUS_ETES = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jLabel_LOGO = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        PANEL_ENTREPRISE = new javax.swing.JPanel();
        PANEL_ENTREPRISE_NOM = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        PANEL_ENTREPRISE8TEL = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        PANEL_ENTRERPISE_ADRESSE = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        PANEL_ENTREPRISE_MAIL = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        MDP_ENTREPRISE = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        REPONSE_NOM_ENTREPRISE = new javax.swing.JTextField();
        REPONSE_MDP_ENTREPRISE = new javax.swing.JPasswordField();
        REPONSE_ADRESSE_ENTREPRISE = new javax.swing.JTextField();
        REPONSE_MAIL_ENTREPRISE = new javax.swing.JTextField();
        REPONSE_TEL_ENTREPRISE = new javax.swing.JTextField();
        PANEL_CENTRE = new javax.swing.JPanel();
        PANEL_ENTREPRISE_NOM2 = new javax.swing.JPanel();
        jTextField15 = new javax.swing.JTextField();
        PANEL_CENTRE_CAPACITE = new javax.swing.JPanel();
        jTextField16 = new javax.swing.JTextField();
        PANEL_ENTRERPISE_ADRESSE2 = new javax.swing.JPanel();
        jTextField17 = new javax.swing.JTextField();
        PANEL_ENTREPRISE_MAIL2 = new javax.swing.JPanel();
        jTextField18 = new javax.swing.JTextField();
        MDP_ENTREPRISE2 = new javax.swing.JPanel();
        jTextField19 = new javax.swing.JTextField();
        REPONSE_NOM_ENTREPRISE2 = new javax.swing.JTextField();
        REPONSE_MDP_ENTREPRISE2 = new javax.swing.JPasswordField();
        REPONSE_TELEPHONE_ENTREPRISE2 = new javax.swing.JTextField();
        REPONSE_ADRESSE_ENTREPRISE2 = new javax.swing.JTextField();
        REPONSE_CAPACITE_ENTREPRISE2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jTextField22 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        PANEL_PARTICULIER = new javax.swing.JPanel();
        PANEL_ENTREPRISE_NOM1 = new javax.swing.JPanel();
        jTextField8 = new javax.swing.JTextField();
        PANEL_ENTREPRISE8TEL1 = new javax.swing.JPanel();
        jTextField9 = new javax.swing.JTextField();
        PANEL_ENTRERPISE_ADRESSE1 = new javax.swing.JPanel();
        jTextField10 = new javax.swing.JTextField();
        PANEL_ENTREPRISE_MAIL1 = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        MDP_ENTREPRISE1 = new javax.swing.JPanel();
        jTextField12 = new javax.swing.JTextField();
        REPONSE_NOM_ENTREPRISE1 = new javax.swing.JTextField();
        REPONSE_MDP_ENTREPRISE1 = new javax.swing.JPasswordField();
        REPONSE_ADRESSE_ENTREPRISE1 = new javax.swing.JTextField();
        REPONSE_MAIL_ENTREPRISE1 = new javax.swing.JTextField();
        REPONSE_TEL_ENTREPRISE1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTextField14 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        OPTIONS_TYPE = new javax.swing.JPanel();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jTextField26 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(915, 626));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 1024));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("INSCRIPTION");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        buttonGroup1.add(BOUTTON_PARTICULIER);
        BOUTTON_PARTICULIER.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        BOUTTON_PARTICULIER.setText("Un particulier");
        BOUTTON_PARTICULIER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOUTTON_PARTICULIERActionPerformed(evt);
            }
        });

        buttonGroup1.add(BOUTON_ENTREPRISE);
        BOUTON_ENTREPRISE.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        BOUTON_ENTREPRISE.setText("Une entreprise");
        BOUTON_ENTREPRISE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOUTON_ENTREPRISEActionPerformed(evt);
            }
        });

        buttonGroup1.add(BOUTON_CENTRE);
        BOUTON_CENTRE.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        BOUTON_CENTRE.setText("Un centre de recyclage");
        BOUTON_CENTRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOUTON_CENTREActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BOUTON_ENTREPRISE, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BOUTTON_PARTICULIER, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BOUTON_CENTRE, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(BOUTTON_PARTICULIER)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BOUTON_ENTREPRISE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BOUTON_CENTRE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jTextField4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextField4.setText("Vous êtes : ");
        jTextField4.setBorder(null);

        javax.swing.GroupLayout PANEL_VOUS_ETESLayout = new javax.swing.GroupLayout(PANEL_VOUS_ETES);
        PANEL_VOUS_ETES.setLayout(PANEL_VOUS_ETESLayout);
        PANEL_VOUS_ETESLayout.setHorizontalGroup(
            PANEL_VOUS_ETESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_VOUS_ETESLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField4)
                .addContainerGap())
        );
        PANEL_VOUS_ETESLayout.setVerticalGroup(
            PANEL_VOUS_ETESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_VOUS_ETESLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel_LOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pfiches/EPF_LOGO (2).png"))); // NOI18N

        mainPanel.setBackground(new java.awt.Color(255, 102, 153));
        mainPanel.setLayout(new java.awt.CardLayout());

        PANEL_ENTREPRISE_NOM.setBackground(new java.awt.Color(0, 0, 0));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("Nom");
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_ENTREPRISE_NOMLayout = new javax.swing.GroupLayout(PANEL_ENTREPRISE_NOM);
        PANEL_ENTREPRISE_NOM.setLayout(PANEL_ENTREPRISE_NOMLayout);
        PANEL_ENTREPRISE_NOMLayout.setHorizontalGroup(
            PANEL_ENTREPRISE_NOMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE_NOMLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        PANEL_ENTREPRISE_NOMLayout.setVerticalGroup(
            PANEL_ENTREPRISE_NOMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE_NOMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2)
                .addContainerGap())
        );

        PANEL_ENTREPRISE8TEL.setBackground(new java.awt.Color(0, 0, 0));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(0, 0, 0));
        jTextField3.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setText("Téléphone");
        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_ENTREPRISE8TELLayout = new javax.swing.GroupLayout(PANEL_ENTREPRISE8TEL);
        PANEL_ENTREPRISE8TEL.setLayout(PANEL_ENTREPRISE8TELLayout);
        PANEL_ENTREPRISE8TELLayout.setHorizontalGroup(
            PANEL_ENTREPRISE8TELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE8TELLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PANEL_ENTREPRISE8TELLayout.setVerticalGroup(
            PANEL_ENTREPRISE8TELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE8TELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField3)
                .addContainerGap())
        );

        PANEL_ENTRERPISE_ADRESSE.setBackground(new java.awt.Color(0, 0, 0));

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(0, 0, 0));
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setText("Adresse");
        jTextField5.setBorder(null);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_ENTRERPISE_ADRESSELayout = new javax.swing.GroupLayout(PANEL_ENTRERPISE_ADRESSE);
        PANEL_ENTRERPISE_ADRESSE.setLayout(PANEL_ENTRERPISE_ADRESSELayout);
        PANEL_ENTRERPISE_ADRESSELayout.setHorizontalGroup(
            PANEL_ENTRERPISE_ADRESSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTRERPISE_ADRESSELayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PANEL_ENTRERPISE_ADRESSELayout.setVerticalGroup(
            PANEL_ENTRERPISE_ADRESSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTRERPISE_ADRESSELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField5)
                .addContainerGap())
        );

        PANEL_ENTREPRISE_MAIL.setBackground(new java.awt.Color(0, 0, 0));

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(0, 0, 0));
        jTextField6.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setText("E-mail");
        jTextField6.setBorder(null);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_ENTREPRISE_MAILLayout = new javax.swing.GroupLayout(PANEL_ENTREPRISE_MAIL);
        PANEL_ENTREPRISE_MAIL.setLayout(PANEL_ENTREPRISE_MAILLayout);
        PANEL_ENTREPRISE_MAILLayout.setHorizontalGroup(
            PANEL_ENTREPRISE_MAILLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE_MAILLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PANEL_ENTREPRISE_MAILLayout.setVerticalGroup(
            PANEL_ENTREPRISE_MAILLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE_MAILLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField6)
                .addContainerGap())
        );

        MDP_ENTREPRISE.setBackground(new java.awt.Color(0, 0, 0));

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(0, 0, 0));
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setText("MDP");
        jTextField7.setBorder(null);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MDP_ENTREPRISELayout = new javax.swing.GroupLayout(MDP_ENTREPRISE);
        MDP_ENTREPRISE.setLayout(MDP_ENTREPRISELayout);
        MDP_ENTREPRISELayout.setHorizontalGroup(
            MDP_ENTREPRISELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MDP_ENTREPRISELayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MDP_ENTREPRISELayout.setVerticalGroup(
            MDP_ENTREPRISELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MDP_ENTREPRISELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        REPONSE_NOM_ENTREPRISE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPONSE_NOM_ENTREPRISEActionPerformed(evt);
            }
        });

        REPONSE_MDP_ENTREPRISE.setText("jPasswordField1");
        REPONSE_MDP_ENTREPRISE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPONSE_MDP_ENTREPRISEActionPerformed(evt);
            }
        });
        REPONSE_MDP_ENTREPRISE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                REPONSE_MDP_ENTREPRISEKeyPressed(evt);
            }
        });

        REPONSE_ADRESSE_ENTREPRISE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPONSE_ADRESSE_ENTREPRISEActionPerformed(evt);
            }
        });

        REPONSE_MAIL_ENTREPRISE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPONSE_MAIL_ENTREPRISEActionPerformed(evt);
            }
        });

        REPONSE_TEL_ENTREPRISE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPONSE_TEL_ENTREPRISEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_ENTREPRISELayout = new javax.swing.GroupLayout(PANEL_ENTREPRISE);
        PANEL_ENTREPRISE.setLayout(PANEL_ENTREPRISELayout);
        PANEL_ENTREPRISELayout.setHorizontalGroup(
            PANEL_ENTREPRISELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISELayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PANEL_ENTREPRISELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PANEL_ENTREPRISE_NOM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_ENTREPRISE8TEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MDP_ENTREPRISE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_ENTRERPISE_ADRESSE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_ENTREPRISE_MAIL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(PANEL_ENTREPRISELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(REPONSE_MAIL_ENTREPRISE, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(REPONSE_ADRESSE_ENTREPRISE, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(REPONSE_MDP_ENTREPRISE, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(REPONSE_NOM_ENTREPRISE, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(REPONSE_TEL_ENTREPRISE))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        PANEL_ENTREPRISELayout.setVerticalGroup(
            PANEL_ENTREPRISELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISELayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(PANEL_ENTREPRISELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PANEL_ENTREPRISE_NOM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(REPONSE_NOM_ENTREPRISE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_ENTREPRISELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PANEL_ENTREPRISE8TEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(REPONSE_TEL_ENTREPRISE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PANEL_ENTREPRISELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PANEL_ENTRERPISE_ADRESSE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(REPONSE_ADRESSE_ENTREPRISE, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PANEL_ENTREPRISELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(REPONSE_MAIL_ENTREPRISE, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PANEL_ENTREPRISE_MAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PANEL_ENTREPRISELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MDP_ENTREPRISE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(REPONSE_MDP_ENTREPRISE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        mainPanel.add(PANEL_ENTREPRISE, "2");

        PANEL_ENTREPRISE_NOM2.setBackground(new java.awt.Color(0, 0, 0));

        jTextField15.setEditable(false);
        jTextField15.setBackground(new java.awt.Color(0, 0, 0));
        jTextField15.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(255, 255, 255));
        jTextField15.setText("Nom");
        jTextField15.setBorder(null);
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_ENTREPRISE_NOM2Layout = new javax.swing.GroupLayout(PANEL_ENTREPRISE_NOM2);
        PANEL_ENTREPRISE_NOM2.setLayout(PANEL_ENTREPRISE_NOM2Layout);
        PANEL_ENTREPRISE_NOM2Layout.setHorizontalGroup(
            PANEL_ENTREPRISE_NOM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE_NOM2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PANEL_ENTREPRISE_NOM2Layout.setVerticalGroup(
            PANEL_ENTREPRISE_NOM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE_NOM2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField15)
                .addContainerGap())
        );

        PANEL_CENTRE_CAPACITE.setBackground(new java.awt.Color(0, 0, 0));

        jTextField16.setEditable(false);
        jTextField16.setBackground(new java.awt.Color(0, 0, 0));
        jTextField16.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField16.setForeground(new java.awt.Color(255, 255, 255));
        jTextField16.setText("Capacité (en KG)");
        jTextField16.setActionCommand("<Not Set>");
        jTextField16.setBorder(null);
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_CENTRE_CAPACITELayout = new javax.swing.GroupLayout(PANEL_CENTRE_CAPACITE);
        PANEL_CENTRE_CAPACITE.setLayout(PANEL_CENTRE_CAPACITELayout);
        PANEL_CENTRE_CAPACITELayout.setHorizontalGroup(
            PANEL_CENTRE_CAPACITELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_CENTRE_CAPACITELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PANEL_CENTRE_CAPACITELayout.setVerticalGroup(
            PANEL_CENTRE_CAPACITELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_CENTRE_CAPACITELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField16)
                .addContainerGap())
        );

        PANEL_ENTRERPISE_ADRESSE2.setBackground(new java.awt.Color(0, 0, 0));

        jTextField17.setEditable(false);
        jTextField17.setBackground(new java.awt.Color(0, 0, 0));
        jTextField17.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(255, 255, 255));
        jTextField17.setText("Téléphone");
        jTextField17.setBorder(null);
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_ENTRERPISE_ADRESSE2Layout = new javax.swing.GroupLayout(PANEL_ENTRERPISE_ADRESSE2);
        PANEL_ENTRERPISE_ADRESSE2.setLayout(PANEL_ENTRERPISE_ADRESSE2Layout);
        PANEL_ENTRERPISE_ADRESSE2Layout.setHorizontalGroup(
            PANEL_ENTRERPISE_ADRESSE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTRERPISE_ADRESSE2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PANEL_ENTRERPISE_ADRESSE2Layout.setVerticalGroup(
            PANEL_ENTRERPISE_ADRESSE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTRERPISE_ADRESSE2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField17)
                .addContainerGap())
        );

        PANEL_ENTREPRISE_MAIL2.setBackground(new java.awt.Color(0, 0, 0));

        jTextField18.setEditable(false);
        jTextField18.setBackground(new java.awt.Color(0, 0, 0));
        jTextField18.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField18.setForeground(new java.awt.Color(255, 255, 255));
        jTextField18.setText("Adresse");
        jTextField18.setBorder(null);
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_ENTREPRISE_MAIL2Layout = new javax.swing.GroupLayout(PANEL_ENTREPRISE_MAIL2);
        PANEL_ENTREPRISE_MAIL2.setLayout(PANEL_ENTREPRISE_MAIL2Layout);
        PANEL_ENTREPRISE_MAIL2Layout.setHorizontalGroup(
            PANEL_ENTREPRISE_MAIL2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE_MAIL2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PANEL_ENTREPRISE_MAIL2Layout.setVerticalGroup(
            PANEL_ENTREPRISE_MAIL2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE_MAIL2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField18)
                .addContainerGap())
        );

        MDP_ENTREPRISE2.setBackground(new java.awt.Color(0, 0, 0));

        jTextField19.setEditable(false);
        jTextField19.setBackground(new java.awt.Color(0, 0, 0));
        jTextField19.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField19.setForeground(new java.awt.Color(255, 255, 255));
        jTextField19.setText("E-mail");
        jTextField19.setBorder(null);
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MDP_ENTREPRISE2Layout = new javax.swing.GroupLayout(MDP_ENTREPRISE2);
        MDP_ENTREPRISE2.setLayout(MDP_ENTREPRISE2Layout);
        MDP_ENTREPRISE2Layout.setHorizontalGroup(
            MDP_ENTREPRISE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MDP_ENTREPRISE2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MDP_ENTREPRISE2Layout.setVerticalGroup(
            MDP_ENTREPRISE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MDP_ENTREPRISE2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        REPONSE_NOM_ENTREPRISE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPONSE_NOM_ENTREPRISE2ActionPerformed(evt);
            }
        });

        REPONSE_MDP_ENTREPRISE2.setText("jPasswordField1");
        REPONSE_MDP_ENTREPRISE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPONSE_MDP_ENTREPRISE2ActionPerformed(evt);
            }
        });

        REPONSE_TELEPHONE_ENTREPRISE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPONSE_TELEPHONE_ENTREPRISE2ActionPerformed(evt);
            }
        });

        REPONSE_ADRESSE_ENTREPRISE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPONSE_ADRESSE_ENTREPRISE2ActionPerformed(evt);
            }
        });

        REPONSE_CAPACITE_ENTREPRISE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPONSE_CAPACITE_ENTREPRISE2ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        jTextField20.setEditable(false);
        jTextField20.setBackground(new java.awt.Color(0, 0, 0));
        jTextField20.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField20.setForeground(new java.awt.Color(255, 255, 255));
        jTextField20.setText("MDP");
        jTextField20.setBorder(null);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        jTextField22.setEditable(false);
        jTextField22.setBackground(new java.awt.Color(0, 0, 0));
        jTextField22.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField22.setForeground(new java.awt.Color(255, 255, 255));
        jTextField22.setText("Heure d'ouverture");
        jTextField22.setBorder(null);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        jTextField23.setEditable(false);
        jTextField23.setBackground(new java.awt.Color(0, 0, 0));
        jTextField23.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField23.setForeground(new java.awt.Color(255, 255, 255));
        jTextField23.setText("Heure de fermeture");
        jTextField23.setBorder(null);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });

        jTextField25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField25KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_CENTRELayout = new javax.swing.GroupLayout(PANEL_CENTRE);
        PANEL_CENTRE.setLayout(PANEL_CENTRELayout);
        PANEL_CENTRELayout.setHorizontalGroup(
            PANEL_CENTRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_CENTRELayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PANEL_CENTRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_ENTRERPISE_ADRESSE2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_ENTREPRISE_NOM2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_CENTRE_CAPACITE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MDP_ENTREPRISE2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_ENTREPRISE_MAIL2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(88, 88, 88)
                .addGroup(PANEL_CENTRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(REPONSE_ADRESSE_ENTREPRISE2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(REPONSE_TELEPHONE_ENTREPRISE2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(REPONSE_MDP_ENTREPRISE2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(REPONSE_NOM_ENTREPRISE2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(REPONSE_CAPACITE_ENTREPRISE2)
                    .addComponent(jTextField21)
                    .addComponent(jTextField24)
                    .addComponent(jTextField25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PANEL_CENTRELayout.setVerticalGroup(
            PANEL_CENTRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_CENTRELayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(PANEL_CENTRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PANEL_ENTREPRISE_NOM2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(REPONSE_NOM_ENTREPRISE2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_CENTRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PANEL_ENTRERPISE_ADRESSE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(REPONSE_TELEPHONE_ENTREPRISE2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_CENTRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(REPONSE_ADRESSE_ENTREPRISE2)
                    .addComponent(PANEL_ENTREPRISE_MAIL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_CENTRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MDP_ENTREPRISE2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_CENTRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(REPONSE_MDP_ENTREPRISE2)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_CENTRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PANEL_CENTRE_CAPACITE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(REPONSE_CAPACITE_ENTREPRISE2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_CENTRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField24)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_CENTRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(PANEL_CENTRE, "1");

        PANEL_ENTREPRISE_NOM1.setBackground(new java.awt.Color(0, 0, 0));

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(0, 0, 0));
        jTextField8.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setText("Nom");
        jTextField8.setBorder(null);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_ENTREPRISE_NOM1Layout = new javax.swing.GroupLayout(PANEL_ENTREPRISE_NOM1);
        PANEL_ENTREPRISE_NOM1.setLayout(PANEL_ENTREPRISE_NOM1Layout);
        PANEL_ENTREPRISE_NOM1Layout.setHorizontalGroup(
            PANEL_ENTREPRISE_NOM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE_NOM1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PANEL_ENTREPRISE_NOM1Layout.setVerticalGroup(
            PANEL_ENTREPRISE_NOM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE_NOM1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField8)
                .addContainerGap())
        );

        PANEL_ENTREPRISE8TEL1.setBackground(new java.awt.Color(0, 0, 0));

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(0, 0, 0));
        jTextField9.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setText("Prénom");
        jTextField9.setBorder(null);
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_ENTREPRISE8TEL1Layout = new javax.swing.GroupLayout(PANEL_ENTREPRISE8TEL1);
        PANEL_ENTREPRISE8TEL1.setLayout(PANEL_ENTREPRISE8TEL1Layout);
        PANEL_ENTREPRISE8TEL1Layout.setHorizontalGroup(
            PANEL_ENTREPRISE8TEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE8TEL1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        PANEL_ENTREPRISE8TEL1Layout.setVerticalGroup(
            PANEL_ENTREPRISE8TEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE8TEL1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        PANEL_ENTRERPISE_ADRESSE1.setBackground(new java.awt.Color(0, 0, 0));

        jTextField10.setEditable(false);
        jTextField10.setBackground(new java.awt.Color(0, 0, 0));
        jTextField10.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(255, 255, 255));
        jTextField10.setText("Téléphone");
        jTextField10.setBorder(null);
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_ENTRERPISE_ADRESSE1Layout = new javax.swing.GroupLayout(PANEL_ENTRERPISE_ADRESSE1);
        PANEL_ENTRERPISE_ADRESSE1.setLayout(PANEL_ENTRERPISE_ADRESSE1Layout);
        PANEL_ENTRERPISE_ADRESSE1Layout.setHorizontalGroup(
            PANEL_ENTRERPISE_ADRESSE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTRERPISE_ADRESSE1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PANEL_ENTRERPISE_ADRESSE1Layout.setVerticalGroup(
            PANEL_ENTRERPISE_ADRESSE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTRERPISE_ADRESSE1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField10)
                .addContainerGap())
        );

        PANEL_ENTREPRISE_MAIL1.setBackground(new java.awt.Color(0, 0, 0));

        jTextField11.setEditable(false);
        jTextField11.setBackground(new java.awt.Color(0, 0, 0));
        jTextField11.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(255, 255, 255));
        jTextField11.setText("Adresse");
        jTextField11.setBorder(null);
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_ENTREPRISE_MAIL1Layout = new javax.swing.GroupLayout(PANEL_ENTREPRISE_MAIL1);
        PANEL_ENTREPRISE_MAIL1.setLayout(PANEL_ENTREPRISE_MAIL1Layout);
        PANEL_ENTREPRISE_MAIL1Layout.setHorizontalGroup(
            PANEL_ENTREPRISE_MAIL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE_MAIL1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PANEL_ENTREPRISE_MAIL1Layout.setVerticalGroup(
            PANEL_ENTREPRISE_MAIL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_ENTREPRISE_MAIL1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField11)
                .addContainerGap())
        );

        MDP_ENTREPRISE1.setBackground(new java.awt.Color(0, 0, 0));

        jTextField12.setEditable(false);
        jTextField12.setBackground(new java.awt.Color(0, 0, 0));
        jTextField12.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(255, 255, 255));
        jTextField12.setText("E-mail");
        jTextField12.setBorder(null);
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MDP_ENTREPRISE1Layout = new javax.swing.GroupLayout(MDP_ENTREPRISE1);
        MDP_ENTREPRISE1.setLayout(MDP_ENTREPRISE1Layout);
        MDP_ENTREPRISE1Layout.setHorizontalGroup(
            MDP_ENTREPRISE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MDP_ENTREPRISE1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MDP_ENTREPRISE1Layout.setVerticalGroup(
            MDP_ENTREPRISE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MDP_ENTREPRISE1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        REPONSE_NOM_ENTREPRISE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPONSE_NOM_ENTREPRISE1ActionPerformed(evt);
            }
        });

        REPONSE_MDP_ENTREPRISE1.setText("jPasswordField1");
        REPONSE_MDP_ENTREPRISE1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                REPONSE_MDP_ENTREPRISE1KeyPressed(evt);
            }
        });

        REPONSE_ADRESSE_ENTREPRISE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPONSE_ADRESSE_ENTREPRISE1ActionPerformed(evt);
            }
        });

        REPONSE_MAIL_ENTREPRISE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPONSE_MAIL_ENTREPRISE1ActionPerformed(evt);
            }
        });

        REPONSE_TEL_ENTREPRISE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPONSE_TEL_ENTREPRISE1ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jTextField14.setEditable(false);
        jTextField14.setBackground(new java.awt.Color(0, 0, 0));
        jTextField14.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(255, 255, 255));
        jTextField14.setText("MDP");
        jTextField14.setBorder(null);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField14))
        );

        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_PARTICULIERLayout = new javax.swing.GroupLayout(PANEL_PARTICULIER);
        PANEL_PARTICULIER.setLayout(PANEL_PARTICULIERLayout);
        PANEL_PARTICULIERLayout.setHorizontalGroup(
            PANEL_PARTICULIERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_PARTICULIERLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PANEL_PARTICULIERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_ENTRERPISE_ADRESSE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_ENTREPRISE_NOM1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_ENTREPRISE8TEL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MDP_ENTREPRISE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_ENTREPRISE_MAIL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(PANEL_PARTICULIERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(REPONSE_MAIL_ENTREPRISE1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(REPONSE_ADRESSE_ENTREPRISE1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(REPONSE_MDP_ENTREPRISE1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(REPONSE_NOM_ENTREPRISE1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(REPONSE_TEL_ENTREPRISE1)
                    .addComponent(jTextField13))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        PANEL_PARTICULIERLayout.setVerticalGroup(
            PANEL_PARTICULIERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_PARTICULIERLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(PANEL_PARTICULIERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(REPONSE_NOM_ENTREPRISE1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(PANEL_ENTREPRISE_NOM1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PANEL_PARTICULIERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(REPONSE_TEL_ENTREPRISE1)
                    .addComponent(PANEL_ENTREPRISE8TEL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_PARTICULIERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(REPONSE_ADRESSE_ENTREPRISE1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(PANEL_ENTRERPISE_ADRESSE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_PARTICULIERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(REPONSE_MAIL_ENTREPRISE1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(PANEL_ENTREPRISE_MAIL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PANEL_PARTICULIERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MDP_ENTREPRISE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PANEL_PARTICULIERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(REPONSE_MDP_ENTREPRISE1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(96, 96, 96))
        );

        mainPanel.add(PANEL_PARTICULIER, "3");

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ENREGISTRER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        OPTIONS_TYPE.setBackground(new java.awt.Color(102, 102, 102));

        jCheckBox8.setBackground(new java.awt.Color(102, 102, 102));
        jCheckBox8.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jCheckBox8.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox8.setText("Textile");

        jCheckBox3.setBackground(new java.awt.Color(102, 102, 102));
        jCheckBox3.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("Organique");

        jCheckBox1.setBackground(new java.awt.Color(102, 102, 102));
        jCheckBox1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Carton");

        jCheckBox2.setBackground(new java.awt.Color(102, 102, 102));
        jCheckBox2.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Papier");

        jCheckBox6.setBackground(new java.awt.Color(102, 102, 102));
        jCheckBox6.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setText("Plastique");

        jCheckBox5.setBackground(new java.awt.Color(102, 102, 102));
        jCheckBox5.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setText("Verre");

        jCheckBox7.setBackground(new java.awt.Color(102, 102, 102));
        jCheckBox7.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setText("Electronique");

        jCheckBox9.setBackground(new java.awt.Color(102, 102, 102));
        jCheckBox9.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jCheckBox9.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox9.setText("Batteries");

        jCheckBox4.setBackground(new java.awt.Color(102, 102, 102));
        jCheckBox4.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("Métaux");

        jTextField26.setText("Type de déchets pris en charge");

        javax.swing.GroupLayout OPTIONS_TYPELayout = new javax.swing.GroupLayout(OPTIONS_TYPE);
        OPTIONS_TYPE.setLayout(OPTIONS_TYPELayout);
        OPTIONS_TYPELayout.setHorizontalGroup(
            OPTIONS_TYPELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OPTIONS_TYPELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OPTIONS_TYPELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OPTIONS_TYPELayout.createSequentialGroup()
                        .addGroup(OPTIONS_TYPELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(OPTIONS_TYPELayout.createSequentialGroup()
                                .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(OPTIONS_TYPELayout.createSequentialGroup()
                                .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(OPTIONS_TYPELayout.createSequentialGroup()
                                .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(OPTIONS_TYPELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OPTIONS_TYPELayout.setVerticalGroup(
            OPTIONS_TYPELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OPTIONS_TYPELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(OPTIONS_TYPELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(OPTIONS_TYPELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(OPTIONS_TYPELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox9))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(504, 504, 504)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
                .addComponent(jLabel_LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(425, 425, 425))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(OPTIONS_TYPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(753, 753, 753))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PANEL_VOUS_ETES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(906, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(574, 574, 574)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel_LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(PANEL_VOUS_ETES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(69, 69, 69)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(266, 266, 266))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OPTIONS_TYPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(364, 364, 364))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(162, 162, 162)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(442, Short.MAX_VALUE)))
        );

        mainPanel.getAccessibleContext().setAccessibleParent(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void REPONSE_TEL_ENTREPRISEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPONSE_TEL_ENTREPRISEActionPerformed
    REPONSE_ADRESSE_ENTREPRISE.requestFocusInWindow();
    }//GEN-LAST:event_REPONSE_TEL_ENTREPRISEActionPerformed

    private void REPONSE_TEL_ENTREPRISE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPONSE_TEL_ENTREPRISE1ActionPerformed
    REPONSE_ADRESSE_ENTREPRISE1.requestFocusInWindow();
    }//GEN-LAST:event_REPONSE_TEL_ENTREPRISE1ActionPerformed

    private void REPONSE_CAPACITE_ENTREPRISE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPONSE_CAPACITE_ENTREPRISE2ActionPerformed
    jTextField24.requestFocusInWindow();
    }//GEN-LAST:event_REPONSE_CAPACITE_ENTREPRISE2ActionPerformed

    private void BOUTON_CENTREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOUTON_CENTREActionPerformed
        mainPanel.setVisible(true);
        cl.show(mainPanel, "1");
        jButton2.setVisible(true);
        OPTIONS_TYPE.setVisible(true);

    }//GEN-LAST:event_BOUTON_CENTREActionPerformed

    private void BOUTON_ENTREPRISEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOUTON_ENTREPRISEActionPerformed
        mainPanel.setVisible(true);
        cl.show(mainPanel, "2");
        jButton2.setVisible(true);
        OPTIONS_TYPE.setVisible(false);
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        jCheckBox7.setSelected(false);
        jCheckBox8.setSelected(false);
        jCheckBox9.setSelected(false);
    }//GEN-LAST:event_BOUTON_ENTREPRISEActionPerformed

    private void BOUTTON_PARTICULIERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOUTTON_PARTICULIERActionPerformed
        mainPanel.setVisible(true);
        cl.show(mainPanel, "3");
        jButton2.setVisible(true);
        OPTIONS_TYPE.setVisible(false);
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        jCheckBox7.setSelected(false);
        jCheckBox8.setSelected(false);
        jCheckBox9.setSelected(false);

    }//GEN-LAST:event_BOUTTON_PARTICULIERActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    this.dispose();
    FAccueil menu = new FAccueil();
    menu.setLocationRelativeTo(null); // Centre la fenêtre à l'écran
    menu.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String nom, prenom, email, mdp, telephone, adresse, ouverture, fermeture, capacite;

    // Exemple pour CENTRE DE RECYCLAGE
    if (BOUTON_CENTRE.isSelected()) {
        nom = REPONSE_NOM_ENTREPRISE2.getText();
        email = jTextField21.getText();
        telephone= REPONSE_TELEPHONE_ENTREPRISE2.getText();
        mdp = REPONSE_MDP_ENTREPRISE2.getText();
        adresse = REPONSE_ADRESSE_ENTREPRISE2.getText();
        capacite = REPONSE_CAPACITE_ENTREPRISE2.getText().trim();
        ouverture = jTextField24.getText();
        fermeture = jTextField25.getText();

        // Validation : champs vides ?
        if (nom.isEmpty() || email.isEmpty() || mdp.isEmpty() || adresse.isEmpty() || ouverture.isEmpty() || fermeture.isEmpty() || capacite.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }


// Exemple : contrôle que le champ capacité contient bien un entier
if (!capacite.matches("\\d+")) {
    JOptionPane.showMessageDialog(this, "La capacité doit être un entier.");
    return;
}

if (!ouverture.matches("^([01]\\d|2[0-3]):[0-5]\\d$")) {
    JOptionPane.showMessageDialog(this, "L'heure d'ouverture doit être au format HH:MM (ex: 08:30).");
    return;
}

if (!fermeture.matches("^([01]\\d|2[0-3]):[0-5]\\d$")) {
    JOptionPane.showMessageDialog(this, "L'heure de fermeture doit être au format HH:MM (ex: 18:00).");
    return;
}

// Vérification du format (déjà fait avant normalement)
if (!ouverture.matches("^([01]\\d|2[0-3]):[0-5]\\d$") || !fermeture.matches("^([01]\\d|2[0-3]):[0-5]\\d$")) {
    JOptionPane.showMessageDialog(this, "Veuillez entrer les horaires au format HH:MM.", "Erreur", JOptionPane.ERROR_MESSAGE);
    return;
}

// Conversion des heures en minutes
String[] partsOuverture = ouverture.split(":");
String[] partsFermeture = fermeture.split(":");

int heuresOuverture = Integer.parseInt(partsOuverture[0]);
int minutesOuverture = Integer.parseInt(partsOuverture[1]);
int totalMinutesOuverture = heuresOuverture * 60 + minutesOuverture;

int heuresFermeture = Integer.parseInt(partsFermeture[0]);
int minutesFermeture = Integer.parseInt(partsFermeture[1]);
int totalMinutesFermeture = heuresFermeture * 60 + minutesFermeture;

// Comparaison
if (totalMinutesFermeture <= totalMinutesOuverture) {
    JOptionPane.showMessageDialog(this, "L'heure de fermeture doit être après l'heure d'ouverture.", "Erreur", JOptionPane.ERROR_MESSAGE);
    return;
}

// Exemple de concaténation des types de déchets cochés
if (emailExisteDeja(email)) {
    JOptionPane.showMessageDialog(this, "Cet email est déjà utilisé. Veuillez en choisir un autre.", "Erreur", JOptionPane.ERROR_MESSAGE);
    return;
}
         
String typesDechets = "";

// Vérifie si aucune case n'est cochée
if (!jCheckBox6.isSelected() && !jCheckBox5.isSelected() && !jCheckBox7.isSelected()
        && !jCheckBox2.isSelected() && !jCheckBox4.isSelected() && !jCheckBox9.isSelected()
        && !jCheckBox1.isSelected() && !jCheckBox3.isSelected() && !jCheckBox8.isSelected()) {
    
    JOptionPane.showMessageDialog(this, "Veuillez sélectionner au moins un type de déchet.", "Erreur", JOptionPane.ERROR_MESSAGE);
    return; // Empêche d'aller plus loin si aucune case cochée
}

// Ajout des types cochés
if (jCheckBox6.isSelected()) typesDechets += "Plastique;";
if (jCheckBox5.isSelected()) typesDechets += "Verre;";
if (jCheckBox7.isSelected()) typesDechets += "Electronique;";
if (jCheckBox2.isSelected()) typesDechets += "Papier;";
if (jCheckBox4.isSelected()) typesDechets += "Métaux;";
if (jCheckBox9.isSelected()) typesDechets += "Batteries;";
if (jCheckBox1.isSelected()) typesDechets += "Carton;";
if (jCheckBox3.isSelected()) typesDechets += "Organique;";
if (jCheckBox8.isSelected()) typesDechets += "Textile;";


        
        sauvegarde("CENTRE;" + nom + ";" + email + ";" + mdp + ";" + adresse + ";" + telephone + ";" + ouverture + ";" + fermeture + ";" + capacite + ";" + typesDechets);
    }

    // Exemple pour ENTREPRISE
    else if (BOUTON_ENTREPRISE.isSelected()) {
        nom = REPONSE_NOM_ENTREPRISE.getText();
        telephone = REPONSE_TEL_ENTREPRISE.getText().trim();
        email = REPONSE_MAIL_ENTREPRISE.getText();
        mdp = REPONSE_MDP_ENTREPRISE.getText();
        adresse = REPONSE_ADRESSE_ENTREPRISE.getText();

        if (nom.isEmpty() || email.isEmpty() || mdp.isEmpty() || adresse.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
 if (emailExisteDeja(email)) {
            JOptionPane.showMessageDialog(this, "Cet email est déjà utilisé. Veuillez en choisir un autre.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        sauvegarde("ENTREPRISE;" + nom + ";" + email + ";" + mdp + ";" + adresse + ";" + telephone);
    }

    // Pour PARTICULIER
    else if (BOUTTON_PARTICULIER.isSelected()) {
        nom = REPONSE_NOM_ENTREPRISE1.getText();
        prenom = REPONSE_TEL_ENTREPRISE1.getText();
        telephone = REPONSE_ADRESSE_ENTREPRISE1.getText();
        email = jTextField13.getText();
        mdp = REPONSE_MDP_ENTREPRISE1.getText();
        adresse = REPONSE_MAIL_ENTREPRISE1.getText();

        if (nom.isEmpty() || email.isEmpty() || mdp.isEmpty() || adresse.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
 if (emailExisteDeja(email)) {
            JOptionPane.showMessageDialog(this, "Cet email est déjà utilisé. Veuillez en choisir un autre.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        sauvegarde("PARTICULIER;" + nom + ";" + email + ";" + mdp + ";" + adresse + ";" + telephone + ";" + prenom);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void REPONSE_NOM_ENTREPRISEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPONSE_NOM_ENTREPRISEActionPerformed
    REPONSE_TEL_ENTREPRISE.requestFocusInWindow();
    }

    private void REPONSE_ADRESSE_ENTREPRISEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPONSE_ADRESSE_ENTREPRISEActionPerformed
    REPONSE_MAIL_ENTREPRISE.requestFocusInWindow();
    }

    private void REPONSE_MAIL_ENTREPRISEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPONSE_MAIL_ENTREPRISEActionPerformed
    REPONSE_MDP_ENTREPRISE.requestFocusInWindow();
    }//GEN-LAST:event_REPONSE_MAIL_ENTREPRISEActionPerformed

    private void REPONSE_MDP_ENTREPRISEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPONSE_MDP_ENTREPRISEActionPerformed
    }//GEN-LAST:event_REPONSE_MDP_ENTREPRISEActionPerformed

    private void REPONSE_MDP_ENTREPRISEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_REPONSE_MDP_ENTREPRISEKeyPressed
if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton2ActionPerformed(null); // Appelle la méthode d'action du bouton
        }    }//GEN-LAST:event_REPONSE_MDP_ENTREPRISEKeyPressed

    private void REPONSE_NOM_ENTREPRISE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPONSE_NOM_ENTREPRISE2ActionPerformed
    REPONSE_TELEPHONE_ENTREPRISE2.requestFocusInWindow();
    }//GEN-LAST:event_REPONSE_NOM_ENTREPRISE2ActionPerformed

    private void REPONSE_NOM_ENTREPRISE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPONSE_NOM_ENTREPRISE1ActionPerformed
    REPONSE_TEL_ENTREPRISE1.requestFocusInWindow();
    }//GEN-LAST:event_REPONSE_NOM_ENTREPRISE1ActionPerformed

    private void REPONSE_ADRESSE_ENTREPRISE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPONSE_ADRESSE_ENTREPRISE1ActionPerformed
    REPONSE_MAIL_ENTREPRISE1.requestFocusInWindow();
    }//GEN-LAST:event_REPONSE_ADRESSE_ENTREPRISE1ActionPerformed

    private void REPONSE_MAIL_ENTREPRISE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPONSE_MAIL_ENTREPRISE1ActionPerformed
    jTextField13.requestFocusInWindow();
    }//GEN-LAST:event_REPONSE_MAIL_ENTREPRISE1ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
    REPONSE_MDP_ENTREPRISE1.requestFocusInWindow();
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void REPONSE_TELEPHONE_ENTREPRISE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPONSE_TELEPHONE_ENTREPRISE2ActionPerformed
    REPONSE_ADRESSE_ENTREPRISE2.requestFocusInWindow();
    }//GEN-LAST:event_REPONSE_TELEPHONE_ENTREPRISE2ActionPerformed

    private void REPONSE_ADRESSE_ENTREPRISE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPONSE_ADRESSE_ENTREPRISE2ActionPerformed
    jTextField21.requestFocusInWindow();
    }//GEN-LAST:event_REPONSE_ADRESSE_ENTREPRISE2ActionPerformed

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
    REPONSE_MDP_ENTREPRISE2.requestFocusInWindow();
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void REPONSE_MDP_ENTREPRISE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPONSE_MDP_ENTREPRISE2ActionPerformed
    REPONSE_CAPACITE_ENTREPRISE2.requestFocusInWindow();
    }//GEN-LAST:event_REPONSE_MDP_ENTREPRISE2ActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
    jTextField25.requestFocusInWindow();
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void jTextField25KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField25KeyPressed
if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton2ActionPerformed(null); // Appelle la méthode d'action du bouton
}
     }//GEN-LAST:event_jTextField25KeyPressed

    private void REPONSE_MDP_ENTREPRISE1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_REPONSE_MDP_ENTREPRISE1KeyPressed
if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton2ActionPerformed(null); // Appelle la méthode d'action du bouton
        }
     }//GEN-LAST:event_REPONSE_MDP_ENTREPRISE1KeyPressed

private boolean emailExisteDeja(String email) {
    try (BufferedReader reader = new BufferedReader(new FileReader("utilisateurs.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            // Vérifier si l'email dans la ligne correspond à l'email à vérifier
            String[] parts = line.split(";");
            String emailExist = parts[2]; // L'email se trouve en 3ème position
            if (emailExist.equals(email)) {
                return true; // Email trouvé, existe déjà
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la lecture du fichier.", "Erreur", JOptionPane.ERROR_MESSAGE);
    }
    return false; // Email non trouvé
}

    private void sauvegarde(String ligne) {
    try (FileWriter writer = new FileWriter("utilisateurs.txt", true)) {
        writer.write(ligne.trim() + "\n"); // .trim() ici enlève les espaces en début/fin
        JOptionPane.showMessageDialog(this, "Inscription enregistrée avec succès !");
        this.dispose();
        FAccueil accueil = new FAccueil();
        accueil.setLocationRelativeTo(null); // Centrer la fenêtre
        accueil.setVisible(true);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la sauvegarde.", "Erreur", JOptionPane.ERROR_MESSAGE);
    }
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
            java.util.logging.Logger.getLogger(FInscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FInscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FInscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FInscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(() -> {
            FInscription dialog = new FInscription(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BOUTON_CENTRE;
    private javax.swing.JRadioButton BOUTON_ENTREPRISE;
    private javax.swing.JRadioButton BOUTTON_PARTICULIER;
    private javax.swing.JPanel MDP_ENTREPRISE;
    private javax.swing.JPanel MDP_ENTREPRISE1;
    private javax.swing.JPanel MDP_ENTREPRISE2;
    private javax.swing.JPanel OPTIONS_TYPE;
    private javax.swing.JPanel PANEL_CENTRE;
    private javax.swing.JPanel PANEL_CENTRE_CAPACITE;
    private javax.swing.JPanel PANEL_ENTREPRISE;
    private javax.swing.JPanel PANEL_ENTREPRISE8TEL;
    private javax.swing.JPanel PANEL_ENTREPRISE8TEL1;
    private javax.swing.JPanel PANEL_ENTREPRISE_MAIL;
    private javax.swing.JPanel PANEL_ENTREPRISE_MAIL1;
    private javax.swing.JPanel PANEL_ENTREPRISE_MAIL2;
    private javax.swing.JPanel PANEL_ENTREPRISE_NOM;
    private javax.swing.JPanel PANEL_ENTREPRISE_NOM1;
    private javax.swing.JPanel PANEL_ENTREPRISE_NOM2;
    private javax.swing.JPanel PANEL_ENTRERPISE_ADRESSE;
    private javax.swing.JPanel PANEL_ENTRERPISE_ADRESSE1;
    private javax.swing.JPanel PANEL_ENTRERPISE_ADRESSE2;
    private javax.swing.JPanel PANEL_PARTICULIER;
    private javax.swing.JPanel PANEL_VOUS_ETES;
    private javax.swing.JTextField REPONSE_ADRESSE_ENTREPRISE;
    private javax.swing.JTextField REPONSE_ADRESSE_ENTREPRISE1;
    private javax.swing.JTextField REPONSE_ADRESSE_ENTREPRISE2;
    private javax.swing.JTextField REPONSE_CAPACITE_ENTREPRISE2;
    private javax.swing.JTextField REPONSE_MAIL_ENTREPRISE;
    private javax.swing.JTextField REPONSE_MAIL_ENTREPRISE1;
    private javax.swing.JPasswordField REPONSE_MDP_ENTREPRISE;
    private javax.swing.JPasswordField REPONSE_MDP_ENTREPRISE1;
    private javax.swing.JPasswordField REPONSE_MDP_ENTREPRISE2;
    private javax.swing.JTextField REPONSE_NOM_ENTREPRISE;
    private javax.swing.JTextField REPONSE_NOM_ENTREPRISE1;
    private javax.swing.JTextField REPONSE_NOM_ENTREPRISE2;
    private javax.swing.JTextField REPONSE_TELEPHONE_ENTREPRISE2;
    private javax.swing.JTextField REPONSE_TEL_ENTREPRISE;
    private javax.swing.JTextField REPONSE_TEL_ENTREPRISE1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel_LOGO;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
