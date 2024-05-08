import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio48 {
    /*
    Estos son los nombres de usuario y pin de los empleados de una empresa:
    Pepe 9385
    Manuel 1234
    Ana 1085
    Haz un programa que cree un Map<String,Integer> que almacene esas asociaciones. A
    continuación, el programa preguntará el nombre y el pin de un usuario y tras consultar el Map,
    nos dirá “Acceso permitido” o “Usuario/Pin incorrecto
     */
    public static void main(String[] args) {
        Map<String,Integer> Logins = new HashMap<>();
        Logins.put("Pepe",9385);
        Logins.put("Manuel",1234);
        Logins.put("Ana",1085);
        boolean controlador = false;
        for (int intentos = 5; intentos>0 && !controlador;intentos--) {
            System.out.println("Tiene "+intentos+" intentos");
            System.out.println("Introduzca un usuario");
            String user = new Scanner(System.in).nextLine();
            System.out.println("Introduzca una contraseña");
            int pass = new Scanner(System.in).nextInt();
            if (!Logins.containsKey(user)) {
                System.out.println("Ese usuario no existe");
            } else {
                if (Logins.get(user)!=pass) {
                    System.out.println("Contraseña incorrecta");
                } else {
                    System.out.println("Bienvenid@ "+user);
                    controlador = true;
                }
            }
        }
    }
}
