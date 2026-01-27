package activity4;

public class IntSelectionSort extends IntSort {

    public IntSelectionSort(int[] array) {
        super("Selection Sort", array);
    }

    @Override
    public void sort() {
        this.sortedArray = getArray().clone();
        int n = sortedArray.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (sortedArray[j] < sortedArray[min_idx]) {
                    min_idx = j;
                }
            }

            int temp = sortedArray[min_idx];
            sortedArray[min_idx] = sortedArray[i];
            sortedArray[i] = temp;
        }
    }
}
