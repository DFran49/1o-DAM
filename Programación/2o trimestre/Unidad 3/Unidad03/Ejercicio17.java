import bpc.daw.consola.CapaTexto;
import bpc.daw.consola.Consola;

public class Ejercicio17 {
    /*
    Usa la Consola DAW para realizar un programa que muestre 20 veces por pantalla
    la frase "En clase no se juega" cada una en renglón diferente. Las veces impares se alinearán a
    la izquierda y las pares a la derecha.
     */
    public static void main(String[] args) {
        Consola Pantalla = new Consola();
        CapaTexto Frase = Pantalla.getCapaTexto();
        int columna;
        int fila = 1;
        for (int i = 1; i <= 20; i++) {
            columna = i%2==0? 30:0;
            Frase.print(i,columna,i+"> En clase no se juega");
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
