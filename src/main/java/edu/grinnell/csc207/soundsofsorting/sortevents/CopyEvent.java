package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
    private List<Integer> indices;
    private T value;

    /**
     * Consruct a copy event.
     * @param indexGoal : the index to copy the value into
     * @param value : the value to copy there
     */
    public CopyEvent(int indexGoal, T value) {
        indices = new ArrayList<>();
        indices.add(indexGoal);
        this.value = value;
    }

    /**
     * apply: apply a copy event.
     * @param arr the array to apply the event to
     */
    public void apply(T[] arr) {
        arr[indices.get(0)] = value;
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
