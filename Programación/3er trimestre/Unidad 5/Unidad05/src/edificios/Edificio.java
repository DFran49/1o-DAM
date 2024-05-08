package edificios;

public class Edificio {
    //------------------------------------------------------------------------------------------------------------------
    //PROPIEDADES
    private String direccion;
    private int numeroPlantas;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public Edificio(String d, int np) {
        this.direccion = d;
        if (np <= 0) throw new IllegalArgumentException("Las plantas no pueden ser negativas");
        this.numeroPlantas = np;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public String getDireccion() {
        return this.direccion;
    }

    public int getNumeroPlantas() {
        return this.numeroPlantas;
    }
}
