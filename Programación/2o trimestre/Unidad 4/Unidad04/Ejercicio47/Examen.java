package Ejercicio47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Examen {
    //PROPIEDADES
    private Map<String, Double> notas;

    //CONSTRUCTOR
    public Examen() {
        this.notas = new HashMap<>();
    }

    //GETTERS
    public double getNota(String alumno) {
        return notas.get(alumno);
    }

    public double getNotaMedia() {
        if (notas.isEmpty()) {
            throw new IllegalStateException();
        } else {
            double media = 0;
            List<Double> nota = new ArrayList<>(this.notas.values());
            for (int i = 0; i < nota.size() ; i++) {
                media += nota.get(i);
            }
            return media / nota.size();
        }

    }

    public boolean mediaAprovado() {
        double media = 0;
        int contador = 0;
        List<Double> nota = new ArrayList<>(this.notas.values());
        for (int i = 0; i < nota.size() ; i++) {
            if (nota.get(i) >=5) {
                media += nota.get(i);
                contador++;
            }
        }
        return media/contador >=5;
    }

    public List<String> getAprobados() {
        List<String> alumnos = new ArrayList<>();
        for (String alumno:notas.keySet()) {
            if (notas.get(alumno) >= 5) {
                alumnos.add(alumno);
            }
        }
        return alumnos;
    }

    //METODOS
    public void añadirNota(String alumno, double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException();
        } else {
            this.notas.put(alumno,nota);
        }
    }
}
