package paqueteria;

import java.util.List;

public interface EmpresaPaqueteria {
    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    void registrarPedido(Paquete p);

    List<Transportista> getTransportistas();

    //------------------------------------------------------------------------------------------------------------------
    //METODOS DEFAULT
    default void enviarPaquetes() {
        for (Transportista transportista : getTransportistas()) {
            transportista.enviar();
        }
    }
}
