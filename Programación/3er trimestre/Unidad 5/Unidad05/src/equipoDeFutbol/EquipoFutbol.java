package equipoDeFutbol;

import java.util.ArrayList;
import java.util.List;

public class EquipoFutbol implements Nombrable{
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private String nombre;
    private List<Empleado> empleados;
    private double presupuesto;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public EquipoFutbol(String n, double p) {
        this.nombre = n;
        this.presupuesto = p;
        this.empleados = new ArrayList<>();
    }

    //------------------------------------------------------------------------------------------------------------------
    //GETTERS
    public List<Empleado> getEmpleados() {
        return this.empleados;
    }

    public double getPresupuesto() {
        return this.presupuesto;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public void addEmpleado(Empleado e) {
        int entrenadores = 0;
        int jugadores = 0;
        for (int i = 0; i < this.empleados.size(); i++) {
            if (this.empleados.get(i) instanceof Entrenador) {
                    entrenadores++;

            } else if (this.empleados.get(i) instanceof Futbolista) {
                jugadores++;
            }
        }
        if (entrenadores > 1) throw new IllegalArgumentException("Solo puede haber 1 entrenador");
        //if (jugadores > 25 || jugadores < 11) throw new IllegalArgumentException("El número de jugadores debe estar entre 11 y 25");
        if (jugadores > 25) throw new IllegalArgumentException("El número de jugadores debe ser menor a 26");
        this.empleados.add(e);
    }

    public void pagarSueldoEmpleados() {
        double aPagar = 0;
        boolean repartir = false;
        for (int i = 0; i < this.empleados.size() ; i++) {
            if (!repartir) {
                if (this.empleados.get(i) instanceof EmpleadoPrimable futbolista && futbolista.esPrimado() && !repartir) {
                    aPagar = (int) (this.empleados.get(i).getSueldo() *1.10);
                } else if (this.presupuesto < this.empleados.get(i).getSueldo() && !repartir) {
                    aPagar = this.presupuesto / (this.empleados.size() - i);
                    repartir = true;
                } else if (!repartir) {
                    aPagar = this.empleados.get(i).getSueldo();
                }
            }

            try {
                this.empleados.get(i).cobrar(aPagar);
            } catch (CabreoException e) {
                System.err.println(e.getMessage());
            }
            this.presupuesto -= aPagar;
            System.out.println(this.presupuesto);
        }

    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS IMPLEMENTADOS
    @Override
    public String getNombre() {
        return this.nombre;
    }
}
