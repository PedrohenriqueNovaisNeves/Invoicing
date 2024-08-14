package faturas;
import java.util.Date;

public class Faturas {

    private double valor;
    private String nome;
    private String vencimento;
    private int IdFatura;
    private String descricaoFatura;

    public Faturas(){
        this.valor = 0;
        this.nome = "";
        this.vencimento = "";
        this.descricaoFatura = "";
        this.IdFatura = 0;
    }

    public boolean setValor(double valor){
        if(this.valor == 0){
            this.valor = valor;
            return true;
        }else{
            return false;
        }
    }

    public double getValor(){
        return valor;
    }

    public boolean setNome(String nome){
        if(this.nome.equals("")){
            this.nome = nome;
            return true;
        }else{
            return false;
        }
    }

    public String getNome(){
        return nome;
    }

    public boolean setVencimento(String data){
        if(this.vencimento.equals("")){
            this.vencimento = data;
            return true;
        }else{
            return false;
        }
    }

    public String getVencimento(){
        return vencimento;
    }

    public boolean setIdFatura(int id){
        if(this.IdFatura == 0){
            this.IdFatura = id;
            return true;
        }else{
            return false;
        }
    }

    public int getIdFatura(){
        return IdFatura;
    }

    public boolean setDescricaoFatura(String descricao){
        if(this.descricaoFatura.equals("")) {
            this.descricaoFatura = descricao;
            return true;
        }else{
            return false;
        }
    }

    public String getDescricaoFatura(){
        return descricaoFatura;
    }

    public boolean consultaFatura(String nome){
        if(this.nome == nome){
            getNome();
            getValor();
            getVencimento();
            return true;
        }else if(this.nome == null){
            System.out.println("Nao temos faturas cadastradas em nosso sistema");
            return true;
        }else{
            return false;
        }
    }
}
