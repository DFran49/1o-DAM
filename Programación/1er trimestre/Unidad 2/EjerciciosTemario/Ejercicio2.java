import bpc.daw.mario.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        //Se crean los marios con el metodo mario
        Mario Mario1 = new Mario(100);
        Mario Mario2 = new Mario(640,320);
        //Se creea la seta con el método seta
        Seta Seta1 = new Seta(0,0);
        //Se crea el cañón con el método cañón
        Cañon Cañon1 = new Cañon(100,320);
        //Se crean las plantas con el método planta
        Planta Planta1 = new Planta(400,500);
        Planta Planta2 = new Planta(Planta1,50);
        Planta Planta3 = new Planta(Planta2,50);
        //Se crea luigi con el método luigi y a continuación, mario a partir de luigi
        Luigi Luigi1 = new Luigi(200);
        Mario Mario3 = new Mario(Luigi1,50);
    }
}