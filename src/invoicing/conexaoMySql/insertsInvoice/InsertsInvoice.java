package invoicing.conexaoMySql.insertsInvoice;
import invoicing.conexaoMySql.ConexaoMySql;
import invoicing.invoice.Invoice;
import java.sql.*;
import java.sql.Date;


public class InsertsInvoice {


    ConexaoMySql connection = new ConexaoMySql();

    public InsertsInvoice(){}

    public void InsertInvoice(String nameInvoice, double valueInvoice, String descriptionInvoice, Date maturity, int idUser){
        try(PreparedStatement InsertInvoice = connection.getConexaoMySQL().prepareStatement("insert into faturas (nomeFatura, valorFatura, descricaoFatura, vencimento, idUsuario) values (?, ?, ?, ?, ?)")){
            InsertInvoice.setString(1, nameInvoice);
            InsertInvoice.setDouble(2, valueInvoice);
            InsertInvoice.setString(3, descriptionInvoice);
            InsertInvoice.setDate(4, maturity);
            InsertInvoice.setInt(5, idUser);

            int insert = InsertInvoice.executeUpdate();

            if(insert == 1){
                System.out.println("Invoice successfully registered");
            }else{
                System.out.println("registration not completed, check that all data is correct");
            }

            InsertInvoice.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("error when registering invoicing.invoice");
            e.printStackTrace();
        }
    }
}
