public class Banco implements Adinerado{
    //ATRIBUTOS
    private double dinero;

    //CONSTRUCTORES
    public Banco() {
        this.dinero = 0;
    }

    //METODOS
    @Override
    public double getDineroTotal() {
        return this.dinero;
    }

    @Override
    public boolean añadirDinero(int cantidad) {
        this.dinero += cantidad;
        return true;
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
