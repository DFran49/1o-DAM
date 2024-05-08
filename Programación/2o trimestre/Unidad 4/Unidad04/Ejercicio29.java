public class Ejercicio29 {
    public static void main(String[] args) {
        BolaDragon[] MisBolas = new  BolaDragon[8];
        for (int i = 0; i < 7 ; i++) {
            try {
                MisBolas[i] = BolaDragon.crearBolaDragon();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        for (int i = 0; i < 7 ; i++) {
            System.out.println(MisBolas[i].getNumero());
        }
        try {
            MisBolas[8] = BolaDragon.crearBolaDragon();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
