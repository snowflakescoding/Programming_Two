import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Account {
    private static final Logger LOGGER = Logger.getLogger(Account.class.getName());
    private static int accountCounter = 1000;
    
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<Transaction> transactionHistory;
    
    public Account(String accountHolder, double initialBalance) {
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        
        this.accountNumber = "ACC" + (accountCounter++);
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        
        LOGGER.log(Level.INFO, "Account created: {0} for {1} with initial balance: ${2}", 
                   new Object[]{accountNumber, accountHolder, initialBalance});
    }
    
    public boolean deposit(double amount) {
        LOGGER.log(Level.INFO, "Attempting deposit of ${0} to account {1}", 
                   new Object[]{amount, accountNumber});

        if (amount <= 0) {
            LOGGER.log(Level.WARNING, "Deposit failed: Invalid amount ${0}", amount);
            System.err.println("Error: Deposit amount must be positive");
            return false;
        }
        
        double oldBalance = balance;
        balance += amount;
        
        Transaction transaction = new Transaction(
            TransactionType.DEPOSIT, 
            amount, 
            this, 
            null, 
            "Deposit to " + accountNumber
        );
        transactionHistory.add(transaction);
        
        LOGGER.log(Level.INFO, "Deposit successful: ${0} deposited. Balance: ${1} -> ${2}", 
                   new Object[]{amount, oldBalance, balance});
        
        return true;
    }
    
    public boolean withdraw(double amount) {
        LOGGER.log(Level.INFO, "Attempting withdrawal of ${0} from account {1}", 
                   new Object[]{amount, accountNumber});
        
        if (amount <= 0) {
            LOGGER.log(Level.WARNING, "Withdrawal failed: Invalid amount ${0}", amount);
            System.err.println("Error: Withdrawal amount must be positive");
            return false;
        }
        
        if (amount > balance) {
            LOGGER.log(Level.WARNING, 
                       "Withdrawal failed: Insufficient funds. Requested: ${0}, Available: ${1}", 
                       new Object[]{amount, balance});
            System.err.println("Error: Insufficient funds. Available balance: $" + balance);
            return false;
        }
        
        double oldBalance = balance;
        balance -= amount;
        
        Transaction transaction = new Transaction(
            TransactionType.WITHDRAWAL, 
            amount, 
            this, 
            null, 
            "Withdrawal from " + accountNumber
        );
        transactionHistory.add(transaction);
        
        LOGGER.log(Level.INFO, "Withdrawal successful: ${0} withdrawn. Balance: ${1} -> ${2}", 
                   new Object[]{amount, oldBalance, balance});
        
        return true;
    }
    
    public boolean transfer(Account toAccount, double amount) {
        LOGGER.log(Level.INFO, "Attempting transfer of ${0} from {1} to {2}", 
                   new Object[]{amount, this.accountNumber, toAccount.getAccountNumber()});
        
        if (this.accountNumber.equals(toAccount.getAccountNumber())) {
            LOGGER.log(Level.WARNING, "Transfer failed: Cannot transfer to same account");
            System.err.println("Error: Cannot transfer to the same account");
            return false;
        }
        
        if (amount <= 0) {
            LOGGER.log(Level.WARNING, "Transfer failed: Invalid amount ${0}", amount);
            System.err.println("Error: Transfer amount must be positive");
            return false;
        }

        if (amount > balance) {
            LOGGER.log(Level.WARNING, 
                       "Transfer failed: Insufficient funds. Requested: ${0}, Available: ${1}", 
                       new Object[]{amount, balance});
            System.err.println("Error: Insufficient funds for transfer. Available: $" + balance);
            return false;
        }

        double senderOldBalance = balance;
        double receiverOldBalance = toAccount.balance;
        
        balance -= amount;
        toAccount.balance += amount;

        Transaction senderTransaction = new Transaction(
            TransactionType.TRANSFER_OUT, 
            amount, 
            this, 
            toAccount, 
            "Transfer to " + toAccount.getAccountNumber()
        );
        
        Transaction receiverTransaction = new Transaction(
            TransactionType.TRANSFER_IN, 
            amount, 
            this, 
            toAccount, 
            "Transfer from " + this.accountNumber
        );
        
        this.transactionHistory.add(senderTransaction);
        toAccount.transactionHistory.add(receiverTransaction);
        
        LOGGER.log(Level.INFO, 
                   "Transfer successful: ${0} transferred from {1} to {2}. " +
                   "Sender balance: ${3} -> ${4}, Receiver balance: ${5} -> ${6}", 
                   new Object[]{amount, accountNumber, toAccount.getAccountNumber(), 
                                senderOldBalance, balance, receiverOldBalance, toAccount.balance});
        
        return true;
    }
    
    public void printTransactionHistory() {
        System.out.println("\n=== Transaction History for " + accountNumber + " ===");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
        System.out.println("\nTransactions:");
        
        if (transactionHistory.isEmpty()) {
            System.out.println("  No transactions yet");
        } else {
            for (int i = 0; i < transactionHistory.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + transactionHistory.get(i));
            }
        }
        System.out.println("==========================================\n");
    }
    
    public boolean verifyBalance() {
        LOGGER.log(Level.INFO, "Verifying balance for account {0}", accountNumber);
        
        double calculatedBalance = 0;
        
        for (Transaction transaction : transactionHistory) {
            switch (transaction.getType()) {
                case DEPOSIT, TRANSFER_IN -> calculatedBalance += transaction.getAmount();
                case WITHDRAWAL, TRANSFER_OUT -> calculatedBalance -= transaction.getAmount();
            }
        }
        
        boolean isValid = Math.abs(balance - calculatedBalance) < 0.01; 
        
        if (isValid) {
            LOGGER.log(Level.INFO, "Balance verification passed for {0}: ${1}", 
                       new Object[]{accountNumber, balance});
        } else {
            LOGGER.log(Level.SEVERE, 
                       "Balance verification FAILED for {0}! Current: ${1}, Calculated: ${2}", 
                       new Object[]{accountNumber, balance, calculatedBalance});
        }
        
        return isValid;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory); 
    }
    
    @Override
    public String toString() {
        return String.format("Account[%s, Holder: %s, Balance: $%.2f]", 
                           accountNumber, accountHolder, balance);
    }
}