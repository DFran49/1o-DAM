package Ejercicio49;

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
        assertEquals("bocadillo",manolosPizzas.getPlatosBaratos().get(2));
        assertEquals("sopa",manolosPizzas.getPlatosBaratos().get(1));
        assertEquals("ensalada",manolosPizzas.getPlatosBaratos().get(0));
        assertEquals(50,manolosPizzas.getCuenta(new String[] {"bocadillo","filete","caviar"}));
    }

}