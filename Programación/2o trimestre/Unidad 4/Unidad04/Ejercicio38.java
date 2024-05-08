public class Ejercicio38 {
    public static void main(String[] Args) {
        Banco miBanco = new Banco();
        System.out.println(miBanco.getDineroTotal());
        System.out.println(miBanco.añadirDinero(1000));
        System.out.println(miBanco.getDineroTotal());
        System.out.println(miBanco.retirarDinero(200));
        System.out.println(miBanco.getDineroTotal());
        System.out.println(miBanco.retirarDinero(4000));
        System.out.println(miBanco.getDineroTotal());

        Monedero miMonedero = new Monedero();
        System.out.println(miMonedero.añadirDinero(50));
        System.out.println(miMonedero.getDineroTotal());
        System.out.println(miMonedero.retirarDinero(30));
        System.out.println(miMonedero.getDineroTotal());
        System.out.println(miMonedero.retirarDinero(400));
        System.out.println(miMonedero.getDineroTotal());

        Monedero miMonedero2 = new Monedero();
        System.out.println(miMonedero2.añadirDinero(50));
        System.out.println(miMonedero2.getDineroTotal());
        System.out.println(miMonedero2.añadirDinero(2000));
        System.out.println(miMonedero2.getDineroTotal());
        System.out.println(miMonedero2.añadirDinero(950));
        System.out.println(miMonedero2.getDineroTotal());
        System.out.println(miMonedero2.añadirDinero(1));
        System.out.println(miMonedero2.getDineroTotal());
    }
}
