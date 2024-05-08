import java.io.*;
import java.util.Scanner;

public class Ej3_FCM {
    /*
    En primer lugar leerá un archivo de texto preguntado por teclado. Si el archivo no
    existe o no se puede leer informará del error y el programa terminará.
    • Se deberá leer el fichero que contendrá el siguiente formato
    Nombre: Nombre
    Apellidos: Apellidos
    Email: mail
    Contraseña: Contraseña
    Contraseña2: Contraseña
    Ejemplo:
    Nombre: Alberto
    Apellidos: Zagalaz Anula
    Email: azagalaz@ieshlanz.es
    Contraseña: secreto1235
    Contraseña2: secreto1235

    Si se produce algún error durante la lectura se informará del error ocurrido y el
    programa acabará.
    • En caso contrario el programa realizará las siguientes comprobaciones:
    ◦ Nombre y apellidos: Que no estén en blanco
    ◦ Email: Que contenga solamente una @, que haya al menos 5 caracteres delante de
    esta y al menos 7 detras de esta. Que exista al menos un punto detras de la @ y
    que después de este (si hay más de uno el último) haya al menos 2 caracteres más.
    ◦ Contraseña: Eliminará posibles espacios que haya delante o detrás de esta y
    comprobará que sean iguales tanto ignorando mayúsculas.
    • Si alguna de las comprobaciones falla se informará del error y el programa continuará.
    • Si todo es correcto escribirá solamente los datos en un fichero que se llame “BD.txt”
    preguntando si quiere añadir o sobreescribir dicho fichero de la siguiente forma, para
    que el usuario se añada al final del fichero o se sobrescriba:
    ---------------------------------
    Nombre Completo
    Email
    Contraseña
    ----------------------------------
    Ejemplo:
    ----------------------------------------------
    Alberto Zagalaz Anula
    azagalaz@ieshlanz.es
    secreto1235
    ---------------------------------------------
     */
    public static void main(String[] args) {
        System.out.println("Introduzca la ruta de un archivo");
        File ArchivoAComprobar = new File(new Scanner(System.in).nextLine());
        if (ArchivoAComprobar.exists()==false&&ArchivoAComprobar.canRead()==false) {
            System.out.println("El archivo seleccionado no existe o no puede leerse");
        } else {
            try {
                Scanner LeerArchivo = new Scanner(ArchivoAComprobar);
                String Linea1 = LeerArchivo.nextLine();
                String Linea2 = LeerArchivo.nextLine();
                String Linea3 = LeerArchivo.nextLine();
                String Linea4 = LeerArchivo.nextLine();
                String Linea5 = LeerArchivo.nextLine();
                String Nombre = Linea1.substring(8);
                String Apellidos = Linea2.substring(11);
                String Mail = Linea3.substring(7);
                String Contraseña1 = Linea4.substring(12);
                String Contraseña2 = Linea5.substring(13);
                if (Nombre=="") {
                    System.out.println("Tiene que introducir un nombre");
                }
                if (Apellidos=="") {
                    System.out.println("Tiene que introducir un/unos apellido/os");
                }
                if (Mail.lastIndexOf("@")!=Mail.indexOf("@")&&Mail.indexOf("@")<4&&Mail.substring(Mail.indexOf("@"),Mail.lastIndexOf(".")).length()<7&&Mail.length()-Mail.lastIndexOf(".")<2) {
                    System.out.println("Debe introducir un mail con al menos 5 caracteres antes de la @, \n" +
                            "al menos 7 caracteres después de la @, una sola @, al menos un punto y al menos 2 caracteres \n" +
                            "después del último punto");
                }
                Contraseña1 = Contraseña1.trim();
                Contraseña2 = Contraseña2.trim();
                if (!Contraseña1.equalsIgnoreCase(Contraseña2)) {
                    System.out.println("Las contraseñas no son iguales");
                } else {
                    try {
                        FileWriter EscribirBBDD = new FileWriter("BD.txt",true);
                        EscribirBBDD.append(Nombre+" "+Apellidos+"\n"+Mail+"\n"+Contraseña1.toLowerCase()+"\n");
                        EscribirBBDD.close();
                    } catch (IOException e) {
                        System.out.println("El archivo seleccionado no es un fichero");
                    }
                }


            } catch (FileNotFoundException e) {
                System.out.println("No se ha encontrado el archivo");
            }
        }
    }
}
