package conexaoMySql;
import java.sql.*;

public class Selects {

     ConexaoMySql conexao = new ConexaoMySql();

     public void selectUser(int idUser){
          try{
               String buscaUser = "select idUsuario from usuarios where (?)";
               PreparedStatement busca = conexao.getConexaoMySQL().prepareStatement(buscaUser);
               ResultSet resultadoBusca = busca.executeQuery();


          }catch (SQLException e){
               System.out.println("Erro ao localizar usuario " + e);
          }
     }
}
