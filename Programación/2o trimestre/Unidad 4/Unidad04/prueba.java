import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class prueba {
    public static void main(String[] args) {
       /*
        MarcadorBaloncesto Granada_Estudiantes = new MarcadorBaloncesto("Granada","Estudiantes");
        for (int i = 0; i < 5 ; i++) {
            Granada_Estudiantes.añadirCanasta('L',1);
        }
        for (int i = 0; i < 8 ; i++) {
            Granada_Estudiantes.añadirCanasta('L',2);
        }
        for (int i = 0; i < 4 ; i++) {
            Granada_Estudiantes.añadirCanasta('L',3);
        }
        for (int i = 0; i < 3 ; i++) {
            Granada_Estudiantes.añadirCanasta('V',1);
        }
        for (int i = 0; i < 10 ; i++) {
            Granada_Estudiantes.añadirCanasta('V',2);
        }
        for (int i = 0; i < 1 ; i++) {
            Granada_Estudiantes.añadirCanasta('V',3);
        }
        System.out.println("Puntos Granada: "+Granada_Estudiantes.puntosLocal);
        System.out.println("Puntos Estudiantes: "+Granada_Estudiantes.puntosVisitante);
        Granada_Estudiantes.reset();
        for (int i = 0; i < 100; i++) {
            Granada_Estudiantes.añadirCanasta('L',1);
        }
        for (int i = 0; i < 80; i++) {
            Granada_Estudiantes.añadirCanasta('V',1);
        }
        System.out.println("Puntos Granada (100): "+Granada_Estudiantes.puntosLocal);
        System.out.println("Puntos Estudiantes (80): "+Granada_Estudiantes.puntosVisitante);
        Granada_Estudiantes.reset();
        System.out.println("Puntos Granada: "+Granada_Estudiantes.puntosLocal);
        System.out.println("Puntos Estudiantes: "+Granada_Estudiantes.puntosVisitante);
        for (int i = 0; i < 10 ; i++) {
            Granada_Estudiantes.añadirCanasta('L',1);
        }
        for (int i = 0; i < 12 ; i++) {
            Granada_Estudiantes.añadirCanasta('V',1);
        }
        System.out.println("Puntos Granada (10): "+Granada_Estudiantes.puntosLocal);
        System.out.println("Puntos Estudiantes (12): "+Granada_Estudiantes.puntosVisitante);
        Granada_Estudiantes.añadirCanasta('L',4);
        System.out.println("Puntos Granada (10+4): "+Granada_Estudiantes.puntosLocal);
        */

        /*Oficina prueba = new Oficina("Vacia");
        prueba.añadirEmpleado("Antonio","44444444M",2000, LocalDate.now());
        System.out.println(prueba.trabajadores.get(0).getNombre());
        System.out.println(prueba.trabajadores.get(0).getDNI());*/
        Map<String, Double> a = new HashMap<>();
        a.put("ola",7.0);
        a.put("olaa",7.0);
        a.put("olaaa",7.0);
        System.out.println(a.get("ola"));
        a.put("ola",6.0);
        System.out.println(a.get("ola"));
        List<String> b = new ArrayList<>();
        b.addAll(a.keySet());
        System.out.println(b);
    }
}
