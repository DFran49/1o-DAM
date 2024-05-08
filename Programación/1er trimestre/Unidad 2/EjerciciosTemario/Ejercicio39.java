public class Ejercicio39 {
    public static void main(String[] args) {
        System.out.println("Información dobre el ordenador:");
        System.out.println("Sistema operativo: " + System.getProperty("os.name"));
        System.out.println("Version sistema operativo: " + System.getProperty("os.version"));
        System.out.println("Arquitectura sistema operativo: " + System.getProperty("os.arch"));
        System.out.println("Usuario actual: " + System.getProperty("user.name"));
        System.out.println("Carpeta archivos temporales: " + System.getenv("TMP"));
    }
}
