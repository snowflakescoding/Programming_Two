package activity4;

public class IntBubbleSort extends IntSort {

    public IntBubbleSort(int[] array) {
        super("Bubble Sort", array);
    }

    @Override
    public void sort() {
        this.sortedArray = getArray().clone();
        int n = sortedArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
    }
}
