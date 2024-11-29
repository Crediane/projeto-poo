package com.fag.infra.console;

import java.util.Scanner;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserInterface;

public class ConsoleUserInterface implements IUserInterface {

    private Scanner input = new Scanner(System.in);

    @Override
    public Integer showInitialScreenMenu() {

        System.out.println("...Bem vindo ao SpecialBank...");
        System.out.println("[1] Login: ");
        System.out.println("[2] Cadastro: ");
        System.out.println("[3] Sair");

        Integer option = input.nextInt();

        return option;
    }

    @Override
    public LoginDTO getLoginData() {
        LoginDTO data = new LoginDTO();

        System.out.println("Informe seu documento: ");
        String document = input.nextLine();

        input.nextInt();

        System.out.println("Informe sua senha: ");
        String password = input.nextLine();

        input.nextInt();

        data.setDocument(document);
        data.setPassword(password);

        return data;
    }

    @Override
    public UserAccountDTO getCreateUserData() {
        UserAccountDTO data = new UserAccountDTO();

        input.nextLine();

        System.out.println("Informe seu documento: \n");
        String document = input.nextLine();

        System.out.println("Informe seu email: \n");
        String email = input.nextLine();

        System.out.println("Informe seu nome: \n");
        String name = input.nextLine();

        System.out.println("Informe sua senha: \n");
        String password = input.nextLine();

        data.setDocument(document);
        data.setEmail(email);
        data.setName(name);
        data.setPassword(password);

        input.nextLine();

        return data;
    }

    @Override
    public Integer showHomeMenu(String userName) {

        System.out.println("Bem vindo\n"  + userName  + "!");
        System.out.println("[1] Consulta boleto");
        System.out.println("[2] Pagamento boleto");
        System.out.println("[3] Gerar QR Code Pix");
        System.out.println("[4] Logout");

        Integer option = input.nextInt();
        input.nextLine();

        return option;

    }

    @Override
    public void showErrorMsg(String msg) {
        System.out.println("ERRO: " + msg);
    }

    @Override
    public void showExitMessage() {
        System.out.println("Ate a proxima");
    }

    @Override
    public String getBarcode() {
        System.out.println("Insira o código de barras:");
        String barcode = input.nextLine();

        return barcode;
    }

    @Override
    public BankslipDTO getPaymentBankslipInfo() {
        BankslipDTO bankslipDTO = new BankslipDTO();

        System.out.println("Insira o código de barras:");
        String barcode = input.nextLine();

        System.out.println("Insira o identificador de pagamento:");
        String id = input.nextLine();

        bankslipDTO.setBarcode(barcode);
        bankslipDTO.setTransactionId(id);

        return bankslipDTO;
    }

    @Override
    public void showBankslipData(String data) {
        System.out.println("Dados do boleto: " + data);
    }

    @Override
    public Double getPixData() {
        System.out.println("Insira valor do PIX:");
        Double amount = input.nextDouble();

        return amount;
    }

    @Override
    public void showPixData(String data) {
        System.out.println("Dados do PIX: " + data);
    }
}
