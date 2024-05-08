import java.io.*;
import java.util.StringTokenizer;

public class prueba {
    public static void main(String[] args) {
        try {
            FileInputStream leer = new FileInputStream("prueba.txt");
            System.out.println(leer.read());
            FileReader lector = new FileReader("prueba.txt");

            BufferedReader leerLineas = new BufferedReader(new FileReader("prueba.txt"));
            String titulo = leerLineas.readLine();
            StringTokenizer trozos = new StringTokenizer(titulo,";");
            String dni = trozos.nextToken();
            String nombre = trozos.nextToken();
            String estudios = trozos.nextToken();
            String  estado = trozos.nextToken();
            System.out.println(dni+";"+nombre+";"+estudios+";"+estado);

            System.out.println(leerLineas.readLine());
            String esNull = leerLineas.readLine();
            System.out.println(esNull);
            System.out.println(Estado.RECOGIDO.ordinal());
            int letra = 0;
            for (int i = 0; i < 3 ; i++) {
                System.out.println(i);
            }
            /*while (letra != -1) {
                letra = lector.read();
                if (letra != 10 && letra != 13) {
                    System.out.println((char) letra + " - " + letra);
                }

            }*/
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
