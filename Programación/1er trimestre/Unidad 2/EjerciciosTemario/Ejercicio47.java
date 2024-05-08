import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio47 {
    public static void main(String[] args) {
        String ruta = new Scanner(System.in).nextLine();
        File Archivo = new File(ruta);
        Desktop Abrir = Desktop.getDesktop();
        try {
            Abrir.open(Archivo);
        } catch (IOException p) {
            System.out.println("Excepcion al abrir");
        }
    }
}
