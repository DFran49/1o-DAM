import bpc.daw.musica.Cancion;
import bpc.daw.musica.Guitarra;
import bpc.daw.musica.NotaMusical;
import bpc.daw.musica.Piano;

public class Ejercicio31 {
    public static void main(String[] args) {
        String NombreCancion = "Estrellita";
        Cancion Estrellita = new Cancion(NombreCancion);
        NotaMusical DoNegra = new NotaMusical(0,2);
        NotaMusical SolNegra = new NotaMusical(4,2);
        NotaMusical LaNegra = new NotaMusical(5,2);
        NotaMusical SolBlanca = new NotaMusical(4,1);
        NotaMusical FaCorchea = new NotaMusical(3,3);
        NotaMusical MiCorchea = new NotaMusical(2,3);
        NotaMusical ReSemi = new NotaMusical(1,4);
        NotaMusical MiSemi = new NotaMusical(2,4);
        NotaMusical FaSemi = new NotaMusical(3,4);
        Estrellita.añadir(DoNegra);
        Estrellita.añadir(DoNegra);
        Estrellita.añadir(SolNegra);
        Estrellita.añadir(SolNegra);
        Estrellita.añadir(LaNegra);
        Estrellita.añadir(LaNegra);
        Estrellita.añadir(SolBlanca);
        Estrellita.añadir(FaCorchea);
        Estrellita.añadir(FaCorchea);
        Estrellita.añadir(MiCorchea);
        Estrellita.añadir(MiCorchea);
        Estrellita.añadir(ReSemi);
        Estrellita.añadir(MiSemi);
        Estrellita.añadir(FaSemi);
        Estrellita.añadir(ReSemi);
        Estrellita.añadir(DoNegra);
        Piano PianoEstrellita = new Piano();
        PianoEstrellita.reproducir(Estrellita);

        Guitarra GuitarraEstrellita = new Guitarra();
        GuitarraEstrellita.reproducir(Estrellita);
    }
}
