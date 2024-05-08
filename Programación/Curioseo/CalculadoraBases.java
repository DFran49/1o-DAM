//Libreria para scann y array list
import java.util.*;

public class CalculadoraBases {

    //Variables para recibir datos
    static int OpcionMenu;
    static int BaseOrigen;
    static int BaseFinal;
    static String CadToASCII;

    //Clase para seleccionar operacion e indicar los datos de esta
    static void RecDatos() {
        ArrayList<String> ListaMenu = new ArrayList<String>();
        ListaMenu.add("Este programa hará de calculadora, las opciones de menú son las siguientes: \n ");
        ListaMenu.add("1 - De otra base a decimal. \n");
        ListaMenu.add("2- De decimal a otra base. \n");
        ListaMenu.add("3 - De base distinta a decimal a otra base \n");
        ListaMenu.add("4 - Caracteres ascii. \n");
        ListaMenu.add("Otro caracter - Salir. \n");
        for(String i : ListaMenu) {
            System.out.println(i);
        }

        OpcionMenu = new Scanner(System.in).nextInt();
        if(OpcionMenu == 1 || OpcionMenu == 3){
            System.out.println("Introduzca la base de origen.");
            BaseOrigen = new Scanner(System.in).nextInt();
            if(OpcionMenu == 3){
                System.out.println("Introduzca la base final.");
                BaseFinal = new Scanner(System.in).nextInt();
            } else if(OpcionMenu == 1){
                System.out.println("La base final es 10.");
                BaseFinal = 10;
            }
        }
        if(OpcionMenu == 2){
            BaseOrigen = 10;
            System.out.println("La base de origen es 10.");
            System.out.println("Introduzca la base final.");
            BaseFinal = new Scanner(System.in).nextInt();
        }
        if(OpcionMenu == 4){
            System.out.println("Introduzca la cadena de texto a traducir.");
            CadToASCII = new Scanner(System.in).nextLine();
            char[] LetrasTraducir = CadToASCII.toCharArray();
        }

    }

    //Variables para convertir
    static double NumAConvertir;
    static int aConvInt;

    //Posible lista para separar por cifras el numero
    static ArrayList<Integer> CifrasNumeroReves = new ArrayList<Integer>();
    static ArrayList<Integer> CifrasNumero = new ArrayList<Integer>();
    static ArrayList<Integer> CifrasDecReves = new ArrayList<Integer>();
    static ArrayList<Integer> CifrasDec = new ArrayList<Integer>();
    static String StrResult = "";
    static double NumResult;

    //Clase para convertir de una base cualquiera a decimal
    static void aDecimal(){
        if(OpcionMenu == 1){
            System.out.println("Introduzca el numero a convertir.");
            NumAConvertir = new Scanner(System.in).nextDouble();

            //Saca la parte entera redondeando y lo multiplico por el multiplo de 10 más
            // grande posible para tener decimales exactos
            aConvInt = (int)Math.floor(NumAConvertir);
            NumAConvertir = Math.round((NumAConvertir-aConvInt)*1000000000);
            NumAConvertir = NumAConvertir/1000000000;
            System.out.println("Los decimales1: "+NumAConvertir);
            do{
                CifrasNumeroReves.add(aConvInt%10);
                aConvInt /= 10;
            } while (aConvInt>0);
            int TmpNum = 0;
            int VarPaso;
            do{
                System.out.println("El ciclo es: "+TmpNum);
                System.out.println("Los decimales son: "+NumAConvertir);
                NumAConvertir *= 10;
                System.out.println("Los decimales x 10 son: "+NumAConvertir);
                VarPaso = (int)Math.floor(NumAConvertir);
                CifrasDec.add(VarPaso);
                NumAConvertir = Math.round((NumAConvertir-VarPaso)*1000000000);
                NumAConvertir = NumAConvertir/1000000000;

                //System.out.println("El numero añadido al array es: "+CifrasDecReves.get(TmpNum));
                TmpNum +=1;
            } while (NumAConvertir!=0);
            System.out.println("Array decimal: ");
            for (int i : CifrasDec) {
                System.out.println(i);
            }

            int contador = -1;
            int TempIntDec;
            //Multiplicacion de prueba para convertir decimales a decimal
            /*while(NumAConvertir != 0.0 || contador < 10 ) {
                System.out.println("El contador es: "+contador);
                System.out.println("Los decimales: "+NumAConvertir);
                NumAConvertir *= BaseOrigen;
                TempIntDec = (int)Math.floor(NumAConvertir);
                if(TempIntDec != 0){
                    CifrasDecReves.add(TempIntDec);
                    NumAConvertir=Math.round((NumAConvertir-TempIntDec)*1000000000);
                    NumAConvertir = NumAConvertir/1000000000;
                }
                contador+=1;
                if(contador==11){
                    NumAConvertir=0;
                }
            }

             */
            int temporal;
            for(int i = 0; i< CifrasNumeroReves.size(); i++){
                System.out.println("Se eleva a: "+i);
                System.out.println("Se eleva el numero: "+CifrasNumeroReves.get(i));
                System.out.println("Potencias parte entera: "+(CifrasNumeroReves.get(i)*Math.pow(BaseOrigen,i)));
                NumResult += CifrasNumeroReves.get(i)*Math.pow(BaseOrigen,i);

            }
            System.out.println("\nLa parte decimal:");
            for(int i = 0; i< CifrasDec.size(); i++){
                System.out.println("Se eleva a: "+contador);
                System.out.println("Se eleva el numero: "+CifrasDec.get(i));
                System.out.println("Potencias parte entera: "+(CifrasDec.get(i)*Math.pow(BaseOrigen,contador)));
                NumResult += CifrasDec.get(i)*Math.pow(BaseOrigen,contador);
                contador -=1;

            }
            //Este bucle añade el entero al resultado
           /* for(int i : CifrasNumero){
                resultado += i;
            }
            resultado +=".";
            //Este bucle añade el decimal al resultado
            for(int i : CifrasDecReves){
                resultado += i;
            }

            */

        }
    }

    /*for(int i = CifrasNumeroReves.size()-1; i >= 0; i-- ){
                CifrasNumero.add(CifrasNumeroReves.get(i));
            }

     */

    public static void main(String[] args) {
        RecDatos();
        if(OpcionMenu >=1 && OpcionMenu <=3) {
            System.out.println("La base origen es: " + BaseOrigen + "\n La base final es: " + BaseFinal);
        } else if(OpcionMenu == 4){
            System.out.println("La cadena de texto a traducir es: "+CadToASCII);
        } else {
            System.out.println("Ha elegido finalizar el programa.");
        }
        aDecimal();

        System.out.println("El resultado es: "+NumResult);
    }
}
