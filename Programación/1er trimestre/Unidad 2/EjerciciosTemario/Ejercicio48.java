import bpc.daw.objetos.MarcadorMejorado;

public class Ejercicio48 {
    public static void main(String[] args) {
        MarcadorMejorado Marcador = new MarcadorMejorado("Estudiantes","CB Granada");
        Marcador.anotarCanasta(MarcadorMejorado.CANASTA_LOCAL,MarcadorMejorado.NORMAL);
        Marcador.anotarCanasta(MarcadorMejorado.CANASTA_VISITANTE,MarcadorMejorado.TRIPLE);
        Marcador.anotarCanasta(MarcadorMejorado.CANASTA_LOCAL,MarcadorMejorado.NORMAL);
        Marcador.anotarCanasta(MarcadorMejorado.CANASTA_VISITANTE,MarcadorMejorado.NORMAL);
        Marcador.anotarCanasta(MarcadorMejorado.CANASTA_VISITANTE,MarcadorMejorado.TRIPLE);
        Marcador.anotarCanasta(MarcadorMejorado.CANASTA_LOCAL,MarcadorMejorado.TIRO_LIBRE);
        Marcador.anotarCanasta(MarcadorMejorado.CANASTA_LOCAL,MarcadorMejorado.TIRO_LIBRE);
        Marcador.anotarCanasta(MarcadorMejorado.CANASTA_VISITANTE,MarcadorMejorado.NORMAL);
        System.out.println("El equipo local es "+Marcador.getNombreLocal()+" con "+Marcador.getPuntosLocal()+" puntos");
        System.out.println("El equipo visitante es "+Marcador.getNombreVisitante()+" con "+Marcador.getPuntosVisitante()+" puntos");
        System.out.println("Va ganando el equipo "+Marcador.getNombreEquipoGanador()+" y va perdiendo el equipo "+Marcador.getNombreEquipoPerdedor());
        //E ->2, CB -> 3, E->2, CB->2, CB->3, E->1, E->1, CB->2
    }
}
