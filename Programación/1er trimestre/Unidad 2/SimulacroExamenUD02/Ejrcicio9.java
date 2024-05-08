import bpc.daw.consola.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Ejrcicio9 {
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

        CapaSprites SpritesPajaro = Pantalla.getCapaSprites();
        Rectangle RectPaj1 = new Rectangle(11,178,77,90);
        Rectangle RectPaj2 = new Rectangle(107,178,73,90);
        Rectangle RectPaj3 = new Rectangle(202,178,72,90);
        Rectangle RectCol = new Rectangle(1,1,77,90);
        File ImagenPajaro = new File("pajaro.png");
        File ImagenCol = new File("Transparente.png");
        Sprite Pajaro;
        Sprite Colision;
        boolean Comprobador = true;
        try {
            Colision = SpritesPajaro.crearSprite(ImageIO.read(ImagenCol),RectCol,640,160);
            Colision.setImagen(ImageIO.read(ImagenCol),RectCol);
            Pajaro = SpritesPajaro.crearSprite(ImageIO.read(ImagenPajaro),RectPaj1,50,160);
            while (Comprobador == true) {
                Thread.sleep(100);
                Pajaro.setImagen(ImageIO.read(ImagenPajaro),RectPaj2);
                Pajaro.moverX(10);
                Thread.sleep(100);
                Pajaro.setImagen(ImageIO.read(ImagenPajaro),RectPaj3);
                Pajaro.moverX(10);
                Thread.sleep(100);
                Pajaro.setImagen(ImageIO.read(ImagenPajaro),RectPaj1);
                Pajaro.moverX(10);
                System.out.println(Pajaro.comprobarColision(Colision));
                if (Pajaro.comprobarColision(Colision)) {
                    Comprobador = false;
                }
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
