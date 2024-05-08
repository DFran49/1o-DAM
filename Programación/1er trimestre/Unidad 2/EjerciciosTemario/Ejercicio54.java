import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio54 {
    public static void main(String[] args) {
        List<String> Palabras = new ArrayList<>();
        Palabras.add("Carambano");
        Palabras.add("Lechuga");
        Palabras.add("Acera");
        Palabras.add("Alfombra");
        Palabras.add("Soporte");
        Palabras.add("Cámara");
        Palabras.add("Persiana");
        Palabras.add("Manivela");
        Palabras.add("Persona");
        Palabras.add("Rayo");
        Collections.sort(Palabras);
        System.out.println("El toString de la lista es "+Palabras.toString());
    }
}
