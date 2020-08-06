package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.xpdojo.bank.Account.createEmptyAccount;

public class AccountTest {

    private final Account account = createEmptyAccount();

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
        account.deposit(5);
        account.withdraw(5);
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void multipleWithdrawalsShouldDecreaseTheAmount(){
        account.deposit(10);
        account.withdraw(5);
        account.withdraw(3);
        assertThat(account.getBalance()).isEqualTo(2);
    }

    @Test
    public void withdrawalFromEmptyAccountShouldNotBeAllowed(){
        assertThrows(RuntimeException.class, () -> createEmptyAccount().withdraw(5));
    }

    @Test
    public void withdrawalCantGoLowerThanZero(){
        account.deposit(4);
        assertThrows(RuntimeException.class, () -> account.withdraw(5));
    }
}
