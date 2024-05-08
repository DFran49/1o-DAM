public class Ejercicio38 {
    public static void main(String[] args) {
        int a = 1;
        int b = 5;
        int c = 6;
        int bNegativo = Math.negateExact(b);
        double bCuadrado = Math.pow(b,2);
        int ac4 = 4*a*c;
        int a2 = 2*a;

        double equacionmas = (bNegativo + (Math.sqrt(bCuadrado - ac4))) / (a2);
        double equacionmenos = (bNegativo - (Math.sqrt(bCuadrado - ac4))) / (a2);
        System.out.println(equacionmas);
        System.out.println(equacionmenos);
    }
}
