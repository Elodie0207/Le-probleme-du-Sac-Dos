package appli;
import objet.Objet;
public class Application {

    public static void main(String[] args) {
        Objet obj1 = new Objet("caca", 50.00f, 1.00f);
        Objet obj2= new Objet("pipi", 10.00f, 6.00f);
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
