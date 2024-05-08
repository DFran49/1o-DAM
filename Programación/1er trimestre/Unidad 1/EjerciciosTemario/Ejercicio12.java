import java.util.Scanner;

public class Ejercicio12 {
    /*Haz un programa que pida al usuario por teclado dos números con decimales:
    precioNormal y porcentajeRebaja. El programa mostrará por pantalla el precio normal y el rebajado,
    tras haber aplicado el porcentaje de descuento indicado en la variable porcentajeRebaja. La salida
    del programa deberá tener el siguiente formato:
     */

    //Primero definimos las variables globales.
    static double precioNormal;
    static double porcentajeRebaja;
    static double cantidadDescuento;
    static double precioFinal;

    //Este bloque pide los valores necesarios al usuario
    static void pedirValores() {
        System.out.println("Introduzca el precio del artículo:");
        precioNormal = new Scanner(System.in).nextDouble();
        System.out.println("Introduzca el descuento que desea aplicar al artículo:");
        porcentajeRebaja = new Scanner(System.in).nextDouble();
    }

    //Este bloque hace los cálculos para saber todos los datos
    static void aplicarDescuento() {
        double tempDescuento = porcentajeRebaja/100;
        cantidadDescuento = precioNormal*tempDescuento;
        precioFinal = precioNormal-cantidadDescuento;
    }

    //Este bloque muestra la tabla de valores
    static void mostrarDescuento() {
        System.out.println("El precio normal del artículo es de: " + precioNormal + " euros.");
        System.out.println("El porcentaje de rebaja aplicado es de: " + porcentajeRebaja + "%.");
        System.out.println("El descuento aplicado al artículo es de: " + cantidadDescuento + " euros");
        System.out.println("El precio final del artículo es de: " + precioFinal + " euros");
    }

    //Este bloque ejecuta las clases anteriores
    public static void main(String[] args){
        pedirValores();
        aplicarDescuento();
        mostrarDescuento();
    }
}
