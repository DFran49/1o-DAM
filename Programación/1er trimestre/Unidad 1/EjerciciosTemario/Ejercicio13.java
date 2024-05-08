import java.util.Scanner;

public class Ejercicio13 {
    /*
    Haz un programa que pregunte al usuario tres números enteros y guárdalos en
    variables llamadas horas, minutos y segundos. El programa mostrará el número total de segundos
    que hay juntando las cantidades de tiempo expresadas en las tres variables.
     */

    static int horas;
    static int minutos;
    static int segundos;
    //Bloque para recoger los datos
    public static void RecDatos(){
        System.out.println("Introduzca las horas");
        horas = new Scanner(System.in).nextInt();
        System.out.println("Introduzca los minutos");
        minutos = new Scanner(System.in).nextInt();
        System.out.println("Introduzca los segundos");
        segundos = new Scanner(System.in).nextInt();
    }
    //bloque para pasar horas y minutos a segundos y sumarlo
    public static void Calculo(){
        segundos = segundos + (minutos*60) + (horas*3600);
    }
    //bloque para ejecutar todo
    public static void main(String[] args) {
        RecDatos();
        Calculo();
        System.out.println("Los segundos totales son: "+segundos);
    }
}
