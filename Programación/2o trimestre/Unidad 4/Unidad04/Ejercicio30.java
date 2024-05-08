public class Ejercicio30 {
    public static void main(String[] args) {
        Altavoz musica = new Altavoz();
        System.out.println(musica.getVolumen());
        musica.ponerVolumenMaximo();
        System.out.println(musica.getVolumen());

        Altavoz roto = new Altavoz();
        try {
            roto.setVolumen(-28);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Altavoz moderado = new Altavoz();
        moderado.setVolumen(127);
        System.out.println(moderado.toString());
    }
}
