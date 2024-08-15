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

     public void selectName(String name){
          try{
               String sqlSelectName = "Select idUsuario from usuarios where nomeCompleto = (?)";
               PreparedStatement SelectName = connection.getConexaoMySQL().prepareStatement(sqlSelectName);
               SelectName.setString(1, name);
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
}
