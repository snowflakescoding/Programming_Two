import java.util.ArrayList;

public class ArrayListOperations {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<>();

        myList.add(42);

        myList.add(3.14f);

        myList.add(true);

        myList.add("Hello, ArrayList!");

        System.out.println("Element 1 (Integer): " + myList.get(0));
        System.out.println("Element 2 (Float):   " + myList.get(1));
        System.out.println("Element 3 (Boolean): " + myList.get(2));
        System.out.println("Element 4 (String):  " + myList.get(3));
    }
}