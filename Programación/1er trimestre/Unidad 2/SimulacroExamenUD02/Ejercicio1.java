import bpc.daw.consola.CapaTexto;
import bpc.daw.consola.Consola;

import java.awt.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        Consola Pantalla = new Consola();
        CapaTexto Texto = Pantalla.getCapaTexto();
        Texto.setColorTexto(Color.RED);
        Texto.print(12,25,"Bienvenido al instituto");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException p) {
            System.out.println("Error de espera");
        }
    }
}
