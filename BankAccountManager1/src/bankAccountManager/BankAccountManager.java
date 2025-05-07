package bankAccountManager;

public class BankAccountManager {
    private AccountService accountService;
    private NotificationService notificationService;

    public BankAccountManager(AccountService accountService, NotificationService notificationService) {
        this.accountService = accountService;
        this.notificationService = notificationService;
    }

    public void performOperations() {
        accountService.createAccount();
        accountService.depositAmount();
        notificationService.sendNotification();
    }
}
