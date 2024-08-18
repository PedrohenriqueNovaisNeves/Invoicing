package conexaoMySql;
import java.sql.*;

public class Selects {

     ConexaoMySql connection = new ConexaoMySql();

     public void selectUser(int idUser){
          try{
               String buscaUser = "select idUsuario from usuarios where (?)";
               PreparedStatement busca = connection.getConexaoMySQL().prepareStatement(buscaUser);
               busca.setInt(1, idUser);
               ResultSet resultadoBusca = busca.executeQuery();

               if(resultadoBusca.next()){
                    idUser = resultadoBusca.getInt(idUser);
                    System.out.println("Usuario localizado ");
               }else{
                    System.out.println("Usuario nao localizado em nossa base de dados!");
               }

               busca.close();
               connection.FecharConexao();
          }catch (SQLException e){
               System.out.println("Erro ao localizar usuario " + e);
          }
     }

     public void selectFatura(int idFatura){
          try{
               String buscaFatura = "select idFatura from faturas where (?)";
               PreparedStatement busca = connection.getConexaoMySQL().prepareStatement(buscaFatura);
               busca.setInt(1, idFatura);
               ResultSet resultadoBusca = busca.executeQuery();

               if(resultadoBusca.next()){
                    idFatura = resultadoBusca.getInt(idFatura);
                    System.out.println("Fatura localizada ");
               }

               busca.close();
               connection.FecharConexao();

          }catch (SQLException e){
               System.out.println("Erro ao localizar fatura " + e);
          }
     }

     public void selectFaturaAndUser(int idFatura, int idUser){
          try{
               String sqlBuscaFatura = "select nomeFatura from faturas where (?)";
               String sqlBuscaUser = "select nomeCompleto from usuarios where (?)";
               PreparedStatement buscaFatura = connection.getConexaoMySQL().prepareStatement(sqlBuscaFatura);
               PreparedStatement buscaUser = connection.getConexaoMySQL().prepareStatement(sqlBuscaUser);
               buscaFatura.setInt(1, idFatura);
               buscaUser.setInt(1, idUser);
               ResultSet resultadoBuscaFatura = buscaFatura.executeQuery();
               ResultSet resultadoBuscaUser = buscaUser.executeQuery();

               try {
                    if((resultadoBuscaFatura.next()) && (resultadoBuscaUser.next())) {
                         String usuario = resultadoBuscaUser.getString(idUser);
                         String fatura = resultadoBuscaFatura.getString(idFatura);
                         System.out.println("Fatura " + fatura + " cadastrada pelo usuario " + usuario);

                    }else{
                         System.out.println("Fatura e usuario nao localizados em nossa base de dados");
                    }
               }catch (NumberFormatException e){
                    System.out.println("Erro na conversao");
               }

               buscaFatura.close();
               buscaUser.close();
               connection.FecharConexao();
          }catch (SQLException e){
               System.out.println("Erro ao localizar fatura e usuario" + e);
          }
     }

     public void selectNameUser(String nameUser){
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

          }catch (SQLException e){
               System.out.println("Error in SQL query ");
               e.printStackTrace();
          }
     }

     public void selectNameFatura(String nameFatura){
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
          }catch (SQLException e){
               System.out.println("Error finding");
               e.printStackTrace();
          }
     }
}