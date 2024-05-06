package SOLIDprinciples.ISP.Problem;

public class Paytm implements UPIpayment{
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
        // Not Supported
        return 0;
    }
}
