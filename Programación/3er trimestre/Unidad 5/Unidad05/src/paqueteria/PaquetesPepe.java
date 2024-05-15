package paqueteria;

import java.util.ArrayList;
import java.util.List;

public class PaquetesPepe implements EmpresaPaqueteria{
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private TransportistaOrdenado pepe;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public PaquetesPepe() {
        this.pepe = new TransportistaOrdenado(300);
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS IMPLEMENTADOS
    @Override
    public void registrarPedido(Paquete p) {
        this.pepe.subirCamion(p);
    }

    @Override
    public List<Transportista> getTransportistas() {
        List<Transportista> transportistas = new ArrayList<>();
        transportistas.add(pepe);
        return transportistas;
    }
}
