import java.util.Scanner;

public class Ejercicio11 {
    /*Haz un programa que pregunte al usuario su nombre, su primer apellido y su segundo
    apellido (cada uno será una pregunta independiente). El ordenador mostrará el nombre y apellidos
    del usuario en formato apellido1 apellido2, nombre
    */
    public static void main(String[] args){
        System.out.println("¿Cuál es tú nombre?");
        String Nombre = new Scanner(System.in).nextLine();
        System.out.println("¿Cuál es tú primer apellido?");
        String Apellido1 = new Scanner(System.in).nextLine();
        System.out.println("¿Cuál es tú segundo apellido?");
        String Apellido2 = new Scanner(System.in).nextLine();

        System.out.println("Hola "+Apellido1+" "+Apellido2+" "+Nombre);
    }
}
