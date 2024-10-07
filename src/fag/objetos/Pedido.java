package fag.objetos;

import java.util.List;

public class Pedido {
    public Mesa mesa;
    public List<Cardapio> itens;

    public Pedido(Mesa mesa, List<Cardapio> itens) {
        this.mesa = mesa;
        this.itens = itens;
    }
}
