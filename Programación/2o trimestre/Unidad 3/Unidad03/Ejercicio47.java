import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio47 {
    /*
    Supongamos que un diccionario español – inglés tiene las palabras de la tabla.
    Realiza tres programas que pregunten cada uno por teclado al usuario una palabra en español
    y nos salga su palabra traducida al inglés, de esta forma:
    a) Usando dos arrays unidimensionales (listas) para guardar los datos de la tabla
    b) Usando un array bidimensional (tabla) para guardar los datos de la tabla
    c) Usando un Map<String,String> para guardar los datos de la tabla
     */
    public static void main(String[] args) {
        String [] listaEsp = {"hola","casa","caballo","hacha","manzana","ventana","tortuga","ratón","mesa"};
        String [] listaEng = {"hello","house","horse","axe","apple","window","turtle","mouse","table"};
        System.out.println("\nEscriba una palabra en español");
        String palabra = new Scanner(System.in).nextLine();
        boolean controlador = false;
        for (int i = 0; i < listaEsp.length && !controlador; i++) {
            if(palabra.equalsIgnoreCase(listaEsp[i])) {
                System.out.println("La palabra "+listaEsp[i]+" se traduce por "+listaEng[i]);
                controlador = true;
            }
        }
        if (!controlador) {
            System.out.println("Lo siento, su palabra no está en el diccionario");
        }

        String [] [] tablaPalabras = {listaEsp,listaEng};
        System.out.println("\nEscriba una palabra en español");
        palabra = new Scanner(System.in).nextLine();
        controlador = false;
        for (int i = 0; i < tablaPalabras[0].length && !controlador; i++) {
            if(palabra.equalsIgnoreCase(tablaPalabras[0][i])) {
                System.out.println("La palabra "+tablaPalabras[0][i]+" se traduce por "+tablaPalabras[1][i]);
                controlador = true;
            }
        }
        if (!controlador) {
            System.out.println("Lo siento, su palabra no está en el diccionario");
        }

        Map<String,String> mapa = new HashMap<>();
        for (int i=0;i<listaEsp.length;i++){
            mapa.put(listaEsp[i],listaEng[i]);
        }
        System.out.println("\nEscriba una palabra en español");
        palabra = new Scanner(System.in).nextLine();
        if (mapa.containsKey(palabra)){
            System.out.println("La palabra "+palabra+" se traduce por "+mapa.get(palabra));
        } else {
            System.out.println("Lo siento, su palabra no está en el diccionario");
        }
    }
}
