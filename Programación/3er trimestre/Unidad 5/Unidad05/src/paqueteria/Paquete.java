package paqueteria;

import java.util.Objects;

public class Paquete implements Comparable<Paquete>{
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    public static final int ALTA = 1;
    public static final int MEDIA = 2;
    public static final int BAJA = 3;
    private String producto;
    private String direccionDestino;
    private int prioridad;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public Paquete(String pro, String dd, int pri) {
        if (pri != ALTA && pri != MEDIA && pri != BAJA)
            throw new IllegalArgumentException("El nivel de prioridad indicado no es válido");
        this.producto = pro;
        this.direccionDestino = dd;
        this.prioridad = pri;
    }

    //------------------------------------------------------------------------------------------------------------------
    //GETTERS
    public String getProducto() {
        return producto;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public int getPrioridad() {
        return prioridad;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS OVERRIDE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paquete paquete = (Paquete) o;
        return Objects.equals(this.producto, paquete.getProducto()) && Objects.equals(this.direccionDestino, paquete.getDireccionDestino());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.producto, this.direccionDestino);
    }

    @Override
    public int compareTo(Paquete P) {
        return this.prioridad - P.prioridad;
    }
}
