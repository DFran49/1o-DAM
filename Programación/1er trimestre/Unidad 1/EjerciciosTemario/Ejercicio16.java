import java.util.Scanner;

public class Ejercicio16 {
    /*
    Un videoclub alquila la película "El padrino" a 3.5 €/día y "Odisea 2001" por 2.95 €/día.
    Haz un programa que pregunte por teclado el número de días que queremos alquilar las dos películas
    y la cantidad de dinero que paga el cliente. El programa mostrará si dicho dinero es suficiente para
    pagar el alquiler la cantidad de días indicada
     */

    static int DiasPadrino;
    static int DiasOdisea;
    static double DineroAPagar;

    //Este bloque recoge los datos
    public static void RecDatos(){
        System.out.println("¿Cuantos días quieres alquilar 'El Padrino'?");
        DiasPadrino = new Scanner(System.in).nextInt();
        System.out.println("¿Cuantos días quieres alquilar 'Odisea 2001'?");
        DiasOdisea = new Scanner(System.in).nextInt();
        System.out.println("¿Con cuanto dinero vas a pagar?");
        DineroAPagar = new Scanner(System.in).nextDouble();
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
