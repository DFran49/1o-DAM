import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;
import javax.swing.*;

public class Autoclicker {
    static String TeclaAPulsar;
    public static void RecDatos (){
        TeclaAPulsar = JOptionPane.showInputDialog("Introduzca la tecla a pulsar:");
    }

    static boolean Encendido;
    static Robot r;
    static int keyCode = KeyEvent.VK_K;
    public static void Bucle()throws AWTException{
        r = new Robot();
        while (Encendido == true){
            r.keyPress(keyCode);
            r.keyRelease(keyCode);
        }
    }

    public static void main(String[] arg)throws AWTException{
        RecDatos();
        Bucle();
    }
}
