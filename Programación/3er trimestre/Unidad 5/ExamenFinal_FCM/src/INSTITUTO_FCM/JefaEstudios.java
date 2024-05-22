package INSTITUTO_FCM;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class JefaEstudios extends EmpleadoInstituto {
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private Map<String,Integer> notasAsignaturas;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public JefaEstudios(String nombre, String instututo) {
        super(nombre, instututo);
        this.notasAsignaturas = new HashMap<>();
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public int getNumeroSuspensos(String asignatura) {
        if (!notasAsignaturas.containsKey(asignatura)) {
            throw new IllegalArgumentException("La asignatura " + asignatura + " no se da en nuestro centro.");
        }
        return notasAsignaturas.get(asignatura);
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS HEREDADOS
    @Override
    public void recibirCalificacion(Profesor p, Alumno a, Nota nota) {
        if (nota.getValoracion().esSuspenso()) {
            if (!this.notasAsignaturas.containsKey(p.getAsignatura())) {
                this.notasAsignaturas.put(p.getAsignatura(),0);
            }
            this.notasAsignaturas.replace(p.getAsignatura(), this.notasAsignaturas.get(p.getAsignatura())+1);
        }

        try {
            FileWriter escribir = new FileWriter("notasFCM.txt", true);
            escribir.append("Asignatura: " + p.getAsignatura() + " - Nota: " + nota.getValoracion() + "\n");
            escribir.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
