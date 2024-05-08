import java.io.File;
import java.util.Scanner;

public class Ej1_FCM {
    /*
    En primer lugar el programa pedirá una ruta al usuario para que la introduzca por
    teclado. A continuación debe comprobar que esa ruta exista y que sea un
    directorio. Si no existe o no es un directorio informará del error y el programa
    acabará.
    • Si la ruta es correcta el programa obtendrá la lista de archivos de ese directorio y
    generará un resumen con los 3 primeros archivos del directorio. Si hay menos de 3
    solo escribirá la información de esos sin dar error. Este resumen se guardará en el
    archivo de texto “resumen_INI.txt” y tendrá el siguiente formato:
    ---------------------------------
    Resumen de archivos de:
    ruta introducida
    ---------------------------------
    nombre1 tipo tamaño
    nombre1 tipo tamaño
    nombre1 tipo tamaño
    Ejemplo:
     */
    public static void main(String[] args) {
        System.out.println("Introduzca una ruta:");
        String Ruta = new Scanner(System.in).nextLine();
        File Archivo = new File(Ruta);
        if (Archivo.exists() == false && Archivo.isDirectory() == false) {
            System.out.println("El directorio indicado no existe o no es directorio, inténtelo de nuevo");
        } else {
            File[] ArrFiles = Archivo.listFiles();
            System.out.println(ArrFiles.length);
            String Output = "Resumen de archivos de:\n" +
                    "    "+Archivo.getPath()+"\n" +
                    "    ---------------------------------\n";
            if (ArrFiles.length == 0) {
                System.out.println("No existen ficheros en la carpeta");
            } else if (ArrFiles.length == 3) {
                Output = Output+"\n    "+ArrFiles[0].getName()+" ";
                if (ArrFiles[0].isFile() == true) {
                    Output = Output+"archivo ";
                } else {
                    Output = Output+"carpeta ";
                }
                Output = Output+ArrFiles[0].length();

                Output = Output+"\n    "+ArrFiles[1].getName()+" ";
                if (ArrFiles[1].isFile() == true) {
                    Output = Output+"archivo ";
                } else {
                    Output = Output+"carpeta ";
                }
                Output = Output+ArrFiles[1].length();

                Output = Output+"\n    "+ArrFiles[2].getName()+" ";
                if (ArrFiles[2].isFile() == true) {
                    Output = Output+"archivo ";
                } else {
                    Output = Output+"carpeta ";
                }
                Output = Output+ArrFiles[2].length();
            } else if (ArrFiles.length == 2) {
                Output = Output+"\n    "+ArrFiles[0].getName()+" ";
                if (ArrFiles[0].isFile() == true) {
                    Output = Output+"archivo ";
                } else {
                    Output = Output+"carpeta ";
                }
                Output = Output+ArrFiles[0].length();

                Output = Output+"\n    "+ArrFiles[1].getName()+" ";
                if (ArrFiles[1].isFile() == true) {
                    Output = Output+"archivo ";
                } else {
                    Output = Output+"carpeta ";
                }
                Output = Output+ArrFiles[1].length();
            } else if (ArrFiles.length == 1) {
                Output = Output+"\n    "+ArrFiles[0].getName()+" ";
                if (ArrFiles[0].isFile() == true) {
                    Output = Output+"archivo ";
                } else {
                    Output = Output+"carpeta ";
                }
                Output = Output+ArrFiles[0].length();
            }
            Output = Output+"\n    ---------------------------------";
            System.out.println(Output);
        }
    }
}
