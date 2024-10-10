package invoicing.validations;

public class validations {

    public validations(){}

    public boolean checkChoice(int selection){
        if((selection == 1) || (selection == 2)){
            return true;
        }else{
            return false;
        }
    }
}