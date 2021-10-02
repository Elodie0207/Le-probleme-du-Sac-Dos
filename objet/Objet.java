package objet;

import java.util.Comparator;
import java.lang.String;

public class Objet {

    private boolean estALinterieur;
    private String chemin;
    private String nom;
    private float poids;
    private float prix;
    private float rapport;

    //Constructeur d'Objet
    public Objet(String nom, float poids, float prix){
        this.nom=nom;
        this.poids=poids;
        this.prix=prix;
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

    public void Rapport(){
        this.rapport=this.prix/this.poids;
    }
}
