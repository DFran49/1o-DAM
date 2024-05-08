/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Francisco Crespo
 */
import java.util.Scanner;
public class EjemploDebugger {
    public static void main(String[] args) {
        int NotaAlumno = 0, SumNotas = 0;
        double i = 0.0;
        double media;
        
        NotaAlumno = new Scanner(System.in).nextInt();
        while (NotaAlumno>=0 || NotaAlumno<=10) {
            SumNotas = SumNotas+NotaAlumno;
            i = i+1;
            NotaAlumno = new Scanner(System.in).nextInt();
        }
        media = SumNotas/i;
        System.out.println("La media es: "+media);
    }
}
