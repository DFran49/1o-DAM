import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlmacenamientoBurbujaLista {
    //Esta variable es global para referenciarla desde la clase Ordenar
    static int cantidad;
    //Este array se define global y no se inicializa
    static List<Integer> lista = new ArrayList<>();

    //Esta clase recibe la longitud del array a ordenar deseada
    static void RecibirNum() {
        System.out.println("¿Cuántos números quiere introducir?");
        cantidad = new Scanner(System.in).nextInt();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Introduzca un número");
            lista.add(new Scanner(System.in).nextInt());
        }
    }

    //Esta clase ordena los números introducidos
    static void Ordenar() {
        int DePaso;
        for(int NumTemp = 0; NumTemp < lista.size() - 1; ++NumTemp) {
            for(int TempNum = 0; TempNum < lista.size() - 1; ++TempNum) {
                if (lista.get(TempNum) > lista.get(TempNum+1)) {
                    DePaso = lista.get(TempNum);
                    lista.set(TempNum, lista.get(TempNum+1));
                    lista.set(TempNum+1,DePaso);
                }
            }
        }

        System.out.println("La lista ordenada es:");
        System.out.println(lista);
    }

    public static void main(String[] args) {
        RecibirNum();
        Ordenar();
    }
}
