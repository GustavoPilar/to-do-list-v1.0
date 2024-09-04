package entities;

import application.Main;
import application.UI;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ListaAfazeres {

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

        System.out.print("Título: ");
        String titulo = Main.sc.nextLine();
        System.out.print(
                "Prioridade:\n" +
                "[1] - P1 (Importante)\n" +
                "[2] - P2 (Pouco Urgente)\n" +
                "[3] - P3 (Não urgente)\n" +
                "Escolha: ");
        int escolha = Main.sc.nextInt();
        Main.sc.nextLine();

        while (escolha < 0 || escolha > 3) {
            System.out.println("Opção inválida. Escolha outra opção.");
        }

        Prioridade prioridade;
        switch (escolha) {
            case 1 -> prioridade = Prioridade.P1;
            case 2 -> prioridade = Prioridade.P2;
            default -> prioridade = Prioridade.P3;
        }

        afazeres.add(new Afazer(titulo, prioridade));
        System.out.println("Afazer adicionado!");
    }

    public void removerAfazer() {
        if (afazeres.isEmpty()) {
            System.out.println("A lista está vazia...");
        }
        else {
            System.out.print("Digite o número para remover: ");
            int index = Main.sc.nextInt();

            while (index < 1 || index > afazeres.size()) {
                System.out.println("Indice inválido. Digite outro: ");
                index = Main.sc.nextInt();
            }

            afazeres.remove(index - 1);
            System.out.println("Afazer removido.");
        }
    }

    public void mudarPrioridade() {
        if (afazeres.isEmpty()) {
            System.out.println("A lista está vazia...");
        }
        else {
            System.out.print("Digite o indice para mudar o status: ");
            int index = Main.sc.nextInt();

            while (index < 1 || index > afazeres.size()) {
                System.out.println("Indice inválido. Digite outro: ");
                index = Main.sc.nextInt();
            }

            System.out.println(afazeres.get(index - 1));
            System.out.println(
                    "Digite a prioridade:\n" +
                    "[1] - P1 (Importante)\n" +
                    "[2] - P2 (Pouco Urgente)\n" +
                    "[3] - P3 (Não urgente)\n" +
                    "Escolha: ");
            int numero = Main.sc.nextInt();

            while (numero < 0 || numero > 3) {
                System.out.println("Valor inválido. Digite novamente: ");
                numero = Main.sc.nextInt();
            }

            switch (numero) {
                case 1 -> afazeres.get(index - 1).setPrioridade(Prioridade.P1);
                case 2 -> afazeres.get(index - 1).setPrioridade(Prioridade.P2);
                default -> afazeres.get(index -1 ).setPrioridade(Prioridade.P3);
            }

            System.out.println("Status do afazer alterado.");
        }
    }

    public void mudarStatus() {
        if (afazeres.isEmpty()) {
            System.out.println("A lista está vazia...");
        }
        else {
            System.out.print("Digite o indice para mudar o status: ");
            int index = Main.sc.nextInt();

            while (index < 1 || index > afazeres.size()) {
                System.out.println("Indice inválido. Digite outro: ");
                index = Main.sc.nextInt();
            }

            System.out.println(afazeres.get(index - 1));
            System.out.println(
                    "Digite a status:\n" +
                            "[1] - PROESSANDO\n" +
                            "[2] - CONCLUIDO\n" +
                            "Escolha: ");
            int numero = Main.sc.nextInt();

            while (numero < 0 || numero > 2) {
                System.out.println("Valor inválido. Digite novamente: ");
                numero = Main.sc.nextInt();
            }

            switch (numero) {
                case 1 -> afazeres.get(index - 1).setStatus(Status.PROCESSANDO);
                default -> afazeres.get(index - 1).setStatus(Status.CONCLUIDO);
            }

            System.out.println("Status do afazer alterado.");
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
