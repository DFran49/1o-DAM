import java.util.Date;
import java.util.Scanner;

public class Ejercicio46 {
    /*
    Realiza un programa que pregunte al usuario su año de nacimiento, si es hombre o
    mujer, su altura (en metros), peso (en kg) y muestre por pantalla su frecuencia cardiaca máxima, su
    índice de masa corporal y su estado según la Organización Mundial de la Salud.
     Frecuencia cardiaca máxima: Si es hombre se calcula como 220 - edad, y si es mujer se
    calcula como 226 - edad.
     Índice de masa corporal (IMC): Se calcula dividiendo el peso entre la altura elevada al
    cuadrado y se muestra con dos cifras decimales.
     El estado según la OMS se mira en esta tabla:
    IMC Estado
    Menor de 16.00 Infrapeso: delgadez severa
    Entre 16.00 y 16.99 Infrapeso: delgadez moderada
    Entre 17.00 y 18.49 Infrapeso: delgadez aceptable
    Entre 18.50 y 24.99 Peso normal
    Entre 25.00 y 29.99 Sobrepeso
    Entre 30.00 y 34.99 Sobrepeso: tipo I
    Entre 35.00 y 40.00 Sobrepeso: tipo II
    Mayor de 40.00 Sobrepeso: tipo III
     */
    static int AnioNacimiento;
    static String Genero;
    static double Altura;
    static double Peso;
    static int Edad;
    public static void RecDat(){
        System.out.println("Introduzca su año de nacimiento.");
        AnioNacimiento = new Scanner(System.in).nextInt();
        System.out.println("Introduzca su género (Hombre o Mujer.)");
        Genero = new Scanner(System.in).nextLine();
        System.out.println("Introduzca su altura en metros (Use la , para separar decimales).");
        Altura = new Scanner(System.in).nextDouble();
        System.out.println("Introduzca su peso en kilos (Use la , para separar decimales).");
        Peso = new Scanner(System.in).nextDouble();
    }
    public static void FrecuenciaMax(){
        Date FechaHoy = new Date();
        int anio = FechaHoy.getYear();
        Edad = anio - AnioNacimiento;
        if(Genero=="Hombre"||Genero=="hombre"){
            System.out.println("Tú Frecuencia cardiaca máxima es: "+(220-Edad));
        } else if (Genero=="Mujer"||Genero=="mujer") {
            System.out.println("Tú Frecuencia cardiaca máxima es: "+(226-Edad));
        }
    }

    public static void main(String[] args) {
        //RecDat();
        FrecuenciaMax();
    }
}
