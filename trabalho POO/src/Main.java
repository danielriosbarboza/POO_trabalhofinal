import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Add adder = new Add();
        teste test = new teste();

        Boolean ligar = true;

        while (ligar) {
            System.out.println("Escolha o método:");
            System.out.println("Opções:");
            System.out.println("0 =  Desligar;");
            System.out.println("1 = Adicionar;");
            System.out.println("2 = Vizualizar produtos e componentes;");
            System.out.println("3 = Excluir Produto;");
            System.out.println("4 = Localizar o produto:");
            System.out.print("5 = Modificar;\n\n");
            System.out.print("Opção: ");
            int metodo = sc.nextInt();
            System.out.println("\n+++++++++++++++++++++++++++++++++++\n");

            switch (metodo) {
                case 0:
                    ligar = false;
                    System.out.println("Desligando...");
                    break;

                case 1:
                    adder.Adicionar(sc);
                    break;

                case 2:
                    test.Teste(sc);
                    break;

            }

        }
    }
}