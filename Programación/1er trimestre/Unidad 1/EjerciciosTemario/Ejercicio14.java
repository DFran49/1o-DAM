import java.util.Scanner;

public class Ejercicio14 {
    /*
    Realiza un programa que pregunte al usuario por teclado un número de “euros” y el
    programa mostrará por pantalla el cambio de dicha cantidad a las siguientes monedas:
    Dolares 1 € = 1.42 $
    Libras 100 € = 87.13£
    Yens 1 € = 113.86 ¥
    Pesetas 1 € = 166.386 pts
     */

    static double Euros;
    static double Dolares;
    static double Libras;
    static double Yens;
    static double Pesetas;

    //Este bloque recoge los datos
    public static void RecDatos(){
        System.out.println("Introduzca sus euros");
        Euros = new Scanner(System.in).nextDouble();
    }

    //Este bloque ejecuta los cálculos
    public static void Calculo(){
        Dolares = Euros * 1.42;
        Libras = Euros * 0.8713;
        Yens = Euros * 113.86;
        Pesetas = Euros * 166.386;
    }

    //Este bloque muestra las conversiones
    public static void MostrarDatos(){
        System.out.println("Las conversiones a distintas monedas son:");
        System.out.println("Dolares: "+Dolares);
        System.out.println("Libras: "+Libras);
        System.out.println("Yens: "+Yens);
        System.out.println("Pesetas: "+Pesetas);
    }

    public static void main(String[] args) {
        RecDatos();
        Calculo();
        MostrarDatos();
    }
}
