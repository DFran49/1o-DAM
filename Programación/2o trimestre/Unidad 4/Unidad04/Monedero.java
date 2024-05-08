public class Monedero implements Adinerado{
    //ATRIBUTOS
    private double dinero;

    //CONSTRUTORES
    public Monedero() {
        this.dinero = 0;
    }

    //METODOS
    @Override
    public double getDineroTotal() {
        return this.dinero;
    }

    @Override
    public boolean añadirDinero(int cantidad) {
        if (cantidad + this.dinero <= 1000) {
            this.dinero += cantidad;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean retirarDinero(int cantidad) {
        if (this.dinero >= cantidad) {
            this.dinero -= cantidad;
            return true;
        } else {
            return false;
        }
    }
}
