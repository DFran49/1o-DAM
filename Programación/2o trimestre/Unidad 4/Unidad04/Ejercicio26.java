public class Ejercicio26 {
    public static void main(String[] args) {
        Fraccion unMedio = new Fraccion(1,2);
        Fraccion tresCuartos = new Fraccion(3,4);
        Fraccion dosQuintos = new Fraccion(2,5);
        Fraccion tresSeptimos = new Fraccion(3,7);
        Fraccion cuatroTercios = new Fraccion(4,3);
        Fraccion ochoQuintos = new Fraccion(8,5);

        Fraccion diezOctavos = Fraccion.sumar(unMedio,tresCuartos);
        System.out.println(diezOctavos.getNumerador()+" / "+diezOctavos.getDenominador());

        Fraccion veintinueveTreintaycincos = Fraccion.sumar(dosQuintos,tresSeptimos);
        System.out.println(veintinueveTreintaycincos.getNumerador()+" / "+veintinueveTreintaycincos.getDenominador());

        Fraccion tresOctavos = Fraccion.dividir(unMedio,cuatroTercios);
        System.out.println(tresOctavos.getNumerador()+" / "+tresOctavos.getDenominador());

        Fraccion setentayunSetentaavos = Fraccion.multiplicar(unMedio,(Fraccion.sumar(tresSeptimos,ochoQuintos)));
        System.out.println(setentayunSetentaavos.getNumerador()+" / "+setentayunSetentaavos.getDenominador());
    }
}
