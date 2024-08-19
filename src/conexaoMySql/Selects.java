package conexaoMySql;
import java.sql.*;

public class Selects {

     ConexaoMySql connection = new ConexaoMySql();

     public void SelectUser(int idUser){
          String sqlSelectUser = "Select idUsuario from usuarios where idUsuario = ?";
          try(PreparedStatement SelectUser = connection.getConexaoMySQL().prepareStatement(sqlSelectUser)){
               SelectUser.setInt(1, idUser);

               try(ResultSet ResultSelect = SelectUser.executeQuery()){

                    if(ResultSelect.next()){
                         int resultIdUser = ResultSelect.getInt("idUsuario");

                         System.out.println("User with id: " + resultIdUser);
                    }else{
                         System.out.println("User not found");
                    }
               }catch (SQLException e){
                    System.out.println("Error finding user");
                    e.printStackTrace();
               }
          }catch (SQLException e){
               System.out.println("Error finding");
               e.printStackTrace();
          }
     }

     public void SelectInvoice(int idInvoice){
          String sqlSelectInvoice = "select idFatura from faturas where idFatura = ?";

          try(PreparedStatement SelectInvoice = connection.getConexaoMySQL().prepareCall(sqlSelectInvoice)){
               SelectInvoice.setInt(1, idInvoice);

               try(ResultSet ResultSelect = SelectInvoice.executeQuery()){
                    if(ResultSelect.next()){
                         int resultIdInvoice = ResultSelect.getInt("idFatura");
                         System.out.println("Invoice with id: " + resultIdInvoice);
                    }else{
                         System.out.println("User not found");
                    }
               }catch (SQLException e){
                    System.out.println("Error finding user");
                    e.printStackTrace();
               }

          }catch (SQLException e){
               System.out.println("Error finding");
               e.printStackTrace();
          }
     }

     public void SelectNameUser(String nameUser){
          try{
               String sqlSelectName = "Select idUsuario from usuarios where nomeCompleto = (?)";
               PreparedStatement SelectName = connection.getConexaoMySQL().prepareStatement(sqlSelectName);
               SelectName.setString(1, nameUser);
               ResultSet resultSelct = SelectName.executeQuery();

               try {
                    if (resultSelct.next()) {
                         int idUser = resultSelct.getInt("idUsuario");
                         System.out.println("user found");
                    }else{
                         System.out.println("user not found");
                    }
               }catch (SQLException e){
                    System.out.println("Error finding user");
                    e.printStackTrace();
               }

               SelectName.close();
               connection.FecharConexao();
          }catch (SQLException e){
               System.out.println("Error finding");
               e.printStackTrace();
          }
     }

     public void SelectNameFatura(String nameFatura){
          try{
               String sqlSelectInvoice = "select idFatura from faturas where nomeFatura = ?";
               PreparedStatement SelectInvoice = connection.getConexaoMySQL().prepareStatement(sqlSelectInvoice);
               SelectInvoice.setString(1, nameFatura);
               ResultSet ResultSelect = SelectInvoice.executeQuery();

               try{
                    if(ResultSelect.next()){
                         int idInvoice = ResultSelect.getInt("idFatura");
                         System.out.println("Invoice found");
                    }else {
                         System.out.println("Invoice not found");
                    }
               }catch (SQLException e){
                    System.out.println("Error finding Invoice");
                    e.printStackTrace();
               }

               SelectInvoice.close();
               connection.FecharConexao();
          }catch (SQLException e){
               System.out.println("Error finding ");
               e.printStackTrace();
          }
     }

     public void SelectAllUser(String nameUser){
          try{
               String sqlSelect = "select * from usuarios where nomeCompleto = ?";
               PreparedStatement SelectAll = connection.getConexaoMySQL().prepareStatement(sqlSelect);
               SelectAll.setString(1, nameUser);
               ResultSet ResultSelect = SelectAll.executeQuery();

               try{
                    if(ResultSelect.next()){
                         String NameUser = ResultSelect.getString("nomeCompleto");
                         int IdUser = ResultSelect.getInt("idUsuario");
                         String cpfUser = ResultSelect.getString("cpf");
                         String rgUser = ResultSelect.getString("rg");
                         String emailUser = ResultSelect.getString("email");

                         System.out.println("User: " + NameUser);
                         System.out.println("with the id: " + IdUser);
                         System.out.println("CPF: " + cpfUser);
                         System.out.println("RG: " + rgUser);
                         System.out.println("E-MAIL: " + emailUser);

                    }else{
                         System.out.println("User not found");
                    }
               }catch (SQLException e){
                    System.out.println("Error finding user");
                    e.printStackTrace();
               }

               SelectAll.close();
               connection.FecharConexao();
          }catch (SQLException e){
               System.out.println("Error finding ");
               e.printStackTrace();
          }
     }

     public void SelectAllInvoice(String nameInvoice){
          String sqlSelectAllInvoice = "select * from faturas where nomeFatura = ?";

          try(PreparedStatement SelectInvoice = connection.getConexaoMySQL().prepareStatement(sqlSelectAllInvoice)){
               SelectInvoice.setString(1, nameInvoice);

               try(ResultSet ResultSelect = SelectInvoice.executeQuery()){

                    if(ResultSelect.next()){
                         String NameInvoice = ResultSelect.getString("nomeFatura");
                         int IdInvoice = ResultSelect.getInt("idFatura");
                         double ValueInvoice = ResultSelect.getDouble("valorFatura");
                         String descriptionInvoice = ResultSelect.getString("descricaoFatura");
                         // id referencing the user in the invoices table
                         int IdUser = ResultSelect.getInt("idUsuario");
                         String maturityInvoice = ResultSelect.getString("vencimento");

                         System.out.println("Invoice found!");
                         System.out.println("Name invoice: " + NameInvoice);
                         System.out.println("with the id: " + IdInvoice);
                         System.out.println("invoice registered by the user with the id: " + IdUser);
                         System.out.println("Invoice value: " + ValueInvoice);
                         System.out.println("Invoice description: " + descriptionInvoice);
                         System.out.println("Invoice Maturity: " + maturityInvoice);
                    }
               }catch (SQLException e){
                    System.out.println("Error finding User");
                    e.printStackTrace();
               }

               SelectInvoice.close();
               connection.FecharConexao();
          }catch (SQLException e){
               System.out.println("Error finding");
               e.printStackTrace();
          }
     }
}