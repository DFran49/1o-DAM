import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Ejercicio46 {
    public static void main(String[] args) {
        Random Aleatorio = new Random();
        int segundos = Aleatorio.nextInt(11);
        System.out.println(segundos);
        segundos = segundos*1000;
        Instant Momento1 = Instant.now();
        try {
            Thread.sleep(segundos);
        } catch (InterruptedException p) {
            System.out.println("Excepción al parar");
        }
        Instant Momento2 = Instant.now();
        Duration Tiempo = Duration.between(Momento1,Momento2);
        System.out.println(Tiempo.getSeconds());
    }
}
