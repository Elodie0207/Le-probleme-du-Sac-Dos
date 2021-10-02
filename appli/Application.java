package appli;
import com.sun.xml.internal.txw2.output.SaxSerializer;
import objet.Objet;
import sac.SacADos;

public class Application {
    
    public static void main(String[] args){
        SacADos sacADos = null;
        String chemin = "scr/appli/items.txt";
            sacADos = new SacADos(chemin,sacADos.getPoidsMaximal());
    sacADos.resoudre();

    }
}
