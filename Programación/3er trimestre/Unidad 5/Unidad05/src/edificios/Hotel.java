package edificios;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Hotel extends Edificio {
    //------------------------------------------------------------------------------------------------------------------
    //PROPIEDADES
    private List<String> clientes;
    private int maximo;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public Hotel(String d, int np, int m) {
        super(d, np);
        this.clientes = new ArrayList<>();
        if (m <= 0) throw new IllegalArgumentException("El número de plantas debe ser mayor a 0");
        this.maximo = m;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public void añadirCliente(String c) {
        if (this.clientes.size() == this.maximo) throw new IllegalStateException("No se pueden añadir más clientes");
        this.clientes.add(c);

    }

    public void retirarCliente(String c) {
        if (!this.clientes.contains(c)) throw new NoSuchElementException("No quedan clientes que retirar");
        this.clientes.remove(c);
    }
}
