package INSTITUTO_FCM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profesor {
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private String nombre;
    private String asignatura;
    List<Notificable> interesados;
    private Map<Alumno, Nota> notas;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR

    public Profesor(String nombre, String asignatura) {
        this.nombre = nombre;
        this.asignatura = asignatura;
        this.interesados = new ArrayList<>();
        this.notas = new HashMap<>();
    }

    //------------------------------------------------------------------------------------------------------------------
    //GETTERS
    public String getNombre() {
        return this.nombre;
    }

    public String getAsignatura() {
        return this.asignatura;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public void addNotificable(Notificable interesado) {
        this.interesados.add(interesado);
    }

    public void calificar(Alumno a, double n) {
        this.notas.put(a, new Nota(n));
        for (Notificable interesado : this.interesados) {
            interesado.recibirCalificacion(this, a, new Nota(n));
        }
    }
}
