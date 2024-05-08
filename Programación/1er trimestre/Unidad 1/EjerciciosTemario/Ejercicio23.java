import java.util.ArrayList;
import java.util.Scanner;
public class Ejercicio23 {
    /*
    Realiza un programa que pregunte por teclado al usuario las tres notas de sus
    exámenes y nos muestre por pantalla si su media le sale aprobado.
     */
    static ArrayList<Double> ListaNotas = new ArrayList<Double>();
    //Método de recopilación de datos
    public static void RecNotas(){
        for(int i=0;i<3;i++) {
            System.out.println("Introduzca la " + i + "ª nota:");
            ListaNotas.add(new Scanner(System.in).nextDouble());
        }
    }

    static double MediaNotas;
    //Método de cálculo de media
    public static void ApliMedia(){
        for(int i=0;i<ListaNotas.size();i++){
            MediaNotas += ListaNotas.get(i);
        }
        MediaNotas /= ListaNotas.size();
    }
    //Método de ejecución
    public static void main(String[] arg){
        RecNotas();
        ApliMedia();
        System.out.println("La media para las notas introducidas es: "+MediaNotas);
    }
}
