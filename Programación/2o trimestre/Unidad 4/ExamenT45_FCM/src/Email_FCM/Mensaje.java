package Email_FCM;

public record Mensaje(String remitente, String mensaje, boolean leido, Formato tipo) {
    //------------------------------------------------------------------------------------------------------------------
    //COMPROBADOR
    public Mensaje {
        if (mensaje.contains(";")) {
            throw new IllegalArgumentException("El mensaje no puede contener \";\"");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //SEGUNDO CONSTRUCTOR
    public Mensaje(String remitente, String mensaje) {
        this(remitente,mensaje,false,Formato.TEXTO);
    }

    //------------------------------------------------------------------------------------------------------------------
    //GETTER
    public String  getLineaCSV() {
        return this.remitente + ";" + this.mensaje + ";" + this.leido + ";" + this.tipo.ordinal();
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODO
    public Mensaje leer() {
        return new Mensaje(this.remitente,this.mensaje, true, this.tipo);
    }
}
