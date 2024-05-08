import java.lang.*;

public class AlmacenamientoBurbuja {

    /*static void RecibirNumeros() {

    }*/

    static void Ordenar() {

        System.out.println("Recibir numeros");
        //int EntradasTotales = /*(int)(Math.random()*11)*/5;
        //System.out.println("Se seleccionarán "+EntradasTotales+" números en total.");
        int NumTemp;
        int[] aOrdenar;
        aOrdenar = new int[]{5};
        System.out.println("aOrdenar length: "+aOrdenar.length);
        for(NumTemp=0; NumTemp<aOrdenar.length; NumTemp++){
            aOrdenar[NumTemp] = (int)(Math.random()*1001);
        }
        System.out.println("Los números a ordenar son: "+aOrdenar);

        int DePaso;
        int TempApoyo;
        for(NumTemp=0; NumTemp<aOrdenar.length-1; NumTemp++) {
            TempApoyo = NumTemp+1;
            System.out.println("TempApoyo No "+NumTemp+" es: "+TempApoyo);
            if(aOrdenar[NumTemp] > aOrdenar[TempApoyo]) {
                DePaso = aOrdenar[NumTemp];
                aOrdenar[NumTemp] = aOrdenar[TempApoyo];
                aOrdenar[TempApoyo] = DePaso;
            }
            System.out.println(aOrdenar[NumTemp]);
        }
        System.out.println("Ordenar");
        for(NumTemp=0; NumTemp<aOrdenar.length; NumTemp++){
            System.out.println(aOrdenar[NumTemp]);
        }
    }

    public static void main(String[] args) {
        //RecibirNumeros();
        Ordenar();
    }

}
