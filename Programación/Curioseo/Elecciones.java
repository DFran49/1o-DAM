import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Elecciones {
    static int Asistencia;
    public static void AlumnAsis() {
        System.out.println("Introduzca cuantos alumnos han asistido hoy:");
        Asistencia = new Scanner(System.in).nextInt();
    }

    static ArrayList<String> Candidatos = new ArrayList<String>();
    public static void EleccionCandidatos(){
        System.out.println("Introduzca el número de candidatos:");
        int TempCandidatos = new Scanner(System.in).nextInt();
        for(int i=1;i<=TempCandidatos;i++){
            System.out.println("Introduzca el candidato "+i);
            Candidatos.add(new Scanner(System.in).nextLine());
        }
    }

    static int[] Votos;
    public static void Votacion(){
        String Voto;
        Votos = new int[Candidatos.size()];
        String Ganador;
        boolean VotoCorrecto = false;
        boolean noTerminar=true;
        int PosVoto = 0;
        for(int i = 0; i< Candidatos.size();i++){
            Votos[i]=0;
        }
        for(int i=0;i<Asistencia;i++){
            System.out.println("Los candidatos son:");
            for(int x=0;x<Candidatos.size();x++){
                System.out.println(Candidatos.get(x));
            }
            System.out.println("\n Introduzca su voto:");
            Voto = new Scanner(System.in).nextLine();
            noTerminar = true;
            while(noTerminar!=false){
                for(int z=0;z<Candidatos.size();z++){
                    if(Voto.equals(Candidatos.get(z))){
                        noTerminar = false;
                        VotoCorrecto=true;
                        PosVoto = z;
                    }
                }
                if(VotoCorrecto==true){
                    System.out.println("Tu voto es correcto.");
                    Votos[PosVoto] = Votos[PosVoto]+1;
                    VotoCorrecto=false;
                } else {
                    System.out.println("No ha introducido un nombre correcto, inténtelo de nuevo.");
                    Voto = new Scanner(System.in).nextLine();
                }
            }

            System.out.println("Puede pasar el siguiente votante.");
            if(i!=Asistencia-1){
                System.out.println("¿Ha llegado ya el siguiente votante?");
                String Pregunta = new Scanner(System.in).nextLine();
            }


        }
        for(int i=0;i< Candidatos.size();i++){
            System.out.println("El candidato "+Candidatos.get(i)+" tiene "+Votos[i]+" votos.");
        }
    }

    public static void main(String[] args) {
        AlumnAsis();
        EleccionCandidatos();
        Votacion();
    }
}
