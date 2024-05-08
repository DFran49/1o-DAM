package equipoDeFutbol;

public class Futbolista extends EmpleadoPrimable{
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private int dorsal;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public Futbolista(String n, double s, int d) {
        super(n,s);
        this.dorsal = d;
    }
}
