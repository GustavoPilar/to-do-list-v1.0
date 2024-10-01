package entities;

import application.Main;
import application.UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class ListaAfazeres {

    private List<Afazer> afazeres;

    public ListaAfazeres() {
        afazeres = new ArrayList<>();
    }

    public List<Afazer> getAfazeres() {
        return afazeres;
    }

    public void setAfazeres(List<Afazer> afazeres) {
        this.afazeres = afazeres;
    }

    public void adicionarAfazer() {
        Afazer afazer = new Afazer();

        System.out.print("Título: ");
        afazer.setTitulo(Main.sc.nextLine());

        System.out.println(
                "Digite o número da prioridade:\n" +
                        "[1] - P1 (Importante)\n" +
                        "[2] - P2 (Pouco Importante)\n" +
                        "[3] - P3 (Não Importante)");
        int escolha = UI.escolherOpcao(1, 3, "Escolha: ");

        switch (escolha) {
            case 1 -> afazer.setPrioridade(Prioridade.P1);
            case 2 -> afazer.setPrioridade(Prioridade.P2);
            default -> afazer.setPrioridade(Prioridade.P3);
        }

        boolean confirmacao = UI.confirmarAcao("adicionar");

        if (confirmacao) {
            afazeres.add(afazer);
            System.out.println("Afazer adicionado!");
        }
        else {
            System.out.println("Afazer adicinado");
        }

    }

    public void removerAfazer() {
        if (afazeres.isEmpty()) {
            System.out.println("A lista está vazia...");
        }
        else {
            System.out.print("Digite a posição do afazer que deseja remover: ");
            int index = UI.escolherOpcao(1, afazeres.size(), "");

            afazeres.get(index - 1);
            boolean confirmacao = UI.confirmarAcao("remover");

            if (confirmacao) {
                afazeres.remove(index - 1);
                System.out.println("Afazer removido!");
            }
            else {
                System.out.println("Afazer não removido");
            }
        }
    }

    public void mudarPrioridade() {
        if (afazeres.isEmpty()) {
            System.out.println("A lista está vazia...");
        }
        else {
            System.out.print("Digite o indice para alterar a prioridade: ");
            int index = UI.escolherOpcao(1, afazeres.size(), "");

            System.out.println(afazeres.get(index - 1));
            System.out.println(
                    "Digite o número da prioridade:\n" +
                    "[1] - P1 (Importante)\n" +
                    "[2] - P2 (Pouco Importante)\n" +
                    "[3] - P3 (Não Importante)");
            int numero = UI.escolherOpcao(1, 3, "Escolha: ");

            boolean confirmacao = UI.confirmarAcao("alterar a prioridade");

            if (confirmacao) {
                switch (numero) {
                    case 1 -> afazeres.get(index - 1).setPrioridade(Prioridade.P1);
                    case 2 -> afazeres.get(index - 1).setPrioridade(Prioridade.P2);
                    default -> afazeres.get(index -1 ).setPrioridade(Prioridade.P3);
                }

                System.out.println("Prioridade do afazer alterada!");
            }
            else {
                System.out.println("Prioridade do afazer não alterada!");
            }
        }
    }

    public void mudarStatus() {
        if (afazeres.isEmpty()) {
            System.out.println("A lista está vazia...");
        }
        else {
            System.out.print("Digite o indice para alterar o status: ");
            int index = UI.escolherOpcao(1, afazeres.size(), "");

            System.out.println(afazeres.get(index - 1));
            System.out.println(
                    "Digite o número do status:\n" +
                            "[1] - PROESSANDO\n" +
                            "[2] - CONCLUIDO");
            int numero = UI.escolherOpcao(1, 2, "Escolha: ");

            boolean confirmacao = UI.confirmarAcao("alterar o status");

            if (confirmacao) {
                switch (numero) {
                    case 1 -> afazeres.get(index - 1).setStatus(Status.PROCESSANDO);
                    default -> afazeres.get(index - 1).setStatus(Status.CONCLUIDO);
                }

                System.out.println("Status do afazer alterado!");
            }
            else {
                System.out.println("Status do afazer não alterado!");
            }


        }
    }

    public void arrumarLista() {
        Comparator<Afazer> comp = Comparator.comparing(Afazer::getPrioridade);
        afazeres.sort(comp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (afazeres.isEmpty()) {
            sb.append("Lista vazia.");
        }
        else {
            for (Afazer a : getAfazeres()) {
                sb.append("[").append(getAfazeres().indexOf(a) + 1).append("] - ").append(a).append("\n");
            }
        }
        return sb.toString();
    }
}
