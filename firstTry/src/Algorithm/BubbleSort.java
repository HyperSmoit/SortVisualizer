package Algorithm;

import com.company.SortArray;

public class BubbleSort implements SortingAlgorithm {
    private long stepDelay = 1;

    @Override
    public void runSort(SortArray arr) {
        int len = arr.arraySize();
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                if (arr.getValue(j) > arr.getValue(i)) {
                    arr.swap(i, j, getDelay(), true);
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
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
