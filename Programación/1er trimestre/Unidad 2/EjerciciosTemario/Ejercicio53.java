
import java.awt.*;
import java.util.Map;
import java.util.TreeMap;

public class Ejercicio53 {
    public static void main(String[] args) {
        Map<String, Color> Arbol = new TreeMap<>();

        Arbol.put("12535ABC", Color.RED);
        Arbol.put("98525KWX", Color.YELLOW);
        Arbol.put("17632MSE", Color.GREEN);
        Arbol.put("85321ABC", Color.YELLOW);
        System.out.println("El tamaño del árbol es "+Arbol.size());
    }
}
