package Persona;

public class DNI {
    public int numero;
    public char letra;

    public DNI(int n, char I) {
        this.numero = n;
        this.letra = I;
    }

    public DNI(String dni) {
        this.numero=Integer.parseInt((dni.substring(0,8)));
        this.letra=dni.charAt(8);
    }
}
