package com.ieshlanz.titulos.clases;

public interface Titulo {
    //------------------------------------------------------------------------------------------------------------------
    //GETTERS
    String getDNI();
    String getNombre();
    String getEstudios();
    Estado getEstado();

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    void setEstado(Estado e);
}
