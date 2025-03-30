package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T> {
    private List<Integer> indices;

    public SwapEvent(int swapFrom, int swapTo) {
        indices = new ArrayList<>();
        indices.add(swapFrom);
        indices.add(swapTo);
    }

    public void apply(T[] arr) {
        int indexOne = indices.get(0);
        int indexTwo = indices.get(1);
        T temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }

    public List<Integer> getAffectedIndices() {
        return indices;
    }

    public boolean isEmphasized() {
        return true;
    }
}
