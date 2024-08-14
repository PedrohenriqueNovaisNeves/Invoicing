package usuario;

public class IdUsuario {

    private int idUsuario;

    public IdUsuario() {
        this.idUsuario = 0;
    }

    public void gerarId(){
        idUsuario++;
    }

    public int getIdUsuario(){
        return idUsuario;
    }
}