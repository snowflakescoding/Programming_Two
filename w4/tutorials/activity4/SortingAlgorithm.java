package activity4;

import java.util.Arrays;

public class SortingAlgorithm {

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array: " + Arrays.toString(data));
        System.out.println("------------------------------------------------");

        IntSort defaultSort = new IntSort("Default Sort", data);
        defaultSort.sort();
        System.out.println(defaultSort.toString());
        System.out.println("Is Sorted? " + defaultSort.isSorted());
        System.out.println("------------------------------------------------");

        IntSort selectionSort = new IntSelectionSort(data);
        selectionSort.sort();
        System.out.println(selectionSort.toString());
        System.out.println("Is Sorted? " + selectionSort.isSorted());
        System.out.println("------------------------------------------------");

        IntSort bubbleSort = new IntBubbleSort(data);
        bubbleSort.sort();
        System.out.println(bubbleSort.toString());
        System.out.println("Is Sorted? " + bubbleSort.isSorted());
    }
}
