package TiempoFCM;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SemanaFCM {
    //ATRIBUTOS//
    private DiaFCM[] sem;

    //CONSTRUCTORES//
    public SemanaFCM() {
        //Inicio el array con 8 posiciones para que los días empiecen desde la posición 1 (La posición 0 no se usa;
        sem = new DiaFCM[8];
        for (int i = 1; i < this.sem.length ; i++) {
            System.out.println("Introduzca la temperatura para el día " + i);
            sem[i] = new DiaFCM(new Scanner(System.in).nextInt());
        }
    }

    //GETTERS//
    public int getTemperaturaFCM(int d) throws IllegalArgumentException {
        //Entre 1 y 7 debido a que la posición 0 no se usa
        if (d < 1 || d > this.sem.length) {
            throw new IllegalArgumentException("Se debe indicar un día entre 1 y 7");
        } else {
            return this.sem[d].getTemperaturaFCM();
        }
    }

    public void setTemperaturaFCM(int d, int t) throws IllegalArgumentException {
        //Entre 1 y 7 debido a que la posición 0 no se usa
        if (d < 1 || d > this.sem.length) {
            throw new IllegalArgumentException("Se debe indicar un día entre 1 y 7");
        } else {
            this.sem[d].setTemperaturaFCM(t);
        }
    }

    public void resumenFCM(String ruta) {
        try {
            FileWriter escribir = new FileWriter(ruta);
            for (int i = 1; i < this.sem.length ; i++) {
                escribir.write("La temperatura del día " + i + " es: " + this.getTemperaturaFCM(i) + "\n");
            }
            escribir.write("La máxima es: " + this.sem[1].getMaximaFCM() + "\n");
            escribir.write("La mínima es: " + this.sem[1].getMinimaFCM());
            escribir.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void maxMinFCM() {
        System.out.println("La máxima es: " + this.sem[1].getMaximaFCM()
                + " La mínima es: " + this.sem[1].getMinimaFCM());
    }
}
