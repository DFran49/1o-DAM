import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio27 {
    /*
    Haz un programa que pida 6 palabras al usuario y las guarde en un List<String>. El
    programa deberá recorrer dicha lista y mostrará por pantalla las que contienen la letra “a”
     */
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>();
        int contador = 0;

        for (int i = 0; i < 6 ; i++) {
            System.out.println("Introsuzca una palabra");
            palabras.add(new Scanner(System.in).nextLine());
        }

        for (int i = 0; i < palabras.size() ; i++) {
            if (palabras.get(i).contains("a")) {
                System.out.println(palabras.get(i));
                contador +=1;
            }
        }
        System.out.println("En la lista hay "+contador+" palabras que contienen la letra 'a'");
    }
}
