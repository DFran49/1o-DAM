package com.ieshlanz.titulos.programa;

import com.ieshlanz.titulos.clases.*;

import java.util.List;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        CatalogoTitulos cat = CatalogoTitulosFactory.getCatalogoTitulos(TipoCatalogo.ARCHIVO);
        int tecla = 0;
        while (tecla != 4) {
            System.out.println("1. Añadir título\n" +
                    "2. Consultar todos los títulos\n" +
                    "3. Cambiar estado del título\n" +
                    "4. Salir");
            tecla = new Scanner(System.in).nextInt();
            switch (tecla) {
                case 1 -> {
                    System.out.println("Introduzca un DNI");
                    String dni = new Scanner(System.in).nextLine();
                    System.out.println("Introduzca un nombre");
                    String nombre = new Scanner(System.in).nextLine();
                    System.out.println("Introduzca unos estudios");
                    String estudios = new Scanner(System.in).nextLine();
                    System.out.println("Introduzca un estado (0 - SIN_RECIBIR, 1 - RECIBIDO, 2 - RECOGIDO)");
                    int estado = new Scanner(System.in).nextInt();
                    Estado[] estados = Estado.values();
                    cat.añadirTitulo(dni, nombre, estudios, estados[estado]);
                }
                case 2 -> {
                    List<Titulo> titulos = cat.getTitulos();
                    for (int i = 0; i < titulos.size() ; i++) {
                        System.out.println(titulos.get(i).toString());
                    }
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Introduzca un DNI");
                    String dni = new Scanner(System.in).nextLine();
                    if (cat.getTitulo(dni) != null) {
                        System.out.println("Introduzca el nuevo estado para el título (0 - SIN_RECIBIR, 1 - RECIBIDO, 2 - RECOGIDO)");
                        int est = new Scanner(System.in).nextInt();
                        if (est == 0) {
                            cat.getTitulo(dni).setEstado(Estado.SIN_RECIBIR);
                        } else if (est == 1) {
                            cat.getTitulo(dni).setEstado(Estado.RECIBIDO);
                        } else if (est == 2) {
                            cat.getTitulo(dni).setEstado(Estado.RECOGIDO);
                        }
                    }
                }
                case 4 -> cat.guardar();
            }
        }
    }
}
