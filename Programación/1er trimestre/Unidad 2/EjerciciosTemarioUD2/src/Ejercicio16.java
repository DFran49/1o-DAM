import java.util.Scanner;

public class Ejercicio16 {
    //Extra - Contar cuantas veces está la segunda en la primera
    //Extra2 - Si se busca palabra que busque la palabra (a no serían las letras) ponle el código de espacio

    //Tomar longitud e inicializar un array con esa longitud, luego un bucle para meter las letras en las posiciones
    //Recorrer array

    public static void main(String[] args) {
        System.out.println("Introduzca una oración");
        String Oracion1 = new Scanner(System.in).nextLine();
        System.out.println("Introduzca una oración para buscar en la primera");
        String Oracion2 = new Scanner(System.in).nextLine();
        String OracionAnt = " "+Oracion2;
        String OracionDesp = Oracion2+" ";
        String OracionAmb = " "+Oracion2+" ";
        String OracionCom = " "+Oracion2+",";
        String OracionPun = " "+Oracion2+".";
        int ContVeces = 0;
        int posicion = 0;
        while (posicion < Oracion1.length()) {
            if (!Oracion1.contains(Oracion2) && !Oracion1.contains(Oracion2+",") && !Oracion1.contains(Oracion2+".")) {
                posicion = Oracion1.length();
            } else {
                System.out.println(Oracion1.indexOf(OracionCom, posicion));
                if (posicion == 0){
                    posicion += (Oracion1.indexOf(OracionDesp))+OracionDesp.length();
                    ContVeces += 1;
                } else if (posicion != 0) {
                    if (Oracion1.indexOf(OracionAnt, posicion) !=-1) {
                        posicion = Oracion1.indexOf(OracionAnt, posicion) + OracionAnt.length();
                        ContVeces += 1;
                    }
                    if (Oracion1.indexOf(OracionAnt+",", posicion) !=-1) {
                        posicion = Oracion1.indexOf(OracionAnt+",", posicion) + OracionAnt.length();
                        ContVeces += 1;
                    }
                    if (Oracion1.indexOf(OracionAnt+".", posicion) !=-1) {
                        posicion = Oracion1.indexOf(OracionAnt+".", posicion) + OracionAnt.length();
                        ContVeces += 1;
                    }

                    System.out.println("patata");
                }

                if (Oracion1.indexOf(OracionAnt, posicion) == -1 && Oracion1.indexOf(OracionDesp, posicion) == -1 && Oracion1.indexOf(OracionAmb, posicion) == -1 && Oracion1.indexOf(OracionCom, posicion-1) == -1 && Oracion1.indexOf(OracionPun, posicion-1) == -1) {
                    posicion = Oracion1.length();
                }
            }
        }
        System.out.println("La palabra "+Oracion2+" está "+ContVeces+" veces");
    }
}
