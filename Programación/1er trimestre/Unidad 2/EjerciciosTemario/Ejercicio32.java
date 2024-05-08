import bpc.daw.reproductor.ArchivoMP3;
import bpc.daw.reproductor.Reproductor;

public class Ejercicio32 {
    public static void main(String[] args) {
        ArchivoMP3 Cancion = new ArchivoMP3("prueba.mp3");
        System.out.println("El título es: " + Cancion.getTitulo());
        System.out.println("El autor es: " + Cancion.getAutor());
        System.out.println("El duración es: " + Cancion.getDuracion());

        Reproductor Reproducir = new Reproductor(Cancion,false,false);
        Reproducir.play();
    }
}
