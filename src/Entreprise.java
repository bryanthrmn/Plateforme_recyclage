// Bryan THIRIMANNA & Gabriel BREMME
// Projet Java - Semestre 4 
// EPF Engineering School

package projet_s4;

import java.util.ArrayList;
import java.util.List;

public class Entreprise extends Utilisateur {
    private List<DemandeCollecte> historiqueCollectes; // historique des demandes de collecte

    public Entreprise(String nom, String telephone, String adresse, String email, String motDePasse) {
        super(nom, telephone, adresse, email, motDePasse);
        this.historiqueCollectes = new ArrayList<>();
    }
    
    public void ajouterDemandeCollecte(DemandeCollecte demande) {
        historiqueCollectes.add(demande);
    }
    
    public void afficherHistoriqueCollecte() {
        System.out.println("\n--- Historique des collectes de " + nom + " ---");
        if (historiqueCollectes.isEmpty()) {
            System.out.println("Aucune demande de collecte effectuée.");
        } else {
            for (DemandeCollecte demande : historiqueCollectes) {
                System.out.println(demande);
            }
        }
    }
    
    // Getter nécessaire pour accéder à l'historique depuis PlateformeRecyclage
    public List<DemandeCollecte> getHistoriqueCollectes() {
        return historiqueCollectes;
    }
    
    @Override
    public String toString() {
        return "Entreprise," + super.toString();
    }
}
