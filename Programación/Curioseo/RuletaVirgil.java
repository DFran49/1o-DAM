import java.util.Scanner;

public class RuletaVirgil {
        public static void main(String[] args) throws InterruptedException {

            // Creamos scanner
            Scanner sc = new Scanner(System.in);

            // Instrucciones del juego
            System.out.println("Vamos a jugar a la ruleta rusa\n");
            System.out.println("Se acaba de cargar el revolver con 1 bala en una de sus 6 cámaras");

            // Variable de los turnos
            int turno = 1;

            // Variable con vida del jugador
            boolean jugadorconvida = true;

            // Variable con vida de la maquina
            boolean maquinaconvida = true;

            // Variable de la bala
            int bala = (int) (Math.random() * 6 + 1);
            System.out.println(bala);

            // Variable de decision
            int decision = 0;

            // Logica de la ruleta
            while (jugadorconvida && maquinaconvida) {
                do {
                    System.out.println("Turno del jugador 1:\n");
                    System.out.println("------\n 1. Dispararte \n\n 2. Disparar a la maquina\n ------");

                    // Verificar si la entrada es un entero
                    while (!sc.hasNextInt()) {
                        System.out.println("Por favor, ingresa un número entero.");
                        sc.next(); // Limpiar el búfer de entrada
                        System.out.println("Turno del jugador 1:\n");
                        System.out.println("------\n 1. Dispararte \n\n 2. Disparar a la maquina\n ------");
                    }

                    decision = sc.nextInt();

                    if (decision != 1 && decision != 2) {
                        System.out.println("Por favor, elige 1 o 2.");
                    }

                } while (decision != 1 && decision != 2);


                // Decision 1, jugador se dispara
                if (decision == 1) {
                    if (turno == bala) {
                        jugadorconvida = false;
                        System.out.println("\nEl jugador acaba de morir porque se ha disparado la bala. Perdiste\n\n");
                        // Pausa antes del siguiente turno
                        Thread.sleep(3000);
                    } else {
                        System.out.println("\nEl jugador se dispara y sigue vivo porque la camara esta vacia\n\n");
                        // Pausa antes del siguiente turno
                        Thread.sleep(3000);
                    }
                }

                // Decision 2, el jugador dispara a la maquina
                if (decision == 2) {
                    if (turno == bala) {
                        maquinaconvida = false;
                        System.out.println("\nEl jugador acaba de disparar la bala a la maquina. Has ganado\n\n");
                        // Pausa antes del siguiente turno
                        Thread.sleep(3000);
                    } else {
                        System.out.println("\nLa maquina sigue viva porque la camara esta vacia\n\n");
                        // Pausa antes del siguiente turno
                        Thread.sleep(3000);
                    }

                    // Al haber tomado esa decision, toca dispararse
                    System.out.println("\nAl haber disparado a la maquina, toca que te dispares\n");
                    if (turno == bala) {
                        jugadorconvida = false;
                        System.out.println("\nEl jugador acaba de morir porque se ha disparado la bala. Perdiste\n\n");
                        // Pausa antes del siguiente turno
                        Thread.sleep(3000);
                    } else {
                        System.out.println("\nEl jugador se dispara y sigue vivo porque la camara esta vacia\n\n");
                        // Pausa antes del siguiente turno
                        Thread.sleep(3000);
                    }

                }

                // Siguiente turno
                turno++;

                if (jugadorconvida && maquinaconvida) {
                    System.out.println("Turno de la maquina:\n\n");
                    decision = (int) (Math.random() * 2 + 1);

                    // Decision 1, la maquina se dispara
                    if (decision == 1) {
                        if (turno == bala) {
                            maquinaconvida = false;
                            System.out.println("\nLa maquina acaba de morir porque se ha disparado la bala. Has ganado\n\n");
                            // Pausa antes del siguiente turno
                            Thread.sleep(3000);
                        } else {
                            System.out.println("\nLa maquina sigue viva porque al dispararse la camara esta vacia\n\n");
                            // Pausa antes del siguiente turno
                            Thread.sleep(3000);
                        }
                    }

                    // Decision 2, la maquina dispara al jugador
                    if (decision == 2) {
                        if (turno == bala) {
                            jugadorconvida = false;
                            System.out.println("\nLa maquina acaba de disparar la bala al jugador. Has perdido\n\n");
                            // Pausa antes del siguiente turno
                            Thread.sleep(3000);
                        } else {
                            System.out.println("\nLa maquina dispara al jugador, y el jugador sigue vivo porque la camara esta vacia\n\n");
                            // Pausa antes del siguiente turno
                            Thread.sleep(3000);
                        }

                        if (jugadorconvida == true) {
                            // Al haber tomado esa decision, toca dispararse
                            System.out.println("\nTurno de la maquina \n");
                            if (turno == bala) {
                                maquinaconvida = false;
                                System.out.println("\nLa maquina acaba de morir porque se ha disparado la bala. Has ganado\n\n");
                                // Pausa antes del siguiente turno
                                Thread.sleep(3000);
                            } else {
                                System.out.println("\nLa maquina se dispara y sigue viva porque la camara esta vacia\n\n");
                                // Pausa antes del siguiente turno
                                Thread.sleep(3000);
                            }
                        }
                    }
                }
            }
        }
    }

