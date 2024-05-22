package INSTITUTO_FCM;

public abstract class EmpleadoInsrituto implements Notificable {
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private String nombre;
    private String instituto;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public EmpleadoInsrituto(String n, String i) {
        this.nombre = n;
        this.instituto = i;
    }

    //------------------------------------------------------------------------------------------------------------------
    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getInstituto() {
        return instituto;
    }
}
