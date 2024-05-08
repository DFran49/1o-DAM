import TiempoFCM.SemanaFCM;

public class MainTiempoFCM {
    public static void main(String[] args) {
        SemanaFCM miSemana = new SemanaFCM();
        miSemana.setTemperaturaFCM(2,5);
        miSemana.setTemperaturaFCM(5,27);
        try {
            miSemana.setTemperaturaFCM(9,12);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        miSemana.resumenFCM("resumenFCM.txt");
    }
}
