package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fag.objetos.Cardapio;
import fag.objetos.Funcionario;
import fag.objetos.Mesa;
import fag.objetos.Pedido;

public class Inicial {
    
    public static List<Funcionario> listaFuncionario = new ArrayList<>();
    public static List<Cardapio> listaCardapio = new ArrayList<>();
    public static List<Mesa> listaMesa = new ArrayList<>();
    public static List<Pedido> listaPedidos = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean menu = true;

        do {
            System.out.println("Sistema de Gerenciamento de Restaurante:\n"
                    + "\n1. Cadastro de Funcionários"
                    + "\n2. Gerenciamento de Cardápio"
                    + "\n3. Cadastro de Mesas"
                    + "\n4. Registro de Pedidos"
                    + "\n5. Acompanhamento de Vendas por Funcionário"
                    + "\n6. Fechamento de Conta e Faturamento"
                    + "\n7. Relatório de Faturamento do Restaurante"
                    + "\n8. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    cadastroFuncionario();
                    break;
                case 2:
                    gerenciamentoCardapio();
                    break;
                case 3:
                    cadastroMesa();
                    break;
                case 4:
                    registroPedidos();
                    break;
                case 5:
                    acompanhamentoVendas();
                    break;
                case 6:
                    fechamentoConta();
                    break;
                case 7:
                    relatorioFaturamento();
                    break;
                case 8:
                    menu = false;
                    break;
                default:
                    System.out.println("Erro!");
                    break;
            }

        } while (menu);
    }

    public static void cadastroFuncionario() {
        System.out.println("Quantos funcionários deseja cadastrar?");
        int quantidade = scanner.nextInt();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Digite o Nome do Funcionário:");
            String nome = scanner.next();

            System.out.println("Digite o ID do Funcionário:");
            int id = scanner.nextInt();

            System.out.println("Digite o Cargo do Funcionário:");
            String cargo = scanner.next().toLowerCase();

            int vendas = 0;
            if (cargo.equals("garçom")) {
                System.out.println("Digite a quantidade de Vendas feitas:");
                vendas = scanner.nextInt();
            }

            Funcionario funcionario = new Funcionario(nome, id, cargo, vendas);
            listaFuncionario.add(funcionario);
        }
    }

    public static void gerenciamentoCardapio() {
        System.out.println("Quantos itens você deseja cadastrar?");
        int quantidade = scanner.nextInt();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Informe os dados do item: Nome, Código, Preço, Disponibilidade:");
            String nome = scanner.next();
            int codigo = scanner.nextInt();
            double preco = scanner.nextDouble();
            int disponibilidade = scanner.nextInt();

            Cardapio cardapio = new Cardapio(nome, codigo, preco, disponibilidade);
            listaCardapio.add(cardapio);
        }
    }

    public static void cadastroMesa() {
        System.out.println("Quantas mesas você deseja cadastrar?");
        int quantidade = scanner.nextInt();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Informe os dados da mesa: Número, Capacidade, Status(true ou false):");
            int numero = scanner.nextInt();
            int capacidade = scanner.nextInt();
            boolean status = scanner.nextBoolean();

            Mesa mesa = new Mesa(numero, capacidade, status);
            listaMesa.add(mesa);
        }
    }

    public static void registroPedidos() {
        System.out.println("Digite o número da mesa para registrar o pedido:");
        int numMesa = scanner.nextInt();
        Mesa mesaSelecionada = null;

        for (Mesa mesa : listaMesa) {
            if (mesa.nummesa == numMesa && mesa.status) {
                mesaSelecionada = mesa;
                break;
            }
        }

        if (mesaSelecionada != null) {
            List<Cardapio> itensPedido = new ArrayList<>();
            boolean maisItens = true;

            while (maisItens) {
                System.out.println("Digite o código do item para adicionar ao pedido:");
                int codItem = scanner.nextInt();
                Cardapio itemSelecionado = null;

                for (Cardapio item : listaCardapio) {
                    if (item.codiprato == codItem && item.disponibilidade > 0) {
                        itemSelecionado = item;
                        item.disponibilidade--; 
                        break;
                    }
                }

                if (itemSelecionado != null) {
                    itensPedido.add(itemSelecionado);
                    System.out.println("Item adicionado: " + itemSelecionado.nomePrato);
                } else {
                    System.out.println("Item não encontrado ou indisponível.");
                }

                System.out.println("Deseja adicionar mais itens? (true/false)");
                maisItens = scanner.nextBoolean();
            }

            Pedido novoPedido = new Pedido(mesaSelecionada, itensPedido);
            listaPedidos.add(novoPedido);
            System.out.println("Pedido registrado com sucesso!");
        } else {
            System.out.println("Mesa não encontrada ou não está disponível.");
        }
    }

    public static void acompanhamentoVendas() {
        System.out.println("Relatório de Vendas por Funcionário:");
        for (Funcionario funcionario : listaFuncionario) {
            System.out.println("Nome: " + funcionario.nome + ", Total de Vendas: " + funcionario.vendas);
        }
    }

    public static void fechamentoConta() {
        System.out.println("Digite o número da mesa para fechar a conta:");
        int numMesa = scanner.nextInt();
        Mesa mesaFechada = null;

        for (Mesa mesa : listaMesa) {
            if (mesa.nummesa == numMesa && mesa.status) {
                mesaFechada = mesa;
                break;
            }
        }

        if (mesaFechada != null) {
            double totalConta = 0;

            for (Pedido pedido : listaPedidos) {
                if (pedido.mesa.nummesa == numMesa) {
                    for (Cardapio item : pedido.itens) {
                        totalConta += item.preco;
                    }
                }
            }

            if (totalConta > 0) {
                System.out.println("Total da conta da mesa " + numMesa + ": " + totalConta);
                mesaFechada.status = false; 
                System.out.println("Mesa " + numMesa + " fechada com sucesso!");
            } else {
                System.out.println("Nenhum pedido encontrado para esta mesa.");
            }
        } else {
            System.out.println("Mesa não encontrada ou já está fechada.");
        }
    }

    public static void relatorioFaturamento() {
        double totalFaturamento = 0;
        System.out.println("Relatório de Faturamento do Restaurante:");

        for (Pedido pedido : listaPedidos) {
            for (Cardapio item : pedido.itens) {
                totalFaturamento += item.preco;
            }
        }

        System.out.println("Total de vendas realizadas: " + totalFaturamento);
    }
}
