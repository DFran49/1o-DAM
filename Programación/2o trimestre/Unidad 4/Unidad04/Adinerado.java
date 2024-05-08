public interface Adinerado {
    //PROPIEDADES
    static int TRANSFERENCIA_MINIMA = 1526;

    //METODOS ABSTRACTOS
    double getDineroTotal();
    boolean añadirDinero(int cantidad);
    boolean retirarDinero(int cantidad);

    //METODOS DEFAULT
    default boolean tieneDinero() {
        return getDineroTotal() > 0;
    }

    default boolean transferirHacia(Adinerado receptor, double cantidad) {
        if (cantidad >= TRANSFERENCIA_MINIMA && cantidad <= getDineroTotal()) {
            if (retirarDinero((int) cantidad)) {
                receptor.añadirDinero((int) cantidad);
                return true;
            }
        }
        return false;
    }

    default boolean transferirDesde(Adinerado emisor, double cantidad) {
        if (cantidad >= TRANSFERENCIA_MINIMA && emisor.getDineroTotal() >= cantidad) {
            if (emisor.retirarDinero((int) cantidad)) {
                añadirDinero((int) cantidad);
                return true;
            }
        }
        return false;
    }

    static boolean transferir(Adinerado emisor, Adinerado receptor, double cantidad) {
        if (cantidad >= TRANSFERENCIA_MINIMA && emisor.getDineroTotal() >= cantidad) {
            if (emisor.retirarDinero((int) cantidad)) {
                receptor.añadirDinero((int) cantidad);
                return true;
            }
        }
        return false;
    }
}
