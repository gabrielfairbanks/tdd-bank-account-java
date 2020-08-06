package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private final Account account = Account.createEmptyAccount();

    @Test
    public void newAccountsShouldHaveZeroBalance(){
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void depositAnAmountThatShouldIncreaseTheBalance(){
        account.deposit(1);
        assertThat(account.getBalance()).isEqualTo(1);
    }

    @Test
    public void multipleDepositsShouldIncreaseTheAmount(){
        account.deposit(1);
        account.deposit(1);
        assertThat(account.getBalance()).isEqualTo(2);
    }

    @Test
    public void withdrawalShouldDecreaseTheBalance(){
        account.withdraw(5);
        assertThat(account.getBalance()).isEqualTo(-5);
    }

    @Test
    public void multipleWithdrawalsShouldDecreaseTheAmount(){
        account.withdraw(5);
        account.withdraw(3);
        assertThat(account.getBalance()).isEqualTo(-8);
    }
}
