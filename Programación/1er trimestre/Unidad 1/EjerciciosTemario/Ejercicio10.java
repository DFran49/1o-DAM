import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio10 {
    /*Haz un programa que muestre el siguiente texto por pantalla, teniendo en cuenta que los
    datos que aparecen subrayados deben encontrase guardados en variables
     */
    public static void main(String[] args) {
        //El siguiente código define los datos a solicitar
        ArrayList<String> aIntroducir = new ArrayList<String>();
        aIntroducir.add("Día de la semana.");
        aIntroducir.add("Día del mes.");
        aIntroducir.add("Mes de la reunión.");
        aIntroducir.add("Grupo que debe asistir.");
        aIntroducir.add("Curso del grupo que debe asistir.");
        aIntroducir.add("Centro de la reunion.");
        aIntroducir.add("Localidad del centro.");
        aIntroducir.add("Hora de la reunión.");

        //El soguiente código define la lista que almacenará las respuestas
        ArrayList<String> DatosReunion = new ArrayList<String>();

        //El siguiente for solicita los datos y los almacena
        for(int NumTemp = 0; NumTemp < aIntroducir.size(); NumTemp++){
            System.out.println("Introduzca el/la: "+aIntroducir.get(NumTemp));
            DatosReunion.add( new Scanner(System.in).nextLine());
            System.out.println("Ciclo: "+NumTemp);
        }

        //El siguiente código redacta el mensaje usando las variables
        System.out.println("El "+DatosReunion.get(0)+" día "+DatosReunion.get(1)+" de "+DatosReunion.get(2)+" tendrá lugar la reunión de \n"+
                "evaluación del "+DatosReunion.get(3)+"º curso de "+DatosReunion.get(4)+" en el "+DatosReunion.get(5)+" de "+DatosReunion.get(6)+". \n" +
                "Los profesores calificarán al alumnado y se prevé que a las "+DatosReunion.get(7)+" horas las notas estén \n" +
                "publicadas en el tablón de anuncios del centro.");


    }
}
