//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import java.util.*;

public class AlmacenamientoBurbuja {

    //Esta variable es global para referenciarla desde la clase Ordenar
    static int LongArr;
    //Este array se define global y no se inicializa
    static int[] aOrdenar;

    //Esta clase recibe la longitud del array a ordenar deseada
    static void RecibirNum() {
        System.out.println("Recibir numeros");
        LongArr = new Scanner(System.in).nextInt();
    }

    //Esta clase genera tantos numeros aleatorios en el array como se haya declarado antes inicializando
    //el array
    static void GenerarNum() {
        aOrdenar = new int[LongArr];
        System.out.println("aOrdenar length: " + aOrdenar.length);
        int NumTemp;
        for(NumTemp = 0; NumTemp < LongArr; NumTemp++) {
            System.out.println("Bucle 1: " + NumTemp);
            aOrdenar[NumTemp] = (int)(Math.random() * 1001.0);
        }

        String aOrdenarText = "Los números a ordenar son: " ;
        for(int TempMostrar : aOrdenar){
            aOrdenarText = aOrdenarText+" "+TempMostrar;
        }
        System.out.println(aOrdenarText);
    }

    //Esta clase ordena los números generados
    static void Ordenar() {
        int DePaso;
        for(int NumTemp = 0; NumTemp < aOrdenar.length - 1; ++NumTemp) {
            for(int TempNum = 0; TempNum < aOrdenar.length - 1; ++TempNum) {
                if (aOrdenar[TempNum] > aOrdenar[TempNum+1]) {
                    DePaso = aOrdenar[TempNum];
                    aOrdenar[TempNum] = aOrdenar[TempNum+1];
                    aOrdenar[TempNum+1] = DePaso;
                }
            }

            System.out.println(aOrdenar[NumTemp]);
        }

        System.out.println("Ordenar");

        for(int NumTemp = 0; NumTemp < aOrdenar.length; NumTemp++) {
            System.out.println(aOrdenar[NumTemp]);
        }

    }

    public static void main(String[] args) {
        RecibirNum();
        GenerarNum();
        Ordenar();
    }
}

