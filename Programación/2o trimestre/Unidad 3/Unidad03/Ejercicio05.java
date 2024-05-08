public class Ejercicio05 {
    /*
    Realiza un programa que genere números enteros aleatorios entre 0 y 10 y los
    muestre por pantalla. El programa terminará cuando el número generado sea el 10.
     */
    public static void main(String[] args) {
        double aleatorio;
        do {
            aleatorio = Math.floor(Math.random()*10+1);
            System.out.println(aleatorio);
        } while (aleatorio!=10);
    }
}
