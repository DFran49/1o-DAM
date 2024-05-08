package BingoFCM;

import java.util.ArrayList;
import java.util.Random;

public class CartonFCM {
    //ATRIBUTOS//
    private ArrayList<Integer> numeros;
    private static int totalCartones = 0;

    //CONSTRUCTORES//
    public CartonFCM(int n) {
        numeros = new ArrayList<>();
        int aleatorio;
        for (int i = 0; i < n ; i++) {
            aleatorio = 1+(new Random().nextInt(49));
            if (!this.numeros.contains(aleatorio)) {
                numeros.add(aleatorio);
            } else {
                i--;
            }
        }
        CartonFCM.totalCartones += 1;
    }

    //GETTERS//
    public static int getTotalCartonesFCM() {
        return CartonFCM.totalCartones;
    }

    //METODOS//
    public boolean contieneFCM(int n) {
        return this.numeros.contains(n);
    }

    public void borrarFCM(int n) {
            this.numeros.remove(Integer.valueOf(n));
    }

    public void mostrarCartonFCM() {
        String mensaje = "Números sin salir: ";
        for (int i = 0; i < this.numeros.size() ; i++) {
            mensaje += this.numeros.get(i) + " ";
        }
        System.out.println(mensaje);
    }

    public boolean bingoFCM() {
        if (this.numeros.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
