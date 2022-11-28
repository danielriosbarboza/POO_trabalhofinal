import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Modificador extends Carregamento {

    public void Modificar(Scanner sc) throws IOException {

        File file1 = new File("E:/Documentos/Workspace - Java/java-in-vscode/Trabalho Final POO/Produtos");
        int count = file1.listFiles().length;
        System.out.print("Digite o nome do produto que desejas modificar: ");
        sc.nextLine();
        String comparar = "Produto: " + sc.nextLine();
        String[] linha = new String[100];
        int z = 0, i;

        for (i = 0; i < count; i++) {
            FileReader file = new FileReader(
                    "E:/Documentos/Workspace - Java/java-in-vscode/Trabalho Final POO/Produtos/" + (i + 1) + ".txt");
            BufferedReader leitor = new BufferedReader(file);
            String line = leitor.readLine();

            if (comparar.equals(line)) {
                BufferedReader br = new BufferedReader(
                        new FileReader(
                                "E:/Documentos/Workspace - Java/java-in-vscode/Trabalho Final POO/Produtos/" + (i + 1)
                                        + ".txt"));

                while ((linha[z] = br.readLine()) != null) {
                    System.out.println(linha[z]);
                    z++;
                }
                br.close();

                System.out.print("Qual o número da linha que você deseja modificar?");
                int y = sc.nextInt();

                if (y == 1) {
                    System.out.print("\nOk, digite pelo o que você quer modificar: ");
                    sc.nextLine();
                    String change = "Produto: " + sc.nextLine();
                    linha[y - 1] = change;
                    break;

                }
                if (y == 2) {
                    System.out.print("\nOk, digite pelo o que você quer modificar: ");
                    sc.nextLine();
                    String change = "Modelo: " + sc.nextLine();
                    linha[y - 1] = change;
                    break;
                }

                if (y == 3) {
                    System.out.print("\nOk, digite pelo o que você quer modificar: ");
                    sc.nextLine();
                    String change = "Fabricante: " + sc.nextLine();
                    linha[y - 1] = change;
                    break;
                }

                if (y == 4) {
                    System.out.print("\nOk, digite pelo o que você quer modificar: ");
                    sc.nextLine();
                    String change = "Garantia: " + sc.nextLine();
                    linha[y - 1] = change;
                    break;
                }

                if (y > 5) {
                    System.out.print("\nOk, digite pelo o que você quer modificar: ");
                    sc.nextLine();
                    String change = "   Componente" + (y - 4) + ": " + sc.nextLine();
                    linha[y - 1] = change;
                    break;
                }
                leitor.close();
            }
        }

        for (int x = 0; x < z; x++) {
            System.out.println(linha[x]);
            String way = "E:/Documentos/Workspace - Java/java-in-vscode/Trabalho Final POO/Produtos/"
                    + (i + 1) + ".txt";
            FileWriter writer = new FileWriter(way, true);
            try {
                writer.write(linha[x] + "\n");
            } catch (Exception erro) {

            }
            writer.close();

        }

    }

}
