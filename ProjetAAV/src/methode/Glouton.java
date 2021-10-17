package methode;

import objet.Objet;

import java.util.ArrayList;
import java.util.Collections;
import objet.Objet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sac.SacADos;

/**
 * La classe Glouton resout le problème du sac avec la méthode gloutonne
 * @author Meryem Guldas & Sébastien Ramirez
 */

public class Glouton{

    /**
     * Permet de résoudre le problème du sac avec l'algorithme gloutonne
     * @param sac à résoudre
     */
    public void resoudre(SacADos sac) {

        ArrayList<Objet> listeobjets = sac.getList();
        for (int i=0; i<listeobjets.size()-1; i++)
            listeobjets.get(i).Rapport(); //on obtient le rapport de chaque objet
        float poidsMax= sac.getPoidsMaximal();
        Quicksort(listeobjets,0,listeobjets.size()-1); //on les trie par

        for (Objet objet: listeobjets){
            if (sac.getPoids()+objet.getPoids()<=poidsMax){ //on les ajoute tant que le poids de l'objet est inférieur au poids Maximum
                sac.add(objet);
            }
        }
    }

    /**
     * Algorithme de tri Rapide
     * @param tab
     * @param entierPr
     * @param entierDr
     */
    private void Quicksort(List<Objet> tab, int entierPr, int entierDr){
        if(entierPr<entierDr) {
            int pivot = (entierPr + entierDr) / 2;
            pivot = Répartition(tab,entierPr,entierDr,pivot);
            Quicksort(tab,entierPr,pivot-1);
            Quicksort(tab, pivot +1,entierDr);
        }
    }

    /**
     * Permet de répartir les objets autour du pivot
     * @param tab
     * @param entierPr
     * @param entierDr
     * @param pivot
     * @return premier entier
     */
    private int Répartition(List<Objet> tab, int entierPr, int entierDr, int pivot){
        Echanger(tab,pivot,entierDr);

        int j = entierPr;
        for (int i= entierPr; i<=entierDr-1; i++){
            if(tab.get(i).getRapport()>=tab.get(entierDr).getRapport()){
                Echanger(tab,i,j);
                j=j+1;
            }
        }
        Echanger(tab,entierDr,j);
        return j;
    }

    /**
     * Permet d'echanger le dernier entier avec le pivot
     * @param t
     * @param entierDr
     * @param pivot
     */
    public static void Echanger(List<Objet> t, int entierDr, int pivot) {
        //échange entre le pivot et le dernier du tableau (le pivot devient le dernier du tableau)
        Objet tmp = t.get(entierDr);
        t.set(entierDr, t.get(pivot));
        t.set(pivot,tmp);
    }

}