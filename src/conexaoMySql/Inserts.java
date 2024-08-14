package conexaoMySql;
import java.sql.*;

public class Inserts {

    ConexaoMySql conexao = new ConexaoMySql();

    public Inserts(){}

    public void insertUser(int idUsuario, String nome, String cpf, String RG, String email){
        try{
            String sql = "insert into usuarios (idUsuario, nomeCompleto, cpf, rg, email) values (?, ?, ?, ?, ?)";
            PreparedStatement insertUser = conexao.getConexaoMySQL().prepareStatement(sql);
            insertUser.setInt(1, idUsuario);
            insertUser.setString(2, nome);
            insertUser.setString(3, cpf);
            insertUser.setString(4, RG);
            insertUser.setString(5, email);
            int LinhasAfetadas = insertUser.executeUpdate();

            System.out.println(LinhasAfetadas + " Usuario(s) inserido(s)");

            insertUser.close();
            conexao.FecharConexao();
        }catch (SQLException e){
            System.out.println("Erro ao inserir usuario " + e);
        }
    }

    public void inserFatura(int idFatura, double valor, String nome,  String descricaoFatura, int idUsuario, String vencimento){
        try{
            String sql = "insert into faturas (idFatura, valorFatura, nomeFatura, descricaoFatura, idUsuario, vencimento) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertFatura = conexao.getConexaoMySQL().prepareStatement(sql);
            insertFatura.setInt(1, idFatura);
            insertFatura.setDouble(2, valor);
            insertFatura.setString(3, nome);
            insertFatura.setString(4, descricaoFatura);
            insertFatura.setInt(5, idUsuario);
            insertFatura.setString(6, vencimento);
            int LinhasAfetadas = insertFatura.executeUpdate();

            System.out.println(LinhasAfetadas + " Fatura(s) inserida(s)");

            insertFatura.close();
            conexao.FecharConexao();


        }catch (SQLException e){
            System.out.println("Erro ao inserir fatura " + e);
        }
    }
}
