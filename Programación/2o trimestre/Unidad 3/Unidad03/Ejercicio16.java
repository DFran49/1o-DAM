import bpc.daw.consola.CapaCanvas;
import bpc.daw.consola.CapaTexto;
import bpc.daw.consola.Consola;
import bpc.daw.consola.Teclado;

import java.awt.*;

public class Ejercicio16 {
    /*
    Haz un programa que dibuje en la pantalla 8 rectángulos cuyas coordenadas,
    dimensiones y color sean aleatorios.
     */
    public static void main(String[] args) {
        Consola Pantalla = new Consola();
        CapaTexto TextPantalla = Pantalla.getCapaTexto();
        CapaCanvas Lienzo = Pantalla.getCapaCanvas();
        Teclado Leer = Pantalla.getTeclado();
        Toolkit Tamaño = Toolkit.getDefaultToolkit();
        Dimension Resolucion = Tamaño.getScreenSize();
        Graphics2D Rectangulos = Lienzo.getGraphics2D();
        Color colores;

        for (int i = 0; i < 8; i++) {
            colores = new Color((int) (Math.random()*256),(int) (Math.random()*256),(int) (Math.random()*256));
            Rectangulos.drawRect((int) (Math.random()*(Resolucion.height-100)+1),(int)(Math.random()*(Resolucion.height-100)+1),(int)(Math.random()*1000+1),(int)(Math.random()*1000+1));
            Rectangulos.setColor(colores);

        }


        char ajfskdf = Leer.leerCaracter();
    }
}
