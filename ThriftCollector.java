import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    public class ThriftCollector {
    private static Map<String, Double> accountBalances = new HashMap<>();
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
            deposit();
            break;
            case 2:
            withdraw();
            break;
            case 3:
            checkBalance();
            break;
            case 4:
            System.out.println("Exiting program.");
            System.exit(0);
            break;
            default:
            System.out.println("Invalid choice. Please try again.");
        }
    }
}
private static void deposit() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter account number: ");
    String accountNumber = scanner.next();
    System.out.print("Enter amount to deposit: ");
    Double amount = scanner.nextDouble();
    if (accountBalances.containsKey(accountNumber)) {
        accountBalances.put(accountNumber, accountBalances.get(accountNumber) + amount);
        System.out.println("Deposit successful.");
    } else {
        accountBalances.put(accountNumber, amount);
        System.out.println("Account created with initial deposit.");
    }
}
private static void withdraw() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter account number:" );
    String accountNumber = scanner.next();
    if (accountBalances.containsKey(accountNumber)) {
        System.out.print("Enter amount to withdraw: ");
        Double amount = scanner.nextDouble();
        if (accountBalances.get(accountNumber) >= amount) {
            accountBalances.put(accountNumber, accountBalances.get(accountNumber) - amount);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    } else {
        System.out.println("Account not found. Please deposit to create an account.");
    }
}
private static void checkBalance() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter account number: ");
    String accountNumber = scanner.next();
    if (accountBalances.containsKey(accountNumber)) {
        System.out.println("Current balance: " + accountBalances.get(accountNumber));
    } else {
        System.out.println("Account not found. Please deposit to create an account.");
    }
}
}