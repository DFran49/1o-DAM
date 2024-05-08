import java.util.Scanner;

public class Ejercicio15 {
    /*
     Haz un programa en el que haya una variable String llamada “clave” con el texto
    que tú quieras. A continuación, el programa pedirá que introduzcas una contraseña por
    teclado. El ordenador mostrará si la variable “clave” coincide con la contraseña introducida.
     */

    public static void main(String[] args) {
        String clave = "Ta bien";
        System.out.println("Introduce la contraseña:");
        String contraseña = new Scanner(System.in).nextLine();
        //El if comprueba si el resultado de si clave es = a contraseña es true y da acceso
        if (clave.equals(contraseña)) {
            System.out.println("Bienvenido usuario");
        } else {
            System.out.println("No pintas nada aquí");
        }
    }
}
