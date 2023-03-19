package org.bcit.comp2522.winter2023.midterm.bonus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Basic_06_MySolution {
//    This code contains a set of JUnit tests for a basic bank account
//    implementation called Basic_05_Account, which is defined in
//    the Basic_05_MySolution class of the same package.
    @Test
    public void testDepositPositiveAmount() throws Basic_05_MySolution.Basic_05_NegativeAmountException {
    //The testDepositPositiveAmount method tests the deposit operation by creating
    // a new account with a balance of 100, depositing 50, and then asserting
    // that the new balance is 150.
        Basic_05_MySolution.Basic_05_Account account = new Basic_05_MySolution().new Basic_05_Account("12345", 100.0);
        account.deposit(50.0);
        Assertions.assertEquals(150.0, account.getBalance());
    }

    @Test
    public void testDepositNegativeAmount() {
    // The testDepositNegativeAmount method tests the deposit operation
    // when a negative amount is passed, by creating a new account with a balance of 100,
    // attempting to deposit -50, and asserting that a Basic_05_NegativeAmountException
    // is thrown and the balance remains at 100.
        Basic_05_MySolution.Basic_05_Account account = new Basic_05_MySolution().new Basic_05_Account("12345", 100.0);
        Assertions.assertThrows(Basic_05_MySolution.Basic_05_NegativeAmountException.class,
                () -> account.deposit(-50.0));
        Assertions.assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testWithdrawPositiveAmount() throws Basic_05_MySolution.Basic_05_NegativeAmountException, Basic_05_MySolution.Basic_05_InsufficientFundsException {
    // The testWithdrawPositiveAmount method tests the withdrawal operation
    // by creating a new account with a balance of 100, withdrawing 50,
    // and then asserting that the new balance is 50.
        Basic_05_MySolution.Basic_05_Account account = new Basic_05_MySolution().new Basic_05_Account("12345", 100.0);
        account.withdraw(50.0);
        Assertions.assertEquals(50.0, account.getBalance());
    }

    @Test
    public void testWithdrawNegativeAmount() {
    // The testWithdrawNegativeAmount method tests the withdrawal operation
    // when a negative amount is passed, by creating a new account with a balance of 100,
    // attempting to withdraw -50, and asserting that a Basic_05_NegativeAmountException
    // is thrown and the balance remains at 100.
        Basic_05_MySolution.Basic_05_Account account = new Basic_05_MySolution().new Basic_05_Account("12345", 100.0);
        Assertions.assertThrows(Basic_05_MySolution.Basic_05_NegativeAmountException.class,
                () -> account.withdraw(-50.0));
        Assertions.assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testWithdrawMoreThanBalance() {
    // The testWithdrawMoreThanBalance method tests the withdrawal operation
    // when an amount greater than the current balance is passed,
    // by creating a new account with a balance of 100, attempting to withdraw 150,
    // and asserting that a Basic_05_InsufficientFundsException is thrown
    // and the balance remains at 100.
        Basic_05_MySolution.Basic_05_Account account = new Basic_05_MySolution().new Basic_05_Account("12345", 100.0);
        Assertions.assertThrows(Basic_05_MySolution.Basic_05_InsufficientFundsException.class,
                () -> account.withdraw(150.0));
        Assertions.assertEquals(100.0, account.getBalance());
    }
}