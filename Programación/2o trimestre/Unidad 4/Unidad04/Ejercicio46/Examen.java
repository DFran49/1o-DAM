package Ejercicio46;

import java.util.ArrayList;
import java.util.List;

public class Examen {
    //PROPIEDADES
    private List<String> alumnos;
    private List<Double> notas;

    //CONSTRUCTOR
    public Examen() {
        this.alumnos = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    //GETTERS
    public double getNota(String alumno) {
        return this.notas.get(alumnos.indexOf(alumno));
    }

    public double getNotaMedia() {
        if (alumnos.isEmpty()) {
            throw new IllegalStateException();
        } else {
            double media = 0;
            for(double a : this.notas) {
                media += a;
            }
            return media / this.notas.size();
        }

    }

    public boolean mediaAprovado() {
        int contador = 0;
        double media = 0;
        for (int i = 0; i < this.alumnos.size() ; i++) {
            if (notas.get(i) >= 5) {
                contador += 1;
                media += notas.get(i);
            }
        }
        return media / contador >= 5;
    }

    public List<String> getAprobados() {
        List<String> aprobados = new ArrayList<>();
        for (int i = 0; i < this.alumnos.size() ; i++) {
            if (notas.get(i) >= 5) {
                aprobados.add(this.alumnos.get(i));
            }
        }
        return aprobados;
    }

    //METODOS
    public void añadirNota(String alumno, double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException();
        } else {
            this.alumnos.add(alumno);
            this.notas.add(nota);
        }
    }
}
