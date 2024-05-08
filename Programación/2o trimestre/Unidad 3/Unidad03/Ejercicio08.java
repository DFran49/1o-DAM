import bpc.daw.consola.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio08 {
    /*
    Usa la Consola DAW para hacer un programa que pregunte al usuario por la ruta de
    una imagen y la ponga como imagen de fondo. El programa entonces preguntará "¿Desea
    poner otra imagen?". Si el usuario pulsa la tecla S, se repetirá el proceso, y si pulsa cualquier
    otra tecla, finalizará.
     */
    public static void main(String[] args) {
        char Respuesta = 'S';
        Consola Pantalla = new Consola();
        CapaFondo CapFon = Pantalla.getCapaFondo();
        FondoImagen FondoMono;
        CapaTexto CapText = Pantalla.getCapaTexto();
        Teclado Leer = Pantalla.getTeclado();
        CapText.println("Introduzca la ruta de una imagen");
        File RutaImagen = new File(Leer.leerCadenaCaracteres());
        boolean LetraCorrecta = false;

        while (Respuesta=='S'||Respuesta=='s') {
            try {
                FondoMono = new FondoImagen(ImageIO.read(RutaImagen));
                CapFon.setFondo(FondoMono);
                FondoMono.setEscalado(true);
                LetraCorrecta = false;
                while (LetraCorrecta==false) {
                    CapText.println("¿Desea poner otra imagen? S/N");
                    Respuesta = Leer.leerCaracter();
                    switch (Respuesta) {
                        case 's','S'->{
                            CapText.println("\nIntroduzca la ruta de una imagen");
                            RutaImagen = new File(Leer.leerCadenaCaracteres());
                            LetraCorrecta = true;
                        }
                        case 'n','N'->{
                            CapText.println("\nGracias");
                            LetraCorrecta = true;
                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException e) {
                                System.out.println("Error de espera");
                            }
                        }
                        default -> {
                            CapText.println("Respuesta incorrecta, inténtelo de nuevo");
                            LetraCorrecta = false;
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer la imagen");
                break;
            }
        }
    }
}
