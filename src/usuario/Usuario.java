package usuario;

public class Usuario {
    private String nome;
    private String CPF;
    private String RG;
    private String email;
    private int idUsuario;


    public Usuario(){
        this.nome = "";
        this.CPF = "";
        this.RG = "";
        this.email = "";
        this.idUsuario = 0;
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

    public boolean setCPF(String cpf){
        if(this.CPF.equals("")){
            this.CPF = cpf;
            return true;
        }else{
            return false;
        }
    }

    public String getCPF(){
        return CPF;
    }

    public boolean setRG(String rg){
        if(this.RG.equals("")){
            this.RG = rg;
            return true;
        }else{
            return false;
        }
    }

    public String getRG(){
        return RG;
    }

    public boolean setEmail(String email){
        if(this.email.equals("")) {
            this.email = email;
            return true;
        }else{
            return false;
        }
    }

    public String getEmail(){
        return email;
    }

    public boolean setIdUsuario(int id){
        if(this.idUsuario == 0){
            this.idUsuario = id;
            return true;
        }else{
            return false;
        }
    }

    public int getIdUsuario(){
        return idUsuario;
    }

    public void mostrarDados(){
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + CPF);
        System.out.println("RG: " + RG);
        System.out.println("Email: " + email);
    }

    public boolean confirmaUsuario(){
        if((this.nome.equals(""))||(this.CPF.equals(""))||(this.RG.equals(""))||(this.email.equals(""))){
            return true;
        }else{
            return false;
        }
    }
}