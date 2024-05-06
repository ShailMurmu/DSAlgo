package SOLIDprinciples.ISP.Solution;

public class Phonepe implements UPIpayment, ScratchCardProvider{

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
