package org.academiadecodigo.javabank.test.application;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;

public class App {

    Prompt prompt;
    Bank bank;
    AccountManager accountManager;
    Customer customer;


    public App() {
        prompt = new Prompt(System.in, System.out);
        bank = new Bank(this.accountManager);
        accountManager = new AccountManager();
    }

    public void setBank() {
        this.accountManager = new AccountManager();
        this.bank = new Bank(accountManager);
        customer = new Customer();
        bank.addCustomer(customer);
    }

    public void enteringID() {
        IntegerInputScanner idNumberBetween = new IntegerRangeInputScanner(1, 5);
        idNumberBetween.setMessage("Please, enter your ID:");
        idNumberBetween.setError("Invalid ID");
        int promptID = prompt.getUserInput(idNumberBetween);

        for (Customer customer: bank.getCustomers()) {
            if(promptID == customer.getMyID()){
                this.customer = customer;
            }

        }

    }

    public void startMenu() {
        String[] firstMenu = {"Open Account", "Get Balance", "Deposit", "Withdraw", "Quit"};
        MenuInputScanner menuInputScanner = new MenuInputScanner(firstMenu);
        menuInputScanner.setMessage("Welcome to Java Bank");
        menuInputScanner.setError("Invalid option. Please, try again.");
        int startMenu = prompt.getUserInput(menuInputScanner);

        switch (startMenu) {
            case 1:
                openAccount();
                break;
            case 2:
                balance();
                break;
            case 3:
                deposit();
                break;
            case 4:
                withdraw();
                break;
            case 5:
                quit();
                break;

        }
    }

    public void openAccount(){
        setBank();
    }

    public void balance(){
        customer.getBalance();
    }

    public void deposit(){
        IntegerInputScanner integerInputScanner = new IntegerInputScanner();
        integerInputScanner.setMessage("Enter the amount to be deposited: ");
        int prompt1 = prompt.getUserInput(integerInputScanner);
        accountManager.deposit(customer.getMyID(), prompt1);
        customer.getBalance();
    }

    public void withdraw(){
        IntegerInputScanner integerInputScanner = new IntegerInputScanner();
        integerInputScanner.setMessage("Enter the amount to be withdrawn: ");
        int prompt1 = prompt.getUserInput(integerInputScanner);
        accountManager.withdraw(customer.getMyID(), prompt1);
        //fazer condição para verificar se o valor pode ser levantado
        customer.getBalance();

    }

    public void quit(){
        System.exit(1);
    }

    public static void main(String[] args) {
        App application = new App();
        application.enteringID();
        application.startMenu();
        application.deposit();
    }


}
