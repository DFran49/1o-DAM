import bpc.daw.consola.CapaCanvas;
import bpc.daw.consola.CapaTexto;
import bpc.daw.consola.Consola;
import bpc.daw.consola.Teclado;

import java.awt.*;

public class Ejercicio09 {
    /*
    Usa la Consola DAW para realizar un programa que pregunte al usuario "¿Cuántos
    círculos desea dibujar?". El usuario escribirá un número entero (si el número es incorrecto o
    negativo, el programa dirá "Número incorrecto" y finalizará sin hacer nada más) y la pantalla
    se borrará y se dibujarán tantos círculos como haya indicado el usuario. Cada círculo tendrá un
    color con valores RGB aleatorios entre 0 y 255, y sus coordenadas también serán aleatorias
    entre (0,0) y la resolución de la pantalla.
     */
    public static void main(String[] args) {
        Consola Pantalla = new Consola();
        CapaTexto TextPantalla = Pantalla.getCapaTexto();
        CapaCanvas Lienzo = Pantalla.getCapaCanvas();
        Teclado Leer = Pantalla.getTeclado();
        Toolkit Tamaño = Toolkit.getDefaultToolkit();
        Dimension Resolucion = Tamaño.getScreenSize();
        Graphics2D Circulos = (Graphics2D) Lienzo.getGraphics2D();
        TextPantalla.println("¿Cuántos círculos desea dibujar?");
        int NumCir = Leer.leerNumeroEntero();
        Color colores;
        switch (NumCir) {
            case 1,2,3,4,5,6,7,8,9,10->{

                while (NumCir!=0){
                    System.out.println(NumCir);
                    colores = new Color((int) (Math.random()*256),(int) (Math.random()*256),(int) (Math.random()*256));

                    Circulos.drawOval((int) (Math.random()*Resolucion.height+1),(int)(Math.random()*Resolucion.width+1),100,100);
                    Circulos.setColor(colores);
                    NumCir-=1;
                }
                char ajfskdf = Leer.leerCaracter();
            }
            default -> System.out.println("Número incorrecto");
        }
    }
}
