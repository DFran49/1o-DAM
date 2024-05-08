package Ejercicio48;

import org.junit.Test;

import static org.junit.Assert.*;

public class RestauranteTest {
    @Test
    public void test1() {
        Restaurante manolosPizzas = new Restaurante("Manolo's Pizza");
        assertEquals(5,manolosPizzas.getPrecio("bocadillo"));
        assertEquals(15,manolosPizzas.getPrecio("filete"));
        assertEquals(8,manolosPizzas.getPrecio("sopa"));
        assertEquals(9,manolosPizzas.getPrecio("ensalada"));
        assertEquals(30,manolosPizzas.getPrecio("caviar"));
        assertTrue(manolosPizzas.estaDisponible("bocadillo"));
        assertTrue(manolosPizzas.estaDisponible("sopa"));
        assertTrue(manolosPizzas.estaDisponible("filete"));
        assertThrows(IllegalArgumentException.class,
                ()->{
                    manolosPizzas.getPrecio("calamares");
        });
        assertFalse(manolosPizzas.estaDisponible("Calamares"));
        assertEquals(manolosPizzas.getPlatosBaratos().get(0),"bocadillo");
        assertEquals(manolosPizzas.getPlatosBaratos().get(1),"sopa");
        assertEquals(manolosPizzas.getPlatosBaratos().get(2),"ensalada");
        assertEquals(manolosPizzas.getCuenta(new String[] {"bocadillo","filete","caviar"}),50);
    }

}