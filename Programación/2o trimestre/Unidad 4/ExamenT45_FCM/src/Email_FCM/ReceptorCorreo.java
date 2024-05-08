package Email_FCM;

public interface ReceptorCorreo {
    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    String getNombre();

    void recibirMensaje(Mensaje e);
}
