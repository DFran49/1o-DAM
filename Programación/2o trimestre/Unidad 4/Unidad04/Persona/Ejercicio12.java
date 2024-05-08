package Persona;

import java.time.LocalDate;

public class Ejercicio12 {
    public static void main(String[] args) {
        Persona menor = new Persona("Manolo",new DNI("111111111N"),1000, LocalDate.of(2009,03,06));
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
