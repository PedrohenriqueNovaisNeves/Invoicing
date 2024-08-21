package conexaoMySql;

import java.sql.*;

public class Updates {

    ConexaoMySql connection = new ConexaoMySql();

    public Updates(){}

    public void UpdateAllDataUser(String name, String cpf, String rg, String email, int idUser){
        String sqlUpdateAll = "update usuarios set nomeCompleto = ?, cpf = ?, rg = ?, email = ? where idUsuario = ?";

        try(PreparedStatement UpdateUser = connection.getConexaoMySQL().prepareStatement(sqlUpdateAll)){
            UpdateUser.setString(1, name);
            UpdateUser.setString(2, cpf);
            UpdateUser.setString(3, rg);
            UpdateUser.setString(4, email);
            UpdateUser.setInt(5, idUser);


            UpdateUser.executeUpdate();
            System.out.println("update completed successfully");
            
            UpdateUser.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error when updating data");
        }
    }

    public void UpdateAllDataInvoice(String nameInvoice, double value, String description, String maturity, int idInvoice){
        try(PreparedStatement UpdateInvocie = connection.getConexaoMySQL().prepareStatement("update faturas set nomeFatura = ?, valorFatura = ?, descricaoFatura = ?, vencimento = ? where idFatura = ?")){
            UpdateInvocie.setString(1, nameInvoice);
            UpdateInvocie.setDouble(2, value);
            UpdateInvocie.setString(3, description);
            UpdateInvocie.setString(4, maturity);
            UpdateInvocie.setInt(5, idInvoice);

            UpdateInvocie.executeUpdate();
            System.out.println("update completed successfully");

            UpdateInvocie.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error when updating data");
        }
    }
}
