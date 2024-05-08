import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ejercicio44 {
    public static void main(String[] args) {
        LocalDate Fecha = LocalDate.now();
        DateTimeFormatter PatronBarras = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter PatronGuiones = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(Fecha.format(PatronBarras));
        System.out.println(Fecha.format(PatronGuiones));
    }
}
