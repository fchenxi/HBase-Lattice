package com.inadco.datastructs.utils;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * primitive heap utilities when {@link PriorityQueue} doesn't really work for
 * us
 * 
 * @author dmitriy
 * 
 */
public class HeapUtils {

    /**
     * rearrange array of values into a min-heap
     * 
     * @param <T>
     *            value type
     * @param values
     *            values ArrayList is really recommended for this.
     * @param comparator
     *            natural order value comparator
     */
    public static <T> void heapifyMin(List<T> values, Comparator<? super T> comparator) {

        int len = values.size();
        for (int start = (len >> 1) - 1; start >= 0; start--)
            siftDownMin(values, start, len, comparator);

    }

    /**
     * min heap sift down
     * 
     * @param <T>
     *            value type
     * @param heap
     *            values organized into a min-heap already
     * @param start
     *            value index to start sift down for
     * @param len
     *            maximum length to sift down to
     * @param comparator
     *            natural order value comparator
     */
    public static <T> void siftDownMin(List<T> heap, int start, int len, Comparator<? super T> comparator) {

        int child1;
        T startVal;
        for (child1 = (start << 1) | 1, startVal = heap.get(start); child1 < len; child1 = (start << 1) | 1) {

            T child1Val = heap.get(child1);
            int child2;
            if ((child2 = child1 + 1) < len) {
                T child2Val = heap.get(child2);

                if (comparator.compare(child2Val, child1Val) < 0) { // min-heap
                    child1 = child2;
                    child1Val = child2Val;
                }
            }
            if (comparator.compare(child1Val, startVal) < 0) { // min-heap
                heap.set(child1, startVal);
                heap.set(start, child1Val);
                start = child1;
            } else
                break;
        }
    }

}
