public class Matricula {
    //ATRIBUTOS//
    public static int siguienteNumeroMatricula = 1;
    private int numeroMatricula;
    private String nombreAlumno;
    private String nombreAsignatura;

    //CONSTRUCTORES//
    public Matricula(String nombreAlumno, String nombreAsignatura) {
        this.nombreAlumno = nombreAlumno;
        this.nombreAsignatura = nombreAsignatura;
        this.numeroMatricula = Matricula.siguienteNumeroMatricula;
        Matricula.siguienteNumeroMatricula += 1;
    }

    //METODOS//
    public String getNombreAlumno() {
        return this.nombreAlumno;
    }
    public String getNombreAsignatura() {
        return this.nombreAsignatura;
    }
    public int getNumeroMatricula() {
        return this.numeroMatricula;
    }
}
