// Bryan THIRIMANNA & Gabriel BREMME
// Projet Java - Semestre 4 
// EPF Engineering School

package projet_s4;

class Dechet {
    private String type;
    private int quantite;package projet_s4;

public class Dechet {
    private String type;
    private int quantite; // en unité ou kg

    public Dechet(String type, int quantite) {
        this.type = type;
        this.quantite = quantite;
    }

    public String getType() {
        return type;
    }
    public int getQuantite() {
        return quantite;
    }
    
    @Override
    public String toString() {
        return type + "," + quantite;
    }
}


    public Dechet(String type, int quantite) {
        this.type = type;
        this.quantite = quantite;
    }

    public String getType() { return type; }
    public int getQuantite() { return quantite; }

    @Override
    public String toString() {
        return type + "," + quantite;
    }

    public static Dechet fromString(String data) {
        String[] parts = data.split(",");
        return new Dechet(parts[0], Integer.parseInt(parts[1]));
    }
}
