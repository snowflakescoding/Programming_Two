import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BankingSystemTest {
    private static final Logger LOGGER = Logger.getLogger(BankingSystemTest.class.getName());
    
    public static void main(String[] args) {
        configureLogging();
        
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║   BANKING SYSTEM - IMPLEMENTATION & DEBUGGING DEMO    ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        System.out.println("TEST 1: Normal Banking Operations");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        testNormalOperations();
        
        System.out.println("\n\nTEST 2: Edge Case - Negative Amounts");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        testNegativeAmounts();
        
        System.out.println("\n\nTEST 3: Edge Case - Insufficient Funds");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        testInsufficientFunds();
        
        System.out.println("\n\nTEST 4: Transfer Operations");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        testTransfers();

        System.out.println("\n\nTEST 5: Balance Verification & Audit Trail");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        testBalanceVerification();
        
        System.out.println("\n\nTEST 6: Edge Case - Invalid Transfers");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        testInvalidTransfers();
        
        System.out.println("\n\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              ALL TESTS COMPLETED                       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
    
    private static void configureLogging() {
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.INFO);
        
        for (var handler : rootLogger.getHandlers()) {
            rootLogger.removeHandler(handler);
        }
        
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new SimpleFormatter());
        rootLogger.addHandler(handler);
        
        LOGGER.log(Level.INFO, "Logging configured for banking system debugging");
    }
    
    private static void testNormalOperations() {
        Account alice = new Account("Alice Smith", 1000.00);
        System.out.println("✓ Created: " + alice);
        
        System.out.println("\n--- Deposit Test ---");
        boolean depositResult = alice.deposit(500.00);
        System.out.println("Deposit Result: " + (depositResult ? "SUCCESS" : "FAILED"));
        System.out.println("New Balance: $" + alice.getBalance());
        
        System.out.println("\n--- Withdrawal Test ---");
        boolean withdrawResult = alice.withdraw(200.00);
        System.out.println("Withdrawal Result: " + (withdrawResult ? "SUCCESS" : "FAILED"));
        System.out.println("New Balance: $" + alice.getBalance());
        
        alice.printTransactionHistory();
    }
    
    private static void testNegativeAmounts() {
        Account bob = new Account("Bob Johnson", 500.00);
        System.out.println("Created: " + bob);
        
        System.out.println("\n--- Attempting negative deposit ---");
        boolean result1 = bob.deposit(-100.00);
        System.out.println("Expected: FAILED, Actual: " + (result1 ? "SUCCESS" : "FAILED"));
        
        System.out.println("\n--- Attempting zero deposit ---");
        boolean result2 = bob.deposit(0.00);
        System.out.println("Expected: FAILED, Actual: " + (result2 ? "SUCCESS" : "FAILED"));
        
        System.out.println("\n--- Attempting negative withdrawal ---");
        boolean result3 = bob.withdraw(-50.00);
        System.out.println("Expected: FAILED, Actual: " + (result3 ? "SUCCESS" : "FAILED"));
        
        System.out.println("\nBalance remained: $" + bob.getBalance() + " ✓");
    }
    
    private static void testInsufficientFunds() {
        Account charlie = new Account("Charlie Brown", 100.00);
        System.out.println("Created: " + charlie);
        System.out.println("Initial Balance: $" + charlie.getBalance());
        
        System.out.println("\n--- Attempting to withdraw more than balance ---");
        boolean result = charlie.withdraw(150.00);
        System.out.println("Withdrawal Result: " + (result ? "SUCCESS ✗" : "FAILED ✓ (as expected)"));
        System.out.println("Balance unchanged: $" + charlie.getBalance() + " ✓");
        
        System.out.println("\n--- Valid withdrawal ---");
        charlie.withdraw(50.00);
        System.out.println("New Balance: $" + charlie.getBalance());
    }
    
    private static void testTransfers() {
        Account sender = new Account("David Lee", 1000.00);
        Account receiver = new Account("Emma Wilson", 500.00);
        
        System.out.println("Sender: " + sender);
        System.out.println("Receiver: " + receiver);
        
        System.out.println("\n--- Transfer $300 from sender to receiver ---");
        boolean transferResult = sender.transfer(receiver, 300.00);
        
        System.out.println("\nTransfer Result: " + (transferResult ? "SUCCESS ✓" : "FAILED ✗"));
        System.out.println("Sender Balance: $" + sender.getBalance() + " (expected $700)");
        System.out.println("Receiver Balance: $" + receiver.getBalance() + " (expected $800)");
        
        sender.printTransactionHistory();
        receiver.printTransactionHistory();
    }
    
    private static void testBalanceVerification() {
        Account testAccount = new Account("Frank Miller", 1000.00);
        
        System.out.println("Performing multiple operations...");
        testAccount.deposit(500.00);
        testAccount.withdraw(200.00);
        testAccount.deposit(100.00);
        testAccount.withdraw(50.00);
        
        System.out.println("\nFinal Balance: $" + testAccount.getBalance());
        
        System.out.println("\n--- Running Balance Verification ---");
        boolean isValid = testAccount.verifyBalance();
        
        if (isValid) {
            System.out.println("✓ Balance verification PASSED");
            System.out.println("  All transactions match the current balance");
        } else {
            System.out.println("✗ Balance verification FAILED");
            System.out.println("  Discrepancy detected in transaction history");
        }
        
        testAccount.printTransactionHistory();
    }
    
    private static void testInvalidTransfers() {
        Account account1 = new Account("Grace Taylor", 500.00);
        Account account2 = new Account("Henry Davis", 300.00);
        
        System.out.println("Account 1: " + account1);
        System.out.println("Account 2: " + account2);
        
        System.out.println("\n--- Test 1: Transfer to same account ---");
        boolean result1 = account1.transfer(account1, 100.00);
        System.out.println("Result: " + (result1 ? "SUCCESS ✗" : "FAILED ✓ (as expected)"));
        
        System.out.println("\n--- Test 2: Transfer with insufficient funds ---");
        boolean result2 = account1.transfer(account2, 1000.00);
        System.out.println("Result: " + (result2 ? "SUCCESS ✗" : "FAILED ✓ (as expected)"));
        
        System.out.println("\n--- Test 3: Transfer negative amount ---");
        boolean result3 = account1.transfer(account2, -50.00);
        System.out.println("Result: " + (result3 ? "SUCCESS ✗" : "FAILED ✓ (as expected)"));
        
        System.out.println("\n--- Test 4: Transfer to null account ---");
        boolean result4 = account1.transfer(null, 100.00);
        System.out.println("Result: " + (result4 ? "SUCCESS ✗" : "FAILED ✓ (as expected)"));
        
        System.out.println("\n--- Test 5: Valid transfer ---");
        boolean result5 = account1.transfer(account2, 100.00);
        System.out.println("Result: " + (result5 ? "SUCCESS ✓" : "FAILED ✗"));
        System.out.println("Account 1 Balance: $" + account1.getBalance());
        System.out.println("Account 2 Balance: $" + account2.getBalance());
    }
}