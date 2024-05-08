package com.ieshlanz.titulos.clases;

import java.util.List;
import java.util.NoSuchElementException;

public interface CatalogoTitulos {
    //------------------------------------------------------------------------------------------------------------------
    //GETTERS
    List<Titulo> getTitulos();

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    boolean guardar();
    boolean añadirTitulo(String dni, String nombre, String estudios, Estado estado);

    //------------------------------------------------------------------------------------------------------------------
    //METODOS DEFAULT
    default Titulo getTitulo(String dni) {
        List<Titulo> titulosLista = getTitulos();
        for (int i = 0; i < titulosLista.size() ; i++) {
            if (titulosLista.get(i).getDNI().equals(dni)) {
                return titulosLista.get(i);
            }
        }
        throw new NoSuchElementException("No existe título para esa persona");
    }
}
