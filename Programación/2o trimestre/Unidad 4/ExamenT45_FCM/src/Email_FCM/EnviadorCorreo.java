package Email_FCM;

public interface EnviadorCorreo {
    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    String getDireccionCorreo();

    //------------------------------------------------------------------------------------------------------------------
    //METODOS DEFAULT
    default void enviarMensaje(ReceptorCorreo destinatario, String textoMensaje, Formato tipo) {
        destinatario.recibirMensaje(new Mensaje(getDireccionCorreo(),textoMensaje,false,tipo));
    }

    default String getNombre() {
        return this.getDireccionCorreo().substring(0,getDireccionCorreo().indexOf("@"));
    }

    default String getDominio() {
        return this.getDireccionCorreo().substring(getDireccionCorreo().indexOf("@")+1,
                                                    getDireccionCorreo().indexOf("."));
    }
}
