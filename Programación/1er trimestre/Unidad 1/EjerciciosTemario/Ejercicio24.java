import java.util.Scanner;
public class Ejercicio24 {
    /*
    Realiza un programa que pregunte al usuario la edad de dos personas. El programa
    mostrará si ambas son mayores de edad, y también si la primera persona es mayor que la segunda.
     */
    static int Edad1;
    static int Edad2;
    static public void RecDatos(){
        System.out.println("Introduzca la edad de la primera persona:");
        Edad1 = new Scanner(System.in).nextInt();
        System.out.println("Introduzca la edad de la segunda persona:");
        Edad2 = new Scanner(System.in).nextInt();
    }
    static boolean MayorEdad;
    static boolean PrimEsMayor;
    static public void CompSoli(){
        MayorEdad = Edad1>=18 && Edad2>=18;
        PrimEsMayor = Edad1>Edad2;
    }
    public static void main(String[] arg){
        RecDatos();
        CompSoli();
        System.out.println("Las personas son mayores de edad, "+MayorEdad);
        System.out.println("La primera persona es mayor que la segunda, "+PrimEsMayor);
    }
}
