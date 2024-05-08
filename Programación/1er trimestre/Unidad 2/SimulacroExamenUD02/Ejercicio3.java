import bpc.daw.consola.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) {
        Consola Pantalla = new Consola();
        Teclado Leer = Pantalla.getTeclado();
        CapaTexto Texto = Pantalla.getCapaTexto();
        File Imagen = new File("mono.jpg");
        Leer.setTipoCursor(Teclado.CURSOR_NULO);
        try {
            FondoImagen FondoMono = new FondoImagen(ImageIO.read(Imagen));
            CapaFondo Fondo = Pantalla.getCapaFondo();
            Fondo.setFondo(FondoMono);
            Texto.println("Pulse una tecla para salir");
            char espera = Leer.leerCaracter();
        } catch (IOException p) {
            System.out.println("Problema con la imagen");
        }
    }
}
