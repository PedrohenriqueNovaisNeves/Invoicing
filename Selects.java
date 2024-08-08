package conexaoMySql;
import java.sql.*;

public class Selects {

     ConexaoMySql conexao = new ConexaoMySql();

     public void selectUser(int idUser){
          try{
               String buscaUser = "select idUsuario from usuarios where (?)";
               PreparedStatement busca = conexao.getConexaoMySQL().prepareStatement(buscaUser);
               busca.setInt(1, idUser);
               ResultSet resultadoBusca = busca.executeQuery();

               if(resultadoBusca.next()){
                    idUser = resultadoBusca.getInt(idUser);
                    System.out.println("Usuario localizado " + idUser);
               }else{
                    System.out.println("Usuario nao localizado em nossa base de dados!");
               }

               busca.close();
               conexao.FecharConexao();
          }catch (SQLException e){
               System.out.println("Erro ao localizar usuario " + e);
          }
     }

     public void selectFatura(int idFatura){
          try{
               String buscaFatura = "select idFatura from faturas where (?)";
               PreparedStatement busca = conexao.getConexaoMySQL().prepareStatement(buscaFatura);
               busca.setInt(1, idFatura);
               ResultSet resultadoBusca = busca.executeQuery();

               if(resultadoBusca.next()){
                    idFatura = resultadoBusca.getInt(idFatura);
                    System.out.println("Fatura localizada " + idFatura);
               }

               busca.close();
               conexao.FecharConexao();

          }catch (SQLException e){
               System.out.println("Erro ao localizar fatura " + e);
          }
     }

     public void selectFaturaAndUser(int idFatura, int idUser){
          try{
               String sqlBuscaFatura = "select idFatura from faturas where (?)";
               String sqlBuscaUser = "select nomeCompleto from usuarios where (?)";
               PreparedStatement buscaFatura = conexao.getConexaoMySQL().prepareStatement(sqlBuscaFatura);
               PreparedStatement buscaUser = conexao.getConexaoMySQL().prepareStatement(sqlBuscaUser);
               buscaFatura.setInt(1, idFatura);
               buscaUser.setInt(1, idUser);
               ResultSet resultadoBuscaFatura = buscaFatura.executeQuery();
               ResultSet resultadoBuscaUser = buscaUser.executeQuery();

               if((resultadoBuscaFatura.next()) && (resultadoBuscaUser.next())){
                    idFatura = resultadoBuscaFatura.getInt(idFatura);
                    idUser = resultadoBuscaUser.getInt(Integer.toString(idUser));
                    System.out.println("Fatura " + idFatura + " Cadastrada pelo usuario " + idUser);
               }

          }catch (SQLException e){
               System.out.println("Erro ao localizar fatura e usuario" + e);
          }
     }
}
