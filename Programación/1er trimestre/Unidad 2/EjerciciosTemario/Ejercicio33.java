import bpc.daw.reproductor.ArchivoMP3;
import bpc.daw.reproductor.PlayList;
import bpc.daw.reproductor.Reproductor;

import java.io.IOException;

public class Ejercicio33 {
    public static void main(String[] args) throws IOException {
        PlayList ListaEjemplo = new PlayList();
        ArchivoMP3 Cancion1 = new ArchivoMP3("prueba.mp3");
        ArchivoMP3 Cancion2 = new ArchivoMP3("dos.mp3");
        ArchivoMP3 Cancion3 = new ArchivoMP3("tres.mp3");
        ListaEjemplo.añadir(Cancion1);
        ListaEjemplo.añadir(Cancion2);
        ListaEjemplo.añadir(Cancion3);
        String RutaLista = "ListaEjemplo.txt";
        ListaEjemplo.guardar(RutaLista);
        Reproductor PlayLista = new Reproductor(ListaEjemplo,true,false);
        PlayLista.play();
    }
}
