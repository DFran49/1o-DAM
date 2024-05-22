package INSTITUTO_FCM;

import java.util.ArrayList;
import java.util.List;

public class PruebaFCM {
    public static void main(String[] args) {
        String instituto = "IES Hermenegildo Lanz";
        DirectorInstituto miguel = new DirectorInstituto("Miguel", instituto);
        JefaEstudios pilar = new JefaEstudios("Pilar", instituto);
        Profesor antonia = new Profesor("Antonia", "Matemáticas");
        Profesor juan = new Profesor("Juan", "Historia");

        Alumno ana = new Alumno("Ana", new ArrayList<>());
        Alumno rafael = new Alumno("Rafael", new ArrayList<>());
        Alumno jorge = new Alumno("Jorge", new ArrayList<>());

        List<Alumno> hijosJulia = new ArrayList<>();
        hijosJulia.add(ana);
        hijosJulia.add(rafael);
        TutorLegal julia = new TutorLegal("Julia", hijosJulia);

        List<Alumno> hijosJaime = new ArrayList<>();
        hijosJaime.add(jorge);
        TutorLegal jaime = new TutorLegal("Jaime", hijosJaime);

        antonia.addNotificable(ana);
        antonia.addNotificable(rafael);
        antonia.addNotificable(miguel);
        antonia.addNotificable(pilar);
        antonia.calificar(ana,10);
        antonia.calificar(rafael, 3);

        juan.addNotificable(ana);
        antonia.addNotificable(rafael);
        juan.addNotificable(jorge);
        juan.addNotificable(miguel);
        juan.addNotificable(pilar);
        juan.calificar(ana, 4);
        juan.calificar(jorge, 2);

        System.out.println("Nota media de Ana: " + ana.getNotaMedia());
        System.out.println("Nota media de Rafael: " + rafael.getNotaMedia());
        System.out.println("Nota media de Jorge: " + jorge.getNotaMedia());

        System.out.println("Nota media del instituto: " + miguel.getNotaMedia());
        System.out.println("Suspensos en Matemáticas: " + pilar.getNumeroSuspensos("Matemáticas"));
        System.out.println("Suspensos en Historia: " + pilar.getNumeroSuspensos("Historia"));
    }
}
