package Algorithm;

import com.company.SortArray;

public class MergeSort implements SortingAlgorithm {
    private long stepDelay = 20;

    private int[] getSubArray(SortArray arr, int begin, int size) {
        int array[] = new int[size];
        for (int i = 0; i < size; ++i) {
            array[i] = arr.getValue(begin + i);
        }
        return array;
    }

    private void merge(SortArray arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int leftArr[] = getSubArray(arr, left, leftSize);
        int rightArr[] = getSubArray(arr, mid + 1, rightSize);

        int i = 0, j = 0, k = left;
    }

    private void mergeSort(SortArray arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void runSort(SortArray arr) {
        int left = 0;
        int right = arr.arraySize() - 1;
        mergeSort(arr, left, right);
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }

    @Override
    public long getDelay() {
        return stepDelay;
    }

    @Override
    public void setDelay(long delay) {
        this.stepDelay = delay;
    }
}