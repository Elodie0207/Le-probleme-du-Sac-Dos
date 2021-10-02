package sac;

import methode.Glouton;
import methode.Methode;
import objet.Objet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
public class SacADos {
    private boolean vide;
    private String chemin;
    private float poidsMaximal = 30;
    private float poids;
    private float prixTotal;
    ArrayList<Objet> objDansLeSac;
    ArrayList<Objet> listeObjets;

    //Constructeur générant un sac vide
    public SacADos() {

    }

    // Constructeur Sac à dos
    public SacADos(String chemin, float poidsMaximal) {
        this.chemin = chemin;
        this.poidsMaximal = poidsMaximal;
        this.listeObjets=new ArrayList<Objet>();
        this.objDansLeSac=new ArrayList<Objet>();

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

    public void resoudre() {

        Glouton glouton = new Glouton();
        glouton.resoudre(this);
        }








    // compter nos objets
        /*public ArrayList<Objet> listeObjetFichier(String chemin) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(chemin));
        while (sc.hasNext()) {
            String ligne = sc.nextLine();
            String[] tabSplit = ligne.split(";");

            String objetsNom = tabSplit[0];
            float objetsPoids = Float.parseFloat(tabSplit[1]);
            float objetsPrix = Float.parseFloat(tabSplit[2]);

            Objet objet = new Objet(objetsNom, objetsPoids, objetsPrix);
            listeObjets.add(objet);
        }
        return listeObjets;
    }*/
    public void add(Objet objet){

            this.objDansLeSac.add(objet);
            this.poids += objet.getPoids();
            this.prixTotal += objet.getPrix();
    }
    @Override
    public String toString() {
        //StringBuilder sb = new StringBuilder();
                //sb.append("Sac à dos\n");
                //sb.append("-Valeur totale: ")
                        //.append(getPrix)
                        //.append("\n");
                //sb.append("-Poids total: ")
                        //.append(this.poids)
                        //.append(" (")
                        //.append(String.format("%,.2f", 100 * this.poids / this.poidsMaximal))
                       // .append("%)\n");
               // sb.append("-Poids Maximal: ")
            //            .append(this.poidsMaximal)
                       // .append("\n");
             //   sb.append("-Objets:\n");
              //  for (Objet objet : this.listeObjets) {
              //      sb.append("  >").append(objet).append("\n");
             //   }
               // return sb.toString();
        return "";
    }

    public ArrayList<Objet> getList() {
        return this.listeObjets;
    }
    public float getPoidsMaximal() {
        return this.poidsMaximal;
    }
    public float getPoids() {
        return this.poids;
    }
    public float getPrixTotal(){
        return this.prixTotal;
    }
}
