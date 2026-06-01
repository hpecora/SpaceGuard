package br.com.spaceguard;

public class Satelite {
    private int id;
    private String nome;
    private String agencia;
    private String tipoMonitoramento;
    private boolean ativo;

    public Satelite(int id, String nome, String agencia, String tipoMonitoramento, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.agencia = agencia;
        this.tipoMonitoramento = tipoMonitoramento;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getTipoMonitoramento() {
        return tipoMonitoramento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setTipoMonitoramento(String tipoMonitoramento) {
        this.tipoMonitoramento = tipoMonitoramento;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void exibirDados() {
        System.out.println("--------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Satelite: " + nome);
        System.out.println("Agencia: " + agencia);
        System.out.println("Tipo de monitoramento: " + tipoMonitoramento);
        System.out.println("Status: " + (ativo ? "Ativo" : "Inativo"));
        System.out.println("--------------------------------");
    }
}