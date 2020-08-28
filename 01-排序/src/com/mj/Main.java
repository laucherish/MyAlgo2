package com.mj;

import com.mj.sort.*;
import com.mj.tools.Asserts;
import com.mj.tools.Integers;
import com.mj.tools.Times;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Integer[] array1 = Integers.tailAscOrder(1, 10000, 2000);
//        Integer[] array2 = Integers.copy(array1);
//        Integer[] array3 = Integers.copy(array1);
//
//        Times.test("冒泡排序", () -> {
//            bubbleSort1(array1);
//        });
//
//        Times.test("冒泡排序2", () -> {
//            bubbleSort2(array2);
//        });
//
//        Times.test("冒泡排序3", () -> {
//            bubbleSort3(array3);
//        });

        Integer[] array = Integers.random(10000, 1, 20000);
//        Integer[] array2 = Integers.copy(array1);
//        Integer[] array3 = Integers.copy(array1);

//        Times.test("HeapSort",()->{
//            new HeapSort().sort(array1);
//        });
//        Times.test("SelectionSort",()->{
//            new SelectionSort().sort(array2);
//        });
//        Times.test("BubbleSort3",()->{
//            new BubbleSort3().sort(array3);
//        });

        testSort(array,
               new BubbleSort1(),
               new BubbleSort2(),
               new HeapSort(),
               new SelectionSort(),
               new BubbleSort3()
        );
    }

    static void testSort(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }

        Arrays.sort(sorts);

        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }

    static void selectionSort(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (array[maxIndex] <= array[begin]) {
                    maxIndex = begin;
                }
            }
            int tmp = array[maxIndex];
            array[maxIndex] = array[end];
            array[end] = tmp;
        }
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
