import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

public class Ejercicio43 {
    public static void main(String[] args) {
        NumberFormat Formato = NumberFormat.getInstance();
        Number Numero = 4 * Math.atan(1);
        String Formateado = "";
        Formato.setMaximumFractionDigits(4);
        String Num = Formato.format(4 * Math.atan(1));
        System.out.println(Num);
    }
}
