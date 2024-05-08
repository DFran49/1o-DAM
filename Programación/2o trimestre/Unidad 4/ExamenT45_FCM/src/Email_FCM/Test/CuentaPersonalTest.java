package Email_FCM.Test;

import Email_FCM.CuentaPersonal;
import Email_FCM.Formato;
import org.junit.Test;

import static org.junit.Assert.*;

public class CuentaPersonalTest {
    @Test
    public void test1() {
        CuentaPersonal maria = new CuentaPersonal("maria@hlanz.es");
        CuentaPersonal pedro = new CuentaPersonal("pedro@hlanz.es");
        pedro.enviarMensaje(maria,"¿Como vas?", Formato.TEXTO);
        maria.enviarMensaje(pedro,"justo pero me da tiempo a todo",Formato.TEXTO);
        assertEquals(1,maria.getMensajes().size());
        assertEquals("¿Como vas?", maria.getMensajes().get(0).mensaje());
        assertEquals(1,pedro.getMensajes().size());
        assertEquals("justo pero me da tiempo a todo", pedro.getMensajes().get(0).mensaje());
    }
}