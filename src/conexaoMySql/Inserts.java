package conexaoMySql;
import java.sql.*;

public class Inserts {

    ConexaoMySql connection = new ConexaoMySql();

    public Inserts(){}

    public void InsertUser(String nameUser, String cpf, String rg, String email){
        try(PreparedStatement InsertUser = connection.getConexaoMySQL().prepareStatement("insert into usuarios (nomeCompleto, cpf, rg, email) values (?, ?, ?, ?)")){
            InsertUser.setString(1, nameUser);
            InsertUser.setString(2, cpf);
            InsertUser.setString(3, rg);
            InsertUser.setString(4, email);

            int Insert = InsertUser.executeUpdate();

            if(Insert == 1){
                System.out.println("user successfully registered");
            }else{
                System.out.println("registration not completed, check that all data is correct");
            }

            InsertUser.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("error when registering user");
            e.printStackTrace();
        }
    }

    public void InsertInvoice(String nameInvoice, double valueInvoice, String descriptionInvoice, String maturity, int idUser){
        try(PreparedStatement InsertInvoice = connection.getConexaoMySQL().prepareStatement("insert into faturas (nomeFatura, valorFatura, descricaoFatura, vencimento, idUsuario) values (?, ?, ?, ?, ?)")){
            InsertInvoice.setString(2, nameInvoice);
            InsertInvoice.setDouble(3, valueInvoice);
            InsertInvoice.setString(4, descriptionInvoice);
            InsertInvoice.setString(5, maturity);
            InsertInvoice.setInt(6, idUser);

            int insert = InsertInvoice.executeUpdate();

            if(insert == 1){
                System.out.println("Invoice successfully registered");
            }else{
                System.out.println("registration not completed, check that all data is correct");
            }

            InsertInvoice.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("error when registering invoice");
        }
    }
}