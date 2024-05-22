package INSTITUTO_FCM;

public enum Valoracion {
    MUY_DEFICIENTE, INSUFICIENTE, SUFICIENTE, BIEN, NOTABLE, SOBRESALIENTE;


    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public boolean esAprobado() {
        return (ordinal() >= 2 && ordinal() <= 5);
    }

    public boolean esSuspenso() {
        return ordinal() <= 1;
    }
}
