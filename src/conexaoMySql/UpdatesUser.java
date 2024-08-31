package conexaoMySql;
import java.sql.*;

public class UpdatesUser {

    ConexaoMySql connection = new ConexaoMySql();

    public UpdatesUser(){}

    public void UpdateAllDataUser(String name, String cpf, String rg, String email, int idUser){
        try(PreparedStatement UpdateUser = connection.getConexaoMySQL().prepareStatement("update usuarios set nomeCompleto = ?, cpf = ?, rg = ?, email = ? where idUsuario = ?")){
            UpdateUser.setString(1, name);
            UpdateUser.setString(2, cpf);
            UpdateUser.setString(3, rg);
            UpdateUser.setString(4, email);
            UpdateUser.setInt(5, idUser);

            int update = UpdateUser.executeUpdate();

            if(update == 1){
                System.out.println("update completed successfully");
            }else{
                System.out.println("Update not completed");
            }
            
            UpdateUser.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("error in updating data");
        }
    }

    public void UpdateAllDataInvoice(String nameInvoice, double value, String description, String maturity, int idInvoice){
        try(PreparedStatement UpdateInvocie = connection.getConexaoMySQL().prepareStatement("update faturas set nomeFatura = ?, valorFatura = ?, descricaoFatura = ?, vencimento = ? where idFatura = ?")){
            UpdateInvocie.setString(1, nameInvoice);
            UpdateInvocie.setDouble(2, value);
            UpdateInvocie.setString(3, description);
            UpdateInvocie.setString(4, maturity);
            UpdateInvocie.setInt(5, idInvoice);

            int update = UpdateInvocie.executeUpdate();

            if(update == 1){
                System.out.println("update completed successfully");
            }else{
                System.out.println("Update not completed");
            }

            UpdateInvocie.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("error in updating data");
        }
    }

    public void UpdateUserName(String name, int idUser){
        try(PreparedStatement UpdateName = connection.getConexaoMySQL().prepareStatement("update usuarios set nomeCompleto = ? where idUsuario = ?")){
            UpdateName.setString(1, name);
            UpdateName.setInt(2, idUser);

            int update = UpdateName.executeUpdate();

            if(update == 1){
                System.out.println("Update completed successfully");
            }else{
                System.out.println("Update not completed");
            }

            UpdateName.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("error in updating data");
            e.printStackTrace();
        }
    }

    public void UpdateCpfUser(String cpf, int idUser){
        try(PreparedStatement UpdateCpf = connection.getConexaoMySQL().prepareStatement("Update usuarios set cpf = ? where idUsuario = ?")){
            UpdateCpf.setString(1, cpf);
            UpdateCpf.setInt(2, idUser);

            int update = UpdateCpf.executeUpdate();

            if(update == 1){
                System.out.println("Update completed successfully");
            }else{
                System.out.println("Update not completed");
            }

            UpdateCpf.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error in updating data");
            e.printStackTrace();
        }
    }

    public void UpdateRgUser(String rg, int idUser){
        try(PreparedStatement UpdateRg = connection.getConexaoMySQL().prepareStatement("update usuarios set rg = ? where idUsuario = ?")){
            UpdateRg.setString(1, rg);
            UpdateRg.setInt(2, idUser);

            int update = UpdateRg.executeUpdate();

            if(update == 1){
                System.out.println("Update completed successfully");
            }else{
                System.out.println("Update not completed");
            }

            UpdateRg.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error in updating data");
            e.printStackTrace();
        }
    }

    public void UpdateEmailUser(String email, int idUser){
        try(PreparedStatement UpdateEmail = connection.getConexaoMySQL().prepareStatement("update usuarios set email = ? where idUsuario = ?")){
            UpdateEmail.setString(1, email);
            UpdateEmail.setInt(2, idUser);

            int update = UpdateEmail.executeUpdate();

            if(update == 1){
                System.out.println("Update completed successfully");
            }else{
                System.out.println("update not completed");
            }

            UpdateEmail.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error in updating data");
            e.printStackTrace();
        }
    }
}
