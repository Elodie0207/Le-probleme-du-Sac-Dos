package appli;
import sac.SacADos;

import java.util.Scanner;

public class Application {


    public static void main(String[] args){
        String reponse;
        SacADos sacADos = null;
        //String chemin = "src/appli/items.txt";
        //sacADos = new SacADos(chemin, 30);
        String chemin = args[0];//pour utiliser dans le cmd
        sacADos = new SacADos(chemin, Float.parseFloat(args[1]));
        Scanner sc= new Scanner(System.in);
        System.out.println("Choisissez votre methode de resolution : Glouton, Dynamique ou PSE (attention a la syntaxe)");
        reponse=sc.next();
        long tdeb = System.nanoTime();
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
        long tFin = System.nanoTime();
        long dureefinal = tFin-tdeb;
        System.out.printf( "la duree est de %f milliseconds\n", dureefinal/ 1_000_000.0 );
    }
}
