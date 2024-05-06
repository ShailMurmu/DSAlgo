package SOLIDprinciples.SRP;

import java.util.Objects;

/*
Single Responsibility Principle stats that a class should have single reason to change.
It should be responsible for single type of logic.
 */

class Account1 {
    public void deposit(int amount) {
        System.out.println("amount deposited :"+amount);
    }
    public void withdraw(int amount) {
        System.out.println("amount withdrawn :"+amount);
    }

    public void printPassbook() {
        System.out.println("printing passbook ...");
    }

    public void takeLoan(String type) {
        if(Objects.equals(type, "PersonalLoan")) {
            System.out.println("Taking personal Loan");
        } else if (Objects.equals(type, "CarLoan")) {
            System.out.println("Taking car loan");
        }
    }
}
