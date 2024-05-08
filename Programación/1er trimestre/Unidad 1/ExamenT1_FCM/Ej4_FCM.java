import java.util.Scanner;

public class Ej4_FCM {
    /*
    La siguiente imagen muestra el índice de un libro que tiene 60 páginas
    Realiza un programa que pregunte al usuario el número de un capítulo. En caso de que
    el número de capítulo introducido por el usuario no sea correcto, el programa deberá
    informar de ello y finalizar. En caso contrario, el programa mostrará el número de
    páginas que tiene ese capítulo, y si el capítulo es corto (menos de 5 páginas), medio
    (entre 5 y 10 páginas) o largo (más de 10 páginas).
     */

    public static void main(String[] args) {
        //La siguiente línea es un array con las páginas de cada capítulo (la primera posición está vacía por comodidad)
        int[] PaginasCap = {0,8,4,2,13,10,14,9};

        //El siguiente bloque pide el capítulo
        System.out.println("Introduzca el capítulo que desee entre el 1 y el 7");
        int CapElegido = new Scanner(System.in).nextInt();

        //Este if comprueba si el capítulo introducido es válido
        if ( CapElegido >= 1 && CapElegido <= 7) {
            //Si es válido indica las páginas que tiene
            System.out.println("El capítulo "+CapElegido+" tiene "+PaginasCap[CapElegido]+" páginas");

            //Y esta secuencia de if comprueba la longitud del capítulo y la muestra
            if (PaginasCap[CapElegido] < 5) {
                System.out.println("El capítulo es corto");
            } else if (PaginasCap[CapElegido] > 10) {
                System.out.println("El capítulo es largo");
            }  else {
                System.out.println("El capítulo es medio");
            }
        } else {
            //Si el capítulo no es válido, se indica que se vuelva a intentar
            System.out.println("El capítulo elegido no exíste, intente de nuevo eligiendo un capítulo apropiado");
        }
    }
}
