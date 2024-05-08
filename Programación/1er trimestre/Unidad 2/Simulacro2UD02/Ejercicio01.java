import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        System.out.println("Introduzca un código ISBN:");
        String ISBN = new Scanner(System.in).nextLine();

        if (ISBN.length() != 13) {
            System.out.println("Introduzca un ISBN de longitud válida (13 caracteres)");
        } else if (ISBN.substring(0,3).equals("978") || ISBN.substring(0,3).equals("979")) {
            System.out.println("¿Qué campo del ISBN deseas consultar?");
            System.out.println("\n1 – identificador");
            System.out.println("2 – código de país");
            System.out.println("3 – código de editor");
            System.out.println("4 – número del artículo");
            System.out.println("5 – dígito de control");
            System.out.println("6 – guardar");
            int Opcion = new Scanner(System.in).nextInt();
            if (Opcion >=6 && Opcion<=1) {
                System.out.println("El programa ha terminado, elija una opción entre 1 y 6");
            } else {
                String  Identificador = Opcion==1 ? "El identificador es: "+ISBN.substring(0,3):"";
                String CodPais = Opcion==2 ? "El código de país es: "+ISBN.substring(3,5):"";
                String CodEditor = Opcion==3 ? "El código del autor es: "+ISBN.substring(5,9):"";
                String NumArticulo = Opcion==4 ? "El número de artículo es: "+ISBN.substring(9,12):"";
                String DigControl = Opcion==5 ? "El dígito de control es: "+ISBN.substring(12):"";
                System.out.print(Identificador);
                System.out.print(CodPais);
                System.out.print(CodEditor);
                System.out.print(NumArticulo);
                System.out.print(DigControl);
                if (Opcion == 6) {
                    try {
                        PrintWriter Archivo = new PrintWriter("libro.xml");
                        Archivo.println("<?xml version=’1.0’ encoding=’UTF-8’?>\n" +
                                "<isbn identificador=’"+ISBN.substring(0,3)+"’>\n" +
                                "<codigo_pais>"+ISBN.substring(3,5)+"</codigo_pais>\n" +
                                "<codigo_editor>"+ISBN.substring(5,9)+"</codigo_editor>\n" +
                                "<numero_articulo>"+ISBN.substring(9,12)+"</numero_articulo>\n" +
                                "<digito_control>"+ISBN.substring(12)+"</digito_control>\n" +
                                "</isbn>");
                        Archivo.close();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
