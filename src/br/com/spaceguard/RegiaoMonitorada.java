package br.com.spaceguard;

public class RegiaoMonitorada {
    private int id;
    private String nome;
    private String cidade;
    private String estado;
    private String tipoRisco;
    private String nivelRisco;

    public RegiaoMonitorada(int id, String nome, String cidade, String estado, String tipoRisco, String nivelRisco) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.tipoRisco = tipoRisco;
        this.nivelRisco = nivelRisco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getTipoRisco() {
        return tipoRisco;
    }

    public String getNivelRisco() {
        return nivelRisco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTipoRisco(String tipoRisco) {
        this.tipoRisco = tipoRisco;
    }

    public void setNivelRisco(String nivelRisco) {
        this.nivelRisco = nivelRisco;
    }

    public void exibirDados() {
        System.out.println("--------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Regiao: " + nome);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);
        System.out.println("Tipo de risco: " + tipoRisco);
        System.out.println("Nivel de risco: " + nivelRisco);
        System.out.println("--------------------------------");
    }
}