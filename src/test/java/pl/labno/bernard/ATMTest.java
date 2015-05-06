package pl.labno.bernard;

import org.junit.rules.ExpectedException;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Rule;


public class ATMTest {
    
    
    @Rule
    public ExpectedException e = ExpectedException.none();
    
    @Test
    public void withdrawCash_NullPin_throwException() {
        e.expect(IllegalStateException.class);
        Bank bank = mock(Bank.class);
        ATM atm = new ATM(bank);

        atm.withdrawCash(1);
    }
    @Test
    public void withdrawCash_IncorrectPin_throwException() {
        e.expect(IllegalStateException.class);
        Bank bank = mock(Bank.class);
        when(bank.isPinCorrect(0, 0)).thenReturn(false);
        ATM atm = new ATM(bank);


        atm.withdrawCash(1);
    }
    
    @Test
    public void withdrawCash_CorrectPinAccountValid_withdrawCashAmount() {

        Bank bank = mock(Bank.class);
        when(bank.isPinCorrect(2000, 2000)).thenReturn(true);
        when(bank.withdraw(1)).thenReturn(1);
        ATM atm = new ATM(bank);

        atm.enterCard(2000);
        atm.enterPin(2000);
        atm.withdrawCash(1);

        verify(bank, times(1)).withdraw(1);
        verify(bank, times(1)).disconnect();
    }
    
    @Test
    public void withdrawCash_NullCard_throwException() {
        e.expect(IllegalStateException.class);
        Bank bank = mock(Bank.class);
        ATM atm = new ATM(bank);

        
        
        atm.withdrawCash(1);
    }
    
    
    
}
