import java.util.*;

class Account {
    private String userId;
    private String userPin;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String userId, String userPin, double initialBalance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPin() {
        return userPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    public void transfer(Account targetAccount, double amount) {
        if (amount <= balance) {
            balance -= amount;
            targetAccount.deposit(amount);
            transactionHistory.add("Transferred: " + amount + " to " + targetAccount.getUserId());
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient balance. Transfer failed.");
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        if(transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
}

class ATM {
    private Set<Account> accounts;
    private Account currentAccount;
    private Scanner scanner;

    public ATM(Set<Account> accounts) {
        this.accounts = accounts;
        this.scanner = new Scanner(System.in);
    }

    public void printSeparator() {
        System.out.println("---------------------------------------------------");
    }

    public void start() {
        if (authenticate()) {
            showMenu();
        } else {
            printSeparator();
            System.out.println("Authentication failed. Retry...");
            printSeparator();
            start();
        }
    }

    private boolean authenticate() {
        printSeparator();
        System.out.println("               Welcome to the ATM!");
        printSeparator();
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter user PIN: ");
        String userPin = scanner.nextLine();
        for (Account account : accounts) {
            if (account.getUserId().equals(userId) && account.getUserPin().equals(userPin)) {
                currentAccount = account;
                printSeparator();
                System.out.println("Authentication successful. Welcome, " + userId + "!");
                printSeparator();
                return true;
            }
        }
        return false;
    }

    private void showMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline
            printSeparator();
            switch (choice) {
                case 1:
                    currentAccount.printTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    currentAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    currentAccount.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter target user ID: ");
                    String targetUserId = scanner.next();
                    Account targetAccount = findAccountById(targetUserId);
                    if (targetAccount == null) {
                        System.out.println("Target account not found. Transfer failed.");
                    } else {
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        currentAccount.transfer(targetAccount, transferAmount);
                    }
                    break;
                case 5:
                    currentAccount.displayBalance();
                    break;
                case 6:
                    System.out.println("     Thank you for using the ATM. Visit again!\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            printSeparator();
        }
    }

    private Account findAccountById(String userId) {
        for (Account account : accounts) {
            if (account.getUserId().equals(userId)) {
                return account;
            }
        }
        return null;
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Set<Account> accounts = new HashSet<>();
        accounts.add(new Account("user123", "1234", 1000.0));
        accounts.add(new Account("user456", "5678", 500.0));
        accounts.add(new Account("user789", "91011", 1500.0));

        ATM atm = new ATM(accounts);
        atm.start();
    }
}
