package fag.objetos;

public class Cardapio {
    public String nomePrato;
    public int codiprato;
    public double preco;
    public int disponibilidade;

    public Cardapio(String nomePrato, int codiprato, double preco, int disponibilidade) {
        this.nomePrato = nomePrato;
        this.codiprato = codiprato;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Cardapio [nomePrato=" + nomePrato + ", codiprato=" + codiprato + ", preco=" + preco
                + ", disponibilidade=" + disponibilidade + "]";
    }
}
