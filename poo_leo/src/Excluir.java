import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Excluir extends Carregamento {

    public void Deletor(Scanner sc) throws IOException {
        Carregamento carregar = new Carregamento();
        File file2 = new File("C:/Users/Daniel/Desktop/poo_leo/Maquinas/");
        int contador = file2.listFiles().length;
        System.out.print("Digite o nome da maquina que desejas apagar: ");
        sc.nextLine();
        String comparacao = "Maquina: " + sc.nextLine();

        for (int i = 0; i < contador; i++) {
            FileReader file = new FileReader(
                    "C:/Users/Daniel/Desktop/poo_leo/Maquinas/" + (i + 1) + ".txt");
            BufferedReader ler = new BufferedReader(file);
            String line = ler.readLine();

            if (comparacao.equals(line)) {
                ler.close();
                file.close();
                try {
                    File deleter = new File(
                            "C:/Users/Daniel/Desktop/poo_leo/Maquinas/" + (i + 1)
                                    + ".txt");
                    deleter.delete();
                    System.out.println("Deletado com sucesso");
                } catch (Exception erro) {

                }
                carregar.Scanear(sc);
                break;
            }
            file.close();

            ler.close();

        }

    }

}
