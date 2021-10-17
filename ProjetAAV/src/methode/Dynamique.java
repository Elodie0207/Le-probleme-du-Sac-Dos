package methode;


import objet.Objet;
import sac.SacADos;

import java.util.ArrayList;

/**
 * La classe Dynamique resout le problème du sac avec la méthode dynamique
 * @author Meryem Guldas & Sébastien Ramirez
 */
public class Dynamique {
int precision=10;
    /**
     * Permet de resoudre le problème du sac avec l'algorithme dynamique
     * @param sac à résoudre
     */
    public void resoudre(SacADos sac){
        /**
         * On définit listeobjets et PoidsMax pour après crée une matrice
         */
        int NvPoidsMax= (int)(sac.getPoidsMaximal()*precision) ; //Précision pour pouvoir stocker en tant que int (conversion de float vers int)
        ArrayList<Objet> listeobjets = sac.getList();
        /**
         * On crée la matrice de taille listeobjets * PoidsMax
         */
        float[][] M = new float[listeobjets.size()][NvPoidsMax+1];
        /**
         * On rempli la matrice
         */
        for(int n=0; n <= NvPoidsMax; n++){
            if ((int)(listeobjets.get(0).getPoids() * precision)> n){
                M[0][n] =0;
            }
            else {
                M[0][n]= (int) listeobjets.get(0).getPrix();
            }
        }

        /**
         * On rempli le reste de la matrice
         */
        for(int j=1;j< listeobjets.size();j++){
            for (int i =0; i<=NvPoidsMax;i++){
                if((int)(listeobjets.get(j).getPoids()*precision)<=i){
                    M[j][i] = Math.max (M[j-1][i],(M[j-1][(i-(int)((listeobjets.get(j).getPoids()*precision)))]+listeobjets.get(j).getPrix()));
                }
                else {
                    M[j][i] = M[j - 1][i];
                }

            }
        }

        /**
         * On lit la matrice et on ajoute les objets
         */
        int npm = NvPoidsMax;
        int lo = listeobjets.size() - 1;
        /**
         * On regarde dans la matrice à gauche
         */
        while (M[lo][npm] == M[lo][npm-1]){
            --npm ;
        }
        /**
         * On regarde dans la matrice en haut
         */
        while (npm > 0){
            while (lo > 0 && M[lo][npm] == M[lo-1][npm]){
                --lo;
            }
            npm = npm - (int)( listeobjets.get(lo).getPoids()*precision) ;
            if (npm >= 0){
                sac.add(listeobjets.get(lo)); //Ajout des objets dans le sac
            }
            --lo;
        }
    }
}