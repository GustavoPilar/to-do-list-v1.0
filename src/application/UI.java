package application;

import entities.Pessoa;

import java.io.IOException;

public final class UI {

    private static Pessoa pessoa = new Pessoa();

    public static void __init__() throws IOException, InterruptedException {
        int opcao;

        System.out.print("Digite o seu nome: ");
        pessoa.setNome(Main.sc.nextLine());

        do {
            System.out.println("|----------------------------|");
            System.out.println("| [1] - To-do-list");
            System.out.println("| [2] - Sair");
            System.out.println("|----------------------------|");
            System.out.print("Esolha: ");
            opcao = Main.sc.nextInt();
            Main.sc.nextLine();

            switch (opcao) {
                case 1 -> toDoList();
                case 2 -> System.out.println("Saindo...");
                default -> System.out.println("Valor inválido.");
            }
        } while (opcao != 2);
    }

    public static void toDoList() throws IOException, InterruptedException {

        int escolha;
        do {
            clearScreen();
            verLista();

            System.out.println("[1] - Adicionar afazer");
            System.out.println("[2] - Remover afazer");
            System.out.println("[3] - Mudar prioridade");
            System.out.println("[4] - Mudar status");
            System.out.println("[5] - Voltar");
            System.out.print("Esolha: " );
            escolha = Main.sc.nextInt();
            Main.sc.nextLine();

            switch (escolha) {
                case 1:
                    pessoa.getListaAfazeres().adicionarAfazer();
                    pause();
                    break;
                case 2:
                    pessoa.getListaAfazeres().removerAfazer();
                    pause();
                    break;
                case 3:
                    pessoa.getListaAfazeres().mudarPrioridade();
                    pause();
                    break;
                case 4:
                    pessoa.getListaAfazeres().mudarStatus();
                    pause();
                    break;
                case 5:
                    System.out.println("Voltando...");
                    pause();
                    break;
                default:
                    System.out.println("Valor inválido");
                    pause();
            }
        } while (escolha != 5);

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
}
