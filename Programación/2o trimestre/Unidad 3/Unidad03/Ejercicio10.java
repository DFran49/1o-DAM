import java.util.Scanner;
import java.util.StringTokenizer;

public class Ejercicio10 {
    /*
    Usa la clase StringTokenizer para hacer un programa que pregunte al usuario
    "Escriba una frase" y nos muestre en una línea diferente cada palabra de la frase y además, el
    número total de palabras encontradas.
     */
    public static void main(String[] args) {
        System.out.println("Escriba una frase");
        String Frase = new Scanner(System.in).nextLine();
        StringTokenizer Tokens = new StringTokenizer(Frase);
        int contador = 0;
        while (Tokens.hasMoreElements()) {
            System.out.println(Tokens.nextToken());
            contador +=1;
        }
        System.out.println("La frase tiene "+contador+" palabras");
    }
}
