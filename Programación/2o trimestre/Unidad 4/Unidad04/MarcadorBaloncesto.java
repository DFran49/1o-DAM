import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class MarcadorBaloncesto {
    //Atributos//
    private String nombreLocal;
    private String nombreVisitante;
    private int puntosLocal;
    private int puntosVisitante;
    private LocalDate fecha;

    //CONSTRUCTORES//
    public MarcadorBaloncesto(String nL, String nVl) {
        this(nL,0,nVl,0,LocalDate.now());
    }

    public MarcadorBaloncesto(String nL, String nVl, LocalDate fecha) {
        this(nL,0,nVl,0,fecha);
    }

    private MarcadorBaloncesto(String nL, int pL, String nVl, int pV, LocalDate fecha) {
        this.nombreLocal = nL;
        this.puntosLocal = pL;
        this.nombreVisitante = nVl;
        this.puntosVisitante = pV;
        this.fecha = fecha;
    }

    public void añadirCanasta(char equipo, int puntos) {
        if (puntos>=1 && puntos<=3) {
            if (equipo == 'L') {
                this.puntosLocal += puntos;
            } else if (equipo == 'V') {
                this.puntosVisitante += puntos;
            }
        }
    }

    //GETTERS//
    public int getPuntosLocal() {
        return this.puntosLocal;
    }

    public int getPuntosVisitante() {
        return this.puntosVisitante;
    }

    //MÉTODOS//
    public void reset() {
        this.puntosLocal = 0;
        this.puntosVisitante = 0;
    }
    public void guardar(String ruta) throws IOException {
        File archivo = new File(ruta);
        archivo.createNewFile();
        FileWriter guardado = new FileWriter(archivo);
        guardado.write(this.nombreLocal+": "+this.puntosLocal+" - "+this.nombreVisitante+": "+this.puntosVisitante);
        guardado.close();
    }

    //METODOS DE ESTADO//
    public boolean ganaLocal() {
        return puntosLocal > puntosVisitante;
    }

    public boolean ganaVisitante() {
        return puntosLocal < puntosVisitante;
    }

    public boolean hayEmpate() {
        return puntosLocal == puntosVisitante;
    }
}
