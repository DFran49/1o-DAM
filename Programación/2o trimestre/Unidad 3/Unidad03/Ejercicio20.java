import bpc.daw.consola.CapaTexto;
import bpc.daw.consola.Consola;
import bpc.daw.consola.Teclado;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ejercicio20 {
    /*
    Usa la Consola DAW y las clases de Java Time para realizar un programa que
    muestre en el centro de la pantalla la hora, minutos y segundos actuales. Durante medio
    minuto, a cada segundo la pantalla se borrará y se volverá a imprimir la hora actual, dando la
    apariencia de un reloj.
     */
    public static void main(String[] args) {
        Consola Pantalla = new Consola();
        CapaTexto Hora = Pantalla.getCapaTexto();
        for (int i = 0; i <= 30; i++) {
            DateTimeFormatter Formato = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime Ahora = LocalTime.now();
            Hora.print(12,31,Ahora.format(Formato));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error de tiempo");;
            }
            Hora.cls();
        }
    }
}
