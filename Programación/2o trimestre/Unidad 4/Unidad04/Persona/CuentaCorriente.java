package Persona;

import java.io.IOException;

public class CuentaCorriente {
    public int numero;
    public double saldo;
    public CuentaCorriente() {
        this((int) (Math.random()*1000+1),0);
    }

    public CuentaCorriente(int numero) {
        this(numero,0.0);
    }

    public CuentaCorriente(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public void añadirDinero(int cantidad) {
        this.saldo += cantidad;
    }
    public void retirarDinero(int cantidad) throws IOException {
        if (this.saldo > cantidad) {
            this.saldo -= cantidad;
        } else {
            throw new IOException("No hay suficientes fondos para la transferencia");
        }
    }
}
