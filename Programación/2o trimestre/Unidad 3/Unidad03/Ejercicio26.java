import java.util.*;

public class Ejercicio26 {
    /*
    Consulta la documentación del “Java Collection Framework” para hacer este
    programa:
    a) Se comenzará creando un objeto List<String> y lo rellenará con un objeto
    ArrayList<String> (se usará abstracción para ello como se vio en el tema 2).
    b) El programa mostrará este menú de opciones, que se repetirá hasta que el usuario
    pulse la opción de salir.
    1. Añadir mensaje a la lista
    2. Consultar el número de mensajes de la lista
    3. Consultar mensaje
    4. Comprobar mensaje
    5. Consultar todos los mensajes
    6. Borrar toda la lista
    7. Salir
    c) Lo que hay que hacer en cada opción es:
    1. Pide al usuario que introduzca una frase y la añadirá al List<String>
    2. Muestra en pantalla el número de elementos que hay en el List<String>
    3. Cuando se selecciona, pueden pasar dos cosas
    1. Si la lista está vacía, se mostrará “No hay mensajes” y volverá al menú.
    2. Si la lista no está vacía, el programa preguntará el número del mensaje
    que se desea consultar y el usuario deberá introducir un número entre
    0 y la última posición válida de la lista. Si se introduce un número fuera
    de ese rango, el programa avisará de ello. En caso contrario, se
    mostrará el mensaje indicado.
    4. Pedirá al usuario que escriba un mensaje y el programa mostrará si el mensaje
    está o no en la lista. En caso de que si esté, se mostrará también su número de
    posición.
    5. Mostrará todos los mensajes de la lista, cada uno en una línea con el formato
    “El mensaje de la posición … es …”
    6. Borra todos los mensajes de la lista
     */
    public static void main(String[] args) {
        List<String> Lista = new ArrayList<>();
        Lista.add("");

        boolean Sigue = true;
        String fraseBuscar;
        char Opcion;
        int frase;

        while (Sigue) {
            System.out.println(Lista);
            System.out.println("\nElija una opción:\n" +
                    "1. Añadir mensaje a la lista\n" +
                    "2. Consultar el número de mensajes de la lista\n" +
                    "3. Consultar mensaje\n" +
                    "4. Comprobar mensaje\n" +
                    "5. Consultar todos los mensajes\n" +
                    "6. Borrar toda la lista\n" +
                    "7. Salir");
            Opcion = new Scanner(System.in).nextLine().charAt(0);

            switch (Opcion) {
                case '1' -> {
                    System.out.println("Introduzca una frase");
                    Lista.add(new Scanner(System.in).nextLine());
                }
                case '2' -> {
                    System.out.println("La lista de frases tiene "+(Lista.size()-1)+" frases");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                case '3' -> {
                    if (Lista.isEmpty()) {
                        System.out.println("No hay mensajes");
                    } else {
                        System.out.println("Introduzca un número entre 1 y "+(Lista.size()-1));
                        frase = new Scanner(System.in).nextInt();
                        if (frase < 0 || frase > Lista.size()) {
                            System.out.println("La posición elegida no existe, inténtelo de nuevo");
                        } else {
                            System.out.println(Lista.get(frase));
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                case '4' -> {
                    System.out.println("Escriba una frase:");
                    fraseBuscar = new Scanner(System.in).nextLine();
                    if (Lista.contains(fraseBuscar)) {
                        System.out.println("La frase existe en la lista en la posición "+(Lista.indexOf(fraseBuscar)));
                    } else {
                        System.out.println("La frase no esxiste en la lista");
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                case '5' -> {
                    for (int i = 1; i<Lista.size();i++) {
                        System.out.println("El mensaje de la posición "+i+" es "+Lista.get(i));
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                case '6' -> {
                    System.out.println("Se borran las frases");
                    Lista.clear();
                    Lista.add("");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                case '7' -> {
                    System.out.println("Adiós");
                    Sigue = false;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> {
                    System.out.println("Elija una opción válida");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
