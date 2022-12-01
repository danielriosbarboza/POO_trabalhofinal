import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.awt.Desktop;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Screen {

    Passos machine = new Passos();

    String listString, path, passos, maquina, comando, passo;
    String[] linha = new String[100];
    int i, z = 0, c = 1;
    int quantidade = 80, p = 0;

    @FXML
    private TextField add_message;

    @FXML
    private TextField delete_process;

    @FXML
    private TextField line_change;

    @FXML
    private TextField locale;

    @FXML
    private Label message;

    @FXML
    private TextField name_process;

    @FXML
    private TextField web_search;

    @FXML
    private TextField change;

    @FXML
    void add_button(ActionEvent event) {

        switch (c) {

            case 1:
                maquina = add_message.getText();
                machine.setMaquina(maquina);
                c++;
                add_message.setText("Qual o comando?");
                break;

            case 2:
                comando = add_message.getText();
                machine.setComando(comando);
                c++;
                add_message.setText("Digite a quantidade de passos do comando:");
                break;

            case 3:
                quantidade = Integer.parseInt(add_message.getText());
                c++;
                p = 0;
                add_message.setText("Passo" + (p + 1));
                break;

            case 4:
                passo = add_message.getText();
                machine.setLocationSteps(p);
                machine.setSteps(passo);
                p++;
                add_message.setText("Passo" + (p + 1));
                System.out.println(machine.getSteps());
        }

        if (p == quantidade) {
            c = 1;
            add_message.setText("Aperte o botão (finalizar) para cadastrar");

        }

    }

    @FXML
    void finish_button(ActionEvent event) throws IOException {
        add_message.setText("Digite o nome da Maquina");
        p = 1;
        String location = String.valueOf(p);
        Path path = Path.of("C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/"
                + location + ".txt");
        String way = "C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/" + location
                + ".txt";

        for (int c = 0; c < 100; c++) {
            if (Files.notExists(path)) {
                FileWriter writer = new FileWriter(way, true);
                try {
                    writer.write(machine.toString());
                } catch (Exception erro) {

                }
                for (int x = 0; x < quantidade; x++) {
                    machine.setLocationSteps(x);
                    System.out.println(machine.getSteps());
                    writer.write(machine.getSteps());
                }
                writer.close();
                File file = new File("C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina");
                int count = file.listFiles().length;
                for (int y = 0; y < count; y++) {
                    path = Paths.get(
                            "C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/" + (y + 1) + ".txt");
                    List<String> lines = Files.readAllLines((java.nio.file.Path) path);
                    String listString = String.join("", lines);
                    machine.setLocationSteps(y);
                    machine.setArmazenamento(listString);
                }
                p = 0;
                locale.setText(way);
                break;
            } else {
                location = String.valueOf(c + 1);
                path = Path.of("C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/"
                        + location + ".txt");
                way = "C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/" + location
                        + ".txt";
            }
        }

    }

    @FXML
    void button_change(ActionEvent event) throws IOException {

        String vizualizar = "Maquina: " + name_process.getText();
        System.out.println(vizualizar);
        File file1 = new File("C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina");
        int count = file1.listFiles().length;
        for (int i = 0; i < count; i++) {
            FileReader file = new FileReader(
                    "C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/" + (i + 1) + ".txt");
            BufferedReader leitor = new BufferedReader(file);
            String line = leitor.readLine();
            if (vizualizar.equals(line)) {
                path = "C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/" + (i + 1) + ".txt";
                leitor.close();
                file.close();
                try {
                    locale.setText("");
                    java.nio.file.Path path = Paths
                            .get("C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/" + (i + 1) + ".txt");
                    List<String> lines = Files.readAllLines((java.nio.file.Path) path);
                    String listString = String.join("\n", lines);
                    System.out.println(listString);
                    message.setText("");
                    message.setText(listString);

                    BufferedReader br = new BufferedReader(
                            new FileReader(
                                    "C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/" + (i + 1) + ".txt"));

                    while ((linha[z] = br.readLine()) != null) {
                        System.out.println(linha[z]);
                        z++;
                    }
                    br.close();
                    break;

                } catch (Exception erro) {

                }
                break;
            } else {
                locale.setText("");
                message.setText("Produto não encontrado, escreva novamente.");

            }
            leitor.close();
        }

        int line = Integer.parseInt(line_change.getText());

        if (line == 1) {
            String changes = "Produto = " + change.getText();
            linha[line - 1] = changes;

        }
        if (line == 2) {
            String changes = "Modelo = " + change.getText();
            linha[line - 1] = changes;
        }
        if (line > 3) {
            String changes = "Componente" + (line - 2) + change.getText();
            linha[line - 1] = changes;
        }

        String text = "";

        for (String message : linha) {
            if (message != null) {
                text += message + "\n";
            }

        }
        message.setText(text);

        File file = new File(path);
        file.delete();
        for (int x = 0; x < z; x++) {
            System.out.println(linha[x]);
            String way = "C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/" + (i + 1) + ".txt";
            FileWriter writer = new FileWriter(way, true);
            try {
                writer.write(linha[x] + "\n");
            } catch (Exception erro) {

            }
            locale.setText(way);
            writer.close();

        }

    }

    @FXML
    void button_search(ActionEvent event) {
        String searchString = web_search.getText();
        try {
            URI link = new URI("http://google.com/search?q=" + searchString);
            Desktop.getDesktop().browse(link);
            web_search.setText("");

        } catch (Exception erro) {
            System.out.println(erro);
        }

    }

    @FXML
    void button_show(ActionEvent event) throws IOException {

        String vizualizar = "Maquina: " + name_process.getText();
        System.out.println(vizualizar);

        File file1 = new File("C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina");
        int count = file1.listFiles().length;
        for (i = 0; i < count; i++) {
            FileReader file = new FileReader(
                    "C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/" + (i + 1) + ".txt");
            BufferedReader leitor = new BufferedReader(file);
            String adress = "C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/" + (i + 1) + ".txt";
            String line = leitor.readLine();

            if (vizualizar.equals(line)) {
                leitor.close();
                file.close();
                try {
                    java.nio.file.Path path = Paths
                            .get("C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/" + (i + 1) + ".txt");
                    List<String> lines = Files.readAllLines((java.nio.file.Path) path);
                    listString = String.join("\n", lines);
                    System.out.println(listString);
                    message.setText(listString);
                    locale.setText(adress);
                    break;

                } catch (Exception erro) {

                }
            } else {
                message.setText("");
                message.setText("Produto não encontrado, escreva novamente.");

            }

        }

    }

    @FXML
    void delete_buttton(ActionEvent event) throws IOException {

        String del = "Maquina: " + delete_process.getText();
        File file1 = new File("C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/");
        int count = file1.listFiles().length;

        for (int i = 0; i < count; i++) {
            FileReader file = new FileReader(
                    "C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/" + (i + 1) + ".txt");
            BufferedReader leitor = new BufferedReader(file);
            String line = leitor.readLine();

            if (del.equals(line)) {
                leitor.close();
                file.close();
                try {
                    File deleter = new File(
                            "C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/" + (i + 1)
                                    + ".txt");
                    message.setText("Deletado com sucesso");
                    deleter.delete();
                    delete_process.setText("Digite o nome da Maquina");

                } catch (Exception erro) {

                }
                File file2 = new File("C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina");
                count = file2.listFiles().length;
                for (int y = 0; y < count; y++) {
                    java.nio.file.Path path = Paths
                            .get("C:/Users/Daniel/Desktop/Trabalhoi Final POO Leo/Maquina/" + (y + 1) + ".txt");
                    List<String> lines = Files.readAllLines((java.nio.file.Path) path);
                    String listString = String.join("", lines);
                    machine.setLocationSteps(y);
                    machine.setArmazenamento(listString);
                }
            }
        }

    }

    @FXML
    void loading(ActionEvent event) throws IOException {
        String endereco = locale.getText();
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        desktop.open(new File(endereco));

    }
}
