package Algorithm;

import com.company.SortArray;

public class InsertionSort implements SortingAlgorithm{
    private long stepDelay = 60;


    @Override
    public void runSort(SortArray arr) {
        int len = arr.arraySize();
        for (int i = 1; i < len; ++i) {
            int key = arr.getValue(i);
            int j = i - 1;
            while (j >= 0 && arr.getValue(j) > key) {
                arr.updateSingle(j+1, arr.getValue(j), 5, true);
                j = j - 1;
            }
            arr.updateSingle(j+1, key, getDelay(), true);
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
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
