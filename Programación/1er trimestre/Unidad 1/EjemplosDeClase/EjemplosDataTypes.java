import java.sql.SQLOutput;

public class EjemplosDataTypes {
    public static void main(String[] args) {
        int edad = 20;
        byte nota = 5;
        short sueldo = 12357;
        String nombre = "Francisco";
        String apellido = "Crespo";
        System.out.println(nombre + " " + apellido+" tu nota es "+nota);
        System.out.println(3+6);
        System.out.println("tu nota es "+(6+8));
        String nombreCompleto = nombre + " " + apellido;
        System.out.println(nombreCompleto);
        double notaExamen = 6.3451618687;
        double altura = 175.0;
        float tamanio = 1.75f;
        long avion = 16346353;
        char estadoCivil='a';
        boolean repetidor=true;



        System.out.println(edad);
        edad = edad + 1;
        System.out.println(edad);
    }

}
