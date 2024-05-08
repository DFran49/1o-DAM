import Persona.*;

import java.time.LocalDate;

public class Ejercicio14 {
    public static void main(String[] args) {
        Persona Antonio = new Persona("Antonio",new DNI("44444444M"),1000, LocalDate.now());
        Persona Juan = new Persona("Juan",new DNI("44444444M"),2000, LocalDate.now());
        /*Oficina vacia = new Oficina("Vacia");
        vacia.añadirEmpleado(Antonio);
        vacia.añadirEmpleado(Juan);
        System.out.println(vacia.trabaja(Antonio));
        System.out.println(vacia.trabaja(Juan));
        vacia.pagarEmpleados();
        vacia.mostrarInformeEmpleados();*/
    }
}
