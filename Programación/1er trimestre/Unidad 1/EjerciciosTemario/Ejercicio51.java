import java.util.Scanner;

public class Ejercicio51 {
    /*
     Haz un programa que pregunte al usuario por su número de DNI. El programa mostrará
    la letra que corresponde a dicho DNI, teniendo en cuenta que se obtiene así:
     Calculamos el resto de dividir el número de DNI entre 23
     Buscamos en la siguiente lista la letra que corresponde a dicho resto y esa será la letra
    del DNI
     */
    static int DNINum;
    static char DNIletra;
    //Este array es la tabla de letras
    static char[] LetrasDNI = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E','T'};
    //Pido eL DNI
    public static void RecDatos(){
        System.out.println("Introduzca su DNI sin letra.");
        DNINum = new Scanner(System.in).nextInt();
    }
    //Se calcula el módulo y se selecciona la letra del array
    public static void CalcLetra(){
        int PosArrayLetras = DNINum%23;
        DNIletra = LetrasDNI[PosArrayLetras];
        System.out.println("La letra del DNI "+DNINum+" es: "+DNIletra);
    }

    public static void main(String[] args) {
        RecDatos();
        CalcLetra();
    }
}
