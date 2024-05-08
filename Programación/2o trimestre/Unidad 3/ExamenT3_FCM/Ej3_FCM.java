import java.io.*;
import java.util.Scanner;

public class Ej3_FCM {
    public static void main(String[] args) {
        boolean repetir = true;
        int opcion;
        int clave;
        int letra = 0;
        File rutaOrigen;
        File rutaCifrado = new File("cifrado.txt");
        File rutaDescifrado = new File("descifrado.txt");
        PrintWriter eascritor;
        FileInputStream lector;
        FileOutputStream escritor;
        while (repetir) {
            System.out.println("\n----------------------------" +
                    "\nPROGRAMA ENIGMA" +
                    "\n----------------------------" +
                    "\n1. Copiar Fichero" +
                    "\n2. Cifrar Fichero" +
                    "\n3. Descifrar Fichero" +
                    "\n4. Salir\n");
            opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduzca la ruta del fichero a copiar.");
                    rutaOrigen = new File(new Scanner(System.in).nextLine());
                    if (!rutaOrigen.isFile()) {
                        System.out.println("Introduzca la ruta de un fichero existente.");
                    } else {
                        System.out.println("Introduzca el nombre del fichero a crear.");
                        File rutaCopia = new File(new Scanner(System.in).nextLine());
                        try {
                            rutaCopia.createNewFile();
                        } catch (IOException e) {
                            System.err.println("No se ha podido crear el archivo "+rutaCopia.getName());
                        }
                        try {
                            lector = new FileInputStream(rutaOrigen);
                            escritor = new FileOutputStream(rutaCopia);
                            while (letra != -1) {
                                try {
                                    letra = lector.read();
                                    if (letra != -1) {
                                        escritor.write(letra);
                                    }
                                } catch (IOException e) {
                                    System.err.println("No hay información que leer.");
                                }
                            }
                        } catch (FileNotFoundException e) {
                            System.err.println("Archivo no encontrado.");
                        }
                    }

                }
                case 2 -> {
                    System.out.println("Introduzca la ruta del fichero a cifrar.");
                    rutaOrigen = new File(new Scanner(System.in).nextLine());
                    System.out.println("Introduzca la clave de cifrado.");
                    clave = new Scanner(System.in).nextInt();

                    //Este if comprueba que la clave sea mayor a 0
                    if (clave<1) {
                        System.out.println("La clave debe ser mayor a 0.");
                    } else {
                        if (!rutaOrigen.isFile()) {
                            System.out.println("Introduzca la ruta de un fichero existente.");
                        } else {
                            try {
                                rutaCifrado.createNewFile();
                            } catch (IOException e) {
                                System.err.println("No se ha podido crear el archivo "+rutaCifrado.getName());
                            }
                            try {
                                lector = new FileInputStream(rutaOrigen);
                                escritor = new FileOutputStream(rutaCifrado);
                                try {
                                    while (letra != -1) {
                                        letra = lector.read();
                                        if (letra != -1) {
                                            escritor.write(letra + clave);
                                        }
                                    }
                                    letra = 0;
                                    escritor.close();
                                } catch (IOException e) {
                                    System.err.println("No hay información que leer.");
                                }
                            } catch (FileNotFoundException e) {
                                System.err.println("Archivo no encontrado.");
                            }
                        }
                    }
                }

                case 3 -> {
                    System.out.println("Introduzca la ruta del fichero a descifrar.");
                    rutaOrigen = new File(new Scanner(System.in).nextLine());
                    System.out.println("Introduzca la clave de cifrado.");
                    clave = new Scanner(System.in).nextInt();

                    //Este if comprueba que la clave sea mayor a 0
                    if (clave<1) {
                        System.out.println("La clave debe ser mayor a 0.");
                    } else {
                        if (!rutaOrigen.isFile()) {
                            System.out.println("Introduzca la ruta de un fichero existente.");
                        } else {
                            try {
                                rutaDescifrado.createNewFile();
                            } catch (IOException e) {
                                System.err.println("No se ha podido crear el archivo "+rutaDescifrado.getName());
                            }
                            try {
                                lector = new FileInputStream(rutaOrigen);
                                escritor = new FileOutputStream(rutaDescifrado);
                                try {
                                    while (letra != -1) {
                                        letra = lector.read();
                                        if (letra != -1) {
                                            escritor.write(letra - clave);
                                        }
                                    }
                                    escritor.close();
                                } catch (IOException e) {
                                    System.err.println("No hay información que leer.");
                                }
                            } catch (FileNotFoundException e) {
                                System.err.println("Archivo no encontrado.");
                            }
                        }
                    }

                }
                case 4 -> {
                    System.out.println("Gracias por usar nuestro programa.");
                    repetir = false;
                }
            }
        }
    }
}
