package w11.tutorials.activity2;

public class PrintTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Task started");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task finished");
    }

    public static void main(String [] args) {
        PrintTask task = new PrintTask();
        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Main thread continues...");
    }
}
