import bpc.daw.consola.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        Consola Pantalla = new Consola();
        Teclado LeerRGB = Pantalla.getTeclado();
        CapaTexto Texto = Pantalla.getCapaTexto();
        try {
            Texto.println("Introduzca un valor entre 0 y 255 para el valor RED");
            int red = LeerRGB.leerNumeroEntero();
            Texto.println("Introduzca un valor entre 0 y 255 para el valor GREEN");
            int green = LeerRGB.leerNumeroEntero();
            Texto.println("Introduzca un valor entre 0 y 255 para el valor BLUE");
            int blue = LeerRGB.leerNumeroEntero();
            boolean redCorrect = red<=255 && red>=0;
            boolean greenCorrect = green<=255 && green>=0;
            boolean blueCorrect = blue<=255 && blue>=0;
            if (redCorrect == true && greenCorrect == true && blueCorrect == true) {
                CapaFondo Fondo = Pantalla.getCapaFondo();
                FondoColorSolido Color = new FondoColorSolido(red,green,blue);
                Fondo.setFondo(Color);
                Pantalla.getCapaFondo();
                int espera = LeerRGB.leerNumeroEntero();
            } else {
                System.out.println("No ha introducido valores entre 0 y 255, intentelo de nuevo");
            }

        } catch (NumberFormatException p) {
            System.out.println("Ha introducido un valor que no es un entero");
        }

    }
}
