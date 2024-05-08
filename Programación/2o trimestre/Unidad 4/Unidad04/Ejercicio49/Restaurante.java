package Ejercicio49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurante {
    //------------------------------------------------------------------------------------------------------------------
    //PROPIEDADES
    private String nombre;
    private Map<String, Integer> platos;


    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTORES
    public Restaurante(String n, String[] pl, int[] pr) {
        this.nombre = n;
        this.platos = new HashMap<>();
        for (int i = 0; i < pl.length ; i++) {
            this.platos.put(pl[i],pr[i]);
        }
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
        if (this.platos.containsKey(plato)) {
            return this.platos.get(plato);
        } else {
            throw new IllegalArgumentException("Ese plato no existe");
        }
    }

    public List<String> getPlatosBaratos() {
        List<String> platosBaratos = new ArrayList<>();
        for (String a : this.platos.keySet()) {
            if (this.platos.get(a) < 12) {
                platosBaratos.add(a);
            }
        }
        return platosBaratos;
    }

    public int getCuenta(String[] platosConsumidos) {
        int cuenta = 0;
        for (int j = 0; j < platosConsumidos.length ; j++) {
            cuenta += this.platos.get(platosConsumidos[j]);
        }
        return cuenta;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public boolean estaDisponible(String plato) {
        return this.platos.containsKey(plato);
    }
}
