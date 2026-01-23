package tutorials;

/**
 * This class implements a simple program that will compute the amount of
 * interest that is earned in 17,000 invested at an interest rate of 0.07 for
 * one year. The interest and the value of the investment after one year are
 * printed to the standard output.
 */
public class Interest {

    public static void main(String[] args) {
        /* Declare the variables. */
        // double principal;
        int principal;
        double rate;
        double interest;

        /* Do the computations. */
        principal = 17000;
        // principal = 17000.0;
        rate = 0.07;
        interest = principal * rate;
        // principal = principal + interest;
        principal = (int) (principal + interest);

        /* Output the results. */
        System.out.print("The interest earned is: ");
        System.out.println(interest);
        System.out.print("The value of the investment after one year is: ");
        System.out.println(principal);

    } // end of main()
} // end of class Interest;
