package br.com.spaceguard;

public class Alerta {
    private int id;
    private RegiaoMonitorada regiao;
    private Satelite satelite;
    private String tipoAlerta;
    private String descricao;
    private String data;
    private String status;

    public Alerta(int id, RegiaoMonitorada regiao, Satelite satelite, String tipoAlerta, String descricao, String data, String status) {
        this.id = id;
        this.regiao = regiao;
        this.satelite = satelite;
        this.tipoAlerta = tipoAlerta;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public RegiaoMonitorada getRegiao() {
        return regiao;
    }

    public Satelite getSatelite() {
        return satelite;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void exibirDados() {
        System.out.println("--------------------------------");
        System.out.println("ID do alerta: " + id);
        System.out.println("Regiao monitorada: " + regiao.getNome());
        System.out.println("Cidade: " + regiao.getCidade() + " - " + regiao.getEstado());
        System.out.println("Satelite responsavel: " + satelite.getNome());
        System.out.println("Tipo de alerta: " + tipoAlerta);
        System.out.println("Descricao: " + descricao);
        System.out.println("Data: " + data);
        System.out.println("Status: " + status);
        System.out.println("--------------------------------");
    }
}