// Bryan THIRIMANNA & Gabriel BREMME
// Projet Java - Semestre 4 
// EPF Engineering School

package projet_s4;

public class DemandeCollecte {
    private String emailEntreprise;
    private Dechet dechet;
    private boolean acceptee;
    private String dateCollecte; // date de collecte fixée
    private CentreRecyclage centre;

    public DemandeCollecte(String emailEntreprise, Dechet dechet) {
        this.emailEntreprise = emailEntreprise;
        this.dechet = dechet;
        this.acceptee = false;
        this.dateCollecte = null;
        this.centre = null;
    }
    
    public void accepterDemande(String dateCollecte, CentreRecyclage centre) {
        this.acceptee = true;
        this.dateCollecte = dateCollecte;
        this.centre = centre;
    }
    
    // Getters nécessaires pour la sauvegarde/chargement
    public String getEmailEntreprise() {
        return emailEntreprise;
    }
    public Dechet getDechet() {
        return dechet;
    }
    public boolean isAcceptee() {
        return acceptee;
    }
    public String getDateCollecte() {
        return dateCollecte;
    }
    public CentreRecyclage getCentre() {
        return centre;
    }
    
    @Override
    public String toString() {
        return "DemandeCollecte: " + dechet.getType() + " (" + dechet.getQuantite() + ") - " +
                (acceptee ? "Acceptée le " + dateCollecte + " par " + (centre != null ? centre.getNom() : "N/A") : "En attente");
    }
}
