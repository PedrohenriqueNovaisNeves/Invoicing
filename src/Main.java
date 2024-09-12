import conexaoMySql.*;
import user.*;
import java.util.Scanner;
import invoice.*;
import validacoes.Validacoes;

public class Main {
    public static void main(String[] args) {
        ConexaoMySql connection = new ConexaoMySql();
        connection.getConexaoMySQL();
        System.out.println(connection.statusConection());
        Inserts inserts = new Inserts();
        Selects selects = new Selects();
        UpdatesUser updateUser = new UpdatesUser();
        UpdateInvoice updateInvoice = new UpdateInvoice();
        Deletes deleteUser = new Deletes();
        Validacoes valida = new Validacoes();
        User user1 = new User();
        Invoice fatura = new Invoice();

    }
}