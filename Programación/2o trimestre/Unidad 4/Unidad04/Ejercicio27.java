public class Ejercicio27 {
    public static void main(String[] args) {
        Oficina[] Oficinas = {Oficina.getOficinaVacia(), Oficina.getOficinaPequeña(), Oficina.getOficinaMediana(), Oficina.getOficinaGrande()};
        for (int i = 0; i < Oficinas.length ; i++) {
            System.out.println(i+" "+Oficinas[i].getTotalEmpleados());
        }
    }
}
