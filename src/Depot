// Bryan THIRIMANNA & Gabriel BREMME
// Projet Java - Semestre 4 
// EPF Engineering School

package projet_s4;

public class Depot {
    private String emailConsommateur;
    private Dechet dechet;
    private String dateDepot;
    private CentreRecyclage centre;

    public Depot(String emailConsommateur, Dechet dechet) {
        this.emailConsommateur = emailConsommateur;
        this.dechet = dechet;
    }
    
    public void enregistrerDepot(String dateDepot, CentreRecyclage centre) {
        this.dateDepot = dateDepot;
        this.centre = centre;
    }
    
    // Getters pour la sauvegarde/chargement
    public String getEmailConsommateur() {
        return emailConsommateur;
    }
    public Dechet getDechet() {
        return dechet;
    }
    public String getDateDepot() {
        return dateDepot;
    }
    public CentreRecyclage getCentre() {
        return centre;
    }
    
    @Override
    public String toString() {
        return "Depot: " + dechet.getType() + " (" + dechet.getQuantite() + ") - Déposé le " + dateDepot + " à " + (centre != null ? centre.getNom() : "N/A");
    }
}
