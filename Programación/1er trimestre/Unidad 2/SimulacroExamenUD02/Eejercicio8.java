import bpc.daw.consola.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Eejercicio8 {
    public static void main(String[] args) {
        Consola Pantalla = new Consola();
        Teclado Leer = Pantalla.getTeclado();
        CapaTexto Texto = Pantalla.getCapaTexto();
        CapaFondo Fondo = Pantalla.getCapaFondo();
        FondoColorSolido color = new FondoColorSolido(255,255,255);
        CapaCanvas Lienzo = Pantalla.getCapaCanvas();
        File PrimeraImagen = new File("mono.jpg");
        File SegundaImagen = new File("genios.jpg");
        Graphics2D Imagen1 = (Graphics2D) Lienzo.getGraphics2D();
        Graphics2D Imagen2 = (Graphics2D) Lienzo.getGraphics2D();
        Fondo.setFondo(color);
        Texto.setColorTexto(Color.BLACK);
        try {
            Imagen1.drawImage(ImageIO.read(PrimeraImagen),200,200,700,800,null);
            Imagen2.drawImage(ImageIO.read(SegundaImagen),1000,200,700,800,null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Texto.println("Pulse una tecla para intercambiar las fotografías");
        char espera = Leer.leerCaracter();

        Texto.cls();
        Lienzo.cls();

        try {
            Imagen1.drawImage(ImageIO.read(SegundaImagen),200,200,700,800,null);
            Imagen2.drawImage(ImageIO.read(PrimeraImagen),1000,200,700,800,null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Texto.println("Pulse una tecla para salir");
        espera = Leer.leerCaracter();
    }
}
