package SOLIDprinciples.DIP.Problem;

import SOLIDprinciples.DIP.CreditCard;
import SOLIDprinciples.DIP.DebitCard;

/*
Dependency Inversion Principle states that we must use abstraction(abstract class/interface)
instead of concrete implementation.
 */
public class Shopper {
    public static void main(String[] args) {
        CreditCard newCreditCard = new CreditCard();
        DebitCard newDebitCard = new DebitCard();
        Shop localGroceryShop = new Shop(newCreditCard);
        // If I have debit card for payment, shop will not allow me to pay
        // as Shop only accept/support credit card payment (Specific card is hard coded for shop).
        // To support/enable debit card payment, we have to modify the Shop implementation.
        // Shop localGroceryShop = new Shop(newDebitCard);
        localGroceryShop.buySomething(100);
    }
}
