package invoicing.invoice;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Invoice {

    private double value;
    private String name;
    private java.sql.Date maturity;
    private String descriptionInvoice;

    public Invoice(){
        this.value = 0;
        this.name = "";
        this.maturity = null;
        this.descriptionInvoice = "";
    }

    public double getValue(){
        return value;
    }

    public String getName(){
        return name;
    }

    public Date getMaturity(){
        return maturity;
    }

    public String getDescriptionInvoice(){
        return descriptionInvoice;
    }

    public void setValue(double value){
        this.value = value;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMaturity(Date maturity){
        this.maturity = maturity;
    }

    public void setDescriptionInvoice(String description){
        this.descriptionInvoice = description;
    }
}
