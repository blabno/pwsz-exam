package pl.labno.bernard;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class ATMTest {


    @Rule
    public ExpectedException w = ExpectedException.none();


    @Test
    public void withdrawCash_cardNull_throwException() {
        w.expect(IllegalStateException.class);

        Bank bank = mock(Bank.class);
        ATM atm = new ATM(bank);

        atm.withdrawCash(1);
    }


    @Test
    public void withdrawCash_nullPinNumber_throwException() {
        w.expect(IllegalStateException.class);

        Bank bank = mock(Bank.class);
        ATM atm = new ATM(bank);

        atm.withdrawCash(1);
    }


    @Test
    public void withdrawCash_notCorrectPinNumber_throwException() {
        w.expect(IllegalStateException.class);

        Bank bank = mock(Bank.class);
        when(bank.isPinCorrect(0, 0)).thenReturn(false);
        ATM atm = new ATM(bank);

        atm.withdrawCash(1);
    }


    @Test
    public void withdrawCash_correctPinNumberAndAccountValid_withdrawCashAmountAndDisconnect() {
        Bank bank = mock(Bank.class);
        when(bank.isPinCorrect(9999, 9999)).thenReturn(true);
        when(bank.withdraw(1)).thenReturn(1);
        ATM atm = new ATM(bank);

        atm.enterCard(9999);
        atm.enterPin(9999);
        atm.withdrawCash(1);

        verify(bank, times(1)).withdraw(1);
        verify(bank, times(1)).disconnect();
    }

    
}           // end ATMTest
