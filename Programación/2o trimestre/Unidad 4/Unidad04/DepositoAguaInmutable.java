public record DepositoAguaInmutable(int capacidadActual, int capacidadMaxima) {
    public DepositoAguaInmutable {
        if (capacidadActual<0 || capacidadMaxima<=capacidadActual){
            throw new IllegalArgumentException("La capacidad actual debe ser 0 o más y la capacidad máxima debe ser mayor o igual a la actual");
        }
    }

    public DepositoAguaInmutable(int capacidadMaxima) {
        this(0,capacidadMaxima);
        if (capacidadMaxima>0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor a 0");
        }
    }

    public DepositoAguaInmutable añadirLitro() {
        return new DepositoAguaInmutable(this.capacidadActual+1,this.capacidadMaxima);
    }

    public DepositoAguaInmutable retirarLitro() {
        return new DepositoAguaInmutable(this.capacidadActual-1,this.capacidadMaxima);
    }

    public int getPorcentaje() {
        return ((this.capacidadActual*100)/this.capacidadMaxima);
    }
}
