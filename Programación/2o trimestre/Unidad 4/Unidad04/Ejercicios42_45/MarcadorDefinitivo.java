package Ejercicios42_45;

public class MarcadorDefinitivo implements MarcadorBaloncesto{
    //PROPIEDADES
    private Equipo local;
    private Equipo visitante;

    //CONSTRUCTOR
    public MarcadorDefinitivo(String local, String visitante) {
        this.local = new Equipo(local);
        this.visitante = new Equipo(visitante);
    }

    //GETTERS
    public String getNombreEquipo(TipoEquipo e) {
        if (TipoEquipo.LOCAL.equals(e)) {
            return this.local.nombre();
        } else {
            return this.visitante.nombre();
        }
    }

    public int getPuntos(TipoEquipo e) {
        if (TipoEquipo.LOCAL.equals(e)) {
            return this.local.puntos();
        } else {
            return this.visitante.puntos();
        }
    }

    //METODOS
    @Override
    public void añadirCanasta(TipoEquipo e, TipoCanasta t) {
        if (TipoEquipo.LOCAL.equals(e)) {
            this.local = local.añadirCanasta(t);
        } else {
            this.visitante = visitante.añadirCanasta(t);
        }
    }
}
