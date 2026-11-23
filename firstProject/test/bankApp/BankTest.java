package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank("Keystone Bank");
    }

    @Test
    public void testThatIHaveABank_AUserRegisters_TheUserIsRegistered() {
        bank.registerCustomer("Opeyemi", "Emmanuel", 1234);

        assertEquals(1 , bank.getNumberOfRegisteredCustomers());

    }

    @Test
    public void testThatIHaveABank_MoreThanOneUserRegisters_TheyAreRegistered() {
        bank.registerCustomer("Opeyemi", "Emmanuel", 1234);
        assertEquals(1 , bank.getNumberOfRegisteredCustomers());

        bank.registerCustomer("Bolu", "Olatunde", 2001);
        assertEquals(2 , bank.getNumberOfRegisteredCustomers());

    }

    @Test
    public void testThatIHaveABank_AUserRegisters_TheUserIsRegistered_ICanGetTheUserInformation() {
        Account opeyemi = bank.registerCustomer("Opeyemi", "Emmanuel", 1234);
        assertEquals(1 , bank.getNumberOfRegisteredCustomers());

        Account free = bank.registerCustomer("Bolu", "Olatunde", 2001);
        assertEquals(2 , bank.getNumberOfRegisteredCustomers());

        assertEquals(opeyemi , bank.findAccount(opeyemi.getAccountNumber()));

    }


    @Test
    public void testThatIHaveABank_AUserRegisters_TheUserIsRegistered_IinputedtheWrongAccountNumber_ItThrowsAnException() {
        Account opeyemi = bank.registerCustomer("Opeyemi", "Emmanuel", 1234);
        assertEquals(1 , bank.getNumberOfRegisteredCustomers());

        Account free = bank.registerCustomer("Bolu", "Olatunde", 2001);
        assertEquals(2 , bank.getNumberOfRegisteredCustomers());

        assertThrows(IllegalArgumentException.class , () -> bank.findAccount(23456));

    }

    @Test
    public void testThatIAmRegistered_MyBalanceIsZero_IDeposit500_MyBalanceIs500(){
        Account opeyemi = bank.registerCustomer("Opeyemi", "Emmanuel", 1234);
        assertEquals(1 , bank.getNumberOfRegisteredCustomers());

        assertEquals(0 , bank.checkBalance(opeyemi.getAccountNumber() , 1234));

        bank.deposit(opeyemi.getAccountNumber() , 500);
        assertEquals(500 , bank.checkBalance(opeyemi.getAccountNumber() , 1234));

    }

    @Test
    public void testThatIAmRegistered_MyBalanceIsZero_IDepositMinus500_MyBalanceItThrowsException(){
        Account opeyemi = bank.registerCustomer("Opeyemi", "Emmanuel", 1234);
        assertEquals(1 , bank.getNumberOfRegisteredCustomers());

        assertEquals(0 , bank.checkBalance(opeyemi.getAccountNumber() , 1234));

        assertThrows(IllegalArgumentException.class , () -> bank.deposit(opeyemi.getAccountNumber() , -500));
        assertEquals(0 , bank.checkBalance(opeyemi.getAccountNumber() , 1234));

    }

    @Test
    public void testThatIAmRegistered_MyBalanceIsZero_IDeposit500_IWithDraw200_BalanceIs300(){
        Account opeyemi = bank.registerCustomer("Opeyemi", "Emmanuel", 1234);
        assertEquals(1 , bank.getNumberOfRegisteredCustomers());

        assertEquals(0 , bank.checkBalance(opeyemi.getAccountNumber() , 1234));

        bank.deposit(opeyemi.getAccountNumber() , 500);
        bank.withDraw(opeyemi.getAccountNumber() , 300 , 1234);

        assertEquals(200 ,  bank.checkBalance(opeyemi.getAccountNumber() , 1234));

    }

    @Test
    public void testThatIAmRegistered_MyBalanceIsZero_IWithDraw200_BalanceIsZero(){
        Account opeyemi = bank.registerCustomer("Opeyemi", "Emmanuel", 1234);
        assertEquals(1 , bank.getNumberOfRegisteredCustomers());

        assertEquals(0 , bank.checkBalance(opeyemi.getAccountNumber() , 1234));

        assertThrows(IllegalArgumentException.class , () -> bank.withDraw(opeyemi.getAccountNumber() , 300 , 1234));
        assertEquals(0 ,  bank.checkBalance(opeyemi.getAccountNumber() , 1234));

    }

    @Test
    public void testThatIAmRegistered_MyBalanceIsZero_IDeposit500_IWithDraw700_BalanceIsZero(){
        Account opeyemi = bank.registerCustomer("Opeyemi", "Emmanuel", 1234);
        assertEquals(0 , bank.checkBalance(opeyemi.getAccountNumber() , 1234));

        bank.deposit(opeyemi.getAccountNumber() , 500);
        assertThrows(IllegalArgumentException.class , () -> bank.withDraw(opeyemi.getAccountNumber() , 700 , 1234));

        assertEquals(500 ,  bank.checkBalance(opeyemi.getAccountNumber() , 1234));

    }

    @Test
    public void testThatIAmRegistered_MyBalanceIsZero_IDeposit1200_ITransfer700_BalanceIs500(){
        Account opeyemi = bank.registerCustomer("Opeyemi", "Emmanuel", 1234);
        assertEquals(0 , bank.checkBalance(opeyemi.getAccountNumber() , 1234));

        Account shukurat = bank.registerCustomer("Shukurat", "Babatunde", 6445);
        assertEquals(0 , bank.checkBalance(shukurat.getAccountNumber() , 6445));

        bank.deposit(opeyemi.getAccountNumber() , 1200);
        bank.transfer(opeyemi.getAccountNumber() , shukurat.getAccountNumber() , 700 , 1234);

        assertEquals(500 ,  bank.checkBalance(opeyemi.getAccountNumber() , 1234));
        assertEquals(700 ,  bank.checkBalance(shukurat.getAccountNumber() , 6445));

    }

    @Test
    public void testThatICreatedAnAccount_IRegistered_IWasRegistered_IDonNotNeedTheAccountSoIRemovedIt_ItWasRemoved() {
        Account opeyemi = bank.registerCustomer("Opeyemi", "Emmanuel", 1234);
        assertEquals(1 , bank.getNumberOfRegisteredCustomers());

        assertEquals(opeyemi , bank.findAccount(opeyemi.getAccountNumber()));

        bank.removeAccount(opeyemi.getAccountNumber() , 1234);
        assertEquals(0 , bank.getNumberOfRegisteredCustomers());

        assertThrows(IllegalArgumentException.class , () -> bank.findAccount(opeyemi.getAccountNumber()));

    }

}