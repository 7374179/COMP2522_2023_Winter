package src.main.java.org.bcit.midterm.mysolution;

public class Basic_05_MySolution {
//    The "Basic_05_Account" class has methods to deposit and withdraw money,
//    but these methods can throw exceptions if certain conditions are not met.
//    For example, if a negative amount is passed to the "deposit" or "withdraw" method,
//    a "Basic_05_NegativeAmountException" will be thrown.
//    Similarly, if a withdrawal amount is greater than the balance,
//    an "Basic_05_InsufficientFundsException" will be thrown.

//    The "Basic_05_Account" class also includes inner classes to represent these custom exceptions.
//    The "Basic_05_NegativeAmountException" and "Basic_05_InsufficientFundsException" classes
//    both extend the base Exception class.

//    In the main method, an instance of the "Basic_05_Account" class is created,
//    and various deposit and withdrawal operations are performed on it,
//    with appropriate exception handling code.
    public class Basic_05_Account {
        private String accountNumber;
        private double balance;

        public Basic_05_Account(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) throws Basic_05_NegativeAmountException {
            if (amount < 0) {
                throw new Basic_05_NegativeAmountException("Cannot deposit a negative amount.");
            }
            balance += amount;
        }

        public void withdraw(double amount) throws Basic_05_InsufficientFundsException, Basic_05_NegativeAmountException {
            if (amount < 0) {
                throw new Basic_05_NegativeAmountException("Cannot withdraw a negative amount.");
            }
            if (amount > balance) {
                throw new Basic_05_InsufficientFundsException("Insufficient funds for withdrawal.");
            }
            balance -= amount;
        }


        public static void main(String[] args) {
            Basic_05_MySolution.Basic_05_Account account = new Basic_05_MySolution().new Basic_05_Account("12345", 100.0);
            try {
                account.deposit(50.0); // should be OK
            } catch (Basic_05_NegativeAmountException e) {
                throw new RuntimeException(e);
            }
            try {
                account.withdraw(75.0); // should be OK
            } catch (Basic_05_InsufficientFundsException e) {
                throw new RuntimeException(e);
            } catch (Basic_05_NegativeAmountException e) {
                throw new RuntimeException(e);
            }
            try {
                account.withdraw(100.0); // should throw an exception since balance is only 75.0
            } catch (Basic_05_InsufficientFundsException e) {
                throw new RuntimeException(e);
            } catch (Basic_05_NegativeAmountException e) {
                throw new RuntimeException(e);
            }
            try {
                account.deposit(-25.0); // should throw an exception since amount is negative
            } catch (Basic_05_NegativeAmountException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public class Basic_05_NegativeAmountException extends Exception {
        public Basic_05_NegativeAmountException(String message) {
            super(message);
        }
    }

    public class Basic_05_InsufficientFundsException extends Exception {
        public Basic_05_InsufficientFundsException(String message) {
            super(message);
        }
    }
}
