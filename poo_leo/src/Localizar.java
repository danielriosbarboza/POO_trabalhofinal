import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Localizar {
    public void localizador(Scanner sc) throws IOException {
        File file1 = new File("C:/Users/Daniel/Desktop/poo_leo/Maquinas/");
        int count = file1.listFiles().length;
        System.out.print("Digite o nome da maquina que desejas localizar: ");
        sc.nextLine();
        String comparador = "Maquina: " + sc.nextLine();
        String adress;

        for (int i = 0; i < count; i++) {
            FileReader file = new FileReader(
                    "C:/Users/Daniel/Desktop/poo_leo/Maquinas/" + (i + 1) + ".txt");
            BufferedReader leitor = new BufferedReader(file);
            String line = leitor.readLine();
            adress = "C:/Users/Daniel/Desktop/poo_leo/Maquinas/" + (i + 1) + ".txt";

            if (comparador.equals(line)) {
                leitor.close();
                System.out.println("O registro da maquina está localizado em: " + adress);
                file.close();
                break;
            }
            file.close();

            leitor.close();

        }

    }

}