import java.util.HashMap;

public class Ejercicio39 {
    public static void main(String[] args) {
        Banco bancoManolo = new Banco();
        bancoManolo.añadirDinero(7000);
        System.out.println("Dinero Manolo -7000-" + bancoManolo.getDineroTotal());
        Banco bancoPaco = new Banco();
        bancoPaco.añadirDinero(5000);
        System.out.println("Dinero Paco -5000-" +bancoPaco.getDineroTotal());

        System.out.println("Manolo.transferirHacia(Paco,2500)" +bancoManolo.transferirHacia(bancoPaco,2500));
        System.out.println("Dinero Manolo -4500-" + bancoManolo.getDineroTotal());
        System.out.println("Dinero Paco -7500-" +bancoPaco.getDineroTotal());

        bancoManolo.retirarDinero((int) bancoManolo.getDineroTotal());
        bancoPaco.retirarDinero((int) bancoPaco.getDineroTotal());
        bancoManolo.añadirDinero(7000);
        bancoPaco.añadirDinero(5000);
        System.out.println("Dinero Manolo -7000-" + bancoManolo.getDineroTotal());
        System.out.println("Dinero Paco -5000-" +bancoPaco.getDineroTotal());
        System.out.println(bancoPaco.transferirDesde(bancoManolo,2500));
        System.out.println("Dinero Manolo -4500-" + bancoManolo.getDineroTotal());
        System.out.println("Dinero Paco -7500-" +bancoPaco.getDineroTotal());

        bancoManolo.retirarDinero((int) bancoManolo.getDineroTotal());
        bancoPaco.retirarDinero((int) bancoPaco.getDineroTotal());
        bancoManolo.añadirDinero(2000);
        bancoManolo.añadirDinero(5000);
        System.out.println(Adinerado.transferir(bancoManolo,bancoPaco,50000));
    }
}
