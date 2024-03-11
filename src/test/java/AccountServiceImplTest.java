import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.CheckingAccount;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.AccountServiceImpl;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class AccountServiceImplTest {

    @Test
    public void testIfCanTransferMoney(){
        /*given - there are 2 accounts and one of the accounts has a balance to transfer to the other
        when - inform the amount to be transferred
        then - amount that is debited from one account and credited to the other*/

        Account sender = new CheckingAccount();
        Account beneficiary = new CheckingAccount();

        double amountCreditedToSender = 1000;
        sender.credit(amountCreditedToSender);
        AccountService accountService = new AccountServiceImpl();
        accountService.add(sender);
        accountService.add(beneficiary);
        double amountToBeTransferred = 300;
        accountService.transfer(sender.getId(), beneficiary.getId(),amountToBeTransferred);
        assertEquals(sender.getBalance(), amountCreditedToSender - amountToBeTransferred,0.00000001);
        assertEquals(beneficiary.getBalance(),amountToBeTransferred,0.000001);
    }

    @Test
    public void testIfCanWithdraw(){
        /*given - need an account with a sufficient balance to carry out the operation
        when - the amount to be withdrawn
        then - the amount must have been withdrawn from the account
         */

        Account account = new CheckingAccount();
        double moneyInTheBank = 500;
        account.credit(moneyInTheBank);
        double amountToWithdraw = 200;

        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.add(account);
        accountService.withdraw(account.getId(), amountToWithdraw);
        assertEquals(account.getBalance(), moneyInTheBank - amountToWithdraw ,0.0000001);



    }


}
