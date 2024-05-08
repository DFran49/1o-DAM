import java.util.Scanner;

public class Ej2_FCM {
    public static void main(String[] args) {
        //Se lee la contraseña
        System.out.println("Introduzca una contraseña.");
        String contraseña = new Scanner(System.in).nextLine();
        //Se lee la confirmación de la contraseña
        System.out.println("Confirme su contraseña.");
        String valContraseña = new Scanner(System.in).nextLine();

        //Se definen booleanos que controlarán la salida de si la contraseña es válida
        boolean mayusc = false;
        boolean mins = false;
        boolean especiales = false;
        //Este booleano es una comprobación de que la longitud es válida (No compruebo ambas por el siguiente if)
        boolean longitud = contraseña.length() >= 8;

        //Este if comprueba si las contraseñas son iguales, si no, lo informa y el programa acaba
        if (!contraseña.equals(valContraseña)) {
            System.out.println("Las contraseñas no coinciden.");
        } else {

            //Este if comprueba con el booleano definido antes si la contraseña es suficientemente larga, si no, lo informa
            //y el programa acaba
            if (!longitud) {
                System.out.println("La contraseña debe tener como mínimo 8 caracteres de longitud.");
            } else {

                //Este for recorre cada letra del string de la contraseña (Ya igual a la comprobación)
                for (int i = 0; i < contraseña.length() ; i++) {

                    //Este if comprueba si la letra actual es un carácter prohibido y define el booleano a true
                    if (contraseña.charAt(i) == '.' || contraseña.charAt(i) == ',' || contraseña.charAt(i) == ' ') {
                        especiales = true;
                    }

                    //Este if comprueba si el caracter está en el rango ASCII de mayúsculas y Ñ y si es así,
                    //pone el booleano a true
                    if (((int) contraseña.charAt(i) >= 65 && (int) contraseña.charAt(i) <= 90) || (int) contraseña.charAt(i) == 165) {
                        mayusc = true;
                    }

                    //Este if comprueba si el caracter está en el rango ASCII de minúsculas y ñ y si es así,
                    //pone el booleano a true
                    if (((int) contraseña.charAt(i) >= 97 && (int) contraseña.charAt(i) <= 122) || (int) contraseña.charAt(i) == 164) {
                        mins = true;
                    }
                }

                //Este if comprueba los booleanos anteriores, solo ejecutando la primera parte si hay al menos una mayúscula,
                //una minúscula y si no hay puntos, comas o espacios
                if (mayusc && mins && !especiales) {
                    System.out.println("La contraseña es válida.");
                } else {
                    System.out.println("La contraseña no es válida, debe tener como mínimo una mayúscula y " +
                            "una minúscula y no debe tener puntos, comas o espacios");
                }
            }
        }
    }
}
