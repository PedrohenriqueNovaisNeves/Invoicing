package invoicing.conexaoMySql.deletesUser;
import invoicing.conexaoMySql.ConexaoMySql;

import java.sql.*;

public class DeletesUser {

    ConexaoMySql connection = new ConexaoMySql();

    public DeletesUser(){}

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
            System.out.println("Error in delete invoicing.user");
            e.printStackTrace();
        }
    }
}
