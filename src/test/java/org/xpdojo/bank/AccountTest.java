package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void newAccountsShouldHaveZeroBalance(){
        Account account = new Account();
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void depositAnAmountThatShouldIncreaseTheBalance(){
        Account account = new Account();
        account.deposit(1);
        assertThat(account.getBalance()).isEqualTo(1);
    }

    @Test
    public void multipleDepositsShouldIncreaseTheAmount(){
        Account account = new Account();
        account.deposit(1);
        account.deposit(1);
        assertThat(account.getBalance()).isEqualTo(2);
    }

    @Test
    public void withdrawalShouldDecreaseTheBalance(){
        Account account = new Account();
        account.withdraw(5);
        assertThat(account.getBalance()).isEqualTo(-5);
    }

    @Test
    public void multipleWithdrawalsShouldDecreaseTheAmount(){
        Account account = new Account();
        account.withdraw(5);
        account.withdraw(3);
        assertThat(account.getBalance()).isEqualTo(-8);
    }


}
