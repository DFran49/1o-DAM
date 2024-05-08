package persona.clases;

public interface Persona {
    //------------------------------------------------------------------------------------------------------------------
    //GETTERS
    String getNombre();
    String getApellido1();
    String getApellido2();
    int getEdad();
    Direccion getDireccion();
    String getTelefono();
    EstadoCivil getEstadoCivil();
    Persona getPareja();

    //------------------------------------------------------------------------------------------------------------------
    //GETTERS DEFAULT
    default String[] getApellidos() {
        return new String[] {getApellido1(), getApellido2()};
    };
}
