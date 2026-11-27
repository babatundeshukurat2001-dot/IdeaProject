
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Bank bank = new Bank();

        System.out.println("WELCOME TO KOWOPE BANK");

        while (true) {

            System.out.println("\n1. Register Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Create your PIN: ");
                    String pin = input.next();

                    bank.registerAccount(pin);

                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter your PIN: ");
                    String depositPin = input.next();

                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = input.nextInt();

                    bank.deposit(depositAmount, depositPin);

                    System.out.println("Deposit operation completed.");
                    break;

                case 3:
                    System.out.print("Enter your PIN: ");
                    String withdrawPin = input.next();

                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = input.nextInt();

                    if (bank.withdraw(withdrawAmount, withdrawPin)) {
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Withdrawal failed!");
                    }
                    break;

                case 4:
                    System.out.print("Enter your PIN: ");
                    String balancePin = input.next();

                    int balance = bank.getBalance(balancePin);

                    if (balance == -1) {
                        System.out.println("Invalid PIN!");
                    } else {
                        System.out.println("Your account balance is: " + balance);
                    }
                    break;

                case 5:
                    System.out.print("Enter sender's PIN: ");
                    String senderPin = input.next();

                    System.out.print("Enter receiver's PIN: ");
                    String receiverPin = input.next();

                    System.out.print("Enter amount to transfer: ");
                    int transferAmount = input.nextInt();

                    if (bank.transfer(transferAmount, senderPin, receiverPin)) {
                        System.out.println("Transfer successful!");
                    } else {
                        System.out.println("Transfer failed! Check your PIN or account balance.");
                    }
                    break;

                case 6:
                    System.out.println("Thanks for banking with us!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
 