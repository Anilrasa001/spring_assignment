package bankAccountManager;


public class Main {
    public static void main(String[] args) {
        
        AccountService accountService = new AccountService();
        NotificationService notification = new EmailNotification(); 

       
        BankAccountManager manager = new BankAccountManager(accountService,notification);
        manager.performOperations();

       
        InterestService interestService = new InterestService();
        interestService.processInterest(new SavingsInterestCalculator());
        interestService.processInterest(new FixedDepositInterestCalculator());
    }
}
