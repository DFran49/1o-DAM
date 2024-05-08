import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Ej2_FCM {
    /*
    Realiza un programa que pregunte por teclado la fecha de salida (día, mes y año) y la
    fecha de vuelta (día, mes y año), También preguntará el numero de plazas a reservar.
    El programa deberá comprobar que los datos leídos sean válidos (1-31,1-12,>=2023) y
    plazas (1-10). Si alguno de los datos no es válido se informará del error y el programa
    acabará.
    • En segundo lugar creará los objetos LocalDate y se comprobará que la fecha se salida
    es posterior a hoy y que la fecha de vuelta es posterior a la de ida (usando métodos de
    la clase). Si no se cumple alguna de estas condiciones el programa informará del error
    y acabará.
    • Si todo es correcto el programa simulará la comprobación de plazas libres del tren
    generando 2 números aleatorios entre 0 y 50, uno para la ida y otro para la vuelta.
    Comprobará que el numero de plazas solicitadas es inferior a las disponibles para
    ambos trayectos. Si en alguno de ellos no hay plazas suficientes informará de ello y el
    programa finalizará.
    • Si hay plazas disponibles generará 1 archivos de texto con el nombre “reservafechaIda.txt” donde fecha es la fecha de ida del viaje. Que contenga lo siguiente:
    ----------------------------------
    Reserva Tren
    TuNombreCompleto
    ---------------------------------
    Fecha Ida: “dd-mm-yyyy”
    Fecha Vuelta: “dd-mm-yyyy”
    Número de plazas: plazas
    Ejemplo:
    ---------------------------------
    Reserva Tren
    Alberto Zagalaz Anula
    ---------------------------------
    Fecha Ida: “14-12-2023”
    Fecha Vuelta: “06-01-2024”
    Número de plazas: 3
     */
    public static void main(String[] args) {
        System.out.println("Introduzca la fecha de salida");
        System.out.println("Introduzca el día");
        int DiaSalida = new Scanner(System.in).nextInt();
        System.out.println("Introduzca el mes");
        int MesSalida = new Scanner(System.in).nextInt();
        System.out.println("Introduzca el año");
        int AñoSalida = new Scanner(System.in).nextInt();
        System.out.println("Introduzca la fecha de vuelta");
        System.out.println("Introduzca el día");
        int DiaVuelta = new Scanner(System.in).nextInt();
        System.out.println("Introduzca el mes");
        int MesVuelta = new Scanner(System.in).nextInt();
        System.out.println("Introduzca el año");
        int AñoVuelta = new Scanner(System.in).nextInt();
        System.out.println("Introduzca las plazas que desea reservar");
        int PlazasAReservar = new Scanner(System.in).nextInt();
        boolean SalidaBien;
        boolean VueltaBien;
        boolean PlazasBien;
        if ((DiaSalida<=31&&DiaSalida>=1)&&(MesSalida<=12&&MesSalida>=1)&&AñoSalida>=2023) {
            SalidaBien = true;
        } else {
            SalidaBien = false;
            System.out.println("No ha introducido bien la fecha de salida, inténtelo de nuevo");
        }
        if ((DiaVuelta<=31&&DiaVuelta>=1)&&(MesVuelta<=12&&MesVuelta>=1)&&AñoVuelta>=2023) {
            VueltaBien = true;
        } else {
            VueltaBien = false;
            System.out.println("No ha introducido bien la fecha de vuelta, inténtelo de nuevo");
        }
        if (PlazasAReservar>=1&&PlazasAReservar<=10) {
            PlazasBien = true;
        } else {
            PlazasBien = false;
            System.out.println("La cantidad de plazas a reservar debe estar entre 1 y 10");
        }
        if (SalidaBien&&VueltaBien&&PlazasBien) {
            LocalDate DateSalida = LocalDate.of(AñoSalida,MesSalida,DiaSalida);
            LocalDate DateVuelta = LocalDate.of(AñoVuelta,MesVuelta,DiaVuelta);
            if (DateSalida.isBefore(LocalDate.now())||DateSalida.isEqual(LocalDate.now())) {
                System.out.println("La fecha de salida tiene que ser posterior a hoy");
            } else {
                if (DateVuelta.isBefore(DateSalida)||DateVuelta.isEqual(DateSalida)) {
                    System.out.println("La fecha de vuelta debe de ser posterior a la fecha de salida");
                } else if (DateVuelta.isAfter(DateSalida)) {
                    Random Aleatorio = new Random();
                    int PlazasIda = Aleatorio.nextInt(50);
                    int PlazasVuelta = Aleatorio.nextInt(50);
                    System.out.println(PlazasIda);
                    System.out.println(PlazasVuelta);
                    if (PlazasIda<PlazasAReservar||PlazasVuelta<PlazasAReservar) {
                        System.out.println("Lo lamentamos, no quedan suficientes plazas en la ida y/o en la vuelta");
                    } else {
                        String Ruta = "reservafechaIda.txt";
                        try {
                            PrintWriter ArchivoEscribe = new PrintWriter(Ruta);
                            ArchivoEscribe.println("----------------------------------\n" +
                                    "    Reserva Tren\n" +
                                    "    Francisco Crespo Martín\n" +
                                    "    ---------------------------------\n" +
                                    "    Fecha Ida: "+DateSalida+"\n" +
                                    "    Fecha Vuelta: "+DateVuelta+"\n" +
                                    "    Número de plazas: "+PlazasAReservar+"\n" +
                                    "    ---------------------------------");
                            ArchivoEscribe.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("El archivo no se encuentra");;
                        }
                    }
                }
            }

        }
    }
}
