import java.util.Scanner;

public class Ejercicio20 {
    /*
    Un camión que tiene capacidad para 3 toneladas necesita 15 viajes para transportar
    una cantidad de arena. Realiza un programa que pregunte por pantalla la capacidad de otro camión y
    nos muestre por pantalla cuántos viajes necesitará para transportar esa misma cantidad de arena.
     */

    static double CapacidadCamion2;
    static double ViajesCamion2;
    static public void PreguntarCapacidad(){
        System.out.println("Introduzca la capacidad del segundo camión en toneladas:");
        CapacidadCamion2 = new Scanner(System.in).nextDouble();
    }

    static public void CalculoViajesCamion2(){
        int CapacidadCamion1 = 3;
        int ViajesCamion1 = 15;
        double ToneladasCarga = CapacidadCamion1*ViajesCamion1;
        ViajesCamion2 = ToneladasCarga/CapacidadCamion2;
    }

    public static void main(String[] arg){
        PreguntarCapacidad();
        CalculoViajesCamion2();
        System.out.println("Un camión de "+CapacidadCamion2+" toneladas necsitaría "+ViajesCamion2+" viajes"+
                "\n para transportar la misma cantidad de arena.");
    }
}
