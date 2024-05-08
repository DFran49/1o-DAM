import java.io.IOException;

public class Ejercicio21 {
    public static void main(String[] args) {
        MarcadorBaloncesto partido = new MarcadorBaloncesto("Granada","Estudiantes");
        for (int i = 0; i < 6 ; i++) {
            partido.añadirCanasta('L',2);
        }
        for (int i = 0; i < 4 ; i++) {
            partido.añadirCanasta('V',2);
        }
        try {
            partido.guardar("Granada-Estudiantes2.txt");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
