package persona.clases;

class ImplementacionPersona implements Persona {
    //------------------------------------------------------------------------------------------------------------------
    //PROPIEDADES
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private Direccion direccion;
    private String telefono;
    private EstadoCivil estadoCivil;
    private Persona pareja;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public ImplementacionPersona(String nombre, String apellido1, String apellido2, int edad, String calle, String ciudad, String pais, String telefono, EstadoCivil ec, Persona pareja) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        if (!comprobarEdad()) {
            throw new IllegalArgumentException("Edad incorrecta");
        }
        this.direccion = new Direccion(calle,ciudad,pais);
        this.telefono = telefono;
        this.estadoCivil = ec;
        if (!comprobarEstadoCivil()){
            throw new IllegalArgumentException("Estado civil incorrecto");
        }
        this.pareja = pareja;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    private boolean comprobarEdad() {
        if (this.edad >= 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean comprobarEstadoCivil() {
        if (this.pareja == null && this.estadoCivil.equals(EstadoCivil.CASADO)) {
            return false;
        } else if (this.pareja != null && this.estadoCivil.equals(EstadoCivil.SOLTERO)) {
            return false;
        } else {
            return true;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //GETTERS IMPLEMENTADOS
    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getApellido1() {
        return this.apellido1;
    }

    @Override
    public String getApellido2() {
        return this.apellido2;
    }

    @Override
    public int getEdad() {
        return this.edad;
    }

    @Override
    public Direccion getDireccion() {
        return this.direccion;
    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public EstadoCivil getEstadoCivil() {
        return this.estadoCivil;
    }

    @Override
    public Persona getPareja() {
        return this.pareja;
    }
}
