import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Add {

    ArrayList<Steps> listP = new ArrayList<Steps>();

    public void Adicionar(Scanner sc) throws IOException {

        char controle = 's';

        do {
            Steps passos = new Steps();
            System.out.print("\nEscreva o nome da máquina: ");
            sc.nextLine();
            String m = sc.nextLine();
            passos.setMaquina(m);
            System.out.print("\n:Nome do comando: ");
            String c = sc.nextLine();
            passos.setComando(c);
            System.out.print("\nQuantos passos serão necessários? ");
            int sp = sc.nextInt();
            listP.add(passos);
            for (Steps i : listP) {
                int num = 1;
                String localizacao = String.valueOf(num);
                String way = "/home/leo/Área de Trabalho/trabalho POO/Maquinas/" + localizacao + ".txt";
                FileWriter writer = new FileWriter(way, true);
                try {
                    writer.write("testando");
                    System.out.printf(i.toString());
                } catch (Exception erro) {

                }
                for (int x = 0; x < sp; x++) {
                    System.out.print("\nDigite o Passo" + (x + 1) + ": ");
                    sc.nextLine();
                    String p = sc.nextLine();
                    passos.setLocationSteps(x);
                    passos.setComando(p);
                    try {
                        writer.write("Testando");
                        System.out.printf("faz a mão");

                    } catch (Exception erro) {

                    }
                }
                writer.close();
                break;
            }

            System.out.println("Deseja cadastrar outro produto?");
            controle = sc.next().charAt(0);

        } while (controle == 's');
    }
}