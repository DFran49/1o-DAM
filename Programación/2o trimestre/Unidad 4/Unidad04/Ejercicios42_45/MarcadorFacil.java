package Ejercicios42_45;

public class MarcadorFacil implements MarcadorBaloncesto{
    //PARAMETROS
    private String nombreEquipoLocal;
    private  String nombreEquipoVisitante;
    private int puntosLocal;
    private int puntosVisitante;

    //CONSTRUCTORES
    public MarcadorFacil(String local, String visitante) {
        this.nombreEquipoLocal = local;
        this.nombreEquipoVisitante = visitante;
        this.puntosLocal = 0;
        this.puntosVisitante = 0;
    }

    //GETTERS
    public String getNombreEquipo(TipoEquipo e) {
        if (TipoEquipo.LOCAL.equals(e)) {
            return this.nombreEquipoLocal;
        } else {
            return this.nombreEquipoVisitante;
        }
    }

    public int getPuntos(TipoEquipo e) {
        if (TipoEquipo.LOCAL.equals(e)) {
            return this.puntosLocal;
        } else {
            return this.puntosVisitante;
        }
    }

    //METODOS
    @Override
    public void añadirCanasta(TipoEquipo e, TipoCanasta t) {
        if (TipoEquipo.LOCAL.equals(e)) {
            this.puntosLocal += t.getValor();
        } else {
            this.puntosVisitante += t.getValor();
        }
    }
}
