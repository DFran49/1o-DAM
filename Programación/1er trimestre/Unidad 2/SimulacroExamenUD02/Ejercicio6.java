import bpc.daw.consola.CapaTexto;
import bpc.daw.consola.Consola;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Ejercicio6 {
    public static void main(String[] args) {
        Consola Pantalla = new Consola();
        CapaTexto Texto = Pantalla.getCapaTexto();
        File fuente = new File("Outwrite.ttf");

        Font outwrite = null;
        try {
            outwrite = Font.createFont(Font.TRUETYPE_FONT,fuente);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        Texto.setFont(outwrite);
        Texto.setColorTexto(Color.WHITE);
        Texto.print(12,25,"Bienvenido al instituto");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException p) {
            System.out.println("Error de espera");
        }
    }
}
