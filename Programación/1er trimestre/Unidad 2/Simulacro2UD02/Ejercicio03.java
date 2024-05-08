import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {
        System.out.println("Introduzca una hora en formato <Horas:Minutos>");
        String Hora = new Scanner(System.in).nextLine();
        ZonedDateTime California;
        try {
            California = ZonedDateTime.of(LocalDate.now(),LocalTime.parse(Hora), ZoneId.of("America/Los_Angeles"));
            DateTimeFormatter FormatoHora = DateTimeFormatter.ofPattern("h:mm a");
            System.out.println(FormatoHora.format(California));
        } catch (Error p) {
            System.out.println("Ha habido un error al introducir la hora, intentalo de nuevo poniendo 0 antes de la hora y/o los minutos de una cifra");
            System.out.println(p);
        }
    }
}
