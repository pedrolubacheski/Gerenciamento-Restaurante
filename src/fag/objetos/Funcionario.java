package fag.objetos;

public class Funcionario {
    public String nome;
    public int ID;
    public String cargo;
    public int vendas;

    public Funcionario(String nome, int id, String cargo, int vendas) {
        this.nome = nome;
        this.ID = id;
        this.cargo = cargo;
        this.vendas = vendas;
    }

    @Override
    public String toString() {
        return "Funcionario [nome=" + nome + ", ID=" + ID + ", cargo=" + cargo + ", vendas=" + vendas + "]";
    }
}
