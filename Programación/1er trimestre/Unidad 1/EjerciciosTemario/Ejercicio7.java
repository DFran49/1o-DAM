public class Ejercicio7 {
    /*Repite el ejercicio 1 usando variables para almacenar los datos. ¿Qué ventajas o
    inconvenientes observas con respecto a dicho ejercicio? */
    public static void main(String[] args) {
        /*Las ventajas de este código respecto al ejercicio 1 son que al ser variables las que
        almacenan los datos, se pueden modificar sin tener que cambiar la línea que imprime.
        Desventajas no veo muchas, solo que sin querer puedes nombrar mal la variable o puedes
        modificar el dato sin ser necesario
         */
        String DNI = "123456789A";
        String Nombre = "Francisco";
        String Apellidos = "Crespo Martín";
        String FechaNacimiento = "09/07/2005";
        Short Edad = 18;
        String Direccion = "C. Inventada N60";
        String Localidad = "Granada";
        String Telefono = "666666666";
        String EMail = "correoinventado@gmail.com";
        System.out.println(DNI);
        System.out.println(Nombre);
        System.out.println(Apellidos);
        System.out.println(FechaNacimiento);
        System.out.println(Edad);
        System.out.println(Direccion);
        System.out.println(Localidad);
        System.out.println(Telefono);
        System.out.println(EMail);
    }
}
