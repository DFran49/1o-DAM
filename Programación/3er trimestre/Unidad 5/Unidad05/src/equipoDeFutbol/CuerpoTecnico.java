package equipoDeFutbol;

public class CuerpoTecnico extends Empleado {
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private  String puesto;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTORES
    public CuerpoTecnico(String n, double s, String p) {
        super(n, s);
        this.puesto = p;
    }

    //------------------------------------------------------------------------------------------------------------------
    //GETTERS
    public String getPuesto() {
        return this.puesto;
    }
}
