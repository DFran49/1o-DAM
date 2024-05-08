package Persona;

import java.time.LocalDate;

public class prueba {
    public static void main(String[] args) {
        /*
        DNI pepeDNI = new DNI("12345678B");
        Persona Pepe = new Persona("Pepe",pepeDNI,1500, LocalDate.of(2007,3,8));
        System.out.println(Pepe.nombre);
        System.out.println(Pepe.dni.numero);
        System.out.println(Pepe.dni.letra);
        System.out.println(Pepe.sueldo);
        System.out.println(Pepe.fechaNacimiento);
        Pepe = new Persona("Pepe",12345678,'B',1500, LocalDate.of(2007,3,8));
        System.out.println(Pepe.nombre);
        System.out.println(Pepe.dni);
        System.out.println(Pepe.sueldo);
        System.out.println(Pepe.fechaNacimiento);

        DNI antonioDNI = new DNI("88776655X");
        Persona Antonio = new Persona("Antonio",antonioDNI);
        System.out.println(Antonio.nombre);
        System.out.println(Antonio.dni.numero);
        System.out.println(Antonio.dni.letra);
        System.out.println(Antonio.sueldo);
        System.out.println(Antonio.fechaNacimiento);
        Antonio = new Persona("Antonio",antonioDNI);
        System.out.println(Antonio.nombre);
        System.out.println(Antonio.dni.numero);
        System.out.println(Antonio.dni.letra);
        System.out.println(Antonio.sueldo);
        System.out.println(Antonio.fechaNacimiento);
        */

        /*
        CuentaCorriente cuenta = new CuentaCorriente(1253,850);
        System.out.println(cuenta.numero);
        System.out.println(cuenta.saldo);
        cuenta.añadirDinero(100);
        System.out.println(cuenta.saldo);
        cuenta.retirarDinero(200);
        System.out.println(cuenta.saldo);
        cuenta.retirarDinero(1000);
        System.out.println(cuenta.saldo);
        */

        /*
        Persona juan = new Persona("Juan",new DNI("11111111H"),1500,LocalDate.now());
        System.out.println(juan.cuenta.saldo);
        for (int i = 0; i < 3 ; i++) {
            juan.cobrarSueldo();
        }
        System.out.println(juan.cuenta.saldo);
        juan.aumentarSueldo(25);
        juan.cobrarSueldo();
        System.out.println(juan.cuenta.saldo);
        */

        Persona menor = new Persona("Manolo",new DNI("111111111N"),1000,LocalDate.of(2009,03,06));
        System.out.println(menor.esMayorEdad());
        Persona mayor = new Persona("Juan",new DNI("121111111Z"),1000,LocalDate.of(1984,03,06));
        System.out.println(mayor.esMayorEdad());
        Persona pobre = new Persona("Manolo",new DNI("111111111N"),1000,LocalDate.of(2009,03,06));
        System.out.println(pobre.tieneDinero());
        Persona yados = new Persona("Manolo",new DNI("111111111N"),900,LocalDate.of(2009,03,06));
        System.out.println(yados.esMileurista());
        Persona noMileurista = new Persona("Manolo",new DNI("111111111N"),1800,LocalDate.of(2009,03,06));
        System.out.println(noMileurista.esMileurista());
    }
}
