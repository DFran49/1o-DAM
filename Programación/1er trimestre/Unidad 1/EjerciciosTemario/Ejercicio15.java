import java.util.Scanner;

public class Ejercicio15 {
    /*
    Crea un programa que pregunte al usuario un número entero llamado
    gradosCentígrados. El programa deberá convertir dicha cantidad a grados Farenheit y mostrarla por
    pantalla.
     */

    static double Celsius;
    static double Farenheit;

    //Este bloque recoge los datos
    public static void RecDatos(){
        System.out.println("Introduzca una temperatura en grados Celsius");
        Celsius = new Scanner(System.in).nextDouble();
    }

    //Este bloque ejecuta los cálculos
    public static void Calculo(){
        //Multiplico por 100 para que los calculos los haga sin decimales
        Farenheit = ((1.8*Celsius)+32)*100;
    }

    //Este bloque muestra las conversiones
    public static void MostrarDatos(){
        //Divido por 100 los Farenheit para que vuelva a tener decimales
        System.out.println(Celsius+" grados Celsius son "+Farenheit/100+" grados Farenheit");

    }

    public static void main(String[] args) {
        RecDatos();
        Calculo();
        MostrarDatos();
    }
}
