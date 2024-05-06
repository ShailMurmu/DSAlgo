package SOLIDprinciples.ISP.Problem;

public class GooglePay implements UPIpayment{
    @Override
    public void makePayment(float amount) {
        // logic
    }

    @Override
    public String getScratchCard(Boolean isPaymentDone) {
        // logic
        return null;
    }

    @Override
    public float getCashBackAsBalance(Boolean isPaymentDone) {
        // logic
        return 0;
    }
}
