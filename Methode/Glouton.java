package methode;

import objet.Objet;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sac.SacADos;
public class Glouton {
    SacADos sac;
    public Glouton(){
        //changer arraylist -> tab
        ArrayList<Objet> listeObjet = new ArrayList<>(sac.getList()); //on ajoute la liste d'objet dans laquelle le rapport ets déjà calculé.
        Quicksort (listeObjet,0,listeObjet.size()-1); //on trie les objets
        Iterator<Objet> tri = listeObjet.iterator(); //iterator permet de supprimer un élément de la collection
        while(tri.hasNext() && sac.getPoids() < sac.getPoidsMaximal()){
            sac.add(tri.next()); //on ajoute au sac si le poids actuel est inférieur au poids maximal
        }

    }



    //Algorithme de tri rapide
    private void Quicksort(int [] tab, int entierPr, int entierDr){
        if(entierPr<entierDr){
            int pivot = (entierDr- entierDr) / 2 + entierPr;
             pivot=Répartition(tab,entierPr,entierDr,pivot);
             Quicksort(tab,entierPr,pivot-1);
             Quicksort(tab, pivot +1,entierDr);
        }
    }

    private int Répartition(int[] tab, int entierPr, int entierDr,int pivot){
        Echanger(tab,pivot,entierDr);
        int j = entierPr;
        for (int i= entierPr; i<entierDr-1; i++){
            if(tab[i]<=tab[entierDr]){
                j=j+1;
            }
        }
        Echanger(tab,entierDr,j);
        return(tab[j]);
    }

    public static void Echanger(int[] t, int entierDr, int pivot) {
        //échange entre le pivot et le dernier du tableau (le pivot devient le dernier du tableau)
        int tmp = t[pivot];
        t[pivot] = t[entierDr];
        t[entierDr] = tmp;
    }
}
