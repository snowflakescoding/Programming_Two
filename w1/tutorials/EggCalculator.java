package tutorials;

import java.util.Scanner;

public class EggCalculator {
    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("How many eggs do you have? ");
            int totalEggs = scanner.nextInt();
            
            int gross = totalEggs / 144;
            int remainingEggs = totalEggs % 144;
            int dozens = remainingEggs / 12;
            int leftOver = remainingEggs % 12;
            
            System.out.println("Your number of eggs is " + gross + " gross, " + dozens + " dozen, and " + leftOver);
        }
    }
}