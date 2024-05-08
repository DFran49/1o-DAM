package TiempoFCM;

public class DiaFCM {
    //ATRIBUTOS//
    private int temperatura;
    private static int maxima = Integer.MIN_VALUE;
    private static int minima = Integer.MAX_VALUE;

    //CONSTRUCTORES//
    public DiaFCM(int n) {
        this.setTemperaturaFCM(n);
    }

    //GETTERS//
    public int getTemperaturaFCM() {
        return this.temperatura;
    }

    public int getMaximaFCM() {
        return DiaFCM.maxima;
    }

    public int getMinimaFCM() {
        return DiaFCM.minima;
    }

    //METODOS//
    public void setTemperaturaFCM(int n) {
        this.temperatura = n;
        if (n > DiaFCM.maxima) {
            DiaFCM.maxima = n;
        } else if (n < DiaFCM.minima) {
            DiaFCM.minima = n;
        }
    }
}
