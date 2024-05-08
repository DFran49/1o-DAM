import java.time.DayOfWeek;
import java.time.LocalDate;

public class Ejercicio45 {
    public static void main(String[] args) {
        LocalDate Fecha = LocalDate.of(2100,2,28);
        DayOfWeek Dia = Fecha.getDayOfWeek();
        System.out.println(Dia.name());
    }
}
