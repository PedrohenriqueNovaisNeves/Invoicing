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
                    System.out.println("Usuario localizado " + idUser);
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
                    System.out.println("Fatura localizada " + idFatura);
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

     public void selectionUpdate(String name){
          try{
               String sqlSearchUser = "Select idUsuario from usuarios where nomeCompleto = (?)";
               PreparedStatement SearchUser = connection.getConexaoMySQL().prepareStatement(sqlSearchUser);
               SearchUser.setString(1, name);
               ResultSet resultSearch = SearchUser.executeQuery();
               System.out.println("Pare");

               try {
                    if (resultSearch.next()) {
                         int idUser = resultSearch.getInt(Integer.parseInt(name));
                         System.out.println("user located in our database " + idUser);
                    } else {
                         System.out.println("User not found");
                    }
               }catch (SQLException e){
                    System.out.println("Error finding user, Possibly the data doesn't match " + e);
               }

          }catch (SQLException e){
               System.out.println("Error finding user " + e);
          }
     }
}
