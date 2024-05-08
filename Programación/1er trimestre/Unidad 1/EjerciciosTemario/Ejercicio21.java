import java.util.Scanner;

public class Ejercicio21 {
    /*
    Un profesor hace un examen en el que la teoría vale un 40% de la nota y los problemas
    un 60%. En total hay 8 preguntas de teoría (todas valen lo mismo) y 4 problemas (todos valen lo
    mismo). Realiza un programa que pregunte al usuario cuántas preguntas de teoría y cuántos
    problemas ha tenido bien, y muestre la nota del alumno en la parte de teoría, en la de problemas y
    en el examen en conjunto.
     */
    static int TeoriaBien;
    static int ProblemasBien;
    static double NotaTeoria;
    static double NotaProblemas;
    static public void RecDatos(){
        System.out.println("¿Cuantas preguntas de teoría has acertado?");
        TeoriaBien = new Scanner(System.in).nextInt();
        System.out.println("¿Cuantos problemas has acertado?");
        ProblemasBien = new Scanner(System.in).nextInt();
    }
    static public void CalcNota(){
        double ValorTeoria = 0.5;
        double ValorProblemas =1.5;
        NotaTeoria = ValorTeoria*TeoriaBien;
        NotaProblemas = ValorProblemas*ProblemasBien;
    }
    public static void main(String[] arg){
        RecDatos();
        CalcNota();
        System.out.println("La nota de teoría es de: "+NotaTeoria);
        System.out.println("La nota de problemas es de: "+NotaProblemas);
        System.out.println("La nota total es de: "+(NotaTeoria+NotaProblemas));
    }
}
