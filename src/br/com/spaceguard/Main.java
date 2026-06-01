package br.com.spaceguard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaMonitoramento sistema = new SistemaMonitoramento();

        int opcao;

        do {
            System.out.println("\n========== SPACEGUARD ==========");
            System.out.println("Sistema de Monitoramento de Desastres com Dados de Satelite");
            System.out.println("1 - Cadastrar regiao monitorada");
            System.out.println("2 - Listar regioes monitoradas");
            System.out.println("3 - Buscar regiao por cidade");
            System.out.println("4 - Atualizar nivel de risco de uma regiao");
            System.out.println("5 - Cadastrar satelite");
            System.out.println("6 - Listar satelites");
            System.out.println("7 - Cadastrar alerta");
            System.out.println("8 - Listar alertas");
            System.out.println("9 - Atualizar status de alerta");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastro de Regiao Monitorada ---");

                    System.out.print("Nome da regiao: ");
                    String nomeRegiao = scanner.nextLine();

                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();

                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();

                    System.out.print("Tipo de risco (Enchente, Queimada, Desmatamento etc.): ");
                    String tipoRisco = scanner.nextLine();

                    System.out.print("Nivel de risco (Baixo, Medio, Alto): ");
                    String nivelRisco = scanner.nextLine();

                    sistema.cadastrarRegiao(nomeRegiao, cidade, estado, tipoRisco, nivelRisco);
                    break;

                case 2:
                    System.out.println("\n--- Regioes Monitoradas ---");
                    sistema.listarRegioes();
                    break;

                case 3:
                    System.out.println("\n--- Buscar Regiao por Cidade ---");

                    System.out.print("Digite a cidade: ");
                    String cidadeBusca = scanner.nextLine();

                    sistema.buscarRegiaoPorCidade(cidadeBusca);
                    break;

                case 4:
                    System.out.println("\n--- Atualizar Nivel de Risco ---");

                    System.out.print("Digite o ID da regiao: ");
                    int idRegiaoAtualizar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo nivel de risco (Baixo, Medio, Alto): ");
                    String novoNivel = scanner.nextLine();

                    sistema.atualizarNivelRisco(idRegiaoAtualizar, novoNivel);
                    break;

                case 5:
                    System.out.println("\n--- Cadastro de Satelite ---");

                    System.out.print("Nome do satelite: ");
                    String nomeSatelite = scanner.nextLine();

                    System.out.print("Agencia responsavel: ");
                    String agencia = scanner.nextLine();

                    System.out.print("Tipo de monitoramento: ");
                    String tipoMonitoramento = scanner.nextLine();

                    System.out.print("O satelite esta ativo? (s/n): ");
                    String respostaAtivo = scanner.nextLine();

                    boolean ativo = respostaAtivo.equalsIgnoreCase("s");

                    sistema.cadastrarSatelite(nomeSatelite, agencia, tipoMonitoramento, ativo);
                    break;

                case 6:
                    System.out.println("\n--- Satelites Cadastrados ---");
                    sistema.listarSatelites();
                    break;

                case 7:
                    System.out.println("\n--- Cadastro de Alerta ---");

                    System.out.println("Regioes disponiveis:");
                    sistema.listarRegioes();

                    System.out.print("Digite o ID da regiao: ");
                    int idRegiao = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Satelites disponiveis:");
                    sistema.listarSatelites();

                    System.out.print("Digite o ID do satelite: ");
                    int idSatelite = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Tipo de alerta: ");
                    String tipoAlerta = scanner.nextLine();

                    System.out.print("Descricao do alerta: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Data do alerta: ");
                    String data = scanner.nextLine();

                    System.out.print("Status do alerta (Ativo, Em analise, Resolvido): ");
                    String status = scanner.nextLine();

                    sistema.cadastrarAlerta(idRegiao, idSatelite, tipoAlerta, descricao, data, status);
                    break;

                case 8:
                    System.out.println("\n--- Alertas Cadastrados ---");
                    sistema.listarAlertas();
                    break;

                case 9:
                    System.out.println("\n--- Atualizar Status de Alerta ---");

                    System.out.print("Digite o ID do alerta: ");
                    int idAlerta = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo status (Ativo, Em analise, Resolvido): ");
                    String novoStatus = scanner.nextLine();

                    sistema.atualizarStatusAlerta(idAlerta, novoStatus);
                    break;

                case 0:
                    System.out.println("Encerrando o SpaceGuard...");
                    break;

                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}