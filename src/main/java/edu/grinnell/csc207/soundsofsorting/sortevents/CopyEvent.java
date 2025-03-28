package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
    private List<Integer> indices;
    private T value;

    public CopyEvent(int indexGoal, T value) {
        indices = new ArrayList<>();
        indices.add(indexGoal);
        this.value = value;
    }

    public void apply(T[] arr) {
        arr[indices.get(0)] = value;
    }

    public List<Integer> getAffectedIndices() {
        return indices;
    }

    public boolean isEmphasized() {
        return true;
    }
}
