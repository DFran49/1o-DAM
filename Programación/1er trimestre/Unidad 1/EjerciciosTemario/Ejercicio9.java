public class Ejercicio9 {
    /*Realiza una copia del archivo del ejercicio anterior. Sobre la copia, haz las modificaciones
    oportunas para que el programa nos informe de que la reunión de evaluación de 1º de ESO será el
    lunes 20 de junio y que las notas se publicarán a las 13:45.
     */
    public static void main(String[] args) {
        //El siguiente código define las variables de la circular
        String DiaSemanaReunion = "lunes";
        short DiaMesReunion = 20;
        String MesReunion = "junio";
        String CursAsisReunion = "ESO";
        byte GrupAsisReunion = 1;
        String CentroReunion = "IES HLanz";
        String LocalidadReunion = "Granada";
        String HoraReunion = "13:45";

        //El siguiente código redacta el mensaje usando las variables
        System.out.println("El "+DiaSemanaReunion+" día "+DiaMesReunion+" de "+MesReunion+" tendrá lugar la reunión de " +
                "evaluación del "+GrupAsisReunion+"º curso de "+CursAsisReunion+" en el "+CentroReunion+" de "+LocalidadReunion+". " +
                "Los profesores calificarán al alumnado y se prevé que a las "+HoraReunion+" horas las notas estén " +
                "publicadas en el tablón de anuncios del centro.");
    }
}
