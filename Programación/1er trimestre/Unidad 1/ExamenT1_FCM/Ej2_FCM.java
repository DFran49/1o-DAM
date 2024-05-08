import java.util.Scanner;

public class Ej2_FCM {
    /*
    Realiza un programa usando arrays para evitar repetir código ni crear
    demasiadas variables. Las notas de los alumnos de una clase se recogen en esta
    tabla:
    • Realiza un programa que pregunte por teclado el número de lista del alumno y nos
    muestre el nombre, la nota del alumno y si está o no por encima de la nota media de la
    clase. En caso de que el número de lista no esté comprendido en el rango válido, se
    mostrará el mensaje “El número de lista no corresponde con ningún alumno”.
    • Supongamos que hubiera que añadir un quinto alumno. Completa el programa para
    que nos diga la nota que debería tener ese hipotético alumno para que la media de
    toda la clase sea un 6.
     */

    public static void main(String[] args) {
        //Los siguientes arrays contienen nombres y notas de los alumnos dejando la casilla 0 vacía para
        //que sea más facil acceder por números de lista
        String[] NombreAlumno = {"","Jose Pérez","Pedro López","Carmen Ruíz","Ana Jiménez","Miguel Revelles"};
        double[] NotaAlumno = {0,4.3,5.75,3.25,6,10.7};

        //La siguiente línea define la media de la clase
        double MediaClase = (NotaAlumno[1]+NotaAlumno[2]+NotaAlumno[3]+NotaAlumno[4]+NotaAlumno[5])/5;

        //El siguiente bloque pide el número del alumno
        System.out.println("Introduzca el número del alumno entre 1 y 5");
        int AlumnoElegido = new Scanner(System.in).nextInt();

        //El siguiente if comprueba si el número introducido no coincide con los números de lista disponibles.
        if (AlumnoElegido<1||AlumnoElegido>5){
            System.out.println("El número de lista no corresponde con ningún alumno");
        } else {
            //Al estar en la lista los némeros, pasa a este bloque, que crea un condicional y muestra por pantalla
            //los datos del alumno
            String NotaSuperaMedia = NotaAlumno[AlumnoElegido]>MediaClase? "es superior":"no es superior";
            System.out.println("El alumno Nº "+AlumnoElegido+" se llama "+NombreAlumno[AlumnoElegido]+", su nota es " +
                    +NotaAlumno[AlumnoElegido]+" y "+NotaSuperaMedia+" a la media.");
        }
    }
}
