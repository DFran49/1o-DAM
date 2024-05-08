package Ejercicios42_45;

public record Equipo(String nombre, int puntos) {
    public Equipo {
        if (puntos < 0) {
            throw new IllegalArgumentException("Los puntos no pueden ser negativos");
        }
    }

    public Equipo(String nombre) {
        this(nombre,0);
    }

    public Equipo añadirCanasta(TipoCanasta t) {
        return new Equipo(nombre,puntos+t.getValor());
    }
}
