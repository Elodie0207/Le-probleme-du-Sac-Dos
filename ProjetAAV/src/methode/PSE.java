package methode;
import objet.Objet;

import java.util.ArrayList;


import sac.SacADos;

public class PSE {
    private float borneMin;
    private float borneMax;
    private float maxPoids;
    private Arbre resMax; //la meilleur solution
    private Glouton glouton = new Glouton();
    ArrayList<Objet> listeobjets;
    public static int nbrec=0;

    public void resoudre(SacADos sac) {

        listeobjets= sac.getList();
        maxPoids = sac.getPoidsMaximal();

        borneMax = 0;
        borneMin = 0;  //les deux bornes sont initialisés à 0



        for(int i =0; i<listeobjets.size();i++){
            this.borneMax += listeobjets.get(i).getPrix();
        }
        glouton.resoudre(sac);

        for (int i = 0; i < sac.getObjDansLeSac().size(); i++) {
            borneMin += sac.getObjDansLeSac().get(i).getPrix();

        }


        if(borneMax != sac.getPrixTotal()){

            Arbre abr = new Arbre();

            resMax = abr;
            nbrec ++;
            if (sac.getPoids()>=12){

                System.out.println(nbrec);
            }
            MethodeRec(abr, borneMax, 0);

            sac.viderSac();
            insertion(resMax,sac);

        }

    }


    public void MethodeRec(Arbre arbre, double Max, int index) {

        //on crée le fils gauche et on ajoute un objet supplémentaire pour le fils gauche mais le filsDroit reste comme le pere
        arbre.setFg(listeobjets.get(index), index);
        arbre.setFd();

        if (arbre.getFg().getValeur() >= this.borneMin && arbre.getFg().getPoids() <= this.maxPoids) {
            this.resMax = arbre.getFg();
            this.borneMin = this.resMax.getValeur();
        }

        if (index < listeobjets.size() - 1 && arbre.getPoids() < this.maxPoids) {
            MethodeRec(arbre.getFg(), Max, index + 1);

            double possibilite = Max - listeobjets.get(index).getPrix();//calcul de la borne max en enlevant les objets non ajoutés// à la possible valeur max
            //possibilite correspond au potentiel que l'arbre peut avoir

            if (possibilite >= borneMin) {
                MethodeRec(arbre.getFd(), possibilite, index + 1);
                //else, il n'y aura pas de meilleur solution
            }
        }
    }


    public void insertion(Arbre abr, SacADos sac){
        if(abr.getIdx() != -1){
            sac.add(listeobjets.get(abr.getIdx()));
        }

        if (!(abr.getProfondeur() == 0)){
            insertion(abr.getPere(), sac);
        }
    }
}
