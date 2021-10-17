package appli;
import sac.SacADos;

import java.util.Scanner;

/**
 * La classe Application permet de lancée la solution du problème du sac à dos avec differente méthode comme la
 * glouton, dynamique et PSE
 *
 * @author Meryem Guldas & Sébastien Ramirez
 */
public class Application {

    /**
     * Entrée du programme
     * @param args les arguments
     */
    public static void main(String[] args){
        String reponse;
        SacADos sacADos = null;
        //String chemin = "src/appli/items.txt";
        //sacADos = new SacADos(chemin, 30);
        String chemin = args[0];//pour utiliser dans le cmd
        sacADos = new SacADos(chemin, Float.parseFloat(args[1]));

        /**
         * Permet d'utiliser l'une des méthodes pour solutioné le problème du sac à dos
         */
        Scanner sc= new Scanner(System.in);
        System.out.println("Choisissez votre methode de resolution : Glouton, Dynamique ou PSE (attention a la syntaxe)");
        reponse=sc.next();

        if (reponse.equals("Glouton")){

            sacADos.resoudreGlouton();

        }

        else if (reponse.equals("Dynamique")){

            sacADos.resoudreDynamique();

        }
        else if (reponse.equals("PSE")){

            sacADos.resoudrePse();

        }
        else  {
            System.out.println("Mauvaise syntaxe");
            System.exit(1);
        }
        System.out.println(sacADos.toString());

        /**
         * Permet de calculer le temps d'execution pour solutioné le problème du sac à dos
         */
        long tdeb = System.nanoTime();
        long tFin = System.nanoTime();
        long dureefinal = tFin-tdeb;
        System.out.printf( "la duree est de %f milliseconds\n", dureefinal/ 1_000_000.0 );
    }
}
