import Persona.CuentaCorriente;

import java.io.IOException;
import java.time.LocalDate;

public class Ejercicio20 {
    public static void main(String[] args) {
        CuentaCorriente miCuenta = new CuentaCorriente();
        miCuenta.añadirDinero(2000);
        try {
            miCuenta.retirarDinero(6000);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
