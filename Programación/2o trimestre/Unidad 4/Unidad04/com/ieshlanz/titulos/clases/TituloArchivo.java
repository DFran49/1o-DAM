package com.ieshlanz.titulos.clases;

public class TituloArchivo implements Titulo{
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private String dni;
    private String nombre;
    private String estudios;
    private  Estado estado;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    TituloArchivo (String d, String n, String e, Estado s) {
        this.dni = d;
        this.nombre = n;
        this.estudios = e;
        this.estado = s;
    }
    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public String toString() {
        return this.dni+";"+this.nombre+";"+this.estudios+";"+this.estado.ordinal();
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS IMPLEMENTADOS
    @Override
    public String getDNI() {
        return this.dni;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getEstudios() {
        return this.estudios;
    }

    @Override
    public Estado getEstado() {
        return this.estado;
    }

    @Override
    public void setEstado(Estado e) {
        this.estado = e;
    }
}
