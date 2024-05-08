import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Ejercicio19 {
    /*
    Realiza un programa que pregunte por teclado una dirección IP y un número
    entero. El programa usará la clase InetAddress para realizar la cantidad de pings indicada a la
    dirección IP, midiendo el tiempo empleado en hacer cada uno (clases Instant y Duration), y
    mostrará el resultado de esta forma:
     */
    public static void main(String[] args) {
        System.out.println("Introduzca una dirección IP:");
        String Direccion = new Scanner(System.in).nextLine();
        InetAddress IP;
        try {
            IP = InetAddress.getByName(Direccion);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("Haciendo ping a "+IP.getHostName()+" ["+Direccion+"]");
            for (int i = 0; i < 4; i++) {
                Instant antes = Instant.now();
                boolean Alcanza = IP.isReachable(1000);
                Instant despues = Instant.now();
                if (Alcanza) {
                    String Tarda = Duration.between(antes,despues).toString();
                    Tarda = Tarda.substring(2,Tarda.lastIndexOf("S"));
                    System.out.println("Respuesta desde "+Direccion+": tiempo="+Tarda+"ms");
                } else {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("No se ha encontrado el host destino");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
