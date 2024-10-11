package com.onlineinteract.dsa_java_udemy.arrays;

import com.onlineinteract.utility.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Print.printSeparator();

        int[] myIntArray = new int[]{4, 2, 6, 5, 1, 3};
        bubbleSort(myIntArray);
        System.out.println(Arrays.toString(myIntArray));
        Print.printSeparator();

        myIntArray = new int[]{4, 2, 6, 5, 1, 3};
        selectionSort(myIntArray);
        System.out.println(Arrays.toString(myIntArray));
        Print.printSeparator();

        myIntArray = new int[]{4, 2, 6, 5, 1, 3};
        insertionSort(myIntArray);
        System.out.println(Arrays.toString(myIntArray));
        Print.printSeparator();

        int[] result = merge(new int[]{1, 3, 7, 8}, new int[]{2, 4, 5, 6});
        System.out.println(Arrays.toString(result));
        Print.printSeparator();

        result = mergeSort(new int[]{3, 1, 4, 2});
        System.out.println(Arrays.toString(result));
        Print.printSeparator();

        myIntArray = new int[]{4, 6, 1, 7, 3, 2, 5};
        int returnedIndex = pivot(myIntArray, 0, myIntArray.length - 1);
        System.out.println("Returned index: " + returnedIndex);
        System.out.println(Arrays.toString(myIntArray));
        Print.printSeparator();

        myIntArray = new int[]{4, 6, 1, 7, 3, 2, 5};
        quickSort(myIntArray, 0, myIntArray.length - 1);
        System.out.println(Arrays.toString(myIntArray));
        Print.printSeparator();

        myIntArray = new int[]{3, 2, 2, 3};
        int length = removeElement(myIntArray, 3);
        System.out.println("New length is: " + length);
        System.out.println(Arrays.toString(myIntArray));
        Print.printSeparator();
    }

    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                int tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int valueToInsert = array[i];
            int j = i - 1;
            while (j > -1 && valueToInsert < array[j]) {
                array[j + 1] = array[j];
                array[j] = valueToInsert;
                j--;
            }
        }
    }

    public static int[] mergeSort(int[] array) {
        /**
         * Base Case
         */
        if (array.length == 1) {
            return array;
        }

        int midIndex = array.length / 2;

        /**
         * Recursive Cases
         */
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        /**
         * Return
         */
        return merge(left, right);
    }

    public static int[] merge(int[] array1, int[] array2) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[array1.length + array2.length];

        while (true) {
            if (i < array1.length && j < array2.length) {
                if (array1[i] < array2[j]) {
                    result[k] = array1[i];
                    i++;
                } else {
                    result[k] = array2[j];
                    j++;
                }
                k++;
                continue;
            }

            if (i < array1.length) {
                result[k] = array1[i];
                i++;
                k++;
                continue;
            }

            if (j < array2.length) {
                result[k] = array2[j];
                j++;
                k++;
                continue;
            }

            break;
        }

        return result;
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }

    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }

        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                list.add(nums[i]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return list.size();
    }
}
