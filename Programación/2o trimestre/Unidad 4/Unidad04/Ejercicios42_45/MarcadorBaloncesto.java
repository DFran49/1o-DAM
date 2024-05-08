package Ejercicios42_45;

public interface MarcadorBaloncesto {
    //METODOS ABSTRACTOS
    void añadirCanasta(TipoEquipo e, TipoCanasta t);
    String getNombreEquipo(TipoEquipo e);
    int getPuntos(TipoEquipo e);

    //METODOS DEFAULT
    default String getMarcador() {
        return getNombreEquipo(TipoEquipo.LOCAL)+" "+getPuntos(TipoEquipo.LOCAL)+" - "
                + getNombreEquipo(TipoEquipo.VISITANTE)+" "+getPuntos(TipoEquipo.VISITANTE);
    }
}
