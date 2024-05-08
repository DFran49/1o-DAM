import java.util.Scanner;

public class Ejercicio03 {
    /*
    Realiza un programa que pregunte al usuario una palabra y cree una variable de
    tipo char llamada letraCentral inicializada con cualquier valor. A continuación, se usará el
    switch mejorado para hacer lo siguiente:
     Si la palabra tiene un número impar de letras, se guardará en letraCentral el carácter
    de su posición central.
     Si la palabra tiene un número par de letras, el programa preguntará al usuario: “hay
    dos posibles letras centrales. ¿Quieres la de la izquierda (i) o la de la derecha (d)?” Si el
    usuario elige “i” o “I”, se guardará en letraCentral la letra cuya posición pega a la
    izquierda del centro de la palabra. Si se elige “d” o “D” se guardará en letraCentral la
    letra cuya posición pega a la derecha del centro de la palabra. Ejemplos:
    o Si elegimos “ADIOS”, como hay cantidad impar de letras, guardamos en
    letraCentral la letra I
    o Si elegimos “HOLA”, hay dos posibles letras centrales, que serían la O (la que
    pega a la izquierda) y la L (la que pega a la derecha)
     */
    public static void main(String[] args) {
        System.out.println("Introduzca una palabra");
        String Palabra = new Scanner(System.in).nextLine();
        int PalabraLength = Palabra.length();
        System.out.println(PalabraLength);
        int Par;
        if (PalabraLength%2==0) {
            System.out.println("La palabra es par");
            Par = 0;
        } else {
            System.out.println("La palabra es impar");
            Par = 1;
        }

        switch (Par) {
            case 0 -> {
                char LetraI = Palabra.charAt((PalabraLength/2)-1);
                char LetraD = Palabra.charAt(PalabraLength/2);
                System.out.println("Hay 2 posibles letras, ¿Quieres la de la derecha (d) o la de la izquierda (i)");
                char Direccion = new Scanner(System.in).nextLine().charAt(0);
                switch (Direccion) {
                    case 'd','D' -> {
                        System.out.println("La letra central derecha de la palabra " + Palabra + " es: " + LetraD);
                    }
                    case 'i','I' -> {
                        System.out.println("La letra central izquierda de la palabra " + Palabra + " es: " + LetraI);
                    }
                    default -> {
                        System.out.println("Ha elegido una opción no válida, inténtelo de nuevo");
                    }
                }
            }
            case 1 -> {
                char LetCentral = Palabra.charAt(PalabraLength/2);
                System.out.println((PalabraLength/2)+1);
                System.out.println("La letra central de la palabra " + Palabra + " es: " + LetCentral);
            }
            default -> {
                System.out.println("Ha ocurrido un error inesperado, inténtelo de nuevo");
            }
        }
    }
}
