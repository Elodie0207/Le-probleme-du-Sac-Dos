package objet;

import java.util.ArrayList;

public class Objet {
    private String nom;
    private float poids;
    private float prix;
    private ArrayList<String> ListeObjet;

    //Constructeur d'Objet
    public Objet(String nom, float poids, float prix){
        this.nom=nom;
        this.poids=poids;
        this.prix=prix;
    }

    public String getNom() {
        return nom;
    }

    public float getPoids() {
        return poids;
    }

    public float getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "  " + nom +  " : "  + "poids "+ poids +  " ; "  + " valeur " + prix;
    }


}
