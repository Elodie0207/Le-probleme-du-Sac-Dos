import objet.Objet;

public class SacADos {
    private boolean vide;
    private String chemin;
    private static float poidsMaximal=30;

    Objet objet;
    //Constructeur générant un sac vide
    public SacADos () {
        objet= null;
        vide= true;
    }

    // Constructeur Sac à dos
    public SacADos(String chemin, float poidsMaximal){
        this.chemin=chemin;
        this.poidsMaximal=poidsMaximal;
        objet = null;

    }


    public void resoudre() {


    }
}
