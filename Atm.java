import java.util.Scanner;

public class Atm{

    private Account account;
    private Transaction transaction;

    public Atm(Account account) {
        this.account = account;
        this.transaction = new Transaction();
    }

    public boolean login(Scanner sc) {

        System.out.print("Enter User ID: ");
        String id = sc.next();

        System.out.print("Enter PIN: ");
        String pin = sc.next();

        if(id.equals(account.getUserId()) && pin.equals(account.getPin())) {
           System.out.println("\nLogin Successful!");
           System.out.println("Welcome, " + account.getName() + "!\n");
            return true;
        }

        System.out.println("Invalid User ID or PIN");
        return false;
    }

    public void menu(Scanner sc) {

        int choice;

        do {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit(sc);
                    break;

                case 3:
                    withdraw(sc);
                    break;

                case 4:
                    transfer(sc);
                    break;

                case 5:
                    transaction.showHistory();
                    break;

                case 6:
                    System.out.println("Thank You for Using ATM!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while(choice != 6);
    }

    private void checkBalance() {
        System.out.println("Current Balance: Rs." + account.getBalance());
    }

    private void deposit(Scanner sc) {

        System.out.print("Enter Amount: ");

        double amount = sc.nextDouble();

        account.setBalance(account.getBalance() + amount);

        transaction.addTransaction("Deposited Rs." + amount);

        System.out.println("Deposit Successful!");
    }

    private void withdraw(Scanner sc) {

        System.out.print("Enter Amount: ");

        double amount = sc.nextDouble();

        if(amount > account.getBalance()) {
            System.out.println("Insufficient Balance");
            return;
        }

        account.setBalance(account.getBalance() - amount);

        transaction.addTransaction("Withdraw Rs." + amount);

        System.out.println("Withdrawal Successful!");
    }

    private void transfer(Scanner sc) {

        System.out.print("Enter Receiver Account Number: ");
        String receiver = sc.next();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        if(amount > account.getBalance()) {
            System.out.println("Insufficient Balance");
            return;
        }

        account.setBalance(account.getBalance() - amount);

        transaction.addTransaction("Transferred Rs." + amount + " to " + receiver);

        System.out.println("Transfer Successful!");
    }
}