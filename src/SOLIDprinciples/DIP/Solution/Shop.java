package SOLIDprinciples.DIP.Solution;

public class Shop {
    private final BankCard bankCard;
    public Shop(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public Boolean buySomething(float amount) {
        bankCard.doPayment(amount);
        return true;
    }
}
