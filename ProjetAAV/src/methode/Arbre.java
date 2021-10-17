package methode;

import objet.Objet;

import java.util.ArrayList;

public class Arbre {
    private float valeur;
    private Arbre fg; //fils supérieur
    private Arbre fd;//fils inférieure
    private final int profondeur;
    private Arbre pere;
    private float poids;
    private int idx;

    /**
     * Constructeur d'arbre générant un arbre vide
     *
     */
    //Arbre vide
    public Arbre() {
        this.profondeur = 0;
        this.pere = this;
        this.poids=0;
        this.valeur=0;
         idx=-1;
    }

    /**
     * Contructeur d'arbre générant un arbre
     * Il est définit par son poids, ça valeur, par son pere, et son index (des objets)
     * @param poids
     * @param valeur
     * @param pere
     * @param idx
     */
    public Arbre(float poids, float valeur, Arbre pere, int idx) {
        this.poids = poids;
        this.pere=pere;
        this.profondeur=pere.profondeur + 1 ;
        this.idx=idx;
        this.valeur=valeur;
    }

    /**
     *
     * @return fils droit
     */
    public Arbre getFd() {
        return fd;
    }

    /**
     *
     * @return l'index
     */
    public int getIdx() {return idx;}

    /**
     *
     * @return fils gauche
     */
    public Arbre getFg(){ return fg;}

    /**
     *
     * @return pere
     */
    public Arbre getPere() {
        return pere;
    }

    /**
     *
     * @return valeur
     */
    public float getValeur() {
        return valeur;
    }

    /**
     *
     * @return poids
     */
    public float getPoids() {
        return poids;
    }

    /**
     * La profondeur de l'arbre
     * @return profondeur
     */
    public int getProfondeur(){
        return this.profondeur;
    }

    /**
     * Permet de générer le fils Gauche avec un objet
     * @param objet
     * @param idx
     */
    public void setFg(Objet objet, int idx) {
        fg = new Arbre(poids + objet.getPoids(), this.getValeur()+ objet.getPrix(), this, idx);
    }

    /**
     *
     * @return Profondeur
     */
    public boolean Racine(){
        return this.profondeur == 0;
    }
    /**
     * Permet de générer le fils Droit sans objet
     */
    public void setFd() {
        fd = new Arbre(this.getPoids(), this.getValeur(), this, -1);
    }

}