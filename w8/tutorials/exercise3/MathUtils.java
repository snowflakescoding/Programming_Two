package exercise3;
// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// ****************************************************************
public class MathUtils {
    //-------------------------------------------------------------
    // Returns the factorial of the argument given
    //-------------------------------------------------------------
    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0)
            throw new IllegalArgumentException(
                "Factorial is not defined for negative numbers. Argument was: " + n);
        if (n > 16)
            throw new IllegalArgumentException(
                "Argument too large: factorial of " + n +
                " exceeds int range. Maximum supported value is 16.");
        int fac = 1;
        for (int i = n; i > 0; i--)
            fac *= i;
        return fac;
    }
}

