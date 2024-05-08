public class Ejercicio8 {
    /*Haz un programa que muestre el siguiente texto por pantalla, teniendo en cuenta que los
    datos que aparecen subrayados deben encontrase guardados en variables
     */
    public static void main(String[] args) {
        //El siguiente código define las variables de la circular
        String DiaSemanaReunion = "viernes";
        Short DiaMesReunion = 26;
        String MesReunion = "mayo";
        String CursAsisReunion = "programación de aplicaciones web";
        Byte GrupAsisReunion = 1;
        String CentroReunion = "IES HLanz";
        String LocalidadReunion = "Granada";
        String HoraReunion = "20:30";

        //El siguiente código redacta el mensaje usando las variables
        System.out.println("El "+DiaSemanaReunion+" día "+DiaMesReunion+" de "+MesReunion+" tendrá lugar la reunión de " +
                "evaluación del "+GrupAsisReunion+"º curso de "+CursAsisReunion+" en el "+CentroReunion+" de "+LocalidadReunion+". " +
                "Los profesores calificarán al alumnado y se prevé que a las "+HoraReunion+" horas las notas estén " +
                "publicadas en el tablón de anuncios del centro.");
    }
}
