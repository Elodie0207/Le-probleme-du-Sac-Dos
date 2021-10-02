package methode;

import objet.Objet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sac.SacADos;

public class Glouton{


    public void resoudre(SacADos sac) {
        ArrayList<Objet> listeobjets = sac.getList();
        float poidsMax= sac.getPoidsMaximal();
        Quicksort(listeobjets,0,listeobjets.size());

        for (Objet objet: listeobjets){
            if (sac.getPoids()+objet.getPoids()<=poidsMax){
                sac.add(objet);
            }
        }
    }

    //Algorithme de tri rapide
    private void Quicksort(List<Objet> tab, int entierPr, int entierDr){
        if(entierPr<entierDr){
            int pivot = (entierPr + entierDr) / 2;
            Répartition(tab,entierPr,entierDr,pivot);
            Quicksort(tab,entierPr,pivot-1);
            Quicksort(tab, pivot +1,entierDr);
        }
    }

    private Objet Répartition(List<Objet> tab, int entierPr, int entierDr, int pivot){
        Echanger(tab,pivot,entierDr);

        int j = entierPr;
        for (int i= entierPr; i<=entierDr-1; i++){
            if(tab.get(i).getRapport()<=tab.get(entierDr).getRapport()){
                Echanger(tab,i,j);
                j=j+1;
            }
        }
        Echanger(tab,entierDr,j);
        return(tab.get(j));
    }

    public static void Echanger(List<Objet> t, int entierDr, int pivot) {
        //échange entre le pivot et le dernier du tableau (le pivot devient le dernier du tableau)
        Objet tmp = t.get(entierDr);
        t.set(entierDr, t.get(pivot));
        t.set(pivot,tmp);
    }

}
