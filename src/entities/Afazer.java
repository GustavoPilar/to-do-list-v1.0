package entities;

public final class Afazer  {

    private String titulo;

    private Prioridade prioridade;
    private Status status;

    public Afazer() {
        status = Status.PROCESSANDO;
    }

    public Afazer(String titulo, Prioridade prioridade) {
        this.titulo = titulo;
        this.prioridade = prioridade;
        status = Status.PROCESSANDO;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "(" + getPrioridade() + ")" + getTitulo() + " - " + getStatus();
    }
}
