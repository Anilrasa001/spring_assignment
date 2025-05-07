package bankAccountManager;


public class FixedDepositInterestCalculator implements InterestCalculator {
    @Override
    public void calculateInterest() {
        System.out.println("Fixed Deposit interest calculated");
    }
}
