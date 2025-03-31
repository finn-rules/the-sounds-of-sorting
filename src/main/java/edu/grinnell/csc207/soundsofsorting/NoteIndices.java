package edu.grinnell.csc207.soundsofsorting;

import java.util.Collections;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    Integer[] indices;

    boolean[] highlight;

    /**
     * NoteIndices : constructor for a noteindices object.
     * 
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        indices = new Integer[n];
        highlight = new boolean[n];
    }

    /*
     * A Fisher-Yates shuffle, which shuffles the array randomly.
     * 
     * @param arr : an array of integers (indices) to be shuffled
     */
    public static void shuffle(Integer[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int randomIndex = (int) (Math.random() * arr.length);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }

    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size. The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * 
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        indices = new Integer[n];
        highlight = new boolean[n];
        for (int i = 0; i < n; i++) {
            this.indices[i] = i;
        }

        for (int i = 0; i < n; i++) {
            this.highlight[i] = false;
        }
        shuffle(this.indices);
    }

    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() {
        return indices;
    }

    /**
     * Highlights the given index of the note array
     * 
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        this.highlight[index] = true;
    }

    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        return this.highlight[index] == true ? true : false;
    }

    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        for (int i = 0; i < highlight.length; i++) {
            this.highlight[i] = false;
        }
    }
}
