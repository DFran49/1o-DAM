package Email_FCM;

public enum Formato {
    //------------------------------------------------------------------------------------------------------------------
    //VALORES
    TEXTO,HTML,JSON,XML,MD,YAML;

    //------------------------------------------------------------------------------------------------------------------
    //METODO
    public boolean humanReadable() {
        return this.equals(TEXTO) || this.equals(MD) || this.equals(YAML);
    }
}
