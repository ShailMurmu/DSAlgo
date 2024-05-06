package SOLIDprinciples.ISP.Solution;

public class GooglePay implements UPIpayment, ScratchCardProvider, CashbackProvider{
    @Override
    public float getCashBackAsBalance(Boolean isPaymentDone) {
        // logic
        return 0;
    }

    @Override
    public String getScratchCard(Boolean isPaymentDone) {
        // logic
        return null;
    }

    @Override
    public void makePayment(float amount) {
        // logic
    }
}
