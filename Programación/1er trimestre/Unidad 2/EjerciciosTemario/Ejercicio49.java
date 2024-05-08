import daw.efectoimagen.EfectoBuilder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio49 {
    public static void main(String[] args) {
        String ruta = new Scanner(System.in).nextLine();
        File Archivo = new File(ruta);
        try {
            BufferedImage Imagen = ImageIO.read(Archivo);
            EfectoBuilder Invertir = new EfectoBuilder(Imagen);
            Invertir.aplicarEfecto(EfectoBuilder.INVERTIR);
            Invertir.aplicarEfecto(EfectoBuilder.BLURRED);
            Invertir.aplicarEfecto(EfectoBuilder.ESCALA_GRISES);
            Invertir.build();
        } catch (IOException p){
            System.out.println("Excepción al seleccionar la imagen");
        }


    }
}
