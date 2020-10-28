package Algorithm;

import com.company.SortArray;

public class QuickSort implements SortingAlgorithm{
    private long stepDelay = 120;

    @Override
    public void runSort(SortArray arr) {

    }

    @Override
    public String getName() {
        return "QuickSort";
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
