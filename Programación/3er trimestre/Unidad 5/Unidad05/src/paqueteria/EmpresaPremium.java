package paqueteria;

import java.util.ArrayList;
import java.util.List;

public class EmpresaPremium implements EmpresaPaqueteria{
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private Transportista rapido;
    private Transportista medio;
    private Transportista lento;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public EmpresaPremium() {
        this.rapido = new Transportista(100);
        this.medio = new Transportista(250);
        this.lento = new Transportista(500);
    }

    @Override
    public void registrarPedido(Paquete p) {
        switch (p.getPrioridad()) {
            case 1 -> this.rapido.subirCamion(p);
            case 2 -> this.medio.subirCamion(p);
            case 3 -> this.lento.subirCamion(p);
            default -> throw new IllegalArgumentException("Prioridad no disponible");
        }
    }

    @Override
    public List<Transportista> getTransportistas() {
        List<Transportista> transportistas = new ArrayList<>();
        transportistas.add(rapido);
        transportistas.add(medio);
        transportistas.add(lento);
        return transportistas;
    }

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
}
