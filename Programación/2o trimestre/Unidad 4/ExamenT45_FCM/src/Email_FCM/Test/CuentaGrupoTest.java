package Email_FCM.Test;

import Email_FCM.CuentaGrupo;
import Email_FCM.CuentaPersonal;
import Email_FCM.Formato;
import Email_FCM.Mensaje;
import org.junit.Test;

import static org.junit.Assert.*;

public class CuentaGrupoTest {
    @Test
    public void test1() {
        CuentaPersonal uno = new CuentaPersonal("uno@gmail.com");
        CuentaPersonal dos = new CuentaPersonal("dos@gmail.com");
        CuentaPersonal tres = new CuentaPersonal("tres@gmail.com");
        CuentaPersonal profe = new CuentaPersonal("profe@gmail.com");

        CuentaGrupo examenFCM = new CuentaGrupo("ExamenFCM");
        examenFCM.add(uno);
        examenFCM.add(dos);
        examenFCM.add(tres);
        assertEquals("uno@gmail.com",examenFCM.getMiembros().get(0).getDireccionCorreo());
        assertEquals("dos@gmail.com",examenFCM.getMiembros().get(1).getDireccionCorreo());
        assertEquals("tres@gmail.com",examenFCM.getMiembros().get(2).getDireccionCorreo());

        for (int i = 0; i < examenFCM.getMiembros().size() ; i++) {
            profe.enviarMensaje(examenFCM.getMiembros().get(i),"Hora de entregar", Formato.TEXTO);
        }
        assertEquals(1,examenFCM.getMiembros().get(0).getMensajes().size());
        assertEquals(1,examenFCM.getMiembros().get(1).getMensajes().size());
        assertEquals(1,examenFCM.getMiembros().get(2).getMensajes().size());
        assertEquals(examenFCM.getMiembros().get(0).getMensajes().get(0),examenFCM.getMiembros().get(1).getMensajes().get(0));
        assertEquals(examenFCM.getMiembros().get(2).getMensajes().get(0),examenFCM.getMiembros().get(1).getMensajes().get(0));
        assertEquals(examenFCM.getMiembros().get(0).getMensajes().get(0), new Mensaje("profe@gmail.com","Hora de entregar",false,Formato.TEXTO));
    }
}