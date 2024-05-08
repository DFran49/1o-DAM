import bpc.daw.consola.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.Random;

public class Ejercicio46 {
    static Consola Pantalla = new Consola();
    static CapaTexto Letras = Pantalla.getCapaTexto();
    static CapaFondo Escenario = Pantalla.getCapaFondo();
    static CapaCanvas Lienzo = Pantalla.getCapaCanvas();
    static CapaSprites CapaIcons = Pantalla.getCapaSprites();
    static Teclado Movimiento = Pantalla.getTeclado();
    static Toolkit TamPantalla = Toolkit.getDefaultToolkit();
    static Dimension Resolucion = TamPantalla.getScreenSize();

    static int Movimientos = 80;
    static int Nivel = 1;
    static int Puntos = 0;
    static int Columnas = Letras.getNumeroColumnas();
    static int Filas = Letras.getNumeroFilas();
    static String Temperatura;
    static int IniX = 4+1;
    static int IniY = 11+1;
    static int CellX = Resolucion.width/Columnas;
    static int CellY = Resolucion.height/Filas;
    static int ComJugadorX = (40*CellX);
    static int ComJugadorY = (15*CellY);
    static int TesoroX = 0;
    static int TesoroY = 0;
    static double Distancia;

    static File RutaIMG = new File("asdadfasf.png");
    static File RutaBorder = new File("si.png");
    static Sprite JugadorSprite;
    static Sprite TesoroSprite;
    static Sprite TopBorder;
    static Sprite LeftBorder;
    static Sprite RightBorder;
    static Sprite BotBorder;
    static Rectangle SpriteTamaño = new Rectangle(0,0,CellX,CellY);
    static Rectangle TesoroTamaño = new Rectangle(0,0,CellX-10,CellY-10);
    static Rectangle HorizontalBorder = new Rectangle(0,0,Resolucion.width,CellY);
    static Rectangle VerticalBorder = new Rectangle(0,0,CellX,Resolucion.height);
    static Graphics2D Pintura = (Graphics2D) Lienzo.getGraphics2D();
    static Random aleatorio = new Random();
    public static void DefinirConsola() {
        Letras.setTamTexto(32);
        Pintura.fillRect(1920-IniX,1080-IniY,IniX,IniY+100);
        Letras.print(0,0,"Nivel: "+Nivel);
        Letras.print(0,15,"Puntos: "+Puntos);
        Letras.print(0,30,"Movimientos restantes: "+Movimientos);
        Letras.print(0,70,"Temperatura");
        Letras.mostrarCuadricula(true);
        Movimiento.setTipoCursor(Teclado.CURSOR_NULO);


        System.out.println("ComJugadorX: "+ComJugadorX);

        System.out.println("ComJugadorX: "+ComJugadorY);



        int JugadorX = ComJugadorX;//845;
        int JugadorY = ComJugadorY;//506;
        TesoroX = (CellX*aleatorio.nextInt(Columnas));
        System.out.println("TesoroX: "+TesoroX);
        TesoroY = (CellY*(aleatorio.nextInt(Filas-1)+1));
        System.out.println("TesoroX: "+TesoroY);

        try {
            JugadorSprite = CapaIcons.crearSprite(ImageIO.read(RutaIMG),SpriteTamaño,JugadorX,JugadorY);
            System.out.println("JugadorX: "+JugadorX);
            System.out.println("JugadorX: "+JugadorY);
            TesoroSprite = CapaIcons.crearSprite(ImageIO.read(RutaIMG),TesoroTamaño,TesoroX+5,TesoroY+5);
            TopBorder = CapaIcons.crearSprite(ImageIO.read(RutaBorder),HorizontalBorder,0,-(CellY/2));
            LeftBorder = CapaIcons.crearSprite(ImageIO.read(RutaBorder),VerticalBorder,-(CellX/2),0);
            BotBorder = CapaIcons.crearSprite(ImageIO.read(RutaBorder),HorizontalBorder,0, Resolucion.height-(CellY/2));
            RightBorder = CapaIcons.crearSprite(ImageIO.read(RutaBorder),VerticalBorder,Resolucion.width-(CellX/2),0);

            int move;
            for (int i = 80; i > 0; i--) {
                move = Movimiento.leerCaracter();
                Letras.cls();
                switch (move) {
                    case 'a','A' -> {
                        if (JugadorSprite.comprobarColision(LeftBorder)==false) {
                            JugadorSprite.moverX(-CellX);
                            JugadorX -= CellX;
                            Movimientos -=1;
                        }
                    }
                    case 's','S' -> {
                        if (!JugadorSprite.comprobarColision(BotBorder)) {
                            JugadorSprite.moverY(+CellY);
                            JugadorY += CellY;
                            Movimientos -=1;
                        }
                    }
                    case 'w','W' -> {
                        if (!JugadorSprite.comprobarColision(TopBorder)) {
                            JugadorSprite.moverY(-CellY);
                            JugadorY -= CellY;
                            Movimientos -=1;
                        }
                    }
                    case 'd','D' -> {
                        if (!JugadorSprite.comprobarColision(RightBorder)) {
                            JugadorSprite.moverX(+CellX);
                            JugadorX += CellX;
                            Movimientos -=1;
                        }
                    }
                }
                Distancia =  Math.sqrt(Math.pow(((JugadorX/CellX)-(TesoroX/CellX)),2) + Math.pow((JugadorY/CellY)-(TesoroY/CellY),2));
                if (JugadorSprite.comprobarColision(TesoroSprite)) {

                    JugadorSprite.setPosicion(ComJugadorX,ComJugadorY);
                    TesoroX = IniX+(CellX*aleatorio.nextInt(91));
                    TesoroY = IniY+(CellY*(aleatorio.nextInt(31)+1));
                    TesoroSprite.setPosicion(TesoroX+5,TesoroY+5);
                    Movimientos += 10;
                    i += 10;
                    Puntos += Movimientos;
                }
                Letras.print(0,0,"Nivel: "+Nivel);
                Letras.print(0,15,"Puntos: "+Puntos);
                Letras.print(0,30,"Movimientos restantes: "+Movimientos);
                if (Distancia<5) {
                    Temperatura = "Quemando";
                } else if (Distancia>5&&Distancia<15) {
                    Temperatura = "Caliente";
                } else if (Distancia>15&&Distancia<35) {
                    Temperatura = "Frio";
                } else if (Distancia>35) {
                    Temperatura = "Muy frio";
                }
                Letras.print(0,70,Temperatura);
            }

        } catch (IOException e) {
            System.err.println("Error de imagen");
        }

    }

    public static void DefinirPosiciones() {

    }

    public static void main(String[] args) {
        DefinirConsola();

    }
}
