package SOLIDprinciples.OCP;

/*
Open-Closed Principle states that a software component like module, class or interface
should be open for extension and closed for modification.
 */
class NotificationService1 {
    public void sendOTP(String medium) {
        if(medium.equals("email")) {
            // send OTP through email
        }

        if(medium.equals("mobile")) {
            // send OTP through mobile
        }

        // future requirement to send OTP through WhatsApp,
        // Shouldn't modify here ... doing so, may introduce bug
    }
}
