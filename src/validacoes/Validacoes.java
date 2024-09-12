package validacoes;
import conexaoMySql.*;

public class Validacoes {

    ConexaoMySql connection = new ConexaoMySql();

    public Validacoes(){}

    public boolean verificaEscolha(int selecao){
        if((selecao == 1)||(selecao == 2)){
            return true;
        }else{
            return false;
        }
    }

    public boolean validaFatura(String nome){
        if(nome.equals("")){
            return true;
        }else{
            return false;
        }
    }

    public boolean correcaoNome(String nome){
        if(nome.equals("")){
            System.out.println("Nome nao inserido");
            return true;
        }else{
            return false;
        }
    }

    public boolean correcaoCPF(String cpf){
        if(cpf.equals("")){
            System.out.println("CPF nao inserido");
            return true;
        }else{
            return false;
        }
    }

    public boolean correcaoRG(String rg){
        if(rg.equals("")){
            System.out.println("RG nao inserido");
            return true;
        }else{
            return false;
        }
    }

    public boolean correcaoEmail(String email){
        if(email.equals("")){
            System.out.println("Email nao inserido");
            return true;
        }else{
            return false;
        }
    }

    public boolean correcaoTodosDados(String nome, String cpf, String rg, String email){
        if((nome.equals("")) && (cpf.equals("")) && (rg.equals("")) && (email.equals(""))){
            System.out.println("Nenhum dado inserido");
            return true;
        }else{
            return false;
        }
    }
}