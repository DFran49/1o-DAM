package Ejercicios42_45;

public enum TipoCanasta {
    //CONSTANTES
    TIRO_LIBRE {
        @Override
        public int getValor() {
            return 1;
        }
    },
    CANASTA_NORMAL {
        @Override
        public int getValor() {
            return 2;
        }
    },
    TRIPLE {
        @Override
        public int getValor() {
            return 3;
        }
    };

    //METODOS ABSTRACTOS
    public abstract int getValor();
}
