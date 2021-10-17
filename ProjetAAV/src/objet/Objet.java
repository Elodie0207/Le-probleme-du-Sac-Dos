package objet;

import java.util.Comparator;
import java.lang.String;


/**
 * La classe Objet est un objet
 * Il est définit par un nom, un poids, un prix et un rapport
 *
 * @author Meryem Guldas & Sébastien Ramirez
 */
public class Objet {

    /**
     * Contient le chemin du fichier qui contient les objets avec leur nom, poids et prix
     */
    private String chemin;

    /**
     * Le nom de l'objet
     */
    private String nom;

    /**
     * Le poids de l'objet
     */
    private float poids;

    /**
     * Le prix de l'objet
     */
    private float prix;

    /**
     * Le rapport de l'objet (Rapport = prix/poids)
     */
    private float rapport;

    /**
     * Constructeur Objet qui contient le nom de l'objet, le poids de l'objet et le prix de l'objet
     * @param nom de l'objet
     * @param poids de l'objet
     * @param prix de l'objet
     */
    public Objet(String nom, float poids, float prix){
        this.nom=nom;
        this.poids=poids;
        this.prix=prix;
        this.rapport=this.prix/this.poids;
    }


    /**
     * Renvoie le nom de l'objet
     * @return String Nom
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Renvoie le poids de l'objet
     * @return float Poids
     */
    public float getPoids() {
        return this.poids;
    }

    /**
     * Renvoie le prix de l'objet
     * @return float Prix
     */
    public float getPrix() {
        return this.prix;
    }

    /**
     * Renvoie le rapport de l'objet (Rapport = prix/poids)
     * @return double Rapport
     */
    public double getRapport(){return this.rapport;}

    /**
     * Renvoie une chaine de caractere de l'ojet avec son nom, poids et prix
     * @return une chaine de caractère du type ("nom de l'objet" : "le poids de l'objet" ; "le prix de l'objet")
     */
    @Override
    public String toString() {
        return "  " + nom +  " : "  + "poids "+ poids +  " ; "  + " prix " + prix;
    }


    /**
     * Calcul le Rapport d'un objet (Rapport = prix/poids)
     */
    public void Rapport(){
        this.rapport=this.prix/this.poids;
    }
}
