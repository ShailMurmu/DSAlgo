package SOLIDprinciples.DIP.Problem;

import SOLIDprinciples.DIP.CreditCard;

public class Shop {
    private final CreditCard creditCard;
    public Shop(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Boolean buySomething(float amount) {
        creditCard.doPayment(amount);
        return true;
    }
}
