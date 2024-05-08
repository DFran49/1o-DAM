import bpc.daw.consola.CapaCanvas;
import bpc.daw.consola.Consola;

import java.awt.*;

public class Ejercicio7 {
    public static void main(String[] args) {
        Consola Pantalla = new Consola();
        Toolkit Tamaño = Toolkit.getDefaultToolkit();
        Dimension Resolucion = Tamaño.getScreenSize();
        int height = Resolucion.height;
        int width = Resolucion.width;
        CapaCanvas Lienzo = Pantalla.getCapaCanvas();
        Graphics2D LineaWH = (Graphics2D) Lienzo.getGraphics2D();
        Graphics2D LineaHW = (Graphics2D) Lienzo.getGraphics2D();
        Graphics2D Circulo = (Graphics2D) Lienzo.getGraphics2D();
        LineaWH.setColor(Color.RED);
        LineaWH.drawLine(0,0,width,height);
        LineaHW.setColor(Color.GREEN);
        LineaHW.drawLine(width,0,0,height);
        Circulo.setColor(Color.BLUE);
        Circulo.drawOval(((width/2)-50),((height/2)-50),100,100);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException p) {
            System.out.println("Error de espera");
        }
    }
}
