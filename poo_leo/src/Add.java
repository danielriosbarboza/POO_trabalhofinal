import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Add extends Carregamento {

    ArrayList<Steps> listaT = new ArrayList<Steps>();

    public void Adicionar(Scanner sc) throws IOException {

        char controle = 's';
        Carregamento carregar = new Carregamento();

        do {
            System.out.print("\nDigite o nome da Maquina: ");
            String m = sc.next();
            l.setMaquina(m);
            System.out.print("\nDigite o nome do Comando: ");
            String c = sc.next();
            l.setComando(c);
            System.out.print("\nQuantos passos terá o comando? ");
            int nc = sc.nextInt();
            for (int x = 0; x < nc; x++) {
                l.setLocationSteps(x);
                System.out.print("\nDigite o nome do passo: ");
                String p = sc.next();
                l.setLocationSteps(x);
                l.setSteps(p);
            }
            listaT.add(l);
            int num = 1;
            String location = String.valueOf(num);
            Path path = Path.of("C:/Users/Daniel/Desktop/poo_leo/Maquinas/" + location + ".txt");
            String way = "C:/Users/Daniel/Desktop/poo_leo/Maquinas/" + location + ".txt";
            for (int y = 0; y < 100; y++) {
                if (Files.notExists(path)) {
                    FileWriter writer = new FileWriter(way, true);
                    try {
                        for (Steps i : listaT) {
                            System.out.println(i.toString());
                            writer.write(i.toString());
                        }
                    } catch (Exception erro) {

                    }

                    for (int x = 0; x < nc; x++) {
                        try {
                            l.setLocationSteps(x);
                            System.out.println(l.toString2());
                            writer.write(l.toString2());
                        } catch (Exception erro) {

                        }

                    }
                    writer.close();
                    carregar.Scanear(sc);
                    break;
                } else {
                    location = String.valueOf(y + 1);
                    path = Path.of("C:/Users/Daniel/Desktop/poo_leo/Maquinas/" + location + ".txt");
                    way = "C:/Users/Daniel/Desktop/poo_leo/Maquinas/" + location + ".txt";
                }
            }
            System.out.println("Deseja cadastrar outro produto?");
            controle = sc.next().charAt(0);
        } while (controle == 's');
    }
}
