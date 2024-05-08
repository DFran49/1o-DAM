import bpc.daw.objetos.MarcadorBaloncesto;

import javax.swing.text.MaskFormatter;

public class Ejercicio12 {
    /*
     En la librería ObjetosSencillos.jar se encuentra la clase MarcadorBaloncesto. Haz
    un programa en el que se cree un partido de baloncesto para el partido que van a jugar el
    Estudiantes y el CB Granada. Registra las siguientes canastas y muestra el nombre de los
    equipos, los puntos que tiene cada uno, el nombre del equipo que va ganando y el que va
    perdiendo.
     */

    public static void main(String[] args) {
        String nomLoc = "Granada";
        String nomVis = "Jaen";
        MarcadorBaloncesto Marcador = new MarcadorBaloncesto("Estudianres","CB Granada");
        Marcador.anotarCanasta('L',2);
        Marcador.anotarCanasta('V',3);
        Marcador.anotarCanasta('L',2);
        Marcador.anotarCanasta('V',2);
        Marcador.anotarCanasta('V',3);
        Marcador.anotarCanasta('L',1);
        Marcador.anotarCanasta('L',1);
        Marcador.anotarCanasta('V',2);
        System.out.println("Está jugando en el equipo local el " + Marcador.getNombreLocal() + " contra el" +
                "\n visitante " + Marcador.getNombreVisitante()+"\n");
        System.out.println(" Puntos:\n Equipo local: " + Marcador.getPuntosLocal() + "\n Equipo visitante: " + Marcador.getPuntosVisitante() + "\n");
        System.out.println(" El equipo ganador es: " + Marcador.getNombreEquipoGanador() + "\n El equipo perdedor es: " + Marcador.getNombreEquipoPerdedor());
    }
}
