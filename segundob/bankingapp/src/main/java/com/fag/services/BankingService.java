package com.fag.services;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IBassRepository;
import com.fag.domain.repositories.IUserInterface;
import com.fag.domain.repositories.IUserRepository;

public class BankingService {

    private IUserInterface gui;

    private IUserRepository userDB;

    private IBassRepository bassRepo;

    private Integer accountNumber = 1;

    public BankingService(IUserInterface gui, IUserRepository userDB,
            IBassRepository bassRepo) {
        this.gui = gui;
        this.userDB = userDB;
        this.bassRepo = bassRepo;
    }

    public Integer showMenu() {
        return gui.showInitialScreenMenu();

    }

    public LoginDTO getLoginDTO() {
        return gui.getLoginData();
    }

    public UserAccountDTO getUserAccountData() {
        UserAccountDTO data = gui.getCreateUserData();
        String uuid = UUID.randomUUID().toString();

        data.setId(uuid);
        data.setAccountNumber(accountNumber.toString());
        data.setCreatedAt(LocalDateTime.now());

        accountNumber++;

        return data;

    }

    public void exitMessage() {
        gui.showExitMessage();
    }

    public void login(UserAccountDTO user) {
        Integer option = gui.showHomeMenu(user.getName());

        switch (option) {
            case 1:
                String barcode = gui.getBarcode();

                String consultaResponse = bassRepo.consultarBoleto(barcode);

                gui.showBankslipData(consultaResponse);

                break;

            case 2:
                BankslipDTO bankslipDTO = gui.getPaymentBankslipInfo();

                String paymentResponse = bassRepo.pagarBoleto(bankslipDTO);

                gui.showBankslipData(paymentResponse);

                break;

            case 3:
                Double amount = gui.getPixData();

                String pixResponse = bassRepo.gerarQRCode(amount);

                gui.showPixData(pixResponse);

                break;

            case 4:
                gui.showExitMessage();
                return;
        }
    }

    public UserAccountDTO createUser(UserAccountDTO user) {
        return userDB.createUser(user);
    }

    public UserAccountDTO findUser(LoginDTO loginDTO) {
        UserAccountDTO user = userDB.findUserBy(loginDTO.getDocument());

        if (user == null) {
            gui.showErrorMsg("Usuario nao encontrado");

            return null;

        }
        if (!user.getPassword().equals(loginDTO.getPassword())) {
            gui.showErrorMsg("Credencial invalida");

            return null;
        }
        return user;

    }

}
