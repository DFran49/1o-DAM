package INSTITUTO_FCM;

public record Nota(double valorNumerico) {
    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public Valoracion getValoracion() {
        if (valorNumerico < 0 || valorNumerico > 10) {
            throw new IllegalArgumentException("La nota no es válida.");
        }
        if (valorNumerico < 3) {
            return Valoracion.MUY_DEFICIENTE;
        } else if (valorNumerico < 5) {
            return Valoracion.INSUFICIENTE;
        } else if (valorNumerico < 6) {
            return Valoracion.SUFICIENTE;
        } else if (valorNumerico < 7) {
            return Valoracion.BIEN;
        } else if (valorNumerico < 9) {
            return Valoracion.NOTABLE;
        } else {
            return Valoracion.SOBRESALIENTE;
        }
    }
}
