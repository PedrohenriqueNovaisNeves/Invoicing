package conexaoMySql;
import java.sql.*;

public class Deletes {

    ConexaoMySql connection = new ConexaoMySql();

    public Deletes(){}

    public void DeleteAllData(String nameUser){
        try(PreparedStatement DeleteData = connection.getConexaoMySQL().prepareStatement("delete from usuarios where nomeCompleto = ?")){
            DeleteData.setString(1, nameUser);

            int deleteUser = DeleteData.executeUpdate();

            if(deleteUser == 1){
                System.out.println("Delete completed successfully");
            }else{
                System.out.println("Delete not completed");
            }

            DeleteData.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error in delete user");
            e.printStackTrace();
        }
    }

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
            System.out.println("Error in delete invoice");
        }
    }
}
