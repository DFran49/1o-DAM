import bpc.daw.reproductor.PlayList;
import bpc.daw.reproductor.Reproductor;

import java.io.IOException;

public class Ejercicio34 {
    public static void main(String[] args) throws IOException {
        PlayList Lista = new PlayList("ListaEjemplo.txt");
        Reproductor PlayLista = new Reproductor(Lista,true,false);
        PlayLista.play();
    }
}
