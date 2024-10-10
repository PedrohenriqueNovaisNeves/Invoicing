package invoicing.conexaoMySql.selectsInvoice;
import invoicing.conexaoMySql.ConexaoMySql;
import java.sql.*;

public class SelectsInvoice {

    ConexaoMySql connection = new ConexaoMySql();

    public SelectsInvoice(){}

    public void SelectInvoice(int idInvoice){
        try(PreparedStatement SelectInvoice = connection.getConexaoMySQL().prepareCall("select idFatura from faturas where idFatura = ?")){
            SelectInvoice.setInt(1, idInvoice);

            try(ResultSet ResultSelect = SelectInvoice.executeQuery()){
                if(ResultSelect.next()){
                    int resultIdInvoice = ResultSelect.getInt("idFatura");
                    System.out.println("Invoice with id: " + resultIdInvoice);
                }else{
                    System.out.println("User not found");
                }
            }catch (SQLException e){
                System.out.println("Error finding invoicing.user");
                e.printStackTrace();
            }

            SelectInvoice.close();
            connection.FecharConexao();
        }catch (SQLException e){
            System.out.println("Error finding");
            e.printStackTrace();
        }
    }

    public void SelectNameInvoice(String nameInvoice){;
        try(PreparedStatement SelectInvoice = connection.getConexaoMySQL().prepareStatement("select idFatura from faturas where nomeFatura = ?")){
            SelectInvoice.setString(1, nameInvoice);

            try(ResultSet ResultSelect = SelectInvoice.executeQuery()){
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

    public void SelectAllInvoice(String nameInvoice){
        try(PreparedStatement SelectInvoice = connection.getConexaoMySQL().prepareStatement("select * from faturas where nomeFatura = ?")){
            SelectInvoice.setString(1, nameInvoice);

            try(ResultSet ResultSelect = SelectInvoice.executeQuery()){

                if(ResultSelect.next()){
                    String NameInvoice = ResultSelect.getString("nomeFatura");
                    int IdInvoice = ResultSelect.getInt("idFatura");
                    double ValueInvoice = ResultSelect.getDouble("valorFatura");
                    String descriptionInvoice = ResultSelect.getString("descricaoFatura");
                    // id referencing the invoicing.user in the invoices table
                    int IdUser = ResultSelect.getInt("idUsuario");
                    String maturityInvoice = ResultSelect.getString("vencimento");

                    System.out.println("Invoice found!");
                    System.out.println("Name invoicing.invoice: " + NameInvoice);
                    System.out.println("with the id: " + IdInvoice);
                    System.out.println("invoicing.invoice registered by the invoicing.user with the id: " + IdUser);
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
