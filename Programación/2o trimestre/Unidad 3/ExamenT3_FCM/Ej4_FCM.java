import bpc.daw.consola.CapaTexto;
import bpc.daw.consola.Consola;
import bpc.daw.consola.Teclado;

import java.awt.*;

public class Ej4_FCM {
    public static void main(String[] args) {
        Consola Pantalla = new Consola();
        CapaTexto Texto = Pantalla.getCapaTexto();
        Teclado Leer = Pantalla.getTeclado();
        Texto.print("Introduzca un número.");
        int num = Leer.leerNumeroEntero();
        Texto.cls();
        //Añado comprobador de que el número es mayor a 0
        if (num < 1) {
            Texto.println("El número debe ser mayor a 0");
        } else {
            Texto.setColorTexto(Color.RED);
            for (int i = 0; i <= num; i++) {
                for (int j = 1; j <= i ; j++) {
                    Texto.print(""+j);
                }
                Texto.println("");
            }
            for (int i = num-1; i > 0; i--) {
                for (int j = 1; j <= i ; j++) {
                    Texto.print(""+j);
                }
                Texto.println("");
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Error de espera.");
        }
    }
}
