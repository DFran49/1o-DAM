package Ejercicios42_45;

import org.junit.Test;

import static org.junit.Assert.*;

public class MarcadorFacilTest {
    @Test
    public void test1(){
        MarcadorFacil miMarc = new MarcadorFacil("Granada", "Estudiantes");
        for (int i = 0; i < 5; i++) {
            miMarc.añadirCanasta(TipoEquipo.LOCAL,TipoCanasta.TIRO_LIBRE);
        }
        for (int i = 0; i < 8; i++) {
            miMarc.añadirCanasta(TipoEquipo.LOCAL,TipoCanasta.CANASTA_NORMAL);
        }
        for (int i = 0; i < 4; i++) {
            miMarc.añadirCanasta(TipoEquipo.LOCAL,TipoCanasta.TRIPLE);
        }

        for (int i = 0; i < 3; i++) {
            miMarc.añadirCanasta(TipoEquipo.VISITANTE,TipoCanasta.TIRO_LIBRE);
        }
        for (int i = 0; i < 10; i++) {
            miMarc.añadirCanasta(TipoEquipo.VISITANTE,TipoCanasta.CANASTA_NORMAL);
        }
        for (int i = 0; i < 1; i++) {
            miMarc.añadirCanasta(TipoEquipo.VISITANTE,TipoCanasta.TRIPLE);
        }
        assertEquals("Granada 33 - Estudiantes 26",miMarc.getMarcador());
    }

    @Test
    public void test2() {
        MarcadorFacil miMarc = new MarcadorFacil("Granada","Estudiantes");
        for (int i = 0; i < 50; i++) {
            miMarc.añadirCanasta(TipoEquipo.LOCAL,TipoCanasta.CANASTA_NORMAL);
        }
        for (int i = 0; i < 40; i++) {
            miMarc.añadirCanasta(TipoEquipo.VISITANTE,TipoCanasta.CANASTA_NORMAL);
        }
        assertEquals("Granada 100 - Estudiantes 80",miMarc.getMarcador());
    }
}