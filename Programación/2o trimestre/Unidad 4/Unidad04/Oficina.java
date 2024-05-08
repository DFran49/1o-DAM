import Persona.DNI;
import Persona.Persona;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Oficina {
    //PARAMETROS//
    private String nombre;
    private ArrayList<Persona> trabajadores;

    //CONSTRUCTORES//
    private Oficina(String nombre) {
        this.nombre = nombre;
        this.trabajadores = new ArrayList<>();
    }

    private Oficina(String nombre, int tipo) {
        this.nombre = nombre;
        if (tipo < 1 || tipo > 3) {
            this.trabajadores = new ArrayList<>();
        } else {
            if (tipo == 1) {
                this.trabajadores = new ArrayList<>();
                this.trabajadores.add(new Persona("António Pérez Pérez",new DNI("11111111H"),900, LocalDate.of(2000,2,28)));
            }
            if (tipo == 2) {
                this.trabajadores = new ArrayList<>();
                this.trabajadores.add(new Persona("António Pérez Pérez",new DNI("11111111H"),900, LocalDate.of(2000,2,28)));
                this.trabajadores.add(new Persona("Luis López López",new DNI("22222222J"),1000, LocalDate.of(1995,9,10)));
            }
            if (tipo == 3) {
                this.trabajadores = new ArrayList<>();
                this.trabajadores.add(new Persona("António Pérez Pérez",new DNI("11111111H"),900, LocalDate.of(2000,2,28)));
                this.trabajadores.add(new Persona("Luis López López",new DNI("22222222J"),1000, LocalDate.of(1995,9,10)));
                this.trabajadores.add(new Persona("Ana Díaz Díaz",new DNI("33333333P "),1200, LocalDate.of(1985,5,21)));
            }
        }
    }

    private Oficina() {
        this.nombre = "Industrias DAW";
        this.trabajadores = new ArrayList<>();
        this.trabajadores.add(new Persona("António Pérez Pérez",new DNI("11111111H"),900, LocalDate.of(2000,2,28)));
        this.trabajadores.add(new Persona("Luis López López",new DNI("22222222J"),1000, LocalDate.of(1995,9,10)));
        this.trabajadores.add(new Persona("Ana Díaz Díaz",new DNI("33333333P "),1200, LocalDate.of(1985,5,21)));
    }

    public void añadirEmpleado(Persona p) {
        this.trabajadores.add(p);
    }
    public void añadirEmpleado(String nombre, String DNI, double sueldo, LocalDate fechaNac) {
        this.trabajadores.add(new Persona(nombre,new DNI(DNI),sueldo,fechaNac));
    }

    //GETTERS//
    public int getTotalEmpleados() {
        return this.trabajadores.size();
    }
    public int getTotalEmpleadosMileuristas() {
        int mileuristas = 0;
        for (int i = 0; i < this.trabajadores.size() ; i++) {
            if (this.trabajadores.get(i).esMileurista()) {
                mileuristas++;
            }
        }
        return mileuristas;
    }
    public List<Persona> getMileuristas() {
        List<Persona> Mileuristas = new ArrayList<>();
        for (int i = 0; i < this.trabajadores.size() ; i++) {
            if (this.trabajadores.get(i).esMileurista()) {
                Mileuristas.add(this.trabajadores.get(i));
            }
        }
        return Mileuristas;
    }
    public double getSueldoMedio() throws IOException {
        if (this.trabajadores.size()==0) {
            throw new IOException("La oficina está vacia");
        } else {
            double total = 0;
            for (int i = 0; i < this.trabajadores.size() ; i++) {
                total += this.trabajadores.get(i).getSueldo();
            }
            return total/this.trabajadores.size();
        }
    }

    //METODOS//

    public boolean trabaja(Persona p) {
        return this.trabajadores.contains(p);
    }
    public void pagarEmpleados() {
        for (int i = 0; i < this.trabajadores.size() ; i++) {
            this.trabajadores.get(i).cobrarSueldo();
        }
    }
    public void mostrarInformeEmpleados() {
        String listado = "";
        for (int i = 0; i < this.trabajadores.size() ; i++) {
            listado = listado+this.trabajadores.get(i).getNombre()+" ";
            listado = listado+this.trabajadores.get(i).getSueldo()+" ";
            if (this.trabajadores.get(i).esMileurista()) {
                listado = listado+"Es mileurista";
            } else {
                listado = listado+"No es mileurista";
            }

            listado = listado+"\n";
        }
        System.out.println(listado);
    }
    public static Oficina getOficinaVacia() {
        return new Oficina("Vacia",0);
    }
    public static Oficina getOficinaPequeña() {
        return new Oficina("Pequeña",1);
    }
    public static Oficina getOficinaMediana() {
        return new Oficina("Mediana",2);
    }
    public static Oficina getOficinaGrande() {
        return new Oficina("Grande",3);
    }
}
