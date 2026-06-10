import java.util.Scanner;

public class Main {

    public static Account account = null;

    public static Account createAccount(Scanner sc) {

        sc.nextLine(); // Clears the leftover newline

        System.out.println("\n===== CREATE ACCOUNT =====");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter User ID: ");
        String userId = sc.next();

        System.out.print("Create PIN: ");
        String pin = sc.next();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        System.out.println("\nAccount Created Successfully!");

        return new Account(name, userId, pin, balance);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=================================");
            System.out.println("        ATM INTERFACE");
            System.out.println("=================================");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    account = createAccount(sc);
                    break;

                case 2:

                    if (account == null) {
                        System.out.println("\nPlease create an account first!");
                        break;
                    }

                    Atm atm = new Atm(account);

                    if (atm.login(sc)) {
                        atm.menu(sc);
                    }

                    break;

                case 3:
                    System.out.println("\nThank You for Using ATM Interface!");
                    sc.close();
                    return;

                default:
                    System.out.println("\nInvalid Choice!");
            }
        }
    }
}