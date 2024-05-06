package SOLIDprinciples.ISP.Problem;
/*
Interface-Segregation Principle states that larger interface should be
broken down to smaller interfaces and keep only relevant interfaces together so that
client should not be forced to implement un-necessary method.
 */
public interface UPIpayment {
    public void makePayment(float amount);
    public String getScratchCard(Boolean isPaymentDone);
    public float getCashBackAsBalance(Boolean isPaymentDone);
}
