package Ejercicio48;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    //------------------------------------------------------------------------------------------------------------------
    //PROPIEDADES
    private String nombre;
    private String[] platos;
    private int[] precio;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTORES
    public Restaurante(String n, String[] pl, int[] pr) {
        this.nombre = n;
        this.platos = pl;
        this.precio = pr;
    }

    public Restaurante(String n) {
        this(n,new String[] {"bocadillo","filete","sopa","ensalada","caviar"}, new int[] {5,15,8,9,30});
    }

    //------------------------------------------------------------------------------------------------------------------
    //GETTERS
    public String getNombre() {
        return this.nombre;
    }

    public int getPrecio(String plato) {
        boolean existe = false;
        for (int i = 0; i < this.platos.length ; i++) {
            if (this.platos[i].equals(plato)) {
                existe = true;
            }
        }
        if (existe) {
            int ciclo = 0;
            while (!this.platos[ciclo].equals(plato) && ciclo < this.platos.length) {
                ciclo++;
            }
            return this.precio[ciclo];
        } else {
            throw new IllegalArgumentException("Ese plato no existe");
        }
    }

    public List<String> getPlatosBaratos() {
        List<String> platosBaratos = new ArrayList<>();
        for (int i = 0; i < this.precio.length ; i++) {
            if (this.precio[i] < 12) {
                platosBaratos.add(this.platos[i]);
            }
        }
        return platosBaratos;
    }

    public int getCuenta(String[] platosConsumidos) {
        int cuenta = 0;
        for (int i = 0; i < this.platos.length ; i++) {
            for (int j = 0; j < platosConsumidos.length ; j++) {
                if (platosConsumidos[j].equals(this.platos[i])) {
                    cuenta += this.precio[i];
                }
            }
        }
        return cuenta;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public boolean estaDisponible(String plato) {
        boolean cumple = false;
        for (int i = 0; i < this.platos.length && !cumple ; i++) {
            cumple = this.platos[i].equals(plato);
        }
        return cumple;
    }
}
