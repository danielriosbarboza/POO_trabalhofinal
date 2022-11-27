import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class teste {

    public void Teste(Scanner sc) throws IOException {
        String way = "/home/leo/Área de Trabalho/trabalho POO/Maquinas/1.txt";

        FileWriter writer = new FileWriter(way, true);
        try {
            writer.write("Funciona\n POr favor");
        } catch (Exception erro) {

        }
        writer.close();

    }
}
