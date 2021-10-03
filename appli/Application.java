package appli;
import com.sun.xml.internal.txw2.output.SaxSerializer;
import objet.Objet;
import sac.SacADos;

public class Application {

    public static void main(String[] args){
        SacADos sacADos = null;
        String chemin = "C:\\Users\\RAMIREZ\\IdeaProjects\\Projet_AAV\\src\\appli\\items.txt";
        sacADos = new SacADos(chemin, 10);
        sacADos.resoudre();
        System.out.println(sacADos.toString());

    }
}
