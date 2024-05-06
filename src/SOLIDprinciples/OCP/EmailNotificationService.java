package SOLIDprinciples.OCP;

public class EmailNotificationService implements NotificationService{

    @Override
    public void sendOTP(String medium) {
        // send OTP through email
    }
}
