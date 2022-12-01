public class Maquina {

    private String maquina;
    private String comando;

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina != null ? maquina : "";
    }

    public String getComando() {

        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando != null ? comando : "";
    }

    @Override
    public String toString() {
        return "Maquina: " + getMaquina() + "\nComando: " + getComando();
    }

}