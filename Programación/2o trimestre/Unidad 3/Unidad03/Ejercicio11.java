import java.util.Scanner;

public class Ejercicio11 {
    /*
    Realiza un programa que calcule de forma aproximada la raíz cuadrada de un
    número positivo N introducido desde el teclado usando el Método de Newton-Raphson, que
    consiste en lo siguiente:
     Creamos dos variables de tipo double llamadas S y A, y les damos valor inicial uno.
     Actualizamos S con la siguiente fórmula:
    𝑆 =
    1 2
    ൬𝐴 + 𝑁𝐴൰
     Si el valor absoluto de la diferencia entre S y A es menor de 0.000001 entonces ya
    hemos terminado y la raíz cuadrada aproximada es S. En caso contrario, le damos a A
    el valor de S y repetimos el proceso a partir del punto anterior.
     */
    public static void main(String[] args) {
        System.out.println("Introduzca un número positivo");
        int N = new Scanner(System.in).nextInt();
        double S = 1;
        double A = 1;
        do {
            A = S;
            S = 0.5*(A+(N/A));
        }while (Math.abs(S-A)>0.000001);
        System.out.println("La raíz cuadrada de "+N+" es "+S);
    }
}
