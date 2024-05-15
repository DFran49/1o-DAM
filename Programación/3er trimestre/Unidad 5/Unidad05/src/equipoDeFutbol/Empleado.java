package equipoDeFutbol;

public class Empleado implements Nombrable{
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private String nombre;
    private double sueldo;
    private double dinero;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTORES
    public Empleado(String n, double s) {
        this.nombre = n;
        this.sueldo = s;
        this.dinero = 0;
    }

    //------------------------------------------------------------------------------------------------------------------
    //GETTERS
    public double getSueldo() {
        return this.sueldo;
    }

    public double getDinero() {
        return this.dinero;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public void cobrar(double cantidad) throws CabreoException {
        if (cantidad < getSueldo()) {
            this.dinero += cantidad;
            throw new CabreoException("Al empleado "+getNombre()+" no se le han pagado "+getSueldo()+" euros");
        }
        this.dinero += cantidad;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS IMPLEMENTADOS
    @Override
    public String getNombre() {
        return this.nombre;
    }
}
