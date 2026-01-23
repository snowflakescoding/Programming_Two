package tutorials;

import java.util.Scanner;

public class GreetingProgram {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("What is your name? ");
            String name = scanner.nextLine();
            
            String upperCaseName = name.toUpperCase();
            
            System.out.println("Hello, " + upperCaseName + ", nice to meet you!");
        }
    }
}
