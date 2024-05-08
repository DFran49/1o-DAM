import java.util.Collection;
import java.util.HashSet;

public class Ejercicio51 {
    public static void main(String[] args) {
        Collection<String> Palabras = new HashSet<>();
        Palabras.add("Silla");
        Palabras.add("Mesa");
        Palabras.add("Niño");
        Palabras.add("Mesa");
        Palabras.add("Casa");
        Palabras.add("Silla");
        Palabras.add("Lápiz");
        System.out.println("El tamaño del set es "+Palabras.size());
        System.out.println("El toString del set es "+Palabras.toString());
    }
}
