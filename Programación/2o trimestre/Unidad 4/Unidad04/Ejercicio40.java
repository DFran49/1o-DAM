public class Ejercicio40 {
    public static void main(String[] args) {
        try {
            DepositoAguaInmutable miDeposito = new DepositoAguaInmutable(50,-100);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            DepositoAguaInmutable miDeposito = new DepositoAguaInmutable(300,200);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        DepositoAguaInmutable miDeposito = new DepositoAguaInmutable(20,500);
        System.out.println(miDeposito.getPorcentaje());
        miDeposito = new DepositoAguaInmutable(400,500);
        DepositoAguaInmutable nuevoDeposito = miDeposito.añadirLitro();
        System.out.println(nuevoDeposito.capacidadActual());

    }
}
