package conexaoMySql;
import java.sql.*;

public class Inserts {

    ConexaoMySql connection = new ConexaoMySql();

    public Inserts(){}

    public void InsertUser(int idUser, String nameUser, String cpf, String rg, String email){
        try(PreparedStatement InsertUser = connection.getConexaoMySQL().prepareStatement("insert into usuarios (idUsuario, nomeCompleto, cpf, rg, email) values (?, ?, ?, ?, ?)")){
            InsertUser.setInt(1, idUser);
            InsertUser.setString(2, nameUser);
            InsertUser.setString(3, cpf);
            InsertUser.setString(4, rg);
            InsertUser.setString(5, email);

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

    public void InsertInvoice(int idInvoice, String nameInvoice, double valueInvoice, String descriptionInvoice, String maturity, int idUser){
        try(PreparedStatement InsertInvoice = connection.getConexaoMySQL().prepareStatement("insert into faturas (idFatura, nomeFatura, valorFatura, descricaoFatura, vencimento, idUsuario) values (?, ?, ?, ?, ?, ?)")){
            InsertInvoice.setInt(1, idInvoice);
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
