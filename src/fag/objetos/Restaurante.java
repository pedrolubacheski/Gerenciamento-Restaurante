package fag.objetos;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    public List<Funcionario> listaFuncionarios;
    public List<Cardapio> listaCardapio;
    public List<Mesa> listaMesas;
    public List<Pedido> listaPedidos;

    public Restaurante() {
        this.listaFuncionarios = new ArrayList<>();
        this.listaCardapio = new ArrayList<>();
        this.listaMesas = new ArrayList<>();
        this.listaPedidos = new ArrayList<>();
    }

    // Adiciona Funcionário
    public void adicionarFuncionario(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
    }

    // Remove Funcionário
    public void removerFuncionario(int indice) {
        if (indice >= 0 && indice < listaFuncionarios.size()) {
            listaFuncionarios.remove(indice);
        }
    }

    // Obtem Funcionários
    public List<Funcionario> getFuncionarios() {
        return listaFuncionarios;
    }

    // Adicionar Item ao Cardápio
    public void adicionarItemCardapio(Cardapio item) {
        listaCardapio.add(item);
    }

    // Obtem Cardápio
    public List<Cardapio> getCardapio() {
        return listaCardapio;
    }

    // Adiciona Mesa
    public void adicionarMesa(Mesa mesa) {
        listaMesas.add(mesa);
    }

    // Obtem Mesas
    public List<Mesa> getMesas() {
        return listaMesas;
    }

    // Adiciona Pedido
    public void adicionarPedido(Pedido pedido) {
        listaPedidos.add(pedido);
    }

    // Obtem Pedidos
    public List<Pedido> getPedidos() {
        return listaPedidos;
    }

    // Calcular Faturamento Total
    public double calcularFaturamentoTotal() {
        double faturamentoTotal = 0;
        for (Pedido pedido : listaPedidos) {
            for (Cardapio item : pedido.itens) {
                faturamentoTotal += item.preco;
            }
        }
        return faturamentoTotal;
    }
}
