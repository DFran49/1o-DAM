package INSTITUTO_FCM;

import java.util.List;

public record TutorLegal(String nombre, List<Alumno> hijos) implements Notificable {
    //------------------------------------------------------------------------------------------------------------------
    //METODOS IMPLEMENTADOS
    @Override
    public void recibirCalificacion(Profesor p, Alumno a, Nota nota) {
        if (hijos.contains(a)) {
            if (nota.getValoracion().esAprobado()) {
                System.out.println("Bien hecho " + a.nombre() + " has sacado un " + nota.valorNumerico() + " en " + p.getAsignatura());
            } else {
                System.out.println("A ver, " + a.nombre() + " has suspendido " + p.getAsignatura() + ", tienes que estudiar más");
            }
        }
    }
}
