public class Ejercicio22 {
    /*
    Un profesor realiza un test a sus alumnos. El test tiene 30 preguntas (todas las
    preguntas valen lo mismo) con cuatro opciones cada una. Se supone que tres preguntas falladas te
    quitan una bien. Las preguntas sin contestar no quitan puntos. Realiza un programa que calcule y
    muestre por pantalla la nota de un alumno que tiene 22 preguntas bien, 6 mal y 2 sin contestar.
     */

    public static void main(String[] args){
        int PreguntasBien = 22;
        int PreguntasMal = 6;
        int NotaARestar = PreguntasMal/3;
        int PreguntasNoContesta = 2;
        double NotaPorPregunta = 0.33;
        double NotaASumar = PreguntasBien*(Math.round(0.33*100.0)/100.0);
        System.out.println(NotaASumar);
        double NotaTotal = (Math.round(NotaASumar*100.0)/100.0)-NotaARestar;
        System.out.println("La nota del alumno es de "+NotaTotal+" sobre 10.");
    }
}
