
import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts = new ArrayList<>();

    public void registerAccount(String pin) {
        Account account = new Account(pin);
        accounts.add(account);
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    private Account findAccount(String pin) {
        for (Account account : accounts) {
            if (account.getBalance(pin) != -1) {
                return account;
            }
        }

        return null;
    }

    public void deposit(int amount, String pin) {
        Account account = findAccount(pin);

        if (account != null) {
            account.deposit(amount);
        }
    }

    public boolean withdraw(int amount, String pin) {
        Account account = findAccount(pin);

        if (account != null) {
            return account.withdraw(amount, pin);
        }

        return false;
    }

    public int getBalance(String pin) {
        Account account = findAccount(pin);

        if (account != null) {
            return account.getBalance(pin);
        }

        return -1;
    }

    public boolean transfer(int amount, String senderPin, String receiverPin) {

        Account sender = findAccount(senderPin);
        Account receiver = findAccount(receiverPin);

        if (sender == null || receiver == null) {
            return false;
        }

        if (amount <= 0) {
            return false;
        }

        if (sender.withdraw(amount, senderPin)) {
            receiver.deposit(amount);
            return true;
        }

        return false;
    }
}
