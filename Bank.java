import java.util.Scanner;

class BankAccount {
    private String accHolder;
    private double balance;

    public BankAccount(String accHolder, double balance) {
        this.accHolder = accHolder;
        this.balance = balance;
    }

    public BankAccount(String accHolder) {
        this(accHolder, 0);
    }

    public String deposit(double amount) {
        this.balance += amount;
        return "Deposited amount $" + amount + ". Current Balance: $" + this.balance;
    }

    public String withdrawal(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            return "Withdrawal amount $" + amount + ". Current Balance: $" + this.balance;
        } else {
            return "Insufficient Balance";
        }
    }

    public String checkBalance() {
        return "Current Balance: $" + this.balance;
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        BankAccount IOB = new BankAccount(userName);

        String choice = "yes";
        while (choice.equalsIgnoreCase("yes")) {
            System.out.print("Choose an action: Deposit=1, Withdrawal=2, or Check balance=3: ");
            String choose = scanner.nextLine();

            switch (choose) {
                case "1":
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.println(IOB.deposit(depositAmount));
                    break;

                case "2":
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println(IOB.withdrawal(withdrawalAmount));
                    break;

                case "3":
                    System.out.println(IOB.checkBalance());
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.print("Would you like to continue? Yes or No: ");
            choice = scanner.nextLine();
        }

        scanner.close();
    }
}
