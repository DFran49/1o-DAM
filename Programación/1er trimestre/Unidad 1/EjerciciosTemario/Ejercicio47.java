import java.util.Scanner;

public class Ejercicio47 {
    /*
    Realiza un programa en el que haya una variable entera llamada año inicializada con
    cualquier valor positivo. El programa mostrará por pantalla si el año guardado en dicha variable es
    bisiesto. Ten en cuenta que un año es bisiesto cuando se cumple alguna de estas dos condiciones:
    a) Es múltiplo de 400
    b) No es múltiplo de 400, pero es múltiplo de 4 y no es múltiplo de 100
     */
    static int Anio;
    //Método para recopilar datos
    public static void RecDatos(){
        System.out.println("Introduzca un año (Positivo o negativo)");
        Anio = new Scanner(System.in).nextInt();
    }
    //Método para calcular si es bisiesto e indicarlo
    public static void CalcBisiesto(){
        //La fórmula busca que el año sea múltiplo de 400 O que sea de 4 Y no de 100 Y no de 400
        if(Anio%400==0||(Anio%4==0&&Anio%100!=0&&Anio%400!=0)){
            System.out.println("El año "+Anio+" es bisiesto.");
        } else {
            System.out.println("El año "+Anio+" no es bisiesto.");
        }
    }

    public static void main(String[] args) {
        RecDatos();
        CalcBisiesto();
    }
}
