package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;

import java.util.HashSet;
import java.util.Set;

public class PromptView {

    Prompt prompt = new Prompt(System.in, System.out);

    public int getUserId() {
        IntegerInputScanner inputScanner = new IntegerInputScanner();
        inputScanner.setMessage("Welcome to Java Bank. Please, enter your Id: ");
        int id = prompt.getUserInput(inputScanner);
        return id;
    }

    public boolean wantToCreateAccount() {
        Set<String> options = new HashSet<>();
        options.add("yes");
        options.add("no");
        StringSetInputScanner wantToCreateAccount = new StringSetInputScanner(options);
        wantToCreateAccount.setMessage("Do you want to create an account? ");
        if (prompt.getUserInput(wantToCreateAccount).equals("yes")) {
            return true;
        }
        return false;
    }

    public AccountType chooseAccountType() throws Exception {
        String[] menuOptions = {AccountType.CHECKING.toString(), AccountType.SAVINGS.toString()};
        MenuInputScanner menuInputScanner = new MenuInputScanner(menuOptions);
        menuInputScanner.setMessage("Choose the Account Type you want to open: ");
        int clientAnswerIndex = prompt.getUserInput(menuInputScanner);
        switch (clientAnswerIndex) {
            case 0:
                return AccountType.CHECKING;
            case 1:
                return AccountType.SAVINGS;


        }

        throw new Exception("Invalid Input");
    }
}