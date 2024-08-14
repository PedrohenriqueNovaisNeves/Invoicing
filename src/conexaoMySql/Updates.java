package conexaoMySql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Updates {

    ConexaoMySql connection = new ConexaoMySql();

    public void updateData (int idUser, String name, String cpf, String RG, String email){
        try{
            String sqlUpdateData = "update usuarios set nomeCompleto = (?), cpf = (?), rg = (?), email = (?) where idUsuario = (?)";
            PreparedStatement updateData = connection.getConexaoMySQL().prepareStatement(sqlUpdateData);
            updateData.setString(1, name);
            updateData.setString(2, cpf);
            updateData.setString(3, RG);
            updateData.setString(4,email);
            updateData.setString(5, email);
            updateData.setInt(6, idUser);


        }catch (SQLException e){
            System.out.println("Error to the update data");
        }
    }
}
