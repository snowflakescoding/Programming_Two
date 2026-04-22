package w11.tutorials.activity1;

public class MainThreadDemo {
    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("Running thread: " + threadName);

        try {
            System.out.println("Pausing for 2 seconds...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted!");
            Thread.currentThread().interrupt();
        }

        System.out.println("Resumed after 2-second pause. Execution complete!");
    }

}
