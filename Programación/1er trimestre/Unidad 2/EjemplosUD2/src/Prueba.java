import bpc.daw.mario.*;

public class Prueba {

    public static void main(String[] args) {

        Mario miMario = new Mario(200,200);
        Luigi miLuigi = new Luigi(300,350);
        Seta miSeta = new Seta(400,350);
        Cañon miCañon = new Cañon(600,400);
        Disparo miDisparo = new Disparo(600,400,200,200);
        Planta miPlanta = new Planta(700,500);
        Mario otro = new Mario(miLuigi,-30);
    }
}
