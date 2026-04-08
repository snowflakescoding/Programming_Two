package w10.tutorials.exercise2;

import java.util.ArrayList;

public class ArrayListIntegerLoop {
    public static void main(String[] args) {
        ArrayList<Integer> myArray = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            myArray.add(i);
        }

        System.out.println("Numbers in myArray:");
        for (int i = 0; i < myArray.size(); i++) {
            System.out.println("myArray[" + i + "] = " + myArray.get(i));
        }
    }
}
