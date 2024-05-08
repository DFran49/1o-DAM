public class Ejercicio45 {
    public static void main(String[] args) {
        int[] aOrdenar = {50,26,7,9,15,27};
        int DePaso;
        for(int NumTemp = 0; NumTemp < aOrdenar.length - 1; ++NumTemp) {
            for(int TempNum = 0; TempNum < aOrdenar.length - 1; ++TempNum) {
                if (aOrdenar[TempNum] > aOrdenar[TempNum+1]) {
                    DePaso = aOrdenar[TempNum];
                    aOrdenar[TempNum] = aOrdenar[TempNum+1];
                    aOrdenar[TempNum+1] = DePaso;
                }
            }

        }

        String mensaje = "Los números ordenados son: -";

        for(int NumTemp = 0; NumTemp < aOrdenar.length; NumTemp++) {
            mensaje = mensaje + aOrdenar[NumTemp] + "-";
        }
        System.out.println(mensaje);
    }
}
