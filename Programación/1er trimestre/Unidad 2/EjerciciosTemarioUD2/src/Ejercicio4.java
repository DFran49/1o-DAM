import bpc.daw.mario.Luigi;
import bpc.daw.mario.Mario;

public class Ejercicio4 {
    public static void main(String[] args) {
        Luigi Luigi1 = new Luigi(500);
        Mario Mario1 = new Mario((Luigi1.getX()+50), Luigi1.getY());
        System.out.println("Las distancias de Mario son: X-"+Mario1.getX()+" e Y-"+Mario1.getY());
        System.out.println("Las distancias de Luigi son: X-"+Luigi1.getX()+" e Y-"+Luigi1.getY());

    }
}
