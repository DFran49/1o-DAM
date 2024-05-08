import bpc.daw.consola.*;

import java.awt.*;

public class Ejercicio5 {
    public static void main(String[] args) {
        Consola Pantalla = new Consola("",640,480);
        CapaFondo Fondo = Pantalla.getCapaFondo();
        FondoColorSolido color = new FondoColorSolido(Color.CYAN);
        Rectangle Rectangulo1 = new Rectangle(0,0,640,400);
        Fondo.setDimensiones(Rectangulo1);
        Fondo.setFondo(color);
        CapaFondo FondoVerde = Pantalla.getCapaFondo();
        Rectangle Rectangulo2 = new Rectangle(0,400,640,80);
        CapaCanvas Lienzo = Pantalla.getCapaCanvas();
        Graphics2D Grafico1 = (Graphics2D) Lienzo.getGraphics();
        Grafico1.setColor(Color.GREEN);
        Grafico1.fillRect(0,400,640,80);
        Graphics2D Grafico2 = (Graphics2D) Lienzo.getGraphics();
        Grafico2.setColor(Color.YELLOW);
        Grafico2.fillOval(120,90,40,40);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException p) {
            System.out.println("Error de espera");
        }
    }
}
