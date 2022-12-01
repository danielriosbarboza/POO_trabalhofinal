public class Passos extends Maquina {

    private int locationsteps;
    private String[] steps = new String[100];
    private String[] armazenamento = new String[100];

    public int getLocationSteps() {

        return locationsteps;
    }

    public void setLocationSteps(int locationsteps) {
        this.locationsteps = locationsteps;
    }

    public String getSteps() {
        return "\n  Passo" + (locationsteps + 1) + ": " + steps[locationsteps];
    }

    public void setSteps(String steps) {
        this.steps[locationsteps] = steps != null ? steps : "";

    }

    public String getArmazenamento() {
        return armazenamento[this.getLocationSteps()];
    }

    public void setArmazenamento(String armazenamento) {
        this.armazenamento[this.getLocationSteps()] = armazenamento;
    }

    @Override
    public String toString() {
        return "Maquina: " + getMaquina() + "\nComando: " + getComando() + "\nPassos:";
    }
}