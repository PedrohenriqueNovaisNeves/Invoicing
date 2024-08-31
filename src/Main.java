import conexaoMySql.*;
import usuario.*;
import java.util.Scanner;
import faturas.*;

public class Main {
    public static void main(String[] args) {
        ConexaoMySql conexao = new ConexaoMySql();
        conexao.getConexaoMySQL();
        System.out.println(conexao.statusConection());
        Inserts inserts = new Inserts();
        Usuario user = new Usuario();
        Scanner text = new Scanner(System.in);
        Scanner number = new Scanner(System.in);
        IdUsuario idUser = new IdUsuario();
        Faturas fatura = new Faturas();
        IdFaturas idFatura = new IdFaturas();
        Selects selects = new Selects();
        UpdatesUser updateUser = new UpdatesUser();
        UpdateInvoice updateInvoice = new UpdateInvoice();
        Deletes deleteUser = new Deletes();

        deleteUser.DeleteAllData("pedro");


    }
}