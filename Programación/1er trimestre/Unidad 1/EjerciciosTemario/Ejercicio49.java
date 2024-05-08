import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio49 {
    /*
    La siguiente gráfica nos muestra el número de asignaturas suspensas de unos alumnos.
    Se supone que un alumno pasa de curso si no tiene asignaturas suspensas. Realiza un programa que
    pregunte al usuario por un número de lista entre 0 y 4 y nos muestre por pantalla el nombre del
    alumno seleccionado, su número de suspensos y si pasa de curso o no.
    */
    //Array de alumnos con posición 0 ocupada como vacía
    static String[] Alumnos = {"","Antonio","Jaime","Pedro","Manuel","Maite"};
    //Array de suspensas con primera posición vacía
    static int[] Suspensas = {0,3,8,2,0,0};
    //Función para mostrar cuantas ha suspendido
    public static void Mostrar(){
        System.out.println("Elija un número entre 1 y 5.");
        int AlumnoElegido = new Scanner(System.in).nextInt();
        //Este if te dice las que ha suspendido el alumno si se escoge entre 1 y 5, si no, te dice que no es válido
        if(AlumnoElegido>=1&&AlumnoElegido<=5){
            System.out.println("El alumno "+AlumnoElegido+" es "+Alumnos[AlumnoElegido]+" y ha suspendido "+Suspensas[AlumnoElegido]+" asignaturas.");
            if(Suspensas[AlumnoElegido]>0){
                System.out.println(Alumnos[AlumnoElegido]+" no pasa de curso.");
            } else if(Suspensas[AlumnoElegido]==0){
                System.out.println(Alumnos[AlumnoElegido]+" pasa de curso.");
            }
        } else {
            System.out.println("No ha elegido un número entre 1 y 5, vuelva a intentarlo.");
        }
    }

    public static void main(String[] args) {
        Mostrar();
    }
}