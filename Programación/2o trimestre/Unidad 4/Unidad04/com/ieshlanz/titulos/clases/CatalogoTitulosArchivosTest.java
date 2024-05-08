package com.ieshlanz.titulos.clases;

import org.junit.Test;

import static org.junit.Assert.*;

public class CatalogoTitulosArchivosTest {
    @Test
    public void test1(){
        CatalogoTitulosArchivos c = new CatalogoTitulosArchivos("test1.txt");
        Titulo t = c.extraerTitulo("12345678M;Pepe López;Explotación de Sistemas Informáticos;1");
        assertEquals("12345678M",t.getDNI());
        assertEquals("Pepe López",t.getNombre());
        assertEquals("Explotación de Sistemas Informáticos",t.getEstudios());
        assertEquals(1,t.getEstado().ordinal());
    }
    @Test
    public void test2(){
        CatalogoTitulosArchivos c = new CatalogoTitulosArchivos("archivo1.txt");
        assertTrue(c.añadirTitulo("11111111H","Luis López","Carrocería",Estado.RECOGIDO));
        assertTrue(c.añadirTitulo("22222222W","María López","Desarrollo de aplicaciones web",Estado.SIN_RECIBIR));
        assertTrue(c.añadirTitulo("33333333M","John López","Electricidad",Estado.RECIBIDO));
        assertTrue(c.guardar());
    }
    @Test
    public void test3(){
        CatalogoTitulosArchivos c = new CatalogoTitulosArchivos("archivo1.txt");
        assertEquals(3,c.getTitulos().size());
        assertEquals("11111111H",c.getTitulos().get(0).getDNI());
        //habría que completarlo
        //hacer la segunda forma también de la sugerencia
        assertEquals("RECOGIDO", c.getTitulos().get(0).getEstado().name());
    }

}