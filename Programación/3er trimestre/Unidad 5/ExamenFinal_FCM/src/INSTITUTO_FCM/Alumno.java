package INSTITUTO_FCM;

import java.util.List;

public record Alumno(String nombre, List<Nota> notas) implements Notificable {

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public double getNotaMedia() {
        if (notas.isEmpty()) {
            throw new IllegalArgumentException("El alumno " + this.nombre + " no tiene notas.");
        }
        double contNotas = 0;
        for (Nota nota : notas) {
            contNotas += nota.valorNumerico();
        }
        return contNotas / notas.size();
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS IMPLEMENTADOS
    @Override
    public void recibirCalificacion(Profesor p, Alumno a, Nota nota) {
        if (this.nombre.equals(a.nombre)) {
            this.notas.add(nota);
        }
    }
}
