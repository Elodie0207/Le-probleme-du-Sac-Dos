package objet;

public class Objet {

    private boolean estALinterieur;
    private String chemin;
    private String nom;
    private float poids;
    private float prix;
    private float valeur;

    
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
    public float getValeur() {
        return valeur;
    }
    @Override
    public String toString() {
        return "  " + nom +  " : "  + "poids "+ poids +  " ; "  + " valeur " + prix;
    }


    public boolean EstALinterieur(){
        return true;
    }
}
