package Ejercicios42_45;

import org.junit.Test;

import static org.junit.Assert.*;

public class EquipoTest {
    @Test
    public void test1() {
        TipoCanasta[] arrTipo = TipoCanasta.values();
        Equipo HLanz = new Equipo("HLanz Basket");
        int punt = 0;
        for (TipoCanasta a: arrTipo) {
            punt += a.getValor();
            HLanz = HLanz.añadirCanasta(a);
            assertNotNull(HLanz);
            assertEquals(punt,HLanz.puntos());
        }
    }
}