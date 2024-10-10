package invoicing;

import invoicing.conexaoMySql.*;
import invoicing.conexaoMySql.deletesInvoice.DeletesInvoice;
import invoicing.conexaoMySql.deletesUser.DeletesUser;
import invoicing.conexaoMySql.insertsInvoice.InsertsInvoice;
import invoicing.conexaoMySql.insertsUser.InsertsUser;
import invoicing.conexaoMySql.selectsInvoice.SelectsInvoice;
import invoicing.conexaoMySql.selectsUser.SelectsUser;
import invoicing.conexaoMySql.updateInvoice.UpdateInvoice;
import invoicing.conexaoMySql.updatesUser.UpdatesUser;
import invoicing.invoice.validationsInvoice.*;
import invoicing.user.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import invoicing.invoice.*;
import invoicing.user.validationsUser.ValidationsUser;
import invoicing.validations.*;
import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        ConexaoMySql connection = new ConexaoMySql();
        connection.getConexaoMySQL();
        System.out.println(connection.statusConection());
        InsertsUser insertsUser = new InsertsUser();
        InsertsInvoice insertsInvoice = new InsertsInvoice();
        SelectsUser selectsUser = new SelectsUser();
        SelectsInvoice selectsInvoice = new SelectsInvoice();
        UpdatesUser updateUser = new UpdatesUser();
        UpdateInvoice updateInvoice = new UpdateInvoice();
        DeletesUser deletesUser = new DeletesUser();
        DeletesInvoice deletesInvoice = new DeletesInvoice();
        validations validations = new validations();
        User user1 = new User();
        Invoice invoice = new Invoice();
        ValidationsInvoice ValidationsInvoice = new ValidationsInvoice();
        ValidationsUser validationsUser = new ValidationsUser();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        //variaveis
        int selection;
        String confirmacao = null;
        char op = 'S';
        String ANSI_BOLD = "\033[1m";
        String ANSI_RESET = "\033[0m";

        do {
            Scanner text = new Scanner(System.in);
            Scanner number = new Scanner(System.in);

            System.out.println("Sejam muito bem vindos ao Invoicing!");
            System.out.println("Um programa novo e inovador voltado a um melhor controle das suas financas");
            System.out.println("-----------");
            System.out.println("Para utilizar nossos servicos e necessario ter um cadastro em nosso sistema");
            System.out.println("-----------");
            System.out.println("Para se cadastrar");
            System.out.println("Digite (1)");
            System.out.println("-----------");
            System.out.println("Caso ja tenha um cadastro e deseja logar");
            System.out.println("Digite (2)");
            System.out.print("DIGITE: ");
            selection = number.nextInt();

            while (!validations.checkChoice(selection)) {
                System.out.println("Digite somente o informado");
                selection = number.nextInt();
            }

            if (selection == 1) {
                System.out.println("Voce esta em nosso campo de Cadastro!!");
                System.out.println("----------");

                System.out.print("Digite seu nome: ");
                user1.setName(text.nextLine());
                System.out.println("---------------");

                System.out.print("Digite seu CPF: ");
                user1.setCPF(text.nextLine());
                while (validationsUser.cpfValidation(user1.getCPF())) {
                    System.out.println("O CPF inserido excedeu o limite permitido, ou nao esta completo");
                    System.out.print("Digite novamente: ");
                    user1.setCPF(text.nextLine());
                }
                System.out.println("---------------");

                System.out.print("Digite o seu RG:");
                user1.setRG(text.nextLine());
                System.out.println("---------------");

                System.out.println("Por ultimo, nos informe seu e-mail, para finalizarmos o seu cadastro");
                user1.setEmail(text.nextLine());
                System.out.println("---------------");

                if (user1.confirmUser()) {
                    if (validationsUser.checkAllData(user1.getName(), user1.getCPF(), user1.getRG(), user1.getEmail())) {
                        System.out.println("Digite novamente seus dados");
                        System.out.println("---------------------------");
                        System.out.print("Digite seu nome: ");
                        user1.setName(text.nextLine());
                        System.out.println("---------------------------");
                        System.out.print("Digite seu CPF: ");
                        user1.setCPF(text.nextLine());
                        System.out.println("---------------------------");
                        System.out.print("Digite seu RG: ");
                        user1.setRG(text.nextLine());
                        System.out.println("---------------------------");
                        System.out.print("Digite seu email: ");
                        user1.setEmail(text.nextLine());
                        System.out.println("---------------------------");

                        while (validationsUser.nameValidation(user1.getName())) {
                            System.out.print("Por favor, digite seu nome: ");
                            user1.setName(text.nextLine());
                        }
                        while (validationsUser.cpfInsertionValidation(user1.getCPF())) {
                            System.out.print("Por favor, digite seu CPF: ");
                            user1.setCPF(text.nextLine());
                        }
                        while (validationsUser.rgValidation(user1.getRG())) {
                            System.out.print("Por favor, digite seu RG: ");
                            user1.setRG(text.nextLine());
                        }
                        while (validationsUser.emailValidation(user1.getEmail())) {
                            System.out.print("Por favor, digite se EMAIL: ");
                            user1.setEmail(text.nextLine());
                        }

                        if (!validationsUser.checkAllData(user1.getName(), user1.getCPF(), user1.getRG(), user1.getEmail())) {
                            System.out.println("Cadastro realizado com sucesso!");
                            System.out.println("-------------------------------");
                        }
                    }

                    if (validationsUser.nameValidation(user1.getName())) {
                        System.out.println("Digite seu nome novamente: ");
                        user1.setName(text.nextLine());

                        while (validationsUser.nameValidation(user1.getName())) {
                            System.out.println("Por favor, digite seu nome");
                            System.out.print("Digite: ");
                            user1.setName(text.nextLine());
                        }
                        if (!validationsUser.nameValidation(user1.getName())) {
                            System.out.println("Nome cadastrado com sucesso!");
                            System.out.println("----------------------------");
                        }
                    }

                    if (validationsUser.cpfInsertionValidation(user1.getCPF())) {
                        System.out.println("Digite seu CPF novamente: ");
                        user1.setCPF(text.nextLine());

                        while (validationsUser.cpfInsertionValidation(user1.getCPF())) {
                            System.out.println("Por favor, digite seu CPF");
                            System.out.print("Digite: ");
                            user1.setCPF(text.nextLine());
                        }
                        if (!validationsUser.cpfInsertionValidation(user1.getCPF())) {
                            System.out.println("CPF cadastrado com sucesso!");
                            System.out.println("----------------------------");
                        }
                    }

                    if (validationsUser.rgValidation(user1.getRG())) {
                        System.out.println("Digite seu RG novamente: ");
                        user1.setRG(text.nextLine());

                        while (validationsUser.rgValidation(user1.getRG())) {
                            System.out.println("Por favor, digite seu RG");
                            System.out.print("Digite: ");
                            user1.setRG(text.nextLine());
                        }
                        if (!validationsUser.rgValidation(user1.getRG())) {
                            System.out.println("RG cadastrado com sucesso!");
                            System.out.println("---------------------------");
                        }
                    }

                    if (validationsUser.emailValidation(user1.getEmail())) {
                        System.out.println("Digite seu EMAIL novamente: ");
                        user1.setEmail(text.nextLine());

                        while (validationsUser.emailValidation(user1.getEmail())) {
                            System.out.println("Por favor, digite seu EMAIL");
                            System.out.print("Digite: ");
                            user1.setEmail(text.nextLine());
                        }
                        if (!validationsUser.emailValidation(user1.getEmail())) {
                            System.out.println("Email cadastrado com sucesso!");
                            System.out.println("-------------------------------");
                        }
                    }

                    System.out.println("Deseja consultar seus dados?");
                    confirmacao = text.nextLine().toUpperCase();

                    switch (confirmacao) {
                        case "SIM":
                            user1.showData();
                            break;
                    }
                    if (!user1.confirmUser()) {
                        insertsUser.InsertUser(user1.getName(), user1.getCPF(), user1.getRG(), user1.getEmail());
                    }
                } else {
                    insertsUser.InsertUser(user1.getName(), user1.getCPF(), user1.getRG(), user1.getEmail());
                    System.out.println("Cadastro realizado com sucesso!");
                    System.out.println("-----------------------------");
                    System.out.println("Deseja consultar seus dados?");
                    confirmacao = text.nextLine().toUpperCase();

                    switch (confirmacao) {
                        case "SIM":
                            user1.showData();
                            break;
                    }
                }

                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("Agora que seu cadastro foi realizado, aqui estao as funcionalidades do nosso sistema:");
                System.out.println(ANSI_BOLD + "CADASTRO DE FATURAS;" + ANSI_RESET);
                System.out.println(ANSI_BOLD + "VISUALIZACAO DE FATURAS;" + ANSI_RESET);
                System.out.println(ANSI_BOLD + "ATUALIZACAO DE FATURAS E/OU DADOS DAS FATURAS;" + ANSI_RESET);
                System.out.println(ANSI_BOLD + "EXCLUSAO DE FATURAS." + ANSI_RESET);
                System.out.println("----------------------------------------");

                System.out.println("Para cadastrar sua fatura, Digite OK");
                confirmacao = text.nextLine().toUpperCase();

                System.out.println("----------------------------------------");

                switch (confirmacao) {
                    case "OK":
                        System.out.println(ANSI_BOLD + "CADASTRO DE FATURAS" + ANSI_RESET);
                        System.out.println("---------------------------------------");

                        System.out.print("Para iniciarmos o cadastro das suas faturas, insira o titulo da sua fatura: ");
                        invoice.setName(text.nextLine());
                        while (ValidationsInvoice.nameValidation(invoice.getName())) {
                            System.out.println("Titulo nao inserido");
                            System.out.print("Digite novamente: ");
                            invoice.setName(text.nextLine());
                        }
                        System.out.println("-----------------------------------");

                        System.out.print("Digite o valor da sua fatura: ");
                        String value = text.nextLine();
                        while (value.equals("")) {
                            System.out.println("Valor nao inserido!");
                            System.out.print("Digite novamente: ");
                            value = text.nextLine();

                            if (!value.equals("")) {
                                double valueConverted = Double.parseDouble(value);
                                invoice.setValue(valueConverted);
                            }
                        }
                        double valueConverted = Double.parseDouble(value);
                        invoice.setValue(valueConverted);
                        System.out.println(invoice.getValue());
                        System.out.println("-----------------------------");

                        System.out.println("Digite a descricao da fatura inserida: ");
                        invoice.setDescriptionInvoice(text.nextLine());
                        while (ValidationsInvoice.descriptionValidation(invoice.getDescriptionInvoice())) {
                            System.out.println("Descricao nao inserida");
                            System.out.println("Digite novamente: ");
                            invoice.setDescriptionInvoice(text.nextLine());
                        }
                        System.out.println("---------------------------");

                        System.out.println("Digite a data de vencimento da sua fatura: ");
                        String dt = text.nextLine();
                        try{
                            java.util.Date dtFormated = format.parse(dt);
                            Date sqlDate = new Date(dtFormated.getTime());
                            invoice.setMaturity(sqlDate);
                        }catch (ParseException e){
                            e.printStackTrace();
                        }

                        System.out.println("stop");

                        System.out.println("------------------------------");

                        if(!ValidationsInvoice.invoiceValidation(invoice.getValue(), invoice.getName(), invoice.getMaturity(), invoice.getDescriptionInvoice())){
                            selectsUser.SelectNameUser(user1.getName());
                            insertsInvoice.InsertInvoice(invoice.getName(), invoice.getValue(), invoice.getDescriptionInvoice(), invoice.getMaturity(), selectsUser.getIdUser());
                            System.out.println("pause");
                        }
                }
            } else if (selection == 2) {
                System.out.println("Selecao 2");
            }

            System.out.println("Caso deseja encerrar o nosso programa, digite S");
            System.out.println("Caso deseje continuar utilizando as nossas ferramentas, Digite qualquer tecla");
            op = text.next().toUpperCase().charAt(0);
        } while (op != 'S');
        System.out.println("Saida do programa!");
    }
}