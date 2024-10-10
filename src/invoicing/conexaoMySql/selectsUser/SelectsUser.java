package invoicing.conexaoMySql.selectsUser;
import invoicing.conexaoMySql.ConexaoMySql;
import java.sql.*;

public class SelectsUser {

    private int idUser;

    ConexaoMySql connection = new ConexaoMySql();

    public SelectsUser(){}

    public void SelectUser(int idUser){
        try(PreparedStatement SelectUser = connection.getConexaoMySQL().prepareStatement("Select idUsuario from usuarios where idUsuario = ?")){
            SelectUser.setInt(1, idUser);

            try(ResultSet ResultSelect = SelectUser.executeQuery()){

                if(ResultSelect.next()){
                    int resultIdUser = ResultSelect.getInt("idUsuario");

                    //System.out.println("User with id: " + resultIdUser);
                    this.idUser = resultIdUser;
                }else{
                    System.out.println("User not found");
                }
            }catch (SQLException e){
                System.out.println("Error finding invoicing.user");
                e.printStackTrace();
            }

            SelectUser.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error finding");
            e.printStackTrace();
        }
    }

    public void SelectNameUser(String nameUser){;
        try(PreparedStatement SelectName = connection.getConexaoMySQL().prepareStatement("Select idUsuario from usuarios where nomeCompleto = ?")){
            SelectName.setString(1, nameUser);

            try (ResultSet resultSelct = SelectName.executeQuery()){
                if (resultSelct.next()) {
                    int idUser = resultSelct.getInt("idUsuario");
                    System.out.println("invoicing.user found");

                    this.idUser = idUser;
                }else{
                    System.out.println("invoicing.user not found");
                }
            }catch (SQLException e){
                System.out.println("Error finding invoicing.user");
                e.printStackTrace();
            }

            SelectName.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error finding");
            e.printStackTrace();
        }
    }

    public void SelectAllUser(String nameUser){
        try(PreparedStatement SelectAll = connection.getConexaoMySQL().prepareStatement("select * from usuarios where nomeCompleto = ?")){
            SelectAll.setString(1, nameUser);

            try(ResultSet ResultSelect = SelectAll.executeQuery()){
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
                System.out.println("Error finding invoicing.user");
                e.printStackTrace();
            }

            SelectAll.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error finding ");
            e.printStackTrace();
        }
    }

    public int getIdUser(){
        return idUser;
    }
}
