package edificios;

public class Rascacielos extends Edificio {
    //------------------------------------------------------------------------------------------------------------------
    //PROPIEDADES
    private int altura;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public Rascacielos(String d, int dp) {
        super(d,dp);
        this.altura = 10 + (3 * this.getNumeroPlantas());
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public int getAltura() {
        return this.altura;
    }
}
