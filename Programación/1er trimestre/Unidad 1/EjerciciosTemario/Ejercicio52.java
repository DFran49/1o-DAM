import java.util.Scanner;

public class Ejercicio52 {
    /*
    Estamos haciendo un programa de loterías y tenemos dos variables llamadas número y
    NúmeroPremiado, que se encuentran inicializadas con números de 5 cifras. El programa deberá
    mostrar por pantalla:
    a) Si el número coincide con el número premiado.
    b) Si el número tiene reintegro, es decir, se dan a la vez las dos siguientes condiciones:
    a. La primera cifra del número coincide con la primera cifra del número premiado
    b. La última cifra del número coincide con la última cifra del número premiado
    Sugerencia: Obtén el cociente y resto de dividir el número premiado entre 10, y mira si
    tienen algo que ver con su última cifra. Inventa algo parecido para obtener la primera cifra
     */
    static int NumeroComprobar;
    //Numero aleatorio de 5 cifras
    static int NumeroGanador = (int) ((Math.random() * (99999 - 10000)) + 10000);
    //Se recoge el numero del cliente
    public static void RecDatos(){
        System.out.println("Elija su número de lotería (mínimo tiene que ser 10000).");
        NumeroComprobar = new Scanner(System.in).nextInt();
    }
    //Se comprueba si el numero del cliente es igual al ganador o si tiene reintegro
    public static void Comprobaciones(){
        //Se divide por 10000 para sacar las decenas de millar
        int DecMillarComprobar = NumeroComprobar/10000;
        int DecMillarPremiado = NumeroGanador/10000;
        //Se eliminan las unidades del número y se resta al número total para sacar las unidades
        int UnidadesComprobar = NumeroComprobar-((NumeroComprobar/10)*10);
        int UnidadesPremiado = NumeroGanador-((NumeroGanador/10)*10);
        //Se hacen las comprobaciones
        if(NumeroComprobar==NumeroGanador){
            System.out.println("Su número es el premiado.");
        } else if(DecMillarComprobar==DecMillarPremiado&&UnidadesComprobar==UnidadesPremiado){
            System.out.println("Le ha tocado el reintegro.");
        } else {
            System.out.println("No le ha tocado nada, siga siendo nuestro fiel cliente.");
        }
    }

    public static void main(String[] args) {
        /* DESCOMENTE LA SIGUIENTE LÍNEA SI QUIERE INTRODUCIR EL NÚMERO GANADOR CON FINES DE TESTEO */
        //System.out.println(NumeroGanador);
        RecDatos();
        Comprobaciones();
    }
}
