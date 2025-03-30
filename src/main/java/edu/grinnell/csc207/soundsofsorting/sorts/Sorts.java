package edu.grinnell.csc207.soundsofsorting.sorts;

import java.util.ArrayList;
import java.util.List;

import edu.grinnell.csc207.soundsofsorting.sortevents.CompareEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.SwapEvent;

/**
 * A collection of sorting algorithms.
 */
public class Sorts {
    /**
     * Swaps indices <code>i</code> and <code>j</code> of array <code>arr</code>.
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to swap
     * @param i   the first index to swap
     * @param j   the second index to swap
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Sorts the array according to the bubble sort algorithm:
     * 
     * <pre>
     * [ unprocessed | i largest elements in order ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> bubbleSort(T[] arr) {
        List<SortEvent<Integer>> events = new ArrayList<>();
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = arr.length - 1; j > 0; j--) {
                events.add(new CompareEvent<>(j - 1, j));
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    events.add(new SwapEvent<>(j - 1, j));
                    swap(arr, j - 1, j);
                }
            }
        }
        return events;
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * 
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> selectionSort(T[] arr) {
        List<SortEvent<Integer>> events = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            T min = arr[i];
            int index = i;
            for (int j = i; j < arr.length; j++) {
                events.add(new CompareEvent<>(j, index));
                if (min.compareTo(arr[j]) > 0) {
                    min = arr[j];
                    index = j;
                }
            }
            events.add(new SwapEvent<>(i, index));
            swap(arr, i, index);
        }
        return events;
    }

    /**
     * Sorts the array according to the insertion sort algorithm:
     * 
     * <pre>
     * [ i elements in order | unprocessed ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> insertionSort(T[] arr) {
        List<SortEvent<Integer>> events = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                events.add(new CompareEvent<>(i, j));
                events.add(new SwapEvent<>(j, j - 1));
                swap(arr, j, j - 1);
                j--;
            }
        }
        return events;
    }

    /**
     * Sorts the array according to the merge sort algorithm.
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> mergeSort(T[] arr) {
        List<SortEvent<Integer>> events = new ArrayList<>();
        mergeSortH(arr, arr.length, 0, events);
        return events;
    }

    private static <T extends Comparable<? super T>> void mergeSortH(T[] arr, int hi, int lo, List<SortEvent<Integer>> events) {
        int mid = lo + (hi - lo) / 2;
        if(lo < mid) {
            mergeSortH(arr, mid, lo, events);
        }
        if(hi > mid + 1) {
            mergeSortH(arr, hi, mid, events);
        }
        merge(arr, mid, lo, hi, mid, events);
        }
        /**
         * A helper function to actually merge the broken down arrays.
         * @param <T>
         * @param arr: The array to be sorted
         * @param firstHi: the right side of the first half of the array
         * @param firstLo: the left side of the first half of the array
         * @param secondHi: the right side of the second half of the array
         * @param secondLo: the left side of the first half of the array
         */
        public static <T extends Comparable<? super T>> void merge(T[] arr, int firstHi, int firstLo, int secondHi, int secondLo, List<SortEvent<Integer>> events) {
            for(int i = firstLo; i < secondHi; i++) {
                for(int j = i + 1; j < secondHi; j++) {
                    events.add(new CompareEvent<>(i, j));
                    if(arr[i].compareTo(arr[j]) > 0) {
                        events.add(new SwapEvent<>(i, j));
                        swap(arr, i, j);
                        
                    }
                }
            }
        }
    /**
     * Sorts the array according to the quick sort algorithm.
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> quickSort(T[] arr) {
        List<SortEvent<Integer>> events = new ArrayList<>();
        quickSortH(arr, 0, arr.length - 1, events);
        return events;
    }

    private static <T extends Comparable<? super T>> void quickSortH(T[] arr, int lo, int hi,  List<SortEvent<Integer>> events) {
        if (lo < hi && lo >= 0 && hi >= 0) {
            events.add(new CompareEvent<>(lo, hi));
            int referencePoint = splitValue(arr, lo, hi, events);
            quickSortH(arr, lo, referencePoint, events);
            quickSortH(arr, referencePoint + 1, hi, events);
        }
    }

    private static <T extends Comparable<? super T>> int splitValue(T[] arr, int lo, int hi, List<SortEvent<Integer>> events) {
        T midValue = arr[lo];
        int i = lo - 1;
        int j = hi + 1;

        while (true) {
            do {
                events.add(new CompareEvent<>(i, hi));
                i++;
            } while (arr[i].compareTo(midValue) < 0 && i <= hi);

            do {
                events.add(new CompareEvent<>(j, lo));
                j--;
            } while (arr[j].compareTo(midValue) > 0 && j >= lo);

            if (i >= j) {
                return j;
            }
            events.add(new SwapEvent<>(i, j));
            swap(arr, i, j);
        }
    }

    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> cocktailShakerSort(T[] arr) {
        List<SortEvent<Integer>> events = new ArrayList<>();
        boolean swapped = true;
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (swapped) {
            swapped = false;
            for (int i = startIndex; i < endIndex; i++) {
                events.add(new CompareEvent<>(i, endIndex));
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swapped = true;
                    events.add(new SwapEvent<>(i, i + 1));
                    swap(arr, i, i + 1);
                }
            }
            if (!swapped) {
                break;
            }

        swapped = false;
        endIndex--;

        for (int j = endIndex; j > startIndex; j--) {
            events.add(new CompareEvent<>(j, endIndex));
            if (arr[j].compareTo(arr[j - 1]) < 0) {
                events.add(new SwapEvent<>(j, j - 1));
                swap(arr, j, j - 1);
                swapped = true;
            }
        }
        startIndex++;
    }
        return events;
    }

public static <T> void eventSort(T[] arr, List<SortEvent<T>> events) {
    for (SortEvent<T> event : events) {
        event.apply(arr);
    }
}
}