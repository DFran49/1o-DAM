import java.util.Scanner;

public class Ej5_FCM {
    /*
    Realiza un programa que trabaje con horas que haga lo siguiente:
    • El programa debe preguntar por teclado dos números por separado, que
    corresponderán a las horas y minutos de una hora española. O sea, el primer número
    será el número de una hora y el segundo el número de minutos de esa hora. El
    programa verificará si la hora está entre 0 y 23 y los minutos entre 0 y 59. En caso de
    que no sea así, se informará de ello y no se hará nada más.
    • En caso de que la hora y minutos sean correctos, el programa mostrará la hora
    correspondiente en España y se expresa como un número entre 0 y 12 acompañado de
    las palabras AM (si esa hora va desde las 12 de la noche a las 12 de la mañana) o PM (si
    va desde las 12 de la mañana a las 12 de la noche.
    • Siguiendo el mismo formato muestra también la hora en california sabiendo que esta
    es 9 horas antes que en españa.
     */

    public static void main(String[] args) {
        //En este bloque se piden las horas y los minutos
        System.out.println("Introduzca la hora deseada en formato 23 horas");
        int Hora = new Scanner(System.in).nextInt();
        System.out.println("Introduzca los minutos deseados");
        int Minutos = new Scanner(System.in).nextInt();

        //En la siguiente línea se calcula cuánto es la hora de españa -9 para California
        int HoraCalifornia = Hora-9;

        //Este if comprueba si las horas introducidas son válidas
        if (Hora >=0 && Hora <=23){
            //Este if comprueba si los minutos introducidos son válidos
            if (Minutos>=0 && Minutos<=59) {
                //Este if comprueba si las horas son superiores para indicar el AM o PM
                if (Hora>12) {
                    //Para indicar el AM hay que restar 12 a las horas
                    System.out.println("En España son las "+(Hora-12)+":"+Minutos+" PM");
                } else {
                    System.out.println("En España son las "+Hora+":"+Minutos+" AM");
                }

                //Este if comprueba si al restar 9 a la hora espalñola da menos que 0
                if (HoraCalifornia<0) {
                    //Esta línea hace la fórmula para convertir el negativo a las horas necesarias
                    HoraCalifornia = 24+HoraCalifornia;

                    //Este if comprueba si las horas son superiores para indicar el AM o PM
                    if (Hora>12) {
                        //Para indicar el AM hay que restar 12 a las horas
                        System.out.println("En California son las "+(HoraCalifornia-12)+":"+Minutos+" PM");
                    } else {
                        System.out.println("En California son las "+HoraCalifornia+":"+Minutos+" AM");
                    }
                } else {
                    //Si no hay que arreglar la hora, se va directamente a la comprobación de medio día
                    if (Hora>12) {
                        System.out.println("En California son las "+(HoraCalifornia-12)+":"+Minutos+" PM");
                    } else {
                        System.out.println("En California son las "+HoraCalifornia+":"+Minutos+" AM");
                    }
                }
            } else {
                //Si los minutos no son válidos, da error
                System.out.println("No ha introducido unos minutos entre 0 y 59, inténtelo de nuevo");
            }
        } else {
            //Si las horas no son válidas, da error
            System.out.println("No ha introducido una hora entre 0 y 23, inténtelo de nuevo");
        }
    }
}
