package Persona;

public class DNIMejorado {
    //PROPIEDADES//
    private int numero;
    private char letra;

    //CONSTRUCTORES//
    public DNIMejorado(int n) {
        this.numero=n;
        this.letra = this.calcularLetra();
    }

    //GETTERS//
    public int getNumero() {
        return this.numero;
    }

    public char getLetra() {
        return this.letra;
    }

    //METODOS PRIVADOS//
    private char calcularLetra() {
        char[] Letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int restoDNI = this.numero%23;
        return Letras[restoDNI];
    }
}
