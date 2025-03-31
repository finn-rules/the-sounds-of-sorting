package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> implements SortEvent<T> {
    private List<Integer> indices;

    public CompareEvent(int first, int second) {
        indices = new ArrayList<>();
        indices.add(first);
        indices.add(second);
    }

    /**
     * apply: apply a compare event.
     * @param arr the array to apply the event to
     */
    public void apply(T[] arr) { 
        arr[0] = arr[0];
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
        return false;
    }
}
