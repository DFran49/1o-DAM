public class Ejercicio35 {
    public static void main(String[] args) {
        int IngJan = 15000;
        int IngFeb = 16000;
        int IngMar = 10000;
        int IngApr = 9000;
        int IngMay = 12000;
        int IngJun = 13000;
        int IngJul = 7000;
        int IngAug = 6000;
        int IngSep = 11000;
        int IngOct = 13000;
        int IngNov = 14000;
        int IngDec = 15000;

        int SpndJan = 8000;
        int SpndFeb = 9000;
        int SpndMar = 11000;
        int SpndApr = 10000;
        int SpndMay = 12000;
        int SpndJun = 10000;
        int SpndJul = 9000;
        int SpndAug = 8000;
        int SpndSep = 9000;
        int SpndOct = 9000;
        int SpndNov = 12000;
        int SpndDec = 14000;

        boolean BenPosJan = IngJan>=SpndJan;
        boolean BenPosFeb = IngFeb>=SpndFeb;
        boolean BenPosMar = IngMar>=SpndMar;
        boolean BenPosApr = IngApr>=SpndApr;
        boolean BenPosMay = IngMay>=SpndMay;
        boolean BenPosJun = IngJun>=SpndJun;
        boolean BenPosJul = IngJul>=SpndJul;
        boolean BenPosAug = IngAug>=SpndAug;
        boolean BenPosSep = IngSep>=SpndSep;
        boolean BenPosOct = IngOct>=SpndOct;
        boolean BenPosNov = IngNov>=SpndNov;
        boolean BenPosDec = IngDec>=SpndDec;

        System.out.println("El balance de Enero es positivo"+BenPosJan);
        System.out.println("El balance de Febrero es positivo"+BenPosFeb);
        System.out.println("El balance de Marzo es positivo"+BenPosMar);
        System.out.println("El balance de Abril es positivo"+BenPosApr);
        System.out.println("El balance de Mayo es positivo"+BenPosMay);
        System.out.println("El balance de Junio es positivo"+BenPosJun);
        System.out.println("El balance de Julio es positivo"+BenPosJul);
        System.out.println("El balance de Agosto es positivo"+BenPosAug);
        System.out.println("El balance de Septiembre es positivo"+BenPosSep);
        System.out.println("El balance de Octubre es positivo"+BenPosOct);
        System.out.println("El balance de Noviembre es positivo"+BenPosNov);
        System.out.println("El balance de Diciembre es positivo"+BenPosDec);


    }
}
