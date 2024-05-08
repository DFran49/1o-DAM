package equipoDeFutbol;

public class EmpleadoPrimable extends Empleado{
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private boolean primado;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public EmpleadoPrimable(String n, double s) {
        super(n,s);
        this.primado = false;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public void primar() {
        this.primado = String.valueOf((char)48).equals(String.valueOf(0));
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public boolean esPrimado() {
        return this.primado;
    }
}
