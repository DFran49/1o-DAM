package com.ieshlanz.titulos.clases;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class CatalogoTitulosArchivos implements CatalogoTitulos {
    //------------------------------------------------------------------------------------------------------------------
    //ATRIBUTOS
    private String ruta;
    private List<Titulo> titulos;

    //------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    CatalogoTitulosArchivos(String ruta) {
        this.titulos = new ArrayList<>();
        File archivo = new File(ruta);
        if (archivo.exists()) {
            try {
                this.ruta = ruta;
                BufferedReader leer = new BufferedReader(new FileReader(ruta));
                boolean controlador = true;
                while (controlador) {
                    String tituloGuardar = leer.readLine();
                    if (tituloGuardar == null) {
                        leer.close();
                        controlador = false;
                    } else {
                        this.titulos.add(extraerTitulo(tituloGuardar));
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("No se ha encontrado el archivo "+ruta);
            } catch (IOException e) {
                System.err.println("Error en la lectura");
            }
        } else {
            try {
                this.ruta = ruta;
                archivo.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("No se ha podido crear el archivo "+ruta);
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS
    static Titulo extraerTitulo(String linea) {
        StringTokenizer trozos = new StringTokenizer(linea,";");
        String dni = trozos.nextToken();
        String nombre = trozos.nextToken();
        String estudios = trozos.nextToken();
        String est = trozos.nextToken();
        Estado estado = null;
        if (est.equals("0")) {
            estado = Estado.SIN_RECIBIR;
        } else if (est.equals("1")) {
            estado = Estado.RECIBIDO;
        } else if (est.equals("2")) {
            estado = Estado.RECOGIDO;
        }

        return new TituloArchivo(dni,nombre,estudios,estado);
    }

    //------------------------------------------------------------------------------------------------------------------
    //METODOS IMPLEMENTADOS
    @Override
    public List<Titulo> getTitulos() {
        return Collections.unmodifiableList(this.titulos);
    }

    @Override
    public boolean guardar() {
        try {
            FileWriter escribir = new FileWriter(this.ruta,false);
            for (int i = 0; i < this.titulos.size() ; i++) {
                escribir.write(this.titulos.get(i).toString()+"\n");
            }
            escribir.close();
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo para guardar");
            return false;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean añadirTitulo(String dni, String nombre, String estudios, Estado estado) {
        TituloArchivo nuevoTitulo = new TituloArchivo(dni, nombre, estudios, estado);
        return this.titulos.add(nuevoTitulo);
    }
}
