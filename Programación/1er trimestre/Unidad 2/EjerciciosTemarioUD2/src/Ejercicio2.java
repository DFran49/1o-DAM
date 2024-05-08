import bpc.daw.mario.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        Mario Mario1 = new Mario(100);
        Mario Mario2 = new Mario(640,320);
        Seta Seta1 = new Seta(0,0);
        Cañon Cañon1 = new Cañon(100,320);
        Planta Planta1 = new Planta(400,500);
        Planta Planta2 = new Planta(Planta1,50);
        Planta Planta3 = new Planta(Planta2,50);
        Luigi Luigi1 = new Luigi(200);
        Mario Mario3 = new Mario(Luigi1,50);
    }
}
