import java.util.Scanner;

public class Ej3_FCM {
    /*
     Realiza una aplicación que pida por teclado tres letras y siempre indique
    cual qué va primera alfabéticamente. Deberá funcionar tanto con mayúsculas como
    minúsculas como con números. Es importante que si hay repetidas el resultado sólo se
    muestre una vez. Ejemplos:
    Letras leidas: R, a, T - > la primera es R
    Letras leidas: A, m, 4 - > la primera es 4
    Letras leidas: j, w, j → La primera es j
     */

    public static void main(String[] args) {
        //El siguiente bloque recoge las letras a comparar
        System.out.println("Introduzca la primera letra");
        char Letra1 = new Scanner(System.in).nextLine().charAt(0);
        System.out.println("Introduzca la Segunda letra");
        char Letra2 = new Scanner(System.in).nextLine().charAt(0);
        System.out.println("Introduzca la Tercera letra");
        char Letra3 = new Scanner(System.in).nextLine().charAt(0);

        //El siguiente bloque convierte las letras a ASCII para su comparación
        int Letra1ASCII = Letra1;
        int Letra2ASCII = Letra2;
        int Letra3ASCII = Letra3;


        //El siguiente bloque comprueba que letra va antes o si van a a vez
        if (Letra1ASCII<=Letra2ASCII && Letra1ASCII<=Letra3ASCII){
            System.out.println("La letra que va primero alfabéticamente es: "+Letra1);
        } else if (Letra2ASCII<=Letra1ASCII && Letra2ASCII<=Letra3ASCII){
            System.out.println("La letra que va primero alfabéticamente es: "+Letra2);
        } else if (Letra3ASCII<=Letra2ASCII && Letra3ASCII<=Letra1){
            System.out.println("La letra que va primero alfabéticamente es: "+Letra3);
        }
    }
}
