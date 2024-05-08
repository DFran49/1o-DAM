public class Ejercicio36 {
    public static void main(String[] args) {
        int beneficios[] = {15000,16000,10000,9000,12000,13000,7000,6000,11000,13000,14000,15000};

        int gastos[] = {8000,9000,11000,10000,12000,10000,9000,8000,9000,9000,12000,14000};
        String meses[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

        for (int i=0;i<beneficios.length;i++){
            System.out.println("El balance de gastos de "+meses[i]+" es: "+(beneficios[(i)]-gastos[i]));
        };
        int mediaGastos = 0;
        int mediaBeneficios = 0;
        for (int i=0;i<beneficios.length;i++){
            mediaBeneficios += beneficios[i];
            mediaGastos += gastos[i];
        };
        mediaBeneficios /= 12;
        mediaGastos /= 12;

        System.out.println("La media de beneficios es: "+mediaBeneficios);
        System.out.println("La media de gastos es: "+mediaGastos);

        boolean AnualPositivo = mediaBeneficios>=mediaGastos;
        System.out.println("La media anual es: "+(mediaBeneficios-mediaGastos));
        System.out.println("El balance es positivo: "+AnualPositivo);

    }
}
