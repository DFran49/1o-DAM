package com.ieshlanz.titulos.clases;

import org.junit.Test;

import static org.junit.Assert.*;

public class CatalogoTitulosFactoryTest {
    @Test
    public void test1(){
        CatalogoTitulos c = CatalogoTitulosFactory.getCatalogoTitulos(TipoCatalogo.ARCHIVO);
        assertNotNull(c);
    }
    @Test(expected=java.lang.IllegalArgumentException.class)
    public void test2(){
        CatalogoTitulos c = CatalogoTitulosFactory.getCatalogoTitulos(TipoCatalogo.BD_MYSQL);
        fail("No se ha lanzado la excepción");
    }

}