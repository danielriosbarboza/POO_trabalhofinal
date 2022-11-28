import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Carregamento {
    Steps l = new Steps();

    public void Scanear(Scanner sc) throws IOException {
        File file = new File("C:/Users/Daniel/Desktop/poo_leo/Maquinas/");
        int count = file.listFiles().length;
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            Path path = Paths.get("C:/Users/Daniel/Desktop/poo_leo/Maquinas/" + (i + 1) + ".txt");
            List<String> lines = Files.readAllLines(path);
            String listString = String.join("", lines);
            l.setLocationSteps(i);
            l.setArmazenamento(listString);
        }
    }

    public void Vizualizar(Scanner sc) throws IOException {
        File file = new File("C:/Users/Daniel/Desktop/poo_leo/Maquinas/");
        int count = file.listFiles().length;
        for (int i = 0; i < count; i++) {
            Path path = Paths.get(
                    "C:/Users/Daniel/Desktop/poo_leo/Maquinas/" + (i + 1) + ".txt");
            List<String> lines = Files.readAllLines(path);
            String listString = String.join("", lines);
            l.setLocationSteps(i);
            l.setArmazenamento(listString);
            System.out.println("Numero" + (i + 1) + ": " + l.getArmazenamento() + "\n\n");
        }
    }
}
