public class Altavoz {
    //ATRIBUTOS//
    public static final int VOL_MAX = 255;
    public static final int VOL_MIN = 0;
    private int volumen;

    //CONSTRUCTORES//
    public Altavoz() {
        this.volumen = VOL_MIN;
    }

    //GETTERS//
    public int getVolumen() {
        return this.volumen;
    }

    //METODOS//
    public void ponerVolumenMaximo() {
        this.volumen = VOL_MAX;
    }
    public void setVolumen(int v) throws IllegalArgumentException {
        if (v < VOL_MIN || v > VOL_MAX) {
            throw new IllegalArgumentException("El volumen debe estar entre "+VOL_MIN+" y "+VOL_MAX);
        } else {
            this.volumen = v;
        }
    }
    public String toString() {
        String volum = "["+this.volumen+"] ";
        double porcentaje = Math.round((this.volumen * 100) / VOL_MAX);
        porcentaje /= 10;
        int contador = 0;
        for (int i = 0; i < porcentaje ; i++) {
            volum += "*";
            contador ++;
        }
        for (int i = contador; i < 10 ; i++) {
            volum += "_";
        }
        return volum;
    }
}
