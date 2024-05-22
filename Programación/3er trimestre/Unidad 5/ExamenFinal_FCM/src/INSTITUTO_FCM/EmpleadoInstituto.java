package INSTITUTO_FCM;

public abstract class EmpleadoInstituto implements Notificable {
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private String nombre;
    private String instituto;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public EmpleadoInstituto(String n, String i) {
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
