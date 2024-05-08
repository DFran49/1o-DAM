public class BolaDragon {
    //ATRIBUTOS//
    private static final int MAXIMO_BOLAS = 7;
    private static int siguienteBola = 1;
    private int numero;

    //CONSTRUCTORES//
    private BolaDragon(int numero) {
        this.numero = numero;
    }

    //GETERS//
    public int getNumero() {
        return this.numero;
    }

    //METODOS//
    public static BolaDragon crearBolaDragon() throws Exception {
        if (BolaDragon.siguienteBola > BolaDragon.MAXIMO_BOLAS) {
            throw new Exception("Ya se han creado 7 bolas de dragón");
        } else {
            BolaDragon temp = new BolaDragon(BolaDragon.siguienteBola);
            BolaDragon.siguienteBola += 1;
            return temp;

        }
    }
}
