import java.util.ArrayList;
import java.util.List;

public class Ejercicio50 {
    public static void main(String[] args) {
        List<String> Palabras = new ArrayList<>();
        Palabras.add("Vale");
        Palabras.add("Cebolla");
        Palabras.add("Motor");
        Palabras.add("Bombilla");
        Palabras.add("Libro");
        System.out.println("El tamaño de la lista es "+Palabras.size());
        System.out.println("La posicion 3 es "+Palabras.get(2));
        System.out.println("El toString de la lista es "+Palabras.toString());
        Palabras.remove(0);
        System.out.println("El tamaño de la lista es "+Palabras.size());
        System.out.println("La posicion 3 es "+Palabras.get(2));
        System.out.println("El toString de la lista es "+Palabras.toString());
    }
}
