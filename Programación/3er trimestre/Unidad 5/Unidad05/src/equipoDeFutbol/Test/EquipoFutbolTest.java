package equipoDeFutbol.Test;

import equipoDeFutbol.Empleado;
import equipoDeFutbol.Entrenador;
import equipoDeFutbol.EquipoFutbol;
import equipoDeFutbol.Futbolista;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EquipoFutbolTest {
    @Test
    public void test1() {
        EquipoFutbol granadaCF = new EquipoFutbol("Granada CF", 1000);
        Futbolista pepe = new Futbolista("Pepe",400, 67);
        pepe.primar();
        Futbolista jose = new Futbolista("Jose",380, 89);
        jose.primar();
        granadaCF.addEmpleado(new Entrenador("Iván",100));
        granadaCF.addEmpleado(new Empleado("Ana",80));
        granadaCF.addEmpleado(pepe);
        granadaCF.addEmpleado(new Futbolista("Jorge",450, 23));
        granadaCF.addEmpleado(jose);

        granadaCF.pagarSueldoEmpleados();
        List<Empleado> empleados = granadaCF.getEmpleados();

        assertEquals(empleados.get(0).getDinero(), 100, 1);
        assertEquals(empleados.get(1).getDinero(), 80, 1);
        assertEquals(empleados.get(2).getDinero(), 440, 1);
        assertEquals(empleados.get(3).getDinero(), 190, 1);
        assertEquals(empleados.get(4).getDinero(), 190, 1);
    }

}