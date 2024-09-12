package user;

public class User {
    private String name;
    private String CPF;
    private String RG;
    private String email;

    public User(){
        this.name = "";
        this.CPF = "";
        this.RG = "";
        this.email = "";
    }

    public String getName(){
        return name;
    }

    public String getCPF(){
        return CPF;
    }

    public String getRG(){
        return RG;
    }

    public String getEmail(){
        return email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCPF(String cpf){
        this.CPF = cpf;
    }

    public void setRG(String RG){
        this.RG = RG;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public boolean confirmUser(){
        if((this.name.equals(""))||(this.CPF.equals(""))||(this.RG.equals(""))||(this.email.equals(""))){
            return true;
        }else{
            return false;
        }
    }

    public boolean setName1(String name){
        if(!this.name.equals("")){
            this.name = name;
            return true;
        }else{
            return false;
        }
    }
}