package com.fag.infra.swing;

import javax.swing.JOptionPane;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserInterface;

public class SwingUserInterface implements IUserInterface {

        @Override
        public Integer showInitialScreenMenu() {

                String menu = "Bem vindo ao SpecialBank"
                                .concat("[1] Login: ")
                                .concat("[2] Cadastro: ")
                                .concat("[3] Sair");

                String escolha = JOptionPane.showInputDialog(
                                null, menu, "Menu do SpecialBank", JOptionPane.INFORMATION_MESSAGE);

                return Integer.parseInt(escolha);

        }

        @Override
        public LoginDTO getLoginData() {
                LoginDTO data = new LoginDTO();

                String document = JOptionPane.showInputDialog(
                                null, "Informe seu documento", "Informe seus dados", JOptionPane.INFORMATION_MESSAGE);

                String password = JOptionPane.showInputDialog(
                                null, "Informe sua senha", "Informe seus dados", JOptionPane.INFORMATION_MESSAGE);

                data.setDocument(document);
                data.setPassword(password);

                return data;
        }

        @Override
        public UserAccountDTO getCreateUserData() {
                UserAccountDTO data = getCreateUserData();

                String document = JOptionPane.showInputDialog(
                                null, "Informe seu documento", 
                                "Informe seus dados", JOptionPane.INFORMATION_MESSAGE);

                String password = JOptionPane.showInputDialog(
                                null, "Informe sua senha", 
                                "Informe seus dados", JOptionPane.INFORMATION_MESSAGE);

                data.setDocument(document);
                data.setPassword(password);

                return data;

        }

        @Override
        public Integer showHomeMenu(String userName) {

                String menu = "Bem vindo" + userName + " ao SpecialBank"
                                .concat("[1] Consulta boleto \n")
                                .concat("[2] Pagamento boleto \n")
                                .concat("[3] Gerar QR Code \n")
                                .concat("[4] Logout");

                String escolha = JOptionPane.showInputDialog(
                                null, menu, "Menu do SpecialBank", JOptionPane.INFORMATION_MESSAGE);

                return Integer.parseInt(escolha);

        }

        @Override
        public void showErrorMsg(String msg) {
                JOptionPane.showMessageDialog(
                                null, "ERRO", msg, JOptionPane.ERROR_MESSAGE);
        }

        @Override
        public void showExitMessage() {
                JOptionPane.showMessageDialog(
                                null, "Ate a proxima", "SpecialBank", JOptionPane.CANCEL_OPTION);
        }

        @Override
        public String getBarcode() {
                String barcode = JOptionPane.showInputDialog(
                                null,
                                "Insira o código de barras a ser consultado",
                                "Código de barras",
                                JOptionPane.INFORMATION_MESSAGE);

                return barcode;
        }

        @Override
        public BankslipDTO getPaymentBankslipInfo() {
                BankslipDTO bankslipDTO = new BankslipDTO();

                String barcode = JOptionPane.showInputDialog(
                                null,
                                "Insira o código de barras a ser pago",
                                "Código de barras",
                                JOptionPane.INFORMATION_MESSAGE);
                String transactionId = JOptionPane.showInputDialog(
                                null,
                                "Insira o identificador de pagamento",
                                "Identificador",
                                JOptionPane.INFORMATION_MESSAGE);

                bankslipDTO.setBarcode(barcode);
                bankslipDTO.setTransactionId(transactionId);

                return bankslipDTO;
        }

        @Override
        public void showBankslipData(String data) {
                JOptionPane.showMessageDialog(
                                null,
                                data,
                                "Dados boleto",
                                JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void showPixData(String data) {
                JOptionPane.showMessageDialog(
                                null,
                                data,
                                "Dados PIX",
                                JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public Double getPixData() {
                String amount = JOptionPane.showInputDialog(
                                null,
                                "Insira o valor do PIX",
                                "Valor transação",
                                JOptionPane.INFORMATION_MESSAGE);

                return Double.parseDouble(amount);
        }
}
