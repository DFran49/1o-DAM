package Persona.test;

import Persona.DNI;
import org.junit.Test;

import static org.junit.Assert.*;

public class DNITest {
    @Test
    public void test1(){
        DNI miDNI = new DNI(12345678,'Z');
        assertEquals(12345678,miDNI.numero);
        assertEquals('Z',miDNI.letra);
    }

    @Test
    public void test2() {
        DNI miDNI = new DNI("12345678X");
        assertEquals(12345678,miDNI.numero);
        assertEquals('X',miDNI.letra);
    }
}