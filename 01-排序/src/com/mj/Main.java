package com.mj;

import com.mj.tools.Integers;
import com.mj.tools.Times;

public class Main {
    public static void main(String[] args) {
        Integer[] array1 = Integers.tailAscOrder(1, 10000, 2000);
        Integer[] array2 = Integers.copy(array1);
        Integer[] array3 = Integers.copy(array1);

        Times.test("冒泡排序", () -> {
            bubbleSort1(array1);
        });

        Times.test("冒泡排序2", () -> {
            bubbleSort2(array2);
        });

        Times.test("冒泡排序3", () -> {
            bubbleSort3(array3);
        });

    }

    static void bubbleSort1(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                }
            }
        }
    }

    static void bubbleSort2(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    static void bubbleSort3(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            // sortedIndex的初始值在数组完全有序的时候有用
            int sortedIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }
}
