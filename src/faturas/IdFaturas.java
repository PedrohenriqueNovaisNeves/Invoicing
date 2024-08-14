package faturas;

public class IdFaturas {

    private int idFatura;

    public IdFaturas() {
        this.idFatura = 0;
    }

    public void gerarIdFatura() {
        idFatura++;
    }

    public int getIdFatura() {
        return idFatura;
    }
}
