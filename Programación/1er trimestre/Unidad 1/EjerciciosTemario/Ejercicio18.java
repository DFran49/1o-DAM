public class Ejercicio18 {
    /*Un estudiante de universidad cobra 7€ por cada hora de sus clases particulares. Haz un
    programa que muestre por pantalla:
    a) Cuánto ganará en un mes si tiene dos alumnos, a los que les da 2 y 3 clases semanales
    respectivamente.
    b) ¿Cuántas horas de clase debe dar al mes si quiere ganar 900€?
     */
    //Variable para el precio por hora global por el uso en ambos apartados
    static int PrecioHora = 7;

    //Clase para definir cuanto gana actualmente
    public static void GanadoMes(){
        int Alumno1 = 2;
        int Alumno2 = 3;
        int TotalMes;
        TotalMes = (Alumno1 + Alumno2)*PrecioHora;
        System.out.println("El estudiante gana "+TotalMes+"€.");
    }

    //Clase para definir cuantas horas tiene que hacer para ganar 900€
    public static void CuantoParaMes(){
        int DineroDeseado = 900;
        int HorasNecesarias;
        HorasNecesarias = DineroDeseado/PrecioHora;
        System.out.println("Las horas necesarias para conseguir "+DineroDeseado+"€ son "+HorasNecesarias);
    }

    public static void main(String[] arg){
        GanadoMes();
        CuantoParaMes();
    }
}
