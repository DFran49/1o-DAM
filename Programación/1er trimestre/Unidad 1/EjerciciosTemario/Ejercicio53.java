public class Ejercicio53 {
    /*
    Un equipo de 7 amigos futbolistas llamados Pedro, Luis, Miguel, Jorge, Juan, Manolo y
    Pepe echa a suerte quien se pone de portero. Para eso, todos sacan a la vez la mano y se cuenta el
    número de dedos que ha sacado cada uno. Entonces, se va contando de uno en uno y al que le
    toque, se pone de portero. Si al llegar al último jugador no se ha terminado, se sigue contando
    comenzando por el primero.
    Realiza un programa que muestre por pantalla el nombre del jugador que se pone de portero
    si el número de dedos que ha sacado cada amigo es:
    4 5 1 0 3 2 3
     */
    public static void main(String[] args) {
        String[] Jugadores = {"Pedro", "Luis", "Miguel", "Jorge", "Juan", "Manolo", "Pepe"};
        int TotalNumeros = 4 + 5 + 1 + 3 + 2 + 3;
        //Se saca cuantas vueltas da antes de la última
        int Vueltas = TotalNumeros/Jugadores.length;
        //Se saca en que jugador cae el último número restando las vueltas completas al máximo
        int NumeroJugador = TotalNumeros-(Vueltas* Jugadores.length);
        System.out.println("El amigo que se queda de portero es: "+Jugadores[NumeroJugador-1]);
    }
}
