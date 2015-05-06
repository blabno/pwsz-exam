package pl.labno.bernard;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class ATMTest {

    @Rule
    public ExpectedException expectedException= ExpectedException.none();
    @Test
    public void withdrawCash_cardNoIsNull_Exception()
    {
     Bank bank=  Mockito.mock(Bank.class);
        ATM atm=new ATM(bank);
        atm.enterPin(1);
        expectedException.expect(IllegalStateException.class);
        atm.withdrawCash(0);
    }
    @Test
    public void withdrawCash_pinIsNull_IllegalStateException()
    {
        Bank bank=  Mockito.mock(Bank.class);
        ATM atm=new ATM(bank);
        atm.enterCard(1);
        expectedException.expect(IllegalStateException.class);
        atm.withdrawCash(0);
    }
    @Test
    public void withdrawCash_pinIsNotCorect_IllegalStateException()
    {
        Bank bank=  Mockito.mock(Bank.class);
        when(bank.isPinCorrect(0,0)).thenReturn(false);
        ATM atm=new ATM(bank);
        atm.enterCard(0);
        atm.enterPin(0);
        expectedException.expect(IllegalStateException.class);
        atm.withdrawCash(0);
    }

    @Test
    public void withdrawCash_bankwithdrawThrow_IllegalStateException()
    {
        Bank bank=  Mockito.mock(Bank.class);
        when(bank.isPinCorrect(0,0)).thenReturn(true);
        when(bank.withdraw(0)).thenThrow(AccountBlockedException.class);
        ATM atm=new ATM(bank);
        atm.enterCard(0);
        atm.enterPin(0);
        expectedException.expect(IllegalStateException.class);
        atm.withdrawCash(0);
    }

}
