import java.util.Scanner;

public class Ej1_FCM {
    /*
    Estás haciendo el software de un peso para una carnicería. El programa
    debe realizar lo siguiente:
    • El usuario introduce por teclado el precio por kg de la carne. A continuación, el
    programa pregunta cuánto pesa un artículo y el programa mostrará por pantalla el
    precio que debe pagar el cliente. En caso de que el peso introducido sea negativo,
    se mostrará el mensaje “El peso debe ser un número positivo” y el programa no
    deberá hacer nada más.
    • Completa el programa para que se haga un euro de descuento por cada 10 euros
    gastados. El descuento se aplicará solo si el precio del artículo es mayor de 20
    euros o el precio por kg sea superior a 5 euros.
    • No olvides añadir comentarios explicando como has realizado los cálculos
     */

    public static void main(String[] args) {
        double PrecioPorKG;
        double PesoCompra;
        double PrecioTotal;

        //El siguiente bloque pide los datos del peso y el precio por kg y los guarda en variables multiplicado por 1000000
        //para posteriormente dividir y quitar los decimales añadidos
        System.out.println("Introduzca el precio por kg de la carne");
        PrecioPorKG = new Scanner(System.in).nextDouble()*1000000;
        System.out.println("Introduzca el peso de carne que se llevará el cliente");
        PesoCompra = new Scanner(System.in).nextDouble()*1000000;


        //El siguiente bloque es una comprobación de si el peso es válido, cortando el programa en caso de que no
        if (PesoCompra<=0){
            System.out.println("El peso introducido debe ser positivo");
        } else {
            //La siguiente línea define el precio total sin descuento restando el precio por kg y el peso, los
            // cuales están divididos por 1000000 para como se menciona anteriormente, eliminar los decimales añadidos
            PrecioTotal = (PrecioPorKG/1000000) * (PesoCompra/1000000);

            //Las siguientes 2 líneas vuelven a dividir los datos para que queden naturales (Aunque posteriormente
            // solo se utiliza una de ellas
            PrecioPorKG /= 1000000;
            PesoCompra /= 1000000;

            //La siguiente comprobación se encarga de confirmar si hay que aplicar descuento, comprobando ambas
            // opciones dadas por el enunciado
            if(PrecioTotal>20 || PrecioPorKG>5){
                //La diguiente línea trunca el resultado de dividir el precio total por 10, dejando el descuento
                double Descuento = Math.floor(PrecioTotal)/10;

                //El siguiente bloque muestra el precio total original, luego el descuento y finalmente
                //el nuevo precio total, aplicando otra vez los redondeos
                System.out.println("El precio de la compra es de: "+(Math.floor(PrecioTotal*1000000)/1000000) +
                        " € que con un descuento de "+Descuento+" € \n lo deja en "+((Math.floor((PrecioTotal*100000000)/1000000)/100)-Descuento)+" €");
            } else {
                //Esta línea es la que se ejecuta si no hay descuento, mostrando el precio total de la misma forma que antes
                System.out.println("El precio de la compra es de: "+(Math.floor(PrecioTotal*1000000)/1000000)+" €");
            }
        }
    }
}
