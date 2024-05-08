package Email_FCM.Test;

import Email_FCM.Mensaje;
import org.junit.Test;

import static org.junit.Assert.*;

public class MensajeTest {
    @Test
    public void test1() {
        Mensaje alberto = new Mensaje("alberto@ieshlanz.es","Esto es una prueba");
        assertEquals("alberto@ieshlanz.es;Esto es una prueba;false;0",alberto.getLineaCSV());
        Mensaje nuevoAlberto = alberto.leer();
        assertTrue(nuevoAlberto.leido());
        assertEquals("alberto@ieshlanz.es;Esto es una prueba;true;0",nuevoAlberto.getLineaCSV());
    }
}