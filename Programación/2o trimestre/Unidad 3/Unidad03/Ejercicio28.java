import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio28 {
    /*
    Haz un programa que pida 6 palabras al usuario y las guarde en un List<String>. El
    programa deberá mostrar por pantalla las palabras únicas (o sea, las palabras repetidas no se
    mostrarán).
     */
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>();
        String varPaso;

        for (int i = 0; i < 6 ; i++) {
            System.out.println("pendejo");
            palabras.add(new Scanner(System.in).nextLine());
        }

        for (int i = 0; i < palabras.size() ; i++) {
            varPaso = palabras.get(i);
            palabras.remove(i);
            if (!palabras.contains(varPaso)) {
                System.out.println(varPaso);
            }
            palabras.add(i,varPaso);
        }
    }
}
