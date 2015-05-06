package pl.labno.bernard;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

public class ATMTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test()
    public void ATM_withdrawCash_noCardNoEntered_Exception(){
        //given
        Bank bankMock = Mockito.mock(Bank.class);
        ATM atm = new ATM(bankMock);
        //when&then
        thrown.expect(IllegalStateException.class);
        atm.withdrawCash(1);
    }

    @Test()
    public void ATM_withdrawCash_noPinNoEntered_Exception(){
        //given
        Bank bankMock = Mockito.mock(Bank.class);
        ATM atm = new ATM(bankMock);
        //when&then
        thrown.expect(IllegalStateException.class);
        atm.withdrawCash(1);
    }

    @Test()
    public void ATM_withdrawCash_incorrectPin_Exception(){
        //given
        Bank bankMock = Mockito.mock(Bank.class);
        Mockito.when(bankMock.isPinCorrect(1, 1)).thenReturn(false);
        ATM atm = new ATM(bankMock);

        //when&then
        atm.enterCard(1);
        atm.enterPin(1);

        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Pin is incorrect");
        atm.withdrawCash(1);
    }


    @Test()
    public void ATM_withdrawCash_correctAndNotBlocked_success(){
        //given
        Bank bankMock = Mockito.mock(Bank.class);
        Mockito.when(bankMock.isPinCorrect(1, 1)).thenReturn(true);
        Mockito.when(bankMock.withdraw(1)).thenReturn(1);
        ATM atm = new ATM(bankMock);

        //when
        atm.enterCard(1);
        atm.enterPin(1);
        int cash = atm.withdrawCash(1);
        //then
        Assert.assertEquals(1, cash);
    }

    @Test()
    public void ATM_withdrawCash_correctAndBlocked_exception(){
        //given
        Bank bankMock = Mockito.mock(Bank.class);
        Mockito.when(bankMock.isPinCorrect(1, 1)).thenReturn(true);
        Mockito.when(bankMock.withdraw(1)).thenThrow(new AccountBlockedException());
        ATM atm = new ATM(bankMock);

        //when&then
        atm.enterCard(1);
        atm.enterPin(1);

        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Account blocked");

        atm.withdrawCash(1);
    }

    @Test
    public void ATM_testGettingErrorMessage_success(){
        //given
        Bank bankMock = Mockito.mock(Bank.class);
        ATM atm = new ATM(bankMock);

        //when
        String errorMessage = atm.getErrorMessage();

        //then
        Assert.assertEquals("", errorMessage);
    }
}
