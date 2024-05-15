package paqueteria;

import java.util.Collection;
import java.util.Collections;

public class TransportistaOrdenado extends Transportista{
    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public TransportistaOrdenado(long te) {
        super(te);
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS OVERRIDE
    @Override
    public void enviar() {
        Collections.sort(this.paquetes);
        super.enviar();
    }
}
