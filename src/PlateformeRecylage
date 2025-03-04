// Bryan THIRIMANNA & Gabriel BREMME
// Projet Java - Semestre 4 
// EPF Engineering School

package projet_s4;

import java.io.*;
import java.util.*;

public class PlateformeRecyclage implements InterfacePlateforme {

    private final String FICHIER_UTILISATEURS = "utilisateurs.txt";
    private final String FICHIER_CENTRES = "centres.txt";
    private final String FICHIER_DEMANDES = "demandes.txt";
    private final String FICHIER_DEPOTS = "depots.txt";
    
    private List<Utilisateur> utilisateurs = new ArrayList<>();
    private List<CentreRecyclage> centres = new ArrayList<>();
    private List<DemandeCollecte> demandes = new ArrayList<>();
    private List<Depot> depots = new ArrayList<>();
    
    private Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        PlateformeRecyclage plateforme = new PlateformeRecyclage();
        plateforme.chargerUtilisateurs();
        plateforme.chargerCentres();
        plateforme.chargerDemandes();
        plateforme.chargerDepots();
        plateforme.menuPrincipal();
        plateforme.sauvegarderUtilisateurs();
        plateforme.sauvegarderCentres();
        plateforme.sauvegarderDemandes();
        plateforme.sauvegarderDepots();
    }
    
    private void menuPrincipal() {
        while (true) {
            System.out.println("\n--- Plateforme de Recyclage ---");
            System.out.println("1. Connexion");
            System.out.println("2. Inscription");
            System.out.println("3. Afficher mon menu utilisateur");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option : ");
            String choix = scanner.nextLine();
            switch (choix) {
                case "1" -> connexion();
                case "2" -> inscription();
                case "3" -> afficherMenuUtilisateur();
                case "4" -> {
                    System.out.println("Sauvegarde des donnees et fermeture...");
                    return;
                }
                default -> System.out.println("Option invalide !");
            }
        }
    }
    
    // ------------------ Méthodes de l'interface ------------------

    @Override
    public void inscription() {
        System.out.println("\n--- Inscription ---");
        System.out.println("1. Consommateur");
        System.out.println("2. Entreprise");
        System.out.println("3. Centre de recyclage");
        System.out.print("Choisissez le type d'utilisateur : ");
        String choix = scanner.nextLine();
        
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Telephone : ");
        String telephone = scanner.nextLine();
        System.out.print("Adresse : ");
        String adresse = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();
        
        switch (choix) {
            case "1" -> {
                System.out.print("Prenom : ");
                String prenom = scanner.nextLine();
                Consommateur consommateur = new Consommateur(prenom, nom, telephone, adresse, email, motDePasse);
                utilisateurs.add(consommateur);
                System.out.println("Inscription reussie pour le consommateur " + prenom + " " + nom);
            }
            case "2" -> {
                Entreprise entreprise = new Entreprise(nom, telephone, adresse, email, motDePasse);
                utilisateurs.add(entreprise);
                System.out.println("Inscription reussie pour l'entreprise " + nom);
            }
            case "3" -> {
                System.out.print("Horaires d'ouverture : ");
                String horaires = scanner.nextLine();
                System.out.print("Capacité de stockage : ");
                int capacite = Integer.parseInt(scanner.nextLine());
                System.out.print("Types de déchets acceptes (separes par des virgules) : ");
                List<String> types = Arrays.asList(scanner.nextLine().split(","));
                CentreRecyclage centre = new CentreRecyclage(nom, telephone, adresse, email, motDePasse, types, horaires, capacite);
                utilisateurs.add(centre);
                centres.add(centre);
                System.out.println("Inscription reussie pour le centre " + nom);
            }
            default -> System.out.println("Choix invalide !");
        }
    }

    @Override
    public void connexion() {
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();
        
        for (Utilisateur user : utilisateurs) {
            if (user.getEmail().equals(email) && user.verifierMotDePasse(motDePasse)) {
                switch (user) {
                    case Consommateur consommateur -> menuConsommateur(consommateur);
                    case Entreprise entreprise -> menuEntreprise(entreprise);
                    case CentreRecyclage centreRecyclage -> menuCentreRecyclage(centreRecyclage);
                    default -> {
                    }
                }
                return;
            }
        }
        System.out.println("Identifiants incorrects !");
    }

    @Override
    public void afficherMenuUtilisateur() {
        System.out.print("Entrez votre email pour afficher votre menu utilisateur : ");
        String email = scanner.nextLine();
        for (Utilisateur user : utilisateurs) {
            if (user.getEmail().equals(email)) {
                switch (user) {
                    case Consommateur consommateur -> menuConsommateur(consommateur);
                    case Entreprise entreprise -> menuEntreprise(entreprise);
                    case CentreRecyclage centreRecyclage -> menuCentreRecyclage(centreRecyclage);
                    default -> {
                    }
                }
                return;
            }
        }
        System.out.println("Utilisateur non trouve.");
    }

    @Override
    public void sauvegarderUtilisateurs() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FICHIER_UTILISATEURS))) {
            for (Utilisateur user : utilisateurs) {
                if (user instanceof Consommateur c) {
                    writer.println("Consommateur;" + c.getPrenom() + ";" + c.toString());
                } else if (user instanceof Entreprise) {
                    writer.println("Entreprise;" + user.toString());
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des utilisateurs : " + e.getMessage());
        }
    }

    @Override
    public void chargerUtilisateurs() {
    utilisateurs.clear();
    try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER_UTILISATEURS))) {
        String line;
        while ((line = reader.readLine()) != null) {
            // Split the line and check if it has enough parts
            String[] parts = line.split(";");
            
            // Minimum validation to prevent ArrayIndexOutOfBoundsException
            if (parts.length < 2) {
                System.out.println("Ligne invalide ignoree : " + line);
                continue;
            }
            
            try {
                if (parts[0].equals("Consommateur")) {
                    // Ensure we have enough parts for a Consommateur
                    if (parts.length < 3) {
                        System.out.println("Donnees de consommateur incomplètes : " + line);
                        continue;
                    }
                    
                    // parts[1] = prenom, parts[2] contient le reste (nom, téléphone, adresse, email, motDePasse)
                    String[] infos = parts[2].split(",");
                    
                    // Validate that infos array has enough elements
                    if (infos.length < 5) {
                        System.out.println("Informations de consommateur incompletes : " + line);
                        continue;
                    }
                    
                    Consommateur c = new Consommateur(
                        parts[1],      // prenom
                        infos[0],      // nom
                        infos[1],      // telephone
                        infos[2],      // adresse
                        infos[3],      // email
                        infos[4]       // motDePasse
                    );
                    utilisateurs.add(c);
                    
                } else if (parts[0].equals("Entreprise")) {
                    // Ensure we have enough parts for an Entreprise
                    if (parts.length < 2) {
                        System.out.println("Données d'entreprise incompletes : " + line);
                        continue;
                    }
                    
                    String[] infos = parts[1].split(",");
                    
                    // Validate that infos array has enough elements
                    if (infos.length < 5) {
                        System.out.println("Informations d'entreprise incompletes : " + line);
                        continue;
                    }
                    
                    Entreprise e = new Entreprise(
                        infos[0],      // nom
                        infos[1],      // telephone
                        infos[2],      // adresse
                        infos[3],      // email
                        infos[4]       // motDePasse
                    );
                    utilisateurs.add(e);
                }
            } catch (Exception e) {
                System.out.println("Erreur lors du chargement d'un utilisateur : " + line);
                System.out.println("Details de l'erreur : " + e.getMessage());
            }
        }
    } catch (IOException e) {
        System.out.println("Aucun fichier utilisateurs trouve, initialisation vide.");
    }
    
    // Optional: Print number of users loaded
    System.out.println("Nombre d'utilisateurs charges : " + utilisateurs.size());
}
    @Override
    public void sauvegarderDemandes() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FICHIER_DEMANDES))) {
            for (DemandeCollecte demande : demandes) {
                // Format : emailEntreprise;dechetType;dechetQuantite;acceptee;dateCollecte;centreEmail
                String centreEmail = (demande.getCentre() != null) ? demande.getCentre().getEmail() : "null";
                String dateCollecte = (demande.getDateCollecte() != null) ? demande.getDateCollecte() : "null";
                writer.println(demande.getEmailEntreprise() + ";" 
                        + demande.getDechet().getType() + ";" 
                        + demande.getDechet().getQuantite() + ";" 
                        + demande.isAcceptee() + ";" 
                        + dateCollecte + ";" 
                        + centreEmail);
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des demandes : " + e.getMessage());
        }
    }

    @Override
    public void chargerDemandes() {
        demandes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER_DEMANDES))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Format : emailEntreprise;dechetType;dechetQuantite;acceptee;dateCollecte;centreEmail
                String[] parts = line.split(";");
                if (parts.length >= 6) {
                    String emailEntreprise = parts[0];
                    String dechetType = parts[1];
                    int quantite = Integer.parseInt(parts[2]);
                    boolean acceptee = Boolean.parseBoolean(parts[3]);
                    String dateCollecte = parts[4].equals("null") ? null : parts[4];
                    String centreEmail = parts[5].equals("null") ? null : parts[5];
                    
                    DemandeCollecte demande = new DemandeCollecte(emailEntreprise, new Dechet(dechetType, quantite));
                    if (acceptee) {
                        CentreRecyclage centreAssocie = null;
                        if (centreEmail != null) {
                            for (CentreRecyclage c : centres) {
                                if (c.getEmail().equals(centreEmail)) {
                                    centreAssocie = c;
                                    break;
                                }
                            }
                        }
                        demande.accepterDemande(dateCollecte, centreAssocie);
                    }
                    demandes.add(demande);
                }
            }
        } catch (IOException e) {
            System.out.println("Aucun fichier demandes trouve, initialisation vide.");
        }
    }

    @Override
    public void deposerDechet() {
        System.out.print("Entrez votre email (consommateur) pour deposer des déchets : ");
        String email = scanner.nextLine();
        for (Utilisateur user : utilisateurs) {
            if (user instanceof Consommateur && user.getEmail().equals(email)) {
                Consommateur consommateur = (Consommateur) user;
                deposerDechet(consommateur);
                return;
            }
        }
        System.out.println("Aucun consommateur trouve avec cet email.");
    }
    
    // ------------------ Méthodes complémentaires ------------------
    
    // Ces méthodes ne font pas partie de l'interface et sont appelées par notre code interne.

    private void menuConsommateur(Consommateur consommateur) {
        while (true) {
            System.out.println("\n--- Menu Consommateur ---");
            System.out.println("1. Rechercher un centre de recyclage");
            System.out.println("2. Voir mon historique de dépots");
            System.out.println("3. Deposer des dechets");
            System.out.println("4. Deconnexion");
            System.out.print("Choisissez une option : ");
            String choix = scanner.nextLine();
            switch (choix) {
                case "1" -> rechercherCentre();
                case "2" -> consommateur.afficherHistoriqueDepots();
                case "3" -> deposerDechet(consommateur);
                case "4" -> {
                    return;
                }
                default -> System.out.println("Option invalide !");
            }
        }
    }
    
    private void menuEntreprise(Entreprise entreprise) {
        while (true) {
            System.out.println("\n--- Menu Entreprise ---");
            System.out.println("1. Faire une demande de collecte");
            System.out.println("2. Voir mes collectes a venir");
            System.out.println("3. Deconnexion");
            System.out.print("Choisissez une option : ");
            String choix = scanner.nextLine();
            switch (choix) {
                case "1" -> faireDemandeCollecte(entreprise);
                case "2" -> entreprise.afficherHistoriqueCollecte();
                case "3" -> {
                    return;
                }
                default -> System.out.println("Option invalide !");
            }
        }
    }
    
    private void menuCentreRecyclage(CentreRecyclage centre) {
        while (true) {
            System.out.println("\n--- Menu Centre de Recyclage ---");
            System.out.println("1. Voir demandes de collecte");
            System.out.println("2. Voir mon historique de collectes/depots");
            System.out.println("3. Deconnexion");
            System.out.print("Choisissez une option : ");
            String choix = scanner.nextLine();
            switch (choix) {
                case "1" -> traiterDemandeCollecte(centre);
                case "2" -> centre.afficherHistoriqueCollecte();
                case "3" -> {
                    return;
                }
                default -> System.out.println("Option invalide !");
            }
        }
    }
    
    private void rechercherCentre() {
        System.out.println("\n--- Centres de Recyclage Disponibles ---");
        for (CentreRecyclage centre : centres) {
            centre.afficherInfos();
        }
    }
    
    private void faireDemandeCollecte(Entreprise entreprise) {
        System.out.print("Type de déchets : ");
        String type = scanner.nextLine();
        System.out.print("Quantité : ");
        int quantite = Integer.parseInt(scanner.nextLine());
        Dechet dechet = new Dechet(type, quantite);
        DemandeCollecte demande = new DemandeCollecte(entreprise.getEmail(), dechet);
        entreprise.ajouterDemandeCollecte(demande);
        demandes.add(demande);
        System.out.println("Demande de collecte enregistree !");
    }
    
    private void traiterDemandeCollecte(CentreRecyclage centre) {
        System.out.print("Saisir l'email de l'entreprise demandant la collecte : ");
        String email = scanner.nextLine();
        for (Utilisateur user : utilisateurs) {
            if (user instanceof Entreprise && user.getEmail().equals(email)) {
                Entreprise entreprise = (Entreprise) user;
                entreprise.afficherHistoriqueCollecte();
                System.out.print("Accepter la dernière demande en attente ? (O/N) : ");
                if (scanner.nextLine().equalsIgnoreCase("O")) {
                    System.out.print("Date de collecte (JJ/MM/AAAA) : ");
                    String date = scanner.nextLine();
                    // Recherche de la dernière demande non acceptée
                    for (int i = entreprise.getHistoriqueCollectes().size() - 1; i >= 0; i--) {
                        DemandeCollecte demande = entreprise.getHistoriqueCollectes().get(i);
                        if (!demande.isAcceptee()) {
                            demande.accepterDemande(date, centre);
                            centre.ajouterCollecte(demande);
                            System.out.println("Demande acceptee !");
                            return;
                        }
                    }
                    System.out.println("Aucune demande en attente trouvee.");
                }
                return;
            }
        }
        System.out.println("Aucune entreprise trouvee avec cet email.");
    }
    
    private void deposerDechet(Consommateur consommateur) {
        System.out.print("Choisissez un centre de recyclage pour deposer vos dechets (entrez l'email du centre) : ");
        String emailCentre = scanner.nextLine();
        CentreRecyclage centreTrouve = null;
        for (CentreRecyclage centre : centres) {
            if (centre.getEmail().equals(emailCentre)) {
                centreTrouve = centre;
                break;
            }
        }
        if (centreTrouve == null) {
            System.out.println("Centre non trouve !");
            return;
        }
        System.out.print("Type de dechets : ");
        String type = scanner.nextLine();
        System.out.print("Quantite : ");
        int quantite = Integer.parseInt(scanner.nextLine());
        System.out.print("Date de depot (JJ/MM/AAAA) : ");
        String dateDepot = scanner.nextLine();
        Dechet dechet = new Dechet(type, quantite);
        consommateur.deposerDechet(centreTrouve, dechet, dateDepot);
        // Enregistrement global pour sauvegarde
        Depot depot = new Depot(consommateur.getEmail(), dechet);
        depot.enregistrerDepot(dateDepot, centreTrouve);
        depots.add(depot);
    }

    // Sauvegarde et chargement des centres et des dépôts (méthodes complémentaires)

    public void sauvegarderCentres() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FICHIER_CENTRES))) {
            for (CentreRecyclage centre : centres) {
                // Format : CentreRecyclage,nom,telephone,adresse,email,motDePasse,types(separés par ;),horaires,capacite
                writer.println(centre.toString());
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des centres : " + e.getMessage());
        }
    }

    public void sauvegarderDepots() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FICHIER_DEPOTS))) {
            for (Depot depot : depots) {
                // Format : emailConsommateur;dechetType;dechetQuantite;dateDepot;centreEmail
                String centreEmail = (depot.getCentre() != null) ? depot.getCentre().getEmail() : "null";
                writer.println(depot.getEmailConsommateur() + ";" 
                        + depot.getDechet().getType() + ";" 
                        + depot.getDechet().getQuantite() + ";" 
                        + depot.getDateDepot() + ";" 
                        + centreEmail);
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des depots : " + e.getMessage());
        }
    }

    public void chargerCentres() {
        centres.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER_CENTRES))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Format attendu : CentreRecyclage,nom,telephone,adresse,email,motDePasse,types(separés par ;),horaires,capacite
                String[] parts = line.split(",");
                if (parts[0].equals("CentreRecyclage")) {
                    List<String> types = Arrays.asList(parts[6].split(";"));
                    CentreRecyclage centre = new CentreRecyclage(parts[1], parts[2], parts[3], parts[4], parts[5], types, parts[7], Integer.parseInt(parts[8]));
                    centres.add(centre);
                    utilisateurs.add(centre);
                }
            }
        } catch (IOException e) {
            System.out.println("Aucun fichier centres trouve, initialisation vide.");
        }
        // Si aucun centre n'est chargé, initialiser 3 centres par défaut.
        if (centres.isEmpty()) {
            System.out.println("Aucun centre de recyclage trouvé. Initialisation des centres par défaut.");
            CentreRecyclage centre1 = new CentreRecyclage("Centre Eco", "0123456789", "123 Rue Verte", "eco@centre.com", "pass", Arrays.asList("Electronique", "Papier"), "08:00-18:00", 500);
            CentreRecyclage centre2 = new CentreRecyclage("RecyclePlus", "0987654321", "45 Avenue Durable", "recycle@plus.com", "pass", Arrays.asList("Plastique", "Metal"), "09:00-17:00", 300);
            CentreRecyclage centre3 = new CentreRecyclage("GreenCenter", "0567890123", "78 Boulevard Écolo", "green@center.com", "pass", Arrays.asList("Batteries", "Electronique"), "07:00-15:00", 400);
            centres.add(centre1);
            centres.add(centre2);
            centres.add(centre3);
            utilisateurs.add(centre1);
            utilisateurs.add(centre2);
            utilisateurs.add(centre3);
        }
    }

    public void chargerDepots() {
        depots.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER_DEPOTS))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Format : emailConsommateur;dechetType;dechetQuantite;dateDepot;centreEmail
                String[] parts = line.split(";");
                if (parts.length >= 5) {
                    String emailConsommateur = parts[0];
                    String dechetType = parts[1];
                    int quantite = Integer.parseInt(parts[2]);
                    String dateDepot = parts[3];
                    String centreEmail = parts[4].equals("null") ? null : parts[4];
                    CentreRecyclage centreAssocie = null;
                    if (centreEmail != null) {
                        for (CentreRecyclage c : centres) {
                            if (c.getEmail().equals(centreEmail)) {
                                centreAssocie = c;
                                break;
                            }
                        }
                    }
                    Depot depot = new Depot(emailConsommateur, new Dechet(dechetType, quantite));
                    depot.enregistrerDepot(dateDepot, centreAssocie);
                    depots.add(depot);
                }
            }
        } catch (IOException e) {
            System.out.println("Aucun fichier depots trouvé, initialisation vide.");
        }
    }
}
