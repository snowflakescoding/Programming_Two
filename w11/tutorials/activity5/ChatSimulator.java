package w11.tutorials.activity5;

import java.util.Random;
import java.util.Scanner;

public class ChatSimulator {
    static class IncomingMessageTask implements Runnable {
        private static final String[] MESSAGES = {
            "Alice: Hi!",
            "Bob: Are you there?",
            "Alice: What's up?",
            "Charlie: Hey everyone!",
            "Bob: Anyone online?",
            "Alice: Just checking in :)",
            "Charlie: See you later!",
            "Bob: Catch you soon!"
        };

        @SuppressWarnings("BusyWait")
        @Override
        public void run() {
            Random random = new Random();
            int rounds = 5 + random.nextInt(6);

            for (int i = 0; i < rounds; i++) {
                try {
                    int delay = 1000 + random.nextInt(1001);
                    Thread.sleep(delay);

                    String msg = MESSAGES[random.nextInt(MESSAGES.length)];
                    System.out.println("\n" + msg);
                    System.out.print("You: ");

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            System.out.println("\n[Chat ended — no more incoming messages]");
        }
    }

    public static void main(String[] args) {
        Thread incomingThread = new Thread(new IncomingMessageTask());
        incomingThread.setDaemon(true);
        incomingThread.start();

        try (Scanner scanner = new Scanner(System.in)) {  // ← fixed here
            System.out.println("=== Chat started. Type your messages below ===\n");

            while (true) {
                System.out.print("You: ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("quit")) {
                    System.out.println("[You left the chat]");
                    break;
                }
                System.out.println("You: " + input);
            }
        }
    }
}