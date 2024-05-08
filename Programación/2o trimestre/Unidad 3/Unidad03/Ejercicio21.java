import bpc.daw.consola.*;

import java.awt.*;

public class Ejercicio21 {
    /*
    Usa la Consola DAW para hacer un programa que pregunte al usuario un número
    de segundos. El programa finalizará cuando pase la cantidad de segundos introducida y
    durante ese tiempo se dibujará y actualizar en la pantalla una barra de progreso como esta:
     */
    public static void main(String[] args) {
        Consola Pantalla = new Consola("Espera infinita",900,500);
        Teclado Leer = Pantalla.getTeclado();
        FondoColorSolido FondoBlanco = new FondoColorSolido(Color.WHITE);
        CapaFondo Fondo = Pantalla.getCapaFondo();
        Fondo.setFondo(FondoBlanco);
        CapaTexto Texto = Pantalla.getCapaTexto();
        Texto.setColorTexto(Color.BLACK);
        CapaCanvas Lienzo = Pantalla.getCapaCanvas();
        Graphics2D BarraCarga = Lienzo.getGraphics2D();


        BarraCarga.setColor(Color.black);
        BarraCarga.drawRect(70,250,700,50);
        Texto.print(1,1,"Introduzca el número de segundos:");
        int Segundos = Leer.leerNumeroEntero();
        for (int i = 0; i <= Segundos; i++) {
            int Avance = (i*100)/Segundos;
            BarraCarga.setColor(Color.BLUE);
            BarraCarga.fillRect(70,250,(Avance*700)/100,50);
            BarraCarga.setColor(Color.black);
            BarraCarga.drawRect(70,250,700,50);
            Texto.print(8,37,Avance+"%");
            Texto.print(10,0," Esperando finalización ... ("+i+" segundos de "+Segundos+")");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
