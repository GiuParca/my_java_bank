package org.academiadecodigo.javabank;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.views.PromptView;
import sun.awt.CustomCursor;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        Bank bank = new Bank(accountManager);
        PromptView promptView = new PromptView();
        int id = promptView.getUserId();

        Customer customer = new Customer(id);
        System.out.println(id);
        try {
            bank.addCustomer(customer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            Customer customer1 = bank.getCustomerById(id);
            boolean wannaCreateAccount = promptView.wantToCreateAccount();
            if(wannaCreateAccount){
                AccountType chosenAccountType = promptView.chooseAccountType();
                customer1.openAccount(chosenAccountType);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
