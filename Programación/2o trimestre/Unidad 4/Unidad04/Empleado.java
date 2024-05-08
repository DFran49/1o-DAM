import java.util.ArrayList;
import java.util.List;

public record Empleado(String nombre, List<Empleado> subordinado) {
    //CONSTRUCTORES//
    public Empleado(String nombre) {
        this(nombre,new ArrayList<>());
    }

    public void mostrarSubordinados() {
        System.out.println(nombre);
        mostrarSubordinados(1);
    }

    private void mostrarSubordinados(int tabs) {
        for (int i = 0; i < subordinado.size() ; i++) {
            System.out.println("-".repeat(tabs)+subordinado.get(i).nombre);
            if (!subordinado.get(i).subordinado.isEmpty()) {
                subordinado.get(i).mostrarSubordinados(tabs+1);
            }
        }
    }
}
