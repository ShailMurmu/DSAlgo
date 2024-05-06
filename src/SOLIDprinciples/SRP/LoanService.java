package SOLIDprinciples.SRP;

import java.util.Objects;

public class LoanService {
    public void takeLoan(String type) {
        if(Objects.equals(type, "PersonalLoan")) {
            System.out.println("Taking personal Loan");
        } else if (Objects.equals(type, "CarLoan")) {
            System.out.println("Taking car loan");
        }
    }
}
