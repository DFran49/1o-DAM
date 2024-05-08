package com.ieshlanz.titulos.clases;

public class CatalogoTitulosFactory {
    public static CatalogoTitulos getCatalogoTitulos(TipoCatalogo t) {
        if (t.equals(TipoCatalogo.ARCHIVO)) {
            return new CatalogoTitulosArchivos("titulos.csv");
        } else {
            throw new IllegalArgumentException("Tipo de catálogo no soportado por el programa");
        }
    }
}
