package invoicing.conexaoMySql.deletesInvoice;
import invoicing.conexaoMySql.ConexaoMySql;

import java.sql.*;

public class DeletesInvoice {

    ConexaoMySql connection = new ConexaoMySql();

    public DeletesInvoice(){}

    public void DeleteAllDataInvoice(String nameInvoice){
        try(PreparedStatement DeleteInvoice = connection.getConexaoMySQL().prepareStatement("delete from faturas where nomeFatura = ?")){
            DeleteInvoice.setString(1, nameInvoice);

            int deleteInvoice = DeleteInvoice.executeUpdate();

            if(deleteInvoice == 1){
                System.out.println("Delete completed successfully");
            }else{
                System.out.println("Delete not completed");
            }

            DeleteInvoice.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error in delete invoicing.invoice");
        }
    }
}
