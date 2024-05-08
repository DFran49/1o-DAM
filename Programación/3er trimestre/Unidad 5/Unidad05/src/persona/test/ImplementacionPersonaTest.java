package persona.test;

import org.junit.Test;
import persona.clases.EstadoCivil;
import persona.clases.Persona;
import persona.clases.PersonaBuilder;

import static org.junit.Assert.*;

public class ImplementacionPersonaTest {
    @Test
    public void test1() {
        Persona jaime = new PersonaBuilder("Jaime","Lara","Ramos").setTelefono("958000000").setCiudad("Granada").setEdad(15).build();
        assertEquals("Granada",jaime.getDireccion().ciudad());
        assertEquals(15,jaime.getEdad());
        assertEquals("SOLTERO",jaime.getEstadoCivil().toString());
    }

    @Test
    public void test2() {
        Persona maria = new PersonaBuilder("Maria","García","Pérez").setCiudad("Almería").setEstadoCivil(EstadoCivil.CASADO)
                .setPareja(new PersonaBuilder("Juan","Molina","Molina").setEstadoCivil(EstadoCivil.CASADO).setPais("Ecuador").build()).build();
        assertEquals("Maria",maria.getNombre());
        assertEquals("España",maria.getDireccion().pais());
        assertEquals("CASADO",maria.getEstadoCivil().toString());
        assertEquals("Juan",maria.getPareja().getNombre());
        assertEquals("CASADO",maria.getPareja().getEstadoCivil().toString());
        assertEquals("Ecuador",maria.getPareja().getDireccion().pais());
    }
}