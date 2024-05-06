package SOLIDprinciples.ISP.Solution;

public class Paytm implements UPIpayment, ScratchCardProvider{

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
