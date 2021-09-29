package sac;

import objet.Objet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SacADos {
    private boolean vide;
    private String chemin;
    private  float poidsMaximal = 30;
    ArrayList<Objet> objpresent;
    ArrayList<Objet> listeObjets;

    private double poids;
    //Constructeur générant un sac vide
    public SacADos() {

    }

    // Constructeur Sac à dos
    public SacADos(String chemin, float poidsMaximal) {
        this.chemin = chemin;
        this.poidsMaximal = poidsMaximal;


    }

    public void résoudre() {


    }





    // compter nos objets
    public ArrayList<Objet> listeObjetFichier(String chemin) throws FileNotFoundException {
        listeObjets=new ArrayList<>(listeObjets);
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
    }
    public void add(Objet objet){

        if(objet.getPoids() + this.poids <= this.poidsMaximal){
            this.objpresent.add(objet);
            this.poids += objet.getPoids();
        }
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
        return listeObjets;
    }
    public  float getPoidsMaximal() {
        return poidsMaximal;
    }
    public double getPoids() {
        return poids;
    }
}
