package com.fag;

import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserInterface;
import com.fag.infra.celcoin.CelcoinBassRepository;
import com.fag.infra.console.ConsoleUserInterface;
import com.fag.infra.pg.PgSupabase;
import com.fag.infra.pg.PostgresConnection;
import com.fag.infra.swing.SwingUserInterface;
import com.fag.infra.testdb.UserTestDB;
import com.fag.services.BankingService;

public class Main {
    public static void main(String[] args) {
        ConsoleUserInterface consoleUI = new ConsoleUserInterface();
        SwingUserInterface swing = new SwingUserInterface();
        UserTestDB userTestDB = new UserTestDB();
        PgSupabase pg = new PgSupabase();
        CelcoinBassRepository celcoinRepo = new CelcoinBassRepository();

        BankingService bankingService = new BankingService(consoleUI, pg, celcoinRepo);

        while (true) {

            Integer opcao = bankingService.showMenu();

            switch (opcao) {
                case 1:
                    LoginDTO loginDTO = bankingService.getLoginDTO();

                    UserAccountDTO user = bankingService.findUser(loginDTO);

                    if (user != null) {
                        bankingService.login(user);
                    }

                    break;
                case 2:
                    UserAccountDTO data = bankingService.getUserAccountData();

                    bankingService.createUser(data);

                    bankingService.login(data);

                    break;
                case 3:
                    bankingService.exitMessage();

                    return;

                default:
                    System.out.println("Opcao invalida");
                    break;

            }
        }

    }

}