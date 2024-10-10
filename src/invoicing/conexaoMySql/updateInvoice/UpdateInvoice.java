package invoicing.conexaoMySql.updateInvoice;
import invoicing.conexaoMySql.ConexaoMySql;
import java.sql.*;

public class UpdateInvoice {

    ConexaoMySql connection = new ConexaoMySql();

    public UpdateInvoice(){}

    public void UpdateAllDataInvoice(int idInvoice, String nameInvoice, double valueInvoice, String descriptionInvoice, String maturity){
        try(PreparedStatement UpdateAllData = connection.getConexaoMySQL().prepareStatement("update faturas set nomeFatura = ?, valorFatura = ?, descricaoFatura = ?, vencimento = ? where idFatura = ?")){
            UpdateAllData.setString(1, nameInvoice);
            UpdateAllData.setDouble(2, valueInvoice);
            UpdateAllData.setString(3, descriptionInvoice);
            UpdateAllData.setString(4, maturity);
            UpdateAllData.setInt(5, idInvoice);

            int Update = UpdateAllData.executeUpdate();

            if(Update == 1){
                System.out.println("update completed successfully");
            }else{
                System.out.println("Update not completed");
            }

            UpdateAllData.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error in updating invoicing.invoice");
            e.printStackTrace();
        }
    }

    public void UpdateNameInvoice(String nameInvoice, int idInvoice){
        try(PreparedStatement UpdateNameInvoice = connection.getConexaoMySQL().prepareStatement("update faturas set nomeFatura = ? where idFatura = ?")){
            UpdateNameInvoice.setString(1, nameInvoice);
            UpdateNameInvoice.setInt(2, idInvoice);

            int update = UpdateNameInvoice.executeUpdate();

            if(update == 1){
                System.out.println("Update completed successfully");
            }else{
                System.out.println("Update not completed");
            }

            UpdateNameInvoice.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error in updating nameInvoice");
            e.printStackTrace();
        }
    }

    public void UpdateValueInvoice(double valueInvoice, int idInvoice){
        try(PreparedStatement UpdateValue = connection.getConexaoMySQL().prepareStatement("Update faturas set valorFatura = ? where idFatura = ?")){
            UpdateValue.setDouble(1, valueInvoice);
            UpdateValue.setInt(2, idInvoice);

            int update = UpdateValue.executeUpdate();

            if(update == 1){
                System.out.println("Update completed successfully");
            }else{
                System.out.println("Update not completed");
            }

            UpdateValue.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error in updating");
            e.printStackTrace();
        }
    }

    public void UpdateDescription(String description, int idInvoice){
        try(PreparedStatement UpdateDescription = connection.getConexaoMySQL().prepareStatement("update faturas set descricaoFatura = ? where idFatura = ?")){
            UpdateDescription.setString(1, description);
            UpdateDescription.setInt(2, idInvoice);

            int update = UpdateDescription.executeUpdate();

            if(update == 1){
                System.out.println("Update completed successfully");
            }else{
                System.out.println("Update not completed");
            }

            UpdateDescription.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error in updating");
            e.printStackTrace();
        }
    }

    public void UpdateMaturity(String maturity, int idInvoice){
        try(PreparedStatement UpdateMaturity = connection.getConexaoMySQL().prepareStatement("update faturas set vencimento = ? where idFatura = ?")){
            UpdateMaturity.setString(1, maturity);
            UpdateMaturity.setInt(2, idInvoice);

            int update = UpdateMaturity.executeUpdate();

            if(update == 1){
                System.out.println("Update completed successfully");
            }else{
                System.out.println("Update not completed");
            }

            UpdateMaturity.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error in updating");
            e.printStackTrace();
        }
    }
}
