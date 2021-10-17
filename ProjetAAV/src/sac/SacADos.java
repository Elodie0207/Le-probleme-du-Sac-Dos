package sac;

import methode.Dynamique;
import methode.Glouton;
import methode.PSE;
import objet.Objet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

/**
 * La classe SacADos est un sac à dos
 * Il est défini par un poidsMaximal, un poids (le poids des objets), un prixTotal, une liste d'objets qui sont dans le
 * sac et d'une liste d'objets
 *
 * @author Meryem Guldas & Sébastien Ramirez
 */

public class SacADos {
    private boolean vide;
    /**
     * Chemin du fichier qui contient les objets et donc le nom, le poids et le prix
     */
    private String chemin;
    /**
     * Poids maximal que peut avoir le sac à dos
     */
    private float poidsMaximal;
    /**
     * Poids actuelle du sac à dos
     */
    private float poids;
    /**
     * Prix total du sac à dos
     */

    private float prixTotal;
    /**
     * Liste des objets actuelle dans le sac à dos
     */
    ArrayList<Objet> objDansLeSac;
    /**
     * Liste de tout les objets
     */
    static ArrayList<Objet> listeObjets;


    /**
     * Constructeur générant un sac à dos vide
     */
    public SacADos() {

    }

    /**
     * Constructeur générant un sac à dos avec une liste d'objets et une liste d'objets dans le sa
     * @param chemin du fichier qui contient les objets
     * @param poidsMaximal du sac
     */
    public SacADos(String chemin, float poidsMaximal) {
        this.chemin = chemin;
        this.poidsMaximal = poidsMaximal;
        this.listeObjets=new ArrayList<Objet>();
        this.objDansLeSac=new ArrayList<Objet>();

        /**
         * Permet de split le fichier au point vigule et l'ajoute dans listeObjets
         */
        try {
            Scanner sc = new Scanner(new File(chemin));
            while (sc.hasNext()) {
                String ligne = sc.nextLine();
                String[] tabSplit = ligne.split(";"); //O
                this.listeObjets.add(new Objet(tabSplit[0],Float.parseFloat(tabSplit[1]),Float.parseFloat(tabSplit[2])));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Resout le problème du sac en lui indiquant la méthode à utiliser (Gloutonne, Dynamique, PSE)
     */
    public void resoudreGlouton() {

        Glouton glouton = new Glouton();
        glouton.resoudre(this);

    }
    public void resoudreDynamique() {

        Dynamique dynamique = new Dynamique();
        dynamique.resoudre(this);

    }
    public void resoudrePse() {

      PSE pse = new PSE();
      pse.resoudre(this);
    }


    /**
     * Permet de vider le sac à dos de tous ces objets
     */
    public void viderSac() {
        poids = 0;
        this.objDansLeSac = new ArrayList<Objet>();
        prixTotal = 0;
    }

    /**
     * Permet d'ajouter un objet dans le sac
     * @param objet
     */
    public void add(Objet objet){
        this.objDansLeSac.add(objet);
        this.poids += objet.getPoids();
        this.prixTotal += objet.getPrix();
    }

    /**
     * Permet de visualiser ce que contient le sac cet-à-dire le prix, le poids et tous les objets
     * @return String sac à dos
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SAC A DOS : \n");
        sb.append("-->Valeur totale: ")
                .append(prixTotal)
                .append("\n");
        sb.append("-->Poids total: ")
                .append(poids)
                .append(" (")
                .append(String.format("%,.2f", 100 * poids / poidsMaximal))
                .append("%)\n");
        sb.append("-->Poids Maximal: ")
                .append(poidsMaximal)
                .append("\n");
        sb.append("-->Objets:\n");
        for (Objet objet : listeObjets) {
            sb.append("  >").append(objet).append("\n");
        }

        sb.append("--->Objets dans le sac:\n");
        for (Objet objet : objDansLeSac) {
            sb.append(" >").append(objet.getNom()).append("\n");
        }

        return sb.toString();
    }

    /**
     * Renvoie tout les objets du fichier
     * @return listeObjets
     */
    public ArrayList<Objet> getList() {
        return this.listeObjets;
    }

    /**
     * Renvoie le poids maximal du sac à dos
     * @return float poidsMaximal
     */
    public float getPoidsMaximal() {
        return this.poidsMaximal;
    }

    /**
     * Renvoie le poids actuelle du sac à dos
     * @return float poids
     */
    public float getPoids() {
        return this.poids;
    }

    /**
     * Renvoie le prix totale du sac à dos
     * @return float prixTotal
     */
    public float getPrixTotal(){
        return this.prixTotal;
    }



    public ArrayList<Objet> getObjDansLeSac() {
        return objDansLeSac;
    }
}