package tutorials;

import java.util.Scanner;

public class InitialsPrinter {
    
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter your initials (e.g., DJE): ");
            String initials = input.nextLine().toUpperCase();
            
            for (int line = 0; line < 9; line++) {
                for (int i = 0; i < initials.length(); i++) {
                    char letter = initials.charAt(i);
                    printLetterLine(letter, line);
                    if (i < initials.length() - 1) {
                        System.out.print("    ");  
                    }
                }
                System.out.println();  
            }
        }
    }

    public static void printLetterLine(char letter, int line) {
        switch (letter) {
            case 'A' -> printA(line);
            case 'B' -> printB(line);
            case 'C' -> printC(line);
            case 'D' -> printD(line);
            case 'E' -> printE(line);
            case 'F' -> printF(line);
            case 'G' -> printG(line);
            case 'H' -> printH(line);
            case 'I' -> printI(line);
            case 'J' -> printJ(line);
            case 'K' -> printK(line);
            case 'L' -> printL(line);
            case 'M' -> printM(line);
            case 'N' -> printN(line);
            case 'O' -> printO(line);
            case 'P' -> printP(line);
            case 'Q' -> printQ(line);
            case 'R' -> printR(line);
            case 'S' -> printS(line);
            case 'T' -> printT(line);
            case 'U' -> printU(line);
            case 'V' -> printV(line);
            case 'W' -> printW(line);
            case 'X' -> printX(line);
            case 'Y' -> printY(line);
            case 'Z' -> printZ(line);
            default -> System.out.print("      ");  
        }
    }
    
    public static void printA(int line) {
        switch (line) {
            case 0 -> System.out.print("  **  ");
            case 1 -> System.out.print(" *  * ");
            case 2 -> System.out.print("*    *");
            case 3 -> System.out.print("*    *");
            case 4 -> System.out.print("******");
            case 5 -> System.out.print("*    *");
            case 6 -> System.out.print("*    *");
            case 7 -> System.out.print("*    *");
            case 8 -> System.out.print("*    *");
        }
    }
    
    public static void printB(int line) {
        switch (line) {
            case 0 -> System.out.print("***** ");
            case 1 -> System.out.print("*    *");
            case 2 -> System.out.print("*    *");
            case 3 -> System.out.print("***** ");
            case 4 -> System.out.print("*    *");
            case 5 -> System.out.print("*    *");
            case 6 -> System.out.print("*    *");
            case 7 -> System.out.print("*    *");
            case 8 -> System.out.print("***** ");
        }
    }
    
    public static void printC(int line) {
        switch (line) {
            case 0 -> System.out.print(" *****");
            case 1 -> System.out.print("*     ");
            case 2 -> System.out.print("*     ");
            case 3 -> System.out.print("*     ");
            case 4 -> System.out.print("*     ");
            case 5 -> System.out.print("*     ");
            case 6 -> System.out.print("*     ");
            case 7 -> System.out.print("*     ");
            case 8 -> System.out.print(" *****");
        }
    }
    
    public static void printD(int line) {
        switch (line) {
            case 0 -> System.out.print("******");
            case 1 -> System.out.print("**    **");
            case 2 -> System.out.print("**    **");
            case 3 -> System.out.print("**    **");
            case 4 -> System.out.print("**    **");
            case 5 -> System.out.print("**    **");
            case 6 -> System.out.print("**    **");
            case 7 -> System.out.print("**    **");
            case 8 -> System.out.print("******");
        }
    }
    
    public static void printE(int line) {
        switch (line) {
            case 0 -> System.out.print("**********");
            case 1 -> System.out.print("**        ");
            case 2 -> System.out.print("**        ");
            case 3 -> System.out.print("**        ");
            case 4 -> System.out.print("********  ");
            case 5 -> System.out.print("**        ");
            case 6 -> System.out.print("**        ");
            case 7 -> System.out.print("**        ");
            case 8 -> System.out.print("**********");
        }
    }
    
    public static void printF(int line) {
        switch (line) {
            case 0 -> System.out.print("**********");
            case 1 -> System.out.print("**        ");
            case 2 -> System.out.print("**        ");
            case 3 -> System.out.print("**        ");
            case 4 -> System.out.print("********  ");
            case 5 -> System.out.print("**        ");
            case 6 -> System.out.print("**        ");
            case 7 -> System.out.print("**        ");
            case 8 -> System.out.print("**        ");
        }
    }
    
    public static void printG(int line) {
        switch (line) {
            case 0 -> System.out.print(" ******");
            case 1 -> System.out.print("*      ");
            case 2 -> System.out.print("*      ");
            case 3 -> System.out.print("*      ");
            case 4 -> System.out.print("*  ****");
            case 5 -> System.out.print("*     *");
            case 6 -> System.out.print("*     *");
            case 7 -> System.out.print("*     *");
            case 8 -> System.out.print(" ***** ");
        }
    }
    
    public static void printH(int line) {
        switch (line) {
            case 0 -> System.out.print("**    **");
            case 1 -> System.out.print("**    **");
            case 2 -> System.out.print("**    **");
            case 3 -> System.out.print("**    **");
            case 4 -> System.out.print("********");
            case 5 -> System.out.print("**    **");
            case 6 -> System.out.print("**    **");
            case 7 -> System.out.print("**    **");
            case 8 -> System.out.print("**    **");
        }
    }
    
    public static void printI(int line) {
        switch (line) {
            case 0 -> System.out.print("**");
            case 1 -> System.out.print("**");
            case 2 -> System.out.print("**");
            case 3 -> System.out.print("**");
            case 4 -> System.out.print("**");
            case 5 -> System.out.print("**");
            case 6 -> System.out.print("**");
            case 7 -> System.out.print("**");
            case 8 -> System.out.print("**");
        }
    }
    
    public static void printJ(int line) {
        switch (line) {
            case 0 -> System.out.print("*************");
            case 1 -> System.out.print("        **   ");
            case 2 -> System.out.print("        **   ");
            case 3 -> System.out.print("        **   ");
            case 4 -> System.out.print("        **   ");
            case 5 -> System.out.print("  **    **   ");
            case 6 -> System.out.print("  **    **   ");
            case 7 -> System.out.print("   **  **    ");
            case 8 -> System.out.print("    ****     ");
        }
    }
    
    public static void printK(int line) {
        switch (line) {
            case 0 -> System.out.print("**    **");
            case 1 -> System.out.print("**   ** ");
            case 2 -> System.out.print("**  **  ");
            case 3 -> System.out.print("** **   ");
            case 4 -> System.out.print("****    ");
            case 5 -> System.out.print("** **   ");
            case 6 -> System.out.print("**  **  ");
            case 7 -> System.out.print("**   ** ");
            case 8 -> System.out.print("**    **");
        }
    }
    
    public static void printL(int line) {
        switch (line) {
            case 0 -> System.out.print("**        ");
            case 1 -> System.out.print("**        ");
            case 2 -> System.out.print("**        ");
            case 3 -> System.out.print("**        ");
            case 4 -> System.out.print("**        ");
            case 5 -> System.out.print("**        ");
            case 6 -> System.out.print("**        ");
            case 7 -> System.out.print("**        ");
            case 8 -> System.out.print("**********");
        }
    }
    
    public static void printM(int line) {
        switch (line) {
            case 0 -> System.out.print("**      **");
            case 1 -> System.out.print("***    ***");
            case 2 -> System.out.print("** *  * **");
            case 3 -> System.out.print("**  **  **");
            case 4 -> System.out.print("**      **");
            case 5 -> System.out.print("**      **");
            case 6 -> System.out.print("**      **");
            case 7 -> System.out.print("**      **");
            case 8 -> System.out.print("**      **");
        }
    }
    
    public static void printN(int line) {
        switch (line) {
            case 0 -> System.out.print("**    **");
            case 1 -> System.out.print("***   **");
            case 2 -> System.out.print("****  **");
            case 3 -> System.out.print("** ** **");
            case 4 -> System.out.print("**  ****");
            case 5 -> System.out.print("**   ***");
            case 6 -> System.out.print("**    **");
            case 7 -> System.out.print("**    **");
            case 8 -> System.out.print("**    **");
        }
    }
    
    public static void printO(int line) {
        switch (line) {
            case 0 -> System.out.print(" ****** ");
            case 1 -> System.out.print("**    **");
            case 2 -> System.out.print("**    **");
            case 3 -> System.out.print("**    **");
            case 4 -> System.out.print("**    **");
            case 5 -> System.out.print("**    **");
            case 6 -> System.out.print("**    **");
            case 7 -> System.out.print("**    **");
            case 8 -> System.out.print(" ****** ");
        }
    }
    
    public static void printP(int line) {
        switch (line) {
            case 0 -> System.out.print("****** ");
            case 1 -> System.out.print("**    **");
            case 2 -> System.out.print("**    **");
            case 3 -> System.out.print("**    **");
            case 4 -> System.out.print("****** ");
            case 5 -> System.out.print("**     ");
            case 6 -> System.out.print("**     ");
            case 7 -> System.out.print("**     ");
            case 8 -> System.out.print("**     ");
        }
    }
    
    public static void printQ(int line) {
        switch (line) {
            case 0 -> System.out.print(" ****** ");
            case 1 -> System.out.print("**    **");
            case 2 -> System.out.print("**    **");
            case 3 -> System.out.print("**    **");
            case 4 -> System.out.print("**    **");
            case 5 -> System.out.print("**  * **");
            case 6 -> System.out.print("**   ** ");
            case 7 -> System.out.print("**    **");
            case 8 -> System.out.print(" ****** *");
        }
    }
    
    public static void printR(int line) {
        switch (line) {
            case 0 -> System.out.print("****** ");
            case 1 -> System.out.print("**    **");
            case 2 -> System.out.print("**    **");
            case 3 -> System.out.print("**    **");
            case 4 -> System.out.print("****** ");
            case 5 -> System.out.print("** **  ");
            case 6 -> System.out.print("**  ** ");
            case 7 -> System.out.print("**   **");
            case 8 -> System.out.print("**    **");
        }
    }
    
    public static void printS(int line) {
        switch (line) {
            case 0 -> System.out.print(" ******");
            case 1 -> System.out.print("**     ");
            case 2 -> System.out.print("**     ");
            case 3 -> System.out.print("**     ");
            case 4 -> System.out.print(" ******");
            case 5 -> System.out.print("      **");
            case 6 -> System.out.print("      **");
            case 7 -> System.out.print("      **");
            case 8 -> System.out.print("****** ");
        }
    }
    
    public static void printT(int line) {
        switch (line) {
            case 0 -> System.out.print("**********");
            case 1 -> System.out.print("    **    ");
            case 2 -> System.out.print("    **    ");
            case 3 -> System.out.print("    **    ");
            case 4 -> System.out.print("    **    ");
            case 5 -> System.out.print("    **    ");
            case 6 -> System.out.print("    **    ");
            case 7 -> System.out.print("    **    ");
            case 8 -> System.out.print("    **    ");
        }
    }
    
    public static void printU(int line) {
        switch (line) {
            case 0 -> System.out.print("**    **");
            case 1 -> System.out.print("**    **");
            case 2 -> System.out.print("**    **");
            case 3 -> System.out.print("**    **");
            case 4 -> System.out.print("**    **");
            case 5 -> System.out.print("**    **");
            case 6 -> System.out.print("**    **");
            case 7 -> System.out.print("**    **");
            case 8 -> System.out.print(" ****** ");
        }
    }
    
    public static void printV(int line) {
        switch (line) {
            case 0 -> System.out.print("**    **");
            case 1 -> System.out.print("**    **");
            case 2 -> System.out.print("**    **");
            case 3 -> System.out.print("**    **");
            case 4 -> System.out.print("**    **");
            case 5 -> System.out.print(" **  ** ");
            case 6 -> System.out.print(" **  ** ");
            case 7 -> System.out.print("  ****  ");
            case 8 -> System.out.print("   **   ");
        }
    }
    
    public static void printW(int line) {
        switch (line) {
            case 0 -> System.out.print("**      **");
            case 1 -> System.out.print("**      **");
            case 2 -> System.out.print("**      **");
            case 3 -> System.out.print("**      **");
            case 4 -> System.out.print("**      **");
            case 5 -> System.out.print("**  **  **");
            case 6 -> System.out.print("** *  * **");
            case 7 -> System.out.print("***    ***");
            case 8 -> System.out.print("**      **");
        }
    }
    
    public static void printX(int line) {
        switch (line) {
            case 0 -> System.out.print("**    **");
            case 1 -> System.out.print("**    **");
            case 2 -> System.out.print(" **  ** ");
            case 3 -> System.out.print("  ****  ");
            case 4 -> System.out.print("   **   ");
            case 5 -> System.out.print("  ****  ");
            case 6 -> System.out.print(" **  ** ");
            case 7 -> System.out.print("**    **");
            case 8 -> System.out.print("**    **");
        }
    }
    
    public static void printY(int line) {
        switch (line) {
            case 0 -> System.out.print("**    **");
            case 1 -> System.out.print("**    **");
            case 2 -> System.out.print(" **  ** ");
            case 3 -> System.out.print("  ****  ");
            case 4 -> System.out.print("   **   ");
            case 5 -> System.out.print("   **   ");
            case 6 -> System.out.print("   **   ");
            case 7 -> System.out.print("   **   ");
            case 8 -> System.out.print("   **   ");
        }
    }
    
    public static void printZ(int line) {
        switch (line) {
            case 0 -> System.out.print("********");
            case 1 -> System.out.print("      **");
            case 2 -> System.out.print("     ** ");
            case 3 -> System.out.print("    **  ");
            case 4 -> System.out.print("   **   ");
            case 5 -> System.out.print("  **    ");
            case 6 -> System.out.print(" **     ");
            case 7 -> System.out.print("**      ");
            case 8 -> System.out.print("********");
        }
    }
}
