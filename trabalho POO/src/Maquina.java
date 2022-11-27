public class Maquina {

    private String maquina;
    private String comando;


    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getComando (){

        return comando;
    }
        
    public void setComando (String comando){
        this.comando = comando;
    }

    @Override
    public String toString() {
        return "\n Maquina: " + getMaquina() + "\n Comando: " + getComando();
    }   
}