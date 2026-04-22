package w11.tutorials.activity3;

public class DownloadDemo {
    public static void downloadFile(String name) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Finished " + name);
        }
    }
    
    public static void sequential() {
        long start = System.currentTimeMillis();

        downloadFile("FileA.zip");
        downloadFile("FileB.zip");

        long end = System.currentTimeMillis();
        System.out.println("Sequential total: " + (end - start) + "ms\n");
    }

    public static void concurrent() throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> downloadFile("FileA.zip"));
        Thread t2 = new Thread(() -> downloadFile("FileB.zip"));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long end = System.currentTimeMillis();
        System.out.println("Concurrent total: " + (end - start) + "ms\n");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Sequential ===");
        sequential();

        System.out.println("=== Concurrent ===");
        concurrent();
    }
}
