package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    public static Integer[] makeBackwardsIntArray() {
        Integer[] backwards = new Integer[100];
        int i = 0;
        for(int j = 100; j > 0; j--) {
            backwards[i] = j;
            i++;
        }
        return backwards;
    }

    public static String[] makeStringArray() {
        return new String[] {
            "hello", "world", "", " ",
            "empty string", "colton", "finn",
            "owen", "saya", "1", "2", "3"
        };
    }
    
    public static Double[] makeDoubleArray() {
        return new Double[] {
            1.0, 3.934, 9.47, 0.01, 0.001, 100.01, 100.001,
            15.743
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    public void testSortBackwards(Consumer<Integer[]> func) {
        Integer[] arr = makeBackwardsIntArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    public void testSortStrings(Consumer<String[]> func) {
        String[] arr = makeStringArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    public void testSortDoubles(Consumer<Double[]> func) {
        Double[] arr = makeDoubleArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
    }

    @Test 
    public void backwardsBubbleSort() {
        testSortBackwards(Sorts::bubbleSort);
    }

    @Test 
    public void bubbleSortStrings() {
        testSortStrings(Sorts::bubbleSort); 
    }
    
    @Test 
    public void bubbleSortDoubles() {
        testSortDoubles(Sorts::bubbleSort); 
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
    }

    @Test 
    public void backwardsInsertionSort() {
        testSortBackwards(Sorts::insertionSort);
    }

    @Test 
    public void stringInsertionSorts() {
        testSortStrings(Sorts::insertionSort); 
    }
    
    @Test 
    public void doubleInsertionSorts() {
        testSortDoubles(Sorts::insertionSort); 
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
    }

    @Test 
    public void backwardsSelectionSort() {
        testSortBackwards(Sorts::selectionSort);
    }

    @Test 
    public void stringSelectionSort() {
        testSortStrings(Sorts::selectionSort); 
    }
    
    @Test 
    public void doubleSelectionSort() {
        testSortDoubles(Sorts::selectionSort); 
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
    }

    @Test
    public void testMergeSortBackwards() {
        testSortBackwards(Sorts::mergeSort);
    }

    @Test
    public void stringMergeSort() {
        testSortStrings(Sorts::mergeSort);
    }

    @Test
    public void doubleMergeSort() {
        testSortDoubles(Sorts::mergeSort);
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
    }

    @Test 
    public void backwardsQuickSort() {
        testSortBackwards(Sorts::quickSort);
    }

    @Test 
    public void stringQuickSort() {
        testSortStrings(Sorts::quickSort); 
    }
    
    @Test 
    public void doubleQuickSort() {
        testSortDoubles(Sorts::quickSort); 
    }


    @Test
    public void testCocktailShakerSort() {
        testSort(Sorts::cocktailShakerSort);
    }

    @Test
    public void testEventBubbleSort() {
        Integer[] arr1 = makeTestArray();
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        List<SortEvent<Integer>> list = Sorts.selectionSort(arr2);
        Sorts.eventSort(arr1, list);
        assertTrue(Arrays.equals(arr1, arr2));
    }
}