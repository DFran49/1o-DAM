import java.io.*;
import java.util.Scanner;
public class Ejercicio02 {
    /*
    Repite el ejercicio 1 utilizando un switch mejorado.
     */
    public static void main(String[] args) {
        System.out.println("Elija una de las siguientes opciones:\n" +
                "1) Escribir dos frases en un archivo\n" +
                "2) Leer dos frases del archivo");
        int opcion = new Scanner(System.in).nextInt();
        File frases = new File("frases.txt");

        try {

            switch (opcion){
                case 1->{
                    PrintWriter Escribir = new PrintWriter(frases);
                    Escribir.println("Vale");
                    Escribir.println("Ta bueno");
                    Escribir.close();
                }

                case 2->{
                    Scanner Leer = new Scanner(frases);
                    System.out.println(Leer.nextLine());
                    System.out.println(Leer.nextLine());
                }

                default->{
                    System.out.println("Elija una opción válida");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
