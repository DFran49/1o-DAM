import bpc.daw.consola.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Ejercicio4 {
    public static void main(String[] args) {
        Consola Pantalla = new Consola();
        Teclado Leer = Pantalla.getTeclado();
        Leer.setTipoCursor(Teclado.CURSOR_NULO);
        CapaTexto Texto = Pantalla.getCapaTexto();
        CapaFondo Fondo = Pantalla.getCapaFondo();
        FondoColorSolido color = new FondoColorSolido(0,0,255);
        Texto.setColorTexto(Color.YELLOW);
        Texto.println("Introduzca la ruta de una imagen (o el nombre del archivo si está en la misma carpeta)");
        File Imagen = new File(Leer.leerCadenaCaracteres());
        try {
            FondoImagen FondoMono = new FondoImagen(ImageIO.read(Imagen));
            Fondo.setFondo(FondoMono);
            FondoMono.setEscalado(true);
            char espera = Leer.leerCaracter();
        } catch (IOException p) {
            System.out.println("Error con la imagen");
        }


    }
}
