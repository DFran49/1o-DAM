import java.util.Scanner;

public class Ej1_FCM {
    public static void main(String[] args) {
        int numero;
        int posicion;
        int contador = 0;
        int[] lista = new int[10];
        for (int i = 0; i < 10; i++) {
            lista[i] = -1;
        }
        while (contador != 10) {
            System.out.println("Introduzca un número a guardar.");
            numero = new Scanner(System.in).nextInt();
            if (numero < 0) {
                System.out.println("Introduzca un número positivo.");
            } else {
                System.out.println("Introduzca una posición para guardar el número entre 0 y 9");
                posicion = new Scanner(System.in).nextInt();
                if (posicion < 0 || posicion > 9 || lista[posicion] != -1) {
                    System.out.println("La posición no está en el rango indicado o ya está usada.");
                } else {
                    lista[posicion] = numero;
                    contador +=1;
                }
            }
        }
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i]+" ");
        }
    }
}
