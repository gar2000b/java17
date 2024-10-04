package com.onlineinteract.dsa_java_udemy.arrays;

import com.onlineinteract.utility.Print;

import java.util.Arrays;

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
            int tmp = array[i];
            int j = i - 1;
            while (j > -1 && tmp < array[j]) {
                array[j + 1] = array[j];
                array[j] = tmp;
                j--;
            }
        }
    }
}
