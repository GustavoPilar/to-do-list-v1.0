package application;

import entities.Pessoa;

import java.io.IOException;

public final class UI {

    private static Pessoa pessoa = new Pessoa();

    public static void __init__() throws IOException, InterruptedException {
        int opcao;
        clearScreen();
        System.out.print("Digite o seu nome: ");
        pessoa.setNome(Main.sc.nextLine());

        do {
            System.out.println("|----------------------------|");
            System.out.println("| [1] - To-do-list");
            System.out.println("| [2] - Sair");
            System.out.println("|----------------------------|");
            opcao = escolherOpcao(1, 2, "Escolha: ");

            switch (opcao) {
                case 1 -> toDoList();
                default -> System.out.println("Saindo...");
            }
        } while (opcao != 2);
    }

    public static void toDoList() throws IOException, InterruptedException {

        int opcao;
        do {
            clearScreen();
            verLista();

            System.out.println("[1] - Adicionar afazer");
            System.out.println("[2] - Remover afazer");
            System.out.println("[3] - Mudar prioridade");
            System.out.println("[4] - Mudar status");
            System.out.println("[5] - Voltar");
            opcao = escolherOpcao(1, 5, "Escolha: ");

            switch (opcao) {
                case 1:
                    clearScreen();
                    pessoa.getListaAfazeres().adicionarAfazer();
                    pause();
                    break;
                case 2:
                    clearScreen();
                    verLista();
                    pessoa.getListaAfazeres().removerAfazer();
                    pause();
                    break;
                case 3:
                    clearScreen();
                    verLista();
                    pessoa.getListaAfazeres().mudarPrioridade();
                    pause();
                    break;
                case 4:
                    clearScreen();
                    verLista();
                    pessoa.getListaAfazeres().mudarStatus();
                    pause();
                    break;
                default:
                    System.out.println("Voltando...");
            }
        } while (opcao != 5);

    }

    public static void verLista() {
        pessoa.getListaAfazeres().arrumarLista();
        System.out.println("|--------------------|");
        System.out.println(pessoa);
        System.out.println("|--------------------|");
    }

    public static void clearScreen() throws IOException, InterruptedException {
        if(System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        else {
            new ProcessBuilder("cmd", "/c", "clear").inheritIO().start().waitFor();
        }
    }

    public static void pause() throws InterruptedException {
        for (int i = 1; i < 4; i++) {
            System.out.print(i + " ");
            Thread.sleep(1000);
        }
        System.out.println();
    }

    public static int escolherOpcao(int min, int max, String msg) {
        System.out.print(msg);
        int opcao = Main.sc.nextInt();
        Main.sc.nextLine();

        while (opcao < min || opcao > max) {
            System.out.print("Opcao invalida. Digite novamente: ");
            opcao = Main.sc.nextInt();
            Main.sc.nextLine();
        }

        return opcao;
    }

    public static boolean confirmarAcao(String acao) {
        System.out.printf("Deseja mesmo %s?\n[1] - Sim\n[2] - Não\n", acao);
        int opcao = UI.escolherOpcao(1, 2, "Escolha: ");

        return opcao == 1;
    }
}
