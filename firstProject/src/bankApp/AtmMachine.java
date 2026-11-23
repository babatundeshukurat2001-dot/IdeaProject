package bankApp;

import java.util.Scanner;


public class AtmMachine {
    private static final Scanner inputCollector = new Scanner(System.in);
    private static final Bank bank = new Bank("Keystone Bank");

    private static void goToMenu(){
        print("""
                \n HELLO, WELCOME TO KEYSTONE BANK!!!
                
                1; Create Account
                2; Check Balance
                3; Deposit
                4; Withdraw
                5; Transfer
                6; Exit
                
                """);
    }
    private static void print(String prompt){
        System.out.println(prompt);

    }
    private static String input(String prompt){
        System.out.print(prompt);
        return inputCollector.nextLine();
    }
    public static void main(String[] args) {
        goToMenu();
        While (true); {
            String choice = input("Enter your choice: ");

            switch(choice){
                case "1" -> createAccount();
                case "2" -> checkBalance();
                case "3" -> bank.deposit();
                case "4" -> withdraw();
                case "5" -> bank.transfer();
                case "6" -> {
                    print("Thank you for choosing our bank!");
                    return;
                }
                default -> {
                    print("Invalid choice!:");
                    goToMenu();
                }
            }

        }
    }

    private static void While(boolean b) {
    }

    private static void createAccount() {
    }

    private static void withdraw(){
    int accountNumber = inputInt("Enter your account number: ");
    int amount = inputInt("Enter amount to withdraw: ");

    int pin = inputInt("Enter pi number: ");
    inputCollector.nextLine();

    try{
        bank.withDraw(accountNumber,amount,pin);
        print("\n-> " + amount + " withdrawn successfully!");
    }
    catch (Exception e){
        print(e.getMessage());
    }
    goToMenu();
    }

    private static int inputInt(String s) {
                return 0;
    }

    private static void checkBalance(){
        int accountNumber = inputInt("Enter your account number: ");
        int pin = inputInt("Enter your pin: ");
        inputCollector.nextLine();
        try{
            print("\n Your balance is " + bank.checkBalance(accountNumber,pin));
        }
        catch (Exception e){
            print(e.getMessage());
        }
        goToMenu();
    }
    private static void creatAccount(){
        String firstName = input("Enter first name: ");
        String lastName = input("Enter last name: ");

        int pin = inputInt("Enter the pin you are to use: ");
        inputCollector.nextLine();

        try{
            Account details = bank.registerCustomer(firstName,lastName,pin);
            print("Account created successfully!!!");
            print("\n Your account number is -> " + details.getAccountNumber());
        }
        catch (Exception e){
            print(e.getMessage());
        }
        goToMenu();
    }


}