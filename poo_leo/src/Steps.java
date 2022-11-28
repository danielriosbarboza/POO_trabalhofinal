public class Steps extends Maquina {

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

        return steps[locationsteps];
    }

    public void setSteps(String steps) {

        this.steps[locationsteps] = steps;

    }

    public String getArmazenamento() {

        return armazenamento[locationsteps];
    }

    public void setArmazenamento(String armazenamento) {

        this.armazenamento[locationsteps] = armazenamento;

    }

    @Override
    public String toString() {
        return "Maquina: " + getMaquina() + "\n Comando: " + getComando();
    }

    public String toString2() {
        return "Passo" + getLocationSteps() + ": " + getSteps();
    }
}
