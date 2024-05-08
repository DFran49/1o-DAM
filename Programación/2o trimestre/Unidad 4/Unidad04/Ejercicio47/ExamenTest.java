package Ejercicio47;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ExamenTest {
    @Test
    public void test1() {
        Examen miExam = new Examen();
        miExam.añadirNota("Antonio",6.0);
        assertEquals(6.0,miExam.getNota("Antonio"),1);
    }

    @Test
    public void test2() {
        Examen miExam = new Examen();
        miExam.añadirNota("Alicia",10);
        miExam.añadirNota("Alejandro",0);
        miExam.añadirNota("Juan Antonio", 5);
        assertEquals(5,miExam.getNotaMedia(),0.1);
        assertTrue(miExam.mediaAprovado());
    }

    @Test
    public void test3() {
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Examen miExam = new Examen();
                    miExam.añadirNota("Antonio", -20);
                });
    }

    @Test
    public void test4() {
        Examen miExam = new Examen();
        miExam.añadirNota("Armando", 3);
        miExam.añadirNota("Matias",4.9);
        miExam.añadirNota("Rigoberto",2);
        assertFalse(miExam.mediaAprovado());
    }

    @Test
    public void test5() {
        Examen miExam = new Examen();
        miExam.añadirNota("Juan Antonio", 6);
        miExam.añadirNota("Jose Antonio",4);
        miExam.añadirNota("Oscar",7);
        List<String> alumnos = new ArrayList<>();
        alumnos.add("Juan Antonio");
        alumnos.add("Oscar");
        assertEquals(alumnos,miExam.getAprobados());
    }

    @Test
    public void test6() {
        assertThrows(IllegalStateException.class,
                ()->{
                    Examen miExamen = new Examen();
                    miExamen.getNotaMedia();
                });
    }
}