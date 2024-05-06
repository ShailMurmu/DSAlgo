package SOLIDprinciples.DIP.Solution;

import SOLIDprinciples.DIP.CreditCard;
import SOLIDprinciples.DIP.DebitCard;

public class Shopper {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard();
        DebitCard debitCard = new DebitCard();
        Shop localShop = new Shop(debitCard);
        localShop.buySomething(100);
    }
}
