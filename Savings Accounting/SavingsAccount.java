import java.lang.*;

public class SavingsAccount extends Account {
    private double interestRate;

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Interest Rate: " + interestRate);
    }
}
