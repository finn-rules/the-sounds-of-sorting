package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T> {
    private List<Integer> indices;

    /**
     * Constructor: create a new swap event.
     * @param swapFrom the index to swap from
     * @param swapTo the index to swap to
     */
    public SwapEvent(int swapFrom, int swapTo) {
        indices = new ArrayList<>();
        indices.add(swapFrom);
        indices.add(swapTo);
    }

    /**
     * apply: apply a swap event.
     * @param arr the array to apply the event to
     */
    public void apply(T[] arr) {
        int indexOne = indices.get(0);
        int indexTwo = indices.get(1);
        T temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }

    /**
     * getAffectedIndices: get the indices affected by this event.
     * @return a list of the indices affected by this event
     */
    public List<Integer> getAffectedIndices() {
        return indices;
    }

    /**
     * isEmphasized: check if this event is emphasized.
     * @return whether the event was emphasized or not
     */
    public boolean isEmphasized() {
        return true;
    }
}
