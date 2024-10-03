package entities;

import javax.print.DocFlavor;

public final class Pessoa {

    private String nome;

    private ListaAfazeres listaAfazeres;

    public Pessoa() {
        listaAfazeres = new ListaAfazeres();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ListaAfazeres getListaAfazeres() {
        return listaAfazeres;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Lista de ");
        sb.append(getNome());
        sb.append("\n");
        sb.append(getListaAfazeres());
        if (!getListaAfazeres().getAfazeres().isEmpty()) {
            sb.append("Porcentagem concluída: ");
            sb.append(String.format("%.2f", getListaAfazeres().porcentagemConcluida()));
            sb.append("%");
        }

        return sb.toString();
    }
}
