import bpc.daw.mario.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        Mario Mario1 = new Mario(100);
        Seta Seta1 = new Seta(0,0);
        Cañon Canon1 = new Cañon(100,320);
        Planta Planta1 = new Planta(400,500);
        Planta Planta2 = new Planta(Planta1,50);
        Planta Planta3 = new Planta(Planta2,50);
        Luigi Luigi1 = new Luigi(200);
        Seta1.andarHacia(0,0);
        Mario1.saltar();
        Canon1.disparar(Luigi1.getX(), Luigi1.getY());
        Planta1.comer(true);
        Planta2.comer(true);
        Planta3.comer(true);
    }
}
