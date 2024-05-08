import java.util.Scanner;

public class Ejercicio06 {
    /*
    Realiza un programa que pregunte al usuario "¿Eres mayor de edad (si/no)?". Si el
    usuario escribe "Si", el ordenador mostrará un mensaje "El usuario es mayor de edad". Si el
    usuario escribe "No", el ordenador mostrará "El usuario es menor de edad". Si el usuario
    escribe cualquier otra cosa, el ordenador mostrará "No te entiendo" y volverá a hacer la
    pregunta hasta que el usuario escriba lo correcto.
     */
    public static void main(String[] args) {

        String mayor;
        boolean DatCorrecto = false;
        do {
            System.out.println("¿Eres mayor de edad (si/no)?");
            mayor = new Scanner(System.in).nextLine();
            switch (mayor){
                case "si","Si","SI"->{
                    System.out.println("El usuario es mayor de edad");
                    DatCorrecto = true;
                }
                case "no","No","NO"->{
                    System.out.println("El usuario es menor de edad");
                    DatCorrecto = true;
                }
                default -> DatCorrecto = false;
            }
        } while (DatCorrecto==false);
    }
}
