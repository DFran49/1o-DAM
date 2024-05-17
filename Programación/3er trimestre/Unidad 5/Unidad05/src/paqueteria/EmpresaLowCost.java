package paqueteria;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EmpresaLowCost implements EmpresaPaqueteria{
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private Transportista[] transportistas;
    private int siguienteTransportista;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public EmpresaLowCost(int n) {
        this.transportistas = new Transportista[n];
        for (int i = 0; i < n ; i++) {
            this.transportistas[i] = new Transportista(new Random().nextInt(40,81));
        }
        this.siguienteTransportista = 0;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS IMPLEMENTADOS
    @Override
    public void registrarPedido(Paquete p) {
        if (this.siguienteTransportista == this.transportistas.length) {
            this.siguienteTransportista = 0;
        }
        this.transportistas[this.siguienteTransportista].subirCamion(p);
    }

    @Override
    public List<Transportista> getTransportistas() {
        return Arrays.stream(this.transportistas).toList();
    }
}
