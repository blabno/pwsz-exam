package pl.labno.bernard;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ATMTest {
  
  @Rule
  public ExpectedException exception = ExpectedException.none();
  
  @Test
  public void withdrawCash_cardNoIsNull_throwException() {
    exception.expect(IllegalStateException.class);
     
    Bank bank = mock(Bank.class);
    ATM a = new ATM(bank);

    a.withdrawCash(1);
    
  }
  
  @Test
  public void withdrawCash_pinIsNull_throwException() {
    exception.expect(IllegalStateException.class);

    Bank bank = mock(Bank.class);
    ATM a = new ATM(bank);

    a.withdrawCash(1);
}

  @Test
  public void withdrawCash_pinIsNotCorrect_throwException() {
    exception.expect(IllegalStateException.class);

    Bank bank = mock(Bank.class);
    when(bank.isPinCorrect(0, 0)).thenReturn(false);
    ATM a = new ATM(bank);

    a.withdrawCash(1);
}

  @Test
  public void withdrawCash_pinIsCorrectAccountCorrect_withdrawCashAmountAndDisconnect() {

    Bank bank = mock(Bank.class);
    when(bank.isPinCorrect(1111, 1111)).thenReturn(true);
    when(bank.withdraw(1)).thenReturn(1);
    ATM a = new ATM(bank);

    a.enterCard(1111);
    a.enterPin(1111);
    a.withdrawCash(1);

    verify(bank, times(1)).withdraw(1);
    verify(bank, times(1)).disconnect();

  }
  
