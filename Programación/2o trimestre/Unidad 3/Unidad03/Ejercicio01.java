import java.io.*;
import java.util.Scanner;

public class Ejercicio01 {
    /*
    Realiza un programa que muestre estas dos opciones al usuario:
    1) Escribir dos frases en un archivo
    2) Leer dos frases del archivo
    Se hará un bloque switch-case que analice la opción elegida por el usuario. Si pulsa 1, se
    creará un archivo llamado “frases.txt” con dos frases (las que tú quieras) en él. Si pulsa 2,
    se leerá el archivo “frases.txt” y se mostrarán en pantalla las dos frases que contiene.
     */
    public static void main(String[] args) {
        System.out.println("Elija una de las siguientes opciones:\n" +
                "1) Escribir dos frases en un archivo\n" +
                "2) Leer dos frases del archivo");
        int opcion = new Scanner(System.in).nextInt();
        File frases = new File("frases.txt");

        try {

            switch (opcion){
                case 1:
                    PrintWriter Escribir = new PrintWriter(frases);
                    Escribir.println("Vale");
                    Escribir.println("Ta bueno");
                    Escribir.close();
                    break;
                case 2:
                    Scanner Leer = new Scanner(frases);
                    System.out.println(Leer.nextLine());
                    System.out.println(Leer.nextLine());
                    break;
                default:
                    System.out.println("Elija una opción válida");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
