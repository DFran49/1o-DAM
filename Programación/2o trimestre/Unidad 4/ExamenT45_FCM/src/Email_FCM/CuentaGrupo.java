package Email_FCM;

import java.util.ArrayList;
import java.util.List;

public class CuentaGrupo {
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private String nombre;
    private List<CuentaPersonal> miembros;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTORES
    public CuentaGrupo(String nombre) {
        this(nombre, new ArrayList<>());
    }

    public CuentaGrupo(String nombre, List<CuentaPersonal> miembros) {
        this.nombre = nombre;
        this.miembros = miembros;
    }

    //------------------------------------------------------------------------------------------------------------------
    //GETTER
    public List<CuentaPersonal> getMiembros() {
        return this.miembros;
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    public void add(CuentaPersonal cuenta) {
        this.miembros.add(cuenta);
    }

    public void add(CuentaGrupo grupo) {
        this.miembros.addAll(grupo.miembros);
    }
}
