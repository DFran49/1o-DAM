package INSTITUTO_FCM;

import java.util.ArrayList;
import java.util.List;

public class DirectorInstituto extends EmpleadoInstituto {
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private List<Double> notasInstituto;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public  DirectorInstituto(String nombre, String instituto) {
        super(nombre,instituto);
        this.notasInstituto = new ArrayList<>();
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public double getNotaMedia() {
        if (notasInstituto.isEmpty()) {
            throw new IllegalArgumentException("No hay notas en el instituto " + this.getInstituto() + ".");
        }
        double contNotas = 0;
        for (double nota : notasInstituto) {
            contNotas += nota;
        }
        return contNotas / notasInstituto.size();
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS HEREDADOS
    @Override
    public void recibirCalificacion(Profesor p, Alumno a, Nota nota) {
        this.notasInstituto.add(nota.valorNumerico());
    }
}
