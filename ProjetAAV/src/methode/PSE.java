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

    /**
     * Permet de resoudre le problème du sac à dos avec la méthode PSE
     * @param sac
     */
    public void resoudre(SacADos sac) {

        listeobjets= sac.getList();
        maxPoids = sac.getPoidsMaximal();

        borneMax = 0;
        borneMin = 0;  //les deux bornes sont initialisés à 0

        //si on met tous les objets dans le sac
        for(int i =0; i<listeobjets.size();i++){
            this.borneMax += listeobjets.get(i).getPrix();
        }
        glouton.resoudre(sac); //on fait un premier test avec l'algorithme glouton qui va créer une bornemin

        for (int i = 0; i < sac.getObjDansLeSac().size(); i++) {
            borneMin += sac.getObjDansLeSac().get(i).getPrix();

        }


        if(borneMax != sac.getPrixTotal()){

            Arbre abr = new Arbre();

            resMax = abr;
            nbrec ++;
            MethodeRec(abr, borneMax, 0);

            //on ajoute les objets dans le sac et on remonte à la racine
            sac.viderSac();
            insertion(resMax,sac);

        }

    }

    /**
     *Permet de créer un arbre récursif
     * @param arbre noeud
     * @param Max bornesup de la valeur actuel
     * @param index index de l'objet
     */
    public void MethodeRec(Arbre arbre, double Max, int index) {

        //on crée le fils gauche et on ajoute un objet supplémentaire pour le fils gauche mais le filsDroit reste comme le pere
        arbre.setFg(listeobjets.get(index), index);
        arbre.setFd();


        //on regarde si nous avons une meilleur solutiond ans le fils gauche
        if (arbre.getFg().getValeur() >= this.borneMin && arbre.getFg().getPoids() <= this.maxPoids) {
            this.resMax = arbre.getFg();
            this.borneMin = this.resMax.getValeur();
        }

        //on regarde si le poids n'est pas atteint et si il y'a encore des objets à mettre
        if (index < listeobjets.size() - 1 && arbre.getPoids() < this.maxPoids) {
            MethodeRec(arbre.getFg(), Max, index + 1);

            //calcul de la borne max en enlevant les objets non ajoutés// à la possible valeur max

            double possibilite = Max - listeobjets.get(index).getPrix();
            //possibilite correspond au potentiel que l'arbre peut avoir
            if (possibilite >= borneMin) {
                MethodeRec(arbre.getFd(), possibilite, index + 1);
                //else, il n'y aura pas de meilleur solution
            }
        }
    }

    /**
     * Ajouter un objet en fonction du meilleur noeud
     * @param abr est le meilleur noeud
     * @param sac
     */
    public void insertion(Arbre abr, SacADos sac){
        if(abr.getIdx() != -1){
            sac.add(listeobjets.get(abr.getIdx()));
        }
        //ajouter les objets en remontant jusqu'à ce que la profondeur soit égale à 0 (donc la racine)
        if (!(abr.getProfondeur() == 0)){
            insertion(abr.getPere(), sac);
        }
    }
}
