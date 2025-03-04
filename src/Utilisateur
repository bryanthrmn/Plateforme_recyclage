// Bryan THIRIMANNA & Gabriel BREMME
// Projet Java - Semestre 4 
// EPF Engineering School

package projet_s4;

public class Utilisateur {
    protected String nom;
    protected String telephone;
    protected String adresse;
    protected String email;
    protected String motDePasse;

    public Utilisateur(String nom, String telephone, String adresse, String email, String motDePasse) {
        this.nom = nom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public boolean verifierMotDePasse(String mot) {
        return this.motDePasse.equals(mot);
    }
    
    // Getters
    public String getNom() { return nom; }
    public String getTelephone() { return telephone; }
    public String getAdresse() { return adresse; }
    public String getEmail() { return email; }
    public String getMotDePasse() { return motDePasse; }
    
    @Override
    public String toString() {
        return nom + "," + telephone + "," + adresse + "," + email + "," + motDePasse;
    }
}
