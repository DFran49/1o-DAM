public class Fraccion {
    //ATRIBUTOS//
    private int numerador;
    private int denominador;

    //CONSTRUCTORES//
    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    //GETERS//
    public int getNumerador() {
        return this.numerador;
    }
    public int getDenominador() {
        return this.denominador;
    }
    public double getValorReal() {
        return (double) this.numerador / this.denominador;
    }
    public Fraccion getInversa() {
        return new Fraccion(this.denominador, this.numerador);
    }

    //METODOS//
    public static Fraccion sumar(Fraccion a, Fraccion b) {
        int numerador = a.getNumerador()* b.getDenominador() + a.getDenominador()*b.getNumerador();
        int denominador = a.getDenominador()*b.getDenominador();
        return new Fraccion(numerador, denominador);
    }
    public static Fraccion multiplicar(Fraccion a, Fraccion b) {
        int numerador = a.getNumerador()* b.getNumerador();
        int denominador = a.getDenominador()*b.getDenominador();
        return new Fraccion(numerador, denominador);
    }
    public static Fraccion dividir(Fraccion a, Fraccion b) {
        return multiplicar(a, b.getInversa());
    }
}
