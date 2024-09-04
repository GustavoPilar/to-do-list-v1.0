package entities;

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
        return "Lista de " + getNome() + "\n" + listaAfazeres.toString();
    }
}
