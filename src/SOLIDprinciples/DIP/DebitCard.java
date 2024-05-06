package SOLIDprinciples.DIP;

import SOLIDprinciples.DIP.Solution.BankCard;

public class DebitCard implements BankCard {
    public void doPayment(float amount) {
        System.out.println("Debit card payment done of amount :"+amount);
    }
}
