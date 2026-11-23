package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    private Account myAccount;

    @BeforeEach
    public void setUp() {
        myAccount = new Account("Opeyemi" , 1234 , 100);
        assertEquals(0 , myAccount.getBalance(1234));

    }

    @Test
    public void IHaveAnAccount_BalanceIsZero_IDeposit200_BalanceIs200() {
        myAccount.deposit(200);

        assertEquals(200 , myAccount.getBalance(1234));

    }

    @Test
    public void IHaveAnAccount_BalanceIsZero_IDeposit200_BalanceIs200_IWantToCheckBalance_InputTheWrongPin_AnExceptionIsThrown() {
        myAccount.deposit(200);

        assertThrows(IllegalArgumentException.class , () -> myAccount.getBalance(1678));

    }

    @Test
    public void IHaveAnAccount_BalanceIsZero_IDepositMinus50_ItThrowsAnException_BalanceIsZero() {
        assertThrows(IllegalArgumentException.class, () -> myAccount.deposit(-50));

        assertEquals(0 , myAccount.getBalance(1234));

    }

    @Test
    public void IDeposit300_BalanceIs300_IInputedTheRightPin_IWithDraw100_BalanceIs200() {
        myAccount.deposit(300);
        assertEquals(300 , myAccount.getBalance(1234));

        myAccount.withdraw(100 , 1234);
        assertEquals(200 , myAccount.getBalance(1234));


    }

    @Test
    public void IDeposit300_BalanceIs300_IInputedTheRightPin_IWithDrawMinus100_ItThrowsAnException_BalanceIs300() {
        myAccount.deposit(300);
        assertEquals(300 , myAccount.getBalance(1234));

        assertThrows(IllegalArgumentException.class , () -> myAccount.withdraw(-100 , 1234));
        assertEquals(300 , myAccount.getBalance(1234));

    }

    @Test
    public void IDeposit300_BalanceIs300_IInputedTheRightPin_IWithDraw500_ItThrowsAnException_BalanceIs300() {
        myAccount.deposit(300);
        assertEquals(300 , myAccount.getBalance(1234));

        assertThrows(IllegalArgumentException.class ,  () -> myAccount.withdraw(500 , 1234));
        assertEquals(300 , myAccount.getBalance(1234));

    }

    @Test
    public void IDeposit300_BalanceIs300_IInputedTheWrongPin_IWithDraw100_BalanceIs300() {
        myAccount.deposit(300);
        assertEquals(300 , myAccount.getBalance(1234));

        assertThrows(IllegalArgumentException.class , () -> myAccount.withdraw(100 , 2349));
        assertEquals(300 , myAccount.getBalance(1234));

    }

    @Test
    public void IWantToChangeMyPin_InputedTheFirstPinWrongly_SoItThrowsAnException_ICannotWithdraw() {
        assertThrows(IllegalArgumentException.class , () -> myAccount.changePin(2345 , 2001));

        myAccount.deposit(400);

        assertThrows(IllegalArgumentException.class , () -> myAccount.withdraw(100 , 6789));
        assertEquals(400 , myAccount.getBalance(1234));

    }

    @Test
    public void IWantToChangeMyPin_InputedTheFirstPinCorrectly_SoItThrowsAnException_ICanWithdraw() {
        myAccount.changePin(1234 , 2001);

        myAccount.deposit(400);

        myAccount.withdraw(100 , 2001);
        assertEquals(300 , myAccount.getBalance(2001));

    }


}