package fag.objetos;

public class Mesa {
    public int nummesa;
    public int capacidademesa;
    public boolean status;

    public Mesa(int nummesa, int capacidademesa, boolean status) {
        this.nummesa = nummesa;
        this.capacidademesa = capacidademesa;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Mesa [nummesa=" + nummesa + ", capacidademesa=" + capacidademesa + ", status=" + status + "]";
    }
}
