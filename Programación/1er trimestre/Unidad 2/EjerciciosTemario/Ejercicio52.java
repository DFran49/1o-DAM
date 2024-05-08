import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio52 {
    public static void main(String[] args) {
        Map<String, Color> Colores = new HashMap<>();
        Colores.put("12535ABC",Color.red);
        Colores.put("98525KWX",Color.yellow);
        Colores.put("17632MSE",Color.green);
        Colores.put("85321ABC",Color.YELLOW);
        System.out.println("El tamaño del HashMap es "+Colores.size());
        System.out.println("El toString del HashMap es "+Colores.toString());
        String Matricula = new Scanner(System.in).nextLine();
        if (Colores.get(Matricula) == null) {
            System.out.println("No existe la matrícula");
        } else {
            System.out.println(Colores.get(Matricula));
        }

    }
}
