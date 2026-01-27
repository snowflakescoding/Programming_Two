package activity4;

import java.util.Arrays;

public class IntSort {

    private String name;
    private int[] array;
    protected int[] sortedArray;

    public IntSort(String name, int[] array) {
        this.name = name;
        this.array = array;
        this.sortedArray = array.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
        this.sortedArray = array.clone();
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    public void sort() {
        this.sortedArray = this.array.clone();
        Arrays.sort(this.sortedArray);
    }

    public boolean isSorted() {
        if (sortedArray == null || sortedArray.length <= 1) {
            return true;
        }
        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (sortedArray[i] > sortedArray[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " Result: " + Arrays.toString(sortedArray);
    }
}
