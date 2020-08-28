package com.mj.sort;

public class BubbleSort3<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            // sortedIndex的初始值在数组完全有序的时候有用
            int sortedIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }
}
