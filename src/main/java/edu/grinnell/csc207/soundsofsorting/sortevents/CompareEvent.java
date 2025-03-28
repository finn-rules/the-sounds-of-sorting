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

    public void apply(T[] arr) { 
        arr[0] = arr[0];
    }

    public List<Integer> getAffectedIndices() {
        return indices;
    }

    public boolean isEmphasized() {
        return false;
    }
}
