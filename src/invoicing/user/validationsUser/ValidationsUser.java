package invoicing.user.validationsUser;

public class ValidationsUser {

    public ValidationsUser(){
    }

    public boolean nameValidation(String name){
        if(name.equals("")){
            System.out.println("Name not entered");
            return true;
        }else{
            return false;
        }
    }

    public boolean cpfInsertionValidation(String cpf){
        if(cpf.equals("")){
            System.out.println("CPF not entered");
            return true;
        }else{
            return false;
        }
    }

    public boolean rgValidation(String rg){
        if(rg.equals("")){
            System.out.println("RG not entered");
            return true;
        }else{
            return false;
        }
    }

    public boolean emailValidation(String email){
        if((email.equals(""))){
            System.out.println("Email not entered");
            return true;
        }else{
            return false;
        }
    }

    public boolean cpfValidation(String cpf) {
        char[] convertStringtoChar = cpf.toCharArray();
        int numberOfCharacters = convertStringtoChar.length;
        if (numberOfCharacters != 11){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkAllData(String name, String cpf, String rg, String email){
        if((name.equals("")) && (cpf.equals("")) && (rg.equals("")) && (email.equals(""))){
            return true;
        }else{
            return false;
        }
    }
}
