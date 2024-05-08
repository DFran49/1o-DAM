package Persona;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private DNI dni;
    private double sueldo;
    private LocalDate fechaNacimiento;
    private CuentaCorriente cuenta;

    public Persona(String n,DNI d,double s,LocalDate fn) {
        this.nombre = n;
        this.dni = d;
        this.sueldo = s;
        this.fechaNacimiento = fn;
        this.cuenta = new CuentaCorriente();
    }

    public Persona(String n,int numDNI,char letraDNI,double s,LocalDate fn) {
        this.nombre = n;
        this.dni = new DNI(numDNI,letraDNI);
        this.sueldo = s;
        this.fechaNacimiento = fn;
        this.cuenta = new CuentaCorriente();
    }

    public Persona(String n,DNI d) {
        this.nombre = n;
        this.dni = d;
        this.sueldo = 900;
        this.fechaNacimiento = LocalDate.now().minusYears(20);
        this.cuenta = new CuentaCorriente();
    }

    public Persona(String n,int numDNI,char letraDNI) {
        this.nombre = n;
        this.dni = new DNI(numDNI,letraDNI);
        this.sueldo = 900;
        this.fechaNacimiento = LocalDate.now().minusYears(20);
        this.cuenta = new CuentaCorriente();
    }

    public void aumentarSueldo(int porcentaje) {
        this.sueldo += this.sueldo*(porcentaje/100.0);
    }
    public void cobrarSueldo() {
        this.cuenta.añadirDinero((int) this.sueldo);
    }

    public String getNombre() {
        return this.nombre;
    }

    public DNI getDNI() {
        return this.dni;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public CuentaCorriente getCuentaCorriente() {
        return this.cuenta;
    }

    public boolean esMayorEdad() {
        return this.fechaNacimiento.plusYears(18).isBefore(LocalDate.now());
    }

    public boolean tieneDinero() {
        return this.cuenta.saldo >= 0;
    }

    public boolean esMileurista() {
        return this.sueldo<1200;
    }
}
