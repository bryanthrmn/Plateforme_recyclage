// Bryan THIRIMANNA & Gabriel BREMME
// Projet Java - Semestre 4 
// EPF Engineering School

package projet_s4;

import java.util.ArrayList;
import java.util.List;

public class CentreRecyclage extends Utilisateur {
    private List<String> typesDechetsAcceptes;
    private String horaires;
    private int capaciteStockage;
    
    private List<DemandeCollecte> historiqueCollectes; // demandes de collecte acceptées
    private List<Depot> historiqueDepots; // dépôts effectués par des consommateurs

    public CentreRecyclage(String nom, String telephone, String adresse, String email, String motDePasse,
                             List<String> typesDechetsAcceptes, String horaires, int capaciteStockage) {
        super(nom, telephone, adresse, email, motDePasse);
        this.typesDechetsAcceptes = typesDechetsAcceptes;
        this.horaires = horaires;
        this.capaciteStockage = capaciteStockage;
        this.historiqueCollectes = new ArrayList<>();
        this.historiqueDepots = new ArrayList<>();
    }
    
    public List<String> getTypesDechetsAcceptes() {
        return typesDechetsAcceptes;
    }
    
    public String getHorairesOuverture() {
        return horaires;
    }
    
    public int getCapaciteStockage() {
        return capaciteStockage;
    }
    
    public void afficherInfos() {
        System.out.println("Centre : " + nom + " | Adresse : " + adresse + " | Horaires : " + horaires);
        System.out.println("Types de dechets acceptes : " + typesDechetsAcceptes);
        System.out.println("Capacite de stockage : " + capaciteStockage);
    }
    
    public void ajouterCollecte(DemandeCollecte demande) {
        historiqueCollectes.add(demande);
    }
    
    public void ajouterDepot(Depot depot) {
        historiqueDepots.add(depot);
    }
    
    public void afficherHistoriqueCollecte() {
        System.out.println("\n--- Historique des collectes (demandes acceptees) et depots pour " + nom + " ---");
        if (historiqueCollectes.isEmpty() && historiqueDepots.isEmpty()) {
            System.out.println("Aucune collecte ou depot enregistre.");
        } else {
            if (!historiqueCollectes.isEmpty()) {
                System.out.println("Demandes de collecte:");
                for (DemandeCollecte demande : historiqueCollectes) {
                    System.out.println(demande);
                }
            }
            if (!historiqueDepots.isEmpty()) {
                System.out.println("Depots de consommateurs:");
                for (Depot depot : historiqueDepots) {
                    System.out.println(depot);
                }
            }
        }
    }
    
    @Override
    public String toString() {
        // Les types de déchets sont séparés par des points-virgules
        return "CentreRecyclage," + super.toString() + "," + String.join(";", typesDechetsAcceptes) + "," + horaires + "," + capaciteStockage;
    }
}
