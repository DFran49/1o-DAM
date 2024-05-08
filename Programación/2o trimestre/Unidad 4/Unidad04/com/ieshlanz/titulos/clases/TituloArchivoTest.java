package com.ieshlanz.titulos.clases;

import org.junit.Test;

import static org.junit.Assert.*;

public class TituloArchivoTest {
    @Test
    public void testNombre(){
        TituloArchivo prueba=new TituloArchivo("12345678M","Pepe López","Explotación de Sistemas Informáticos", Estado.RECIBIDO);
        assertEquals("Pepe López",prueba.getNombre());
    }
    @Test
    public void testDni(){
        TituloArchivo prueba=new TituloArchivo("12345678M","Pepe López","Explotación de Sistemas Informáticos", Estado.RECIBIDO);
        assertEquals("12345678M",prueba.getDNI());
    }
    @Test
    public void testEstudios(){
        TituloArchivo prueba=new TituloArchivo("12345678M","Pepe López","Explotación de Sistemas Informáticos", Estado.RECIBIDO);
        assertEquals("Explotación de Sistemas Informáticos",prueba.getEstudios());
    }
    @Test
    public void testEstado(){
        TituloArchivo prueba=new TituloArchivo("12345678M","Pepe López","Explotación de Sistemas Informáticos", Estado.RECIBIDO);
        assertEquals(Estado.RECIBIDO,prueba.getEstado());
    }
    @Test
    public void testToString(){
        TituloArchivo prueba=new TituloArchivo("12345678M","Pepe López","Explotación de Sistemas Informáticos", Estado.RECIBIDO);
        assertEquals("12345678M;Pepe López;Explotación de Sistemas Informáticos;1",prueba.toString());
    }

}