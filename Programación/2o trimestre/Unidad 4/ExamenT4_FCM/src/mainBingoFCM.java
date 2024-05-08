import BingoFCM.CartonFCM;

import java.util.Scanner;

public class mainBingoFCM {
    public static void main(String[] args) {
        CartonFCM primero = new CartonFCM(5);
        CartonFCM segundo = new CartonFCM(5);
        System.out.println("Cartones creados: " + CartonFCM.getTotalCartonesFCM());

        int temporal;
        while (!primero.bingoFCM() && !segundo.bingoFCM()) {
            System.out.println("Introduzca un número.");
            temporal = new Scanner(System.in).nextInt();
            primero.borrarFCM(temporal);
            primero.mostrarCartonFCM();
            segundo.borrarFCM(temporal);
            segundo.mostrarCartonFCM();
        }

        if (primero.bingoFCM()) {
            System.out.println("¡Enhorabuena! Ha ganado el primer cartón");
        } else {
            System.out.println("¡Enhorabuena! Ha ganado el segundo cartón");
        }
    }
}
