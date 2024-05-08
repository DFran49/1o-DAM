package Email_FCM;

import org.apache.commons.validator.routines.EmailValidator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CuentaPersonal implements ReceptorCorreo,EnviadorCorreo {
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private String direccion;
    private List<Mensaje> buzon;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public CuentaPersonal(String direccion) {
        if (!validarDireccion(direccion)) {
            throw new IllegalArgumentException("La dirección " + direccion +" es incorrecta");
        }
        this.direccion = direccion;
        this.buzon = new ArrayList<>();
    }

    //------------------------------------------------------------------------------------------------------------------
    //GETTERS
    public List<Mensaje> getMensajes() {
        return this.buzon;
    }

    public List<Mensaje> getMensajes(boolean estado) {
        List<Mensaje> devolver = new ArrayList<>();
        for (int i = 0; i < buzon.size() ; i++) {
            if (buzon.get(i).leido() && estado) {
                devolver.add(buzon.get(i));
            } else if (!buzon.get(i).leido() && !estado) {
                devolver.add(buzon.get(i));
            }
        }
        return devolver;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    private static boolean validarDireccion(String direccion) {
        return EmailValidator.getInstance().isValid(direccion);
    }

    public int leer() {
        int contador = 0;
        for (int i = 0; i < buzon.size() ; i++) {
            if (!this.buzon.get(i).leido()) {
                this.buzon.set(i,this.buzon.get(i).leer());
                contador++;
            }
        }
        return contador;
    }

    public boolean guardarMensajes(String ruta) {
        File archivo = new File(ruta);
        try {
            PrintWriter escritor = new PrintWriter(new PrintWriter(archivo) ,true);
            for (int i = 0; i < this.buzon.size() ; i++) {
                escritor.println(this.buzon.get(i).getLineaCSV());
            }
            escritor.close();
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo");
            return false;
        }
    }

    public void cargarMensajes(String ruta) throws IOException {
        FileReader usoLector = new FileReader(ruta);
        BufferedReader lector = new BufferedReader(usoLector);
        String cadena = cadena = lector.readLine();
        while (cadena != null) {
            StringTokenizer trozos = new StringTokenizer(cadena,";");
            String remitente = trozos.nextToken();
            String mensaje = trozos.nextToken();
            boolean leido = trozos.nextToken().equals("true");
            Formato[] tipos = Formato.values();
            Formato tipo = tipos[Integer.parseInt(trozos.nextToken())];
            recibirMensaje(new Mensaje(remitente,mensaje,leido,tipo));
            cadena = lector.readLine();
        }
        lector.close();
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS IMPLEMENTADOS

    @Override
    public String getDireccionCorreo() {
        return this.direccion;
    }

    @Override
    public String getNombre() {
        return this.direccion.substring(0,getDireccionCorreo().indexOf("@"));
    }

    @Override
    public void recibirMensaje(Mensaje e) {
        this.buzon.add(e);
    }
}
