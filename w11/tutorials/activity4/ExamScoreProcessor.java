package w11.tutorials.activity4;

import java.util.Arrays;

public class ExamScoreProcessor {
    static class SumTask implements Runnable {
        private final int[] scores;
        private int result = 0;

        public SumTask(int[] scores) {
            this.scores = scores;
        }

        @Override
        public void run() {
            for (int score : scores) {
                result += score;
            }
            System.out.println(Thread.currentThread().getName() + " -> partial sum = " + result);
        }

        public int getResult() { return result; }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] scores = { 88, 92, 75, 63, 97, 84, 70, 55, 91, 78 };

        int mid = scores.length / 2;
        int[] firstHalf = Arrays.copyOfRange(scores, 0, mid);
        int[] secondHalf = Arrays.copyOfRange(scores, mid, scores.length);

        SumTask task1 = new SumTask(firstHalf);
        SumTask task2 = new SumTask(secondHalf);

        Thread t1 = new Thread(task1, "Thread-A");
        Thread t2 = new Thread(task2, "Thread-B");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        int total = task1.getResult() + task2.getResult();
        System.out.println("Total score sum = " + total);
    }

}
