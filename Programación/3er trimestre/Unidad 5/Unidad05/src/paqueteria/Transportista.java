package paqueteria;

import java.util.ArrayList;
import java.util.List;

public class Transportista {
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    protected List<Paquete> paquetes;
    protected long tiempoEntrega;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR

    public Transportista(long te) {
        this.paquetes = new ArrayList<>();
        this.tiempoEntrega = tiempoEntrega;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    void subirCamion(Paquete p) {
        this.paquetes.add(p);
    }

    void enviar() {
        for (Paquete paquete : this.paquetes) {
            try {
                Thread.sleep(this.tiempoEntrega);
                System.out.println("El paquete: " + paquete.getProducto() + " con prioridad: " +
                        paquete.getPrioridad() + " ha llegado a: " + paquete.getDireccionDestino() + ".");
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());;
            }
        }
    }
}
