
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class BankTest {

    private Bank bank;

    @BeforeMethod
    public void setup() {
        bank = new Bank();
    }

    @Test
    public void testThatICanCreateABank() {
        assertNotNull(bank);
    }

    @Test
    public void testThatICanCreateABank_AndRegisterAnAccount() {
        bank.registerAccount("1234");

        assertEquals(1, bank.getNumberOfAccounts());
    }

    @Test
    public void testThatICanRegister_MultipleAccounts() {
        bank.registerAccount("1234");
        bank.registerAccount("5678");

        assertEquals(2, bank.getNumberOfAccounts());
    }

    @Test
    public void testThatICanDepositIntoAnAccount() {
        bank.registerAccount("5678");

        bank.deposit(1000, "5678");

        assertEquals(1000, bank.getBalance("5678"));
    }

    @Test
    public void testThatICanWithdrawFromAnAccount() {
        bank.registerAccount("1234");
        bank.deposit(5000, "1234");

        assertTrue(bank.withdraw(2000, "1234"));

        assertEquals(3000, bank.getBalance("1234"));
    }

    @Test
    public void testThatICannotWithdrawMoreThanMyBalance() {
        bank.registerAccount("1234");
        bank.deposit(200, "1234");

        assertFalse(bank.withdraw(500, "1234"));

        assertEquals(200, bank.getBalance("1234"));
    }

    @Test
    public void testThatEachAccountHasItsOwnBalance() {
        bank.registerAccount("1234");
        bank.registerAccount("5678");

        bank.deposit(500, "1234");
        bank.deposit(1000, "5678");

        assertEquals(500, bank.getBalance("1234"));
        assertEquals(1000, bank.getBalance("5678"));
    }

    @Test
    public void testThatWrongPinCannotAccessAccount() {
        bank.registerAccount("1234");
        bank.deposit(500, "1234");

        assertEquals(-1, bank.getBalance("0000"));
    }

    @Test
    public void testThatICanTransferMoneyFromOneAccountToAnother() {
        bank.registerAccount("1234");
        bank.registerAccount("5678");

        bank.deposit(5000, "1234");

        assertTrue(bank.transfer(2000, "1234", "5678"));

        assertEquals(3000, bank.getBalance("1234"));
        assertEquals(2000, bank.getBalance("5678"));
    }

    @Test
    public void testThatICannotTransferMoreThanMyBalance() {
        bank.registerAccount("1234");
        bank.registerAccount("5678");

        bank.deposit(1000, "1234");

        assertFalse(bank.transfer(2000, "1234", "5678"));

        assertEquals(1000, bank.getBalance("1234"));
        assertEquals(0, bank.getBalance("5678"));
    }

    @Test
    public void testThatICannotTransferToAnAccountThatDoesNotExist() {
        bank.registerAccount("1234");
        bank.deposit(1000, "1234");

        assertFalse(bank.transfer(500, "1234", "9999"));

        assertEquals(1000, bank.getBalance("1234"));
    }
}
