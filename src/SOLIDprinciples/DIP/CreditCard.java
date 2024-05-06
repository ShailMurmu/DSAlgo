package SOLIDprinciples.DIP;

import SOLIDprinciples.DIP.Solution.BankCard;

public class CreditCard implements BankCard {
    public void doPayment(float amount) {
        System.out.println("Credit card payment done of amount :"+amount);
    }
}
