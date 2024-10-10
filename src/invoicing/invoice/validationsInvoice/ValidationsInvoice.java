package invoicing.invoice.validationsInvoice;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidationsInvoice {

    private Date dtFormated;

    public ValidationsInvoice() {
    }

    public boolean nameValidation(String name) {
        if (name.equals("")) {
            System.out.println("Name not entered");
            return true;
        } else {
            return false;
        }
    }

    public boolean descriptionValidation(String description){
        if(description.equals("")){
            System.out.println("description not entered");
            return true;
        }else{
            return false;
        }
    }

    public boolean maturityValidation(Date maturity){
        if(maturity.equals("")){
            System.out.println("maturity not entered");
            return true;
        }else{
            return false;
        }
    }

    public boolean invoiceValidation(double value, String name, Date maturity, String description){
        if((value == 0) && (name.equals("")) && (maturity == null) && (description.equals(""))){
            return true;
        }else{
            return false;
        }
    }
}
