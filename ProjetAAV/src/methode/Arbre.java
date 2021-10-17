package methode;

import objet.Objet;

import java.util.ArrayList;

/**
 * La classe Arbre crée un arbre
 *
 * @author Meryem Guldas & Sébastien Ramirez
 */
public class Arbre {
    /**
     * La valeur actuel
     */
    private float valeur;

    /**
     * Le fils gauche (fils supérieur)
     */
    private Arbre fg;

    /**
     * Le fils droite (fils inférieur)
     */
    private Arbre fd;

    /**
     * La profondeur
     */
    private final int profondeur;

    /**
     * Le pere
     */
    private Arbre pere;

    /**
     * Le poid
     */
    private float poids;

    /**
     * L'index de l'objet
     */
    private int idx;

    /**
     * Constructeur d'arbre générant un arbre vide
     */
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
     * @param poids le poids du noeud
     * @param valeur la valeur du noeud
     * @param pere le noeud pere
     * @param idx l'index de l'objet
     */
    public Arbre(float poids, float valeur, Arbre pere, int idx) {
        this.poids = poids;
        this.pere=pere;
        this.profondeur=pere.profondeur + 1 ;
        this.idx=idx;
        this.valeur=valeur;
    }

    /**
     * Renvoie le fils droit
     * @return fils droit
     */
    public Arbre getFd() {
        return fd;
    }

    /**
     * Renvoie le fils gauche
     * @return fils gauche
     */
    public Arbre getFg(){ return fg;}

    /**
     * Renvoie l'index de l'objet
     * @return int l'index
     */
    public int getIdx() {return idx;}

    /**
     * Renvoie le pere
     * @return pere
     */
    public Arbre getPere() {
        return pere;
    }

    /**
     * Renvoie la valeur du noeud
     * @return float valeur
     */
    public float getValeur() {
        return valeur;
    }

    /**
     * Renvoie le poid du noeud
     * @return float poids
     */
    public float getPoids() {
        return poids;
    }

    /**
     * La profondeur de l'arbre
     * @return int profondeur
     */
    public int getProfondeur(){
        return this.profondeur;
    }

    /**
     * Verifie si un noeud est la racine
     * @return Profondeur
     */
    public boolean Racine(){
        return this.profondeur == 0;
    }

    /**
     * Permet de générer le fils Gauche avec un objet
     * @param objet à ajouter
     * @param idx l'index de l'objet
     */
    public void setFg(Objet objet, int idx) {
        fg = new Arbre(poids + objet.getPoids(), this.getValeur()+ objet.getPrix(), this, idx);
    }

    /**
     * Permet de générer le fils Droit sans objet
     */
    public void setFd() {
        fd = new Arbre(this.getPoids(), this.getValeur(), this, -1);
    }

}
