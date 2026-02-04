import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private static int transactionCounter = 1;
    private static final DateTimeFormatter DATE_FORMATTER = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    private final String transactionId;
    private final TransactionType type;
    private final double amount;
    private final LocalDateTime timestamp;
    private final Account sourceAccount;
    private final Account destinationAccount;
    private final String description;
    
    public Transaction(TransactionType type, double amount, 
                      Account sourceAccount, Account destinationAccount, 
                      String description) {
        this.transactionId = "TXN" + String.format("%06d", transactionCounter++);
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.description = description;
    }
    
    public String getTransactionId() {
        return transactionId;
    }
    
    public TransactionType getType() {
        return type;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public Account getSourceAccount() {
        return sourceAccount;
    }
    
    public Account getDestinationAccount() {
        return destinationAccount;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getDetailedInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Transaction ID: %s\n", transactionId));
        sb.append(String.format("Type: %s\n", type));
        sb.append(String.format("Amount: $%.2f\n", amount));
        sb.append(String.format("Timestamp: %s\n", timestamp.format(DATE_FORMATTER)));
        
        if (sourceAccount != null) {
            sb.append(String.format("Source: %s (%s)\n", 
                                   sourceAccount.getAccountNumber(), 
                                   sourceAccount.getAccountHolder()));
        }
        
        if (destinationAccount != null) {
            sb.append(String.format("Destination: %s (%s)\n", 
                                   destinationAccount.getAccountNumber(), 
                                   destinationAccount.getAccountHolder()));
        }
        
        sb.append(String.format("Description: %s", description));
        
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s: $%.2f - %s (%s)", 
                           transactionId,
                           timestamp.format(DATE_FORMATTER),
                           amount,
                           type,
                           description);
    }
}