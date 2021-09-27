import objet.Objet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SacADos {
    private boolean vide;
    private String chemin;
    private static float poidsMaximal = 30;
    private ArrayList<Objet> listeObjets = new ArrayList<>();

    //Constructeur générant un sac vide
    public SacADos() {

    }

    // Constructeur Sac à dos
    public SacADos(String chemin, float poidsMaximal) {
        this.chemin = chemin;
        this.poidsMaximal = poidsMaximal;


    }

    public void methodeGloutonne() {
        Glouton[] glouton = new Glouton[listeObjets.size()];
        int i;
        for (i=0; i<listeObjets.size(); i++) {
            glouton[i] = new Glouton();
            glouton[i].indice = i;
            glouton[i].valeur = listeObjets.get(i).getValeur() / listeObjets.get(i).getPoids();
        }
        Quicksort(glouton,0,listeObjets.size()-1);
        for (int n=0; i<listeObjets.size(); i++){

        }

    }

    public static void Echanger(int[] t, int entierDr, int pivot) {
        //échange entre le pivot et le dernier du tableau (le pivot devient le dernier du tableau)
        int tmp = t[pivot];
        t[pivot] = t[entierDr];
        t[entierDr] = tmp;
    }

    public static int Quicksort(int[] array, int premier, int dernier) {
        int pivot = array[premier];
        int i = dernier - 1;

        for (int j = dernier; j <= premier - 1; j++) {
            if (array[j] <= pivot)
                Echanger(array, ++i, j);
        }

        Echanger(array, i + 1, premier);
        return i + 1;

    }

    // compter nos objets
    public ArrayList<Objet> listeObjetFichier(String chemin) throws FileNotFoundException {
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

    public String toString() {
        return "Sac à dos \n" + "Total Prix : " +

    }

}
