import bpc.daw.consola.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ejercicio02 {
    public static void main(String[] args) {
        Consola Pantalla = new Consola();
        CapaCanvas Lienzo = Pantalla.getCapaCanvas();
        Graphics CapaGraphics = Lienzo.getGraphics();
        CapaGraphics.setColor(Color.WHITE);
        int[] PuntosX = {250,297,446,297,250,203,53,202,250};
        int[] PuntosY = {46,180,224,268,400,268,224,180,46};
//        CapaGraphics.drawLine(250,46,297,180);
//        CapaGraphics.drawLine(297,180,446,224);
//        CapaGraphics.drawLine(446,224,297,268);
//        CapaGraphics.drawLine(297,268,250,400);
//        CapaGraphics.drawLine(250,400,203,268);
//        CapaGraphics.drawLine(203,268,53,224);
//        CapaGraphics.drawLine(53,224,202,180);
//        CapaGraphics.drawLine(202,180,250,46);
        CapaGraphics.drawPolygon(PuntosX, PuntosY, 8);
        Rectangle Captura = new Rectangle(50,43,1920,1080);

        try {
            Robot Doraemon = new Robot();
            File Ruta = new File("media\\estrella.jpeg");
            BufferedImage ImagenBuffer = Doraemon.createScreenCapture(Captura);
            ImageIO.write(ImagenBuffer,"jpeg",Ruta);
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        Pantalla.getTeclado().leerCaracter();

    }
}
