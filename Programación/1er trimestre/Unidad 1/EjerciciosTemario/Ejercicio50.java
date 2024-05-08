import java.util.Scanner;

public class Ejercicio50 {
    /*
    Hacer un programa en el que haya una variable entera llamada dinero e inicializarla a
    cualquier valor. El programa nos expresará esa cantidad en billetes de 500, 100, 50, 20 y 10 € y
    monedas de 2 y 1 €. Se ignoran los céntimos.
     */
    static int DineroTotal;
    //Recojo los datos
    public static void RecDatos() {
        System.out.println("Introduzca una cantidad de dinero en euros sin céntimos.");
        DineroTotal = new Scanner(System.in).nextInt();
    }
    //Hago los cálculos
    public static void CalculoPartes(){
        int Billetes500 = 0;
        int Billetes100 = 0;
        int Billetes50 = 0;
        int Billetes20 = 0;
        int Billetes10 = 0;
        int Monedas2 = 0;
        int Monedas1 = 0;
        /*Si el dinero total es mayor a 500, averiguo cuantos 500 hay y quito la cantidad x500 (ej. 1500 tiene 3, quito
        500x3=1500) y añado la cantidad a la variable de 500 y resto el dinero equivalente al total.
        Lo mismo para los demás, solo que con otros números.
         */

        if(DineroTotal>=500){
            Billetes500 = DineroTotal/500;
            DineroTotal = DineroTotal-((DineroTotal/500)*500);
        }
        if(DineroTotal>=100){
            Billetes100 = DineroTotal/100;
            DineroTotal = DineroTotal-((DineroTotal/100)*100);
        }
        if(DineroTotal>=50){
            Billetes50 = DineroTotal/50;
            DineroTotal = DineroTotal-((DineroTotal/50)*50);
        }
        if(DineroTotal>=20){
            Billetes20 = DineroTotal/20;
            DineroTotal = DineroTotal-((DineroTotal/20)*20);
        }
        if(DineroTotal>=10){
            Billetes10 = DineroTotal/10;
            DineroTotal = DineroTotal-((DineroTotal/10)*10);
        }
        if(DineroTotal>=2){
            Monedas2 = DineroTotal/2;
            DineroTotal = DineroTotal-((DineroTotal/2)*2);
        }
        if(DineroTotal>=1){
            Monedas1 = DineroTotal;
            DineroTotal = DineroTotal-DineroTotal;
        }
        //Muestro por pantalla la cantidad de billetes.
        System.out.println("Tiene "+Billetes500+" billetes de 500€.");
        System.out.println("Tiene "+Billetes100+" billetes de 100€.");
        System.out.println("Tiene "+Billetes50+" billetes de 50€.");
        System.out.println("Tiene "+Billetes20+" billetes de 20€.");
        System.out.println("Tiene "+Billetes10+" billetes de 10€.");
        System.out.println("Tiene "+Monedas2+" monedas de 2€.");
        System.out.println("Tiene "+Monedas1+" monedas de 1€.");
    }

    public static void main(String[] args) {
        RecDatos();
        CalculoPartes();
    }
}
