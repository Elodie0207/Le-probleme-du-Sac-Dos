package objet;

import java.util.Comparator;

public class Objet {

    private boolean estALinterieur;
    private String chemin;
    private String nom;
    private double poids;
    private double prix;
    private double rapport;

    //Constructeur d'Objet
    public Objet(String nom, double poids, double prix){
        this.nom=nom;
        this.poids=poids;
        this.prix=prix;
        this.rapport=prix/poids;
    }



    public String getNom() {
        return this.nom;
    }

    public double getPoids() {
        return this.poids;
    }

    public double getPrix() {
        return this.prix;
    }


    public double getRapport(){return this.rapport;}
    @Override
    public String toString() {
        return "  " + nom +  " : "  + "poids "+ poids +  " ; "  + " prix " + prix;
    }


    public boolean EstALinterieur(){
        return true;
    }

    public static Comparator <Objet> rapport() {
        return ((o1, o2) -> Double.compare(o2.getRapport(),o1.getRapport()));
    }
}

}
