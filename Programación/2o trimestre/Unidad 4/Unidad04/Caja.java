public class Caja {
    private boolean abierto;
    private String mensaje;
    public Caja(boolean a, String n) {
        this.abierto = a;
        this.mensaje = n;
    }

    public Caja(String n) {
        this(false,n);
    }

    public Caja() {
        this(false,"Viva el tema 4");
    }

    public void setMensaje(String m) {
        this.mensaje = m;
    }
    public void pasarMayusculas() {
        this.mensaje = this.mensaje.toUpperCase();
    }
    public void abrir() {
        this.abierto = true;
    }
    public void cerrar() {
        this.abierto = false;
    }
    public boolean esAbierta() {
        return this.abierto;
    }
    public String getMensaje() {
        return this.mensaje;
    }
}
