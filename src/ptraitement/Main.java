package ptraitement;

import pfiches.FAccueil;  // Assure-toi que l'importation de FAccueil est correcte

public class Main {

    public static class Session {
        public static String mailEntreprise = "0";
    }



    public static void main(String[] args) {
        FAccueil fAccueil = new FAccueil();
        fAccueil.setVisible(true);
    }
}
