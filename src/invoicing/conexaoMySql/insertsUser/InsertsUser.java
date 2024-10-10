package invoicing.conexaoMySql.insertsUser;
import invoicing.conexaoMySql.ConexaoMySql;

import java.sql.*;

public class InsertsUser {

    ConexaoMySql connection = new ConexaoMySql();

    public InsertsUser(){}

    public void InsertUser(String nameUser, String cpf, String rg, String email){
        try(PreparedStatement InsertUser = connection.getConexaoMySQL().prepareStatement("insert into usuarios (nomeCompleto, cpf, rg, email) values (?, ?, ?, ?)")){
            InsertUser.setString(1, nameUser);
            InsertUser.setString(2, cpf);
            InsertUser.setString(3, rg);
            InsertUser.setString(4, email);

            int Insert = InsertUser.executeUpdate();

            if(Insert == 1){
                System.out.println("invoicing.user successfully registered");
            }else{
                System.out.println("registration not completed, check that all data is correct");
            }

            InsertUser.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("error when registering invoicing.user");
            e.printStackTrace();
        }
    }
}
