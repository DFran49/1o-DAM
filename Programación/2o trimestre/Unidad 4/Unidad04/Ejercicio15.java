public class Ejercicio15 {
    public static void main(String[] args) {
        MarcadorBaloncesto Granada_Estudiantes = new MarcadorBaloncesto("Granada","Estudiantes");
        for (int i = 0; i < 80 ; i++) {
            Granada_Estudiantes.añadirCanasta('L',1);
            Granada_Estudiantes.añadirCanasta('V',1);
        }
        System.out.println("Empate: "+Granada_Estudiantes.hayEmpate());
        System.out.println("Gana Local: "+Granada_Estudiantes.ganaLocal());
        System.out.println("Gana Visitante: "+Granada_Estudiantes.ganaVisitante());

        for (int i = 0; i < 10 ; i++) {
            Granada_Estudiantes.añadirCanasta('L',1);
        }
        System.out.println("Empate: "+Granada_Estudiantes.hayEmpate());
        System.out.println("Gana Local: "+Granada_Estudiantes.ganaLocal());
        System.out.println("Gana Visitante: "+Granada_Estudiantes.ganaVisitante());
    }
}
