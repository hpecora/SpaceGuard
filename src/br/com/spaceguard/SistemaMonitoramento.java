package br.com.spaceguard;

import java.util.ArrayList;
import java.util.List;

public class SistemaMonitoramento {
    private List<RegiaoMonitorada> regioes;
    private List<Satelite> satelites;
    private List<Alerta> alertas;

    public SistemaMonitoramento() {
        this.regioes = new ArrayList<>();
        this.satelites = new ArrayList<>();
        this.alertas = new ArrayList<>();
        carregarDadosIniciais();
    }

    private void carregarDadosIniciais() {
        RegiaoMonitorada r1 = new RegiaoMonitorada(1, "Zona Rural Norte", "Ribeirão Preto", "SP", "Queimada", "Alto");
        RegiaoMonitorada r2 = new RegiaoMonitorada(2, "Margem do Rio Central", "São Paulo", "SP", "Enchente", "Médio");
        RegiaoMonitorada r3 = new RegiaoMonitorada(3, "Área de Preservação Verde", "Manaus", "AM", "Desmatamento", "Alto");

        regioes.add(r1);
        regioes.add(r2);
        regioes.add(r3);

        Satelite s1 = new Satelite(1, "Aqua", "NASA", "Clima e temperatura", true);
        Satelite s2 = new Satelite(2, "Sentinel-2", "ESA", "Imagem orbital e vegetação", true);
        Satelite s3 = new Satelite(3, "CBERS-4A", "INPE", "Monitoramento ambiental", true);

        satelites.add(s1);
        satelites.add(s2);
        satelites.add(s3);

        alertas.add(new Alerta(1, r1, s1, "Risco de Queimada", "Temperatura elevada e baixa umidade detectadas.", "01/06/2026", "Ativo"));
        alertas.add(new Alerta(2, r2, s2, "Risco de Enchente", "Aumento do nível do rio detectado por monitoramento orbital.", "01/06/2026", "Em análise"));
        alertas.add(new Alerta(3, r3, s3, "Risco de Desmatamento", "Alteração na cobertura vegetal identificada.", "01/06/2026", "Ativo"));
    }

    public void cadastrarRegiao(String nome, String cidade, String estado, String tipoRisco, String nivelRisco) {
        int id = regioes.size() + 1;
        RegiaoMonitorada novaRegiao = new RegiaoMonitorada(id, nome, cidade, estado, tipoRisco, nivelRisco);
        regioes.add(novaRegiao);
        System.out.println("Região cadastrada com sucesso!");
    }

    public void listarRegioes() {
        if (regioes.isEmpty()) {
            System.out.println("Nenhuma região cadastrada.");
            return;
        }

        for (RegiaoMonitorada regiao : regioes) {
            regiao.exibirDados();
        }
    }

    public RegiaoMonitorada buscarRegiaoPorId(int id) {
        for (RegiaoMonitorada regiao : regioes) {
            if (regiao.getId() == id) {
                return regiao;
            }
        }
        return null;
    }

    public void buscarRegiaoPorCidade(String cidade) {
        boolean encontrou = false;

        for (RegiaoMonitorada regiao : regioes) {
            if (regiao.getCidade().equalsIgnoreCase(cidade)) {
                regiao.exibirDados();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma região encontrada para essa cidade.");
        }
    }

    public void atualizarNivelRisco(int id, String novoNivel) {
        RegiaoMonitorada regiao = buscarRegiaoPorId(id);

        if (regiao != null) {
            regiao.setNivelRisco(novoNivel);
            System.out.println("Nível de risco atualizado com sucesso!");
        } else {
            System.out.println("Região não encontrada.");
        }
    }

    public void cadastrarSatelite(String nome, String agencia, String tipoMonitoramento, boolean ativo) {
        int id = satelites.size() + 1;
        Satelite novoSatelite = new Satelite(id, nome, agencia, tipoMonitoramento, ativo);
        satelites.add(novoSatelite);
        System.out.println("Satélite cadastrado com sucesso!");
    }

    public void listarSatelites() {
        if (satelites.isEmpty()) {
            System.out.println("Nenhum satélite cadastrado.");
            return;
        }

        for (Satelite satelite : satelites) {
            satelite.exibirDados();
        }
    }

    public Satelite buscarSatelitePorId(int id) {
        for (Satelite satelite : satelites) {
            if (satelite.getId() == id) {
                return satelite;
            }
        }
        return null;
    }

    public void cadastrarAlerta(int idRegiao, int idSatelite, String tipoAlerta, String descricao, String data, String status) {
        RegiaoMonitorada regiao = buscarRegiaoPorId(idRegiao);
        Satelite satelite = buscarSatelitePorId(idSatelite);

        if (regiao == null) {
            System.out.println("Região não encontrada.");
            return;
        }

        if (satelite == null) {
            System.out.println("Satélite não encontrado.");
            return;
        }

        int id = alertas.size() + 1;
        Alerta novoAlerta = new Alerta(id, regiao, satelite, tipoAlerta, descricao, data, status);
        alertas.add(novoAlerta);
        System.out.println("Alerta cadastrado com sucesso!");
    }

    public void listarAlertas() {
        if (alertas.isEmpty()) {
            System.out.println("Nenhum alerta cadastrado.");
            return;
        }

        for (Alerta alerta : alertas) {
            alerta.exibirDados();
        }
    }

    public void atualizarStatusAlerta(int idAlerta, String novoStatus) {
        for (Alerta alerta : alertas) {
            if (alerta.getId() == idAlerta) {
                alerta.setStatus(novoStatus);
                System.out.println("Status do alerta atualizado com sucesso!");
                return;
            }
        }

        System.out.println("Alerta não encontrado.");
    }
}