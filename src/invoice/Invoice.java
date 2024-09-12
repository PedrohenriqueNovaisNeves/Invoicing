package invoice;

public class Invoice {

    private double value;
    private String name;
    private String maturity;
    private String descriptionInvoice;

    public Invoice(){
        this.value = 0;
        this.name = "";
        this.maturity = "";
        this.descriptionInvoice = "";
    }

    public double getValue(){
        return value;
    }

    public String getName(){
        return name;
    }

    public String getMaturity(){
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

    public void setMaturity(String maturity){
        this.maturity = maturity;
    }

    public void setDescriptionInvoice(String description){
        this.descriptionInvoice = description;
    }
}
