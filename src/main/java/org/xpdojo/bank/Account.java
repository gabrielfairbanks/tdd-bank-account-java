package org.xpdojo.bank;

public class Account {

    private int balance = 0;

    private Account() {
    }

    public static Account createEmptyAccount() {
        return new Account();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}
