package com.onlineinteract.dsa_java_udemy.heaps;

import com.onlineinteract.utility.Print;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        MaxHeap myMaxHeap = new MaxHeap();
        myMaxHeap.insert(99);
        myMaxHeap.insert(72);
        myMaxHeap.insert(61);
        myMaxHeap.insert(58);
        System.out.println(myMaxHeap.getHeap());
        Print.printSeparator();

        myMaxHeap.insert(100);
        System.out.println(myMaxHeap.getHeap());
        Print.printSeparator();

        myMaxHeap.insert(75);
        System.out.println(myMaxHeap.getHeap());
        Print.printSeparator();

        // ----

        myMaxHeap = new MaxHeap();
        myMaxHeap.insert(95);
        myMaxHeap.insert(75);
        myMaxHeap.insert(80);
        myMaxHeap.insert(55);
        myMaxHeap.insert(60);
        myMaxHeap.insert(50);
        myMaxHeap.insert(65);
        System.out.println(myMaxHeap.getHeap());
        Print.printSeparator();

        myMaxHeap.remove();
        System.out.println(myMaxHeap.getHeap());
        Print.printSeparator();

        myMaxHeap.remove();
        System.out.println(myMaxHeap.getHeap());
        Print.printSeparator();

        MinHeap myMinHeap = new MinHeap();
        myMinHeap.insert(1);
        myMinHeap.insert(12);
        myMinHeap.insert(18);
        myMinHeap.insert(24);
        myMinHeap.insert(26);
        myMinHeap.insert(38);
        myMinHeap.insert(39);
        System.out.println(myMinHeap.getHeap());
        Print.printSeparator();

        myMinHeap.remove();
        System.out.println(myMinHeap.getHeap());
        Print.printSeparator();

        myMinHeap.insert(4);
        System.out.println(myMinHeap.getHeap());
        Print.printSeparator();

        // Test case 1
        int[] nums1 = {7, 10, 4, 3, 20, 15};
        int k1 = 3;
        System.out.println("Test case 1:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallestWithPriorityQueue(nums1, k1));
        System.out.println();

        // Test case 2
        int[] nums2 = {2, 1, 3, 5, 6, 4};
        int k2 = 2;
        System.out.println("Test case 2:");
        System.out.println("Expected output: 2");
        System.out.println("Actual output: " + findKthSmallestWithPriorityQueue(nums2, k2));
        System.out.println();

        // Test case 3
        int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
        int k3 = 5;
        System.out.println("Test case 3:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallestWithPriorityQueue(nums3, k3));
        System.out.println();

        Print.printSeparator();

        // Test case 1
        int[] nums4 = {3, 2, 1, 5, 6, 4};
        int k4 = 2;
        System.out.println("Test case 1:");
        System.out.println("Expected output: 5");
        System.out.println("Actual output: " + findKthLargest(nums4, k4));
        System.out.println();

        // Test case 2
        int[] nums5 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k5 = 4;
        System.out.println("Test case 2:");
        System.out.println("Expected output: 4");
        System.out.println("Actual output: " + findKthLargest(nums5, k5));
        System.out.println();

        Print.printSeparator();

        // Test case 1
        int[] nums6 = {1, 5, 2, 9, 3, 6, 8};
        System.out.println("Test case 1:");
        System.out.println("Input: [1, 5, 2, 9, 3, 6, 8]");
        System.out.println("Expected output: [1, 5, 5, 9, 9, 9, 9]");
        System.out.println("Actual output: " + streamMax(nums6));
        System.out.println();

        // Test case 2
        int[] nums7 = {10, 2, 5, 1, 0, 11, 6};
        System.out.println("Test case 2:");
        System.out.println("Input: [10, 2, 5, 1, 0, 11, 6]");
        System.out.println("Expected output: [10, 10, 10, 10, 10, 11, 11]");
        System.out.println("Actual output: " + streamMax(nums7));
        System.out.println();

        // Test case 3
        int[] nums8 = {3, 3, 3, 3, 3};
        System.out.println("Test case 3:");
        System.out.println("Input: [3, 3, 3, 3, 3]");
        System.out.println("Expected output: [3, 3, 3, 3, 3]");
        System.out.println("Actual output: " + streamMax(nums8));
        System.out.println();

        Print.printSeparator();
    }

    public static List<Integer> streamMax(int[] nums) {
        if (nums.length == 0) {
            new ArrayList<Integer>();
        }

        MaxHeap heap = new MaxHeap();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            // If heap is empty or num > root heap value (observe short circuit evaluation).
            if (heap.getHeap().isEmpty() || num > heap.getHeap().get(0)) {
                heap.insert(num);
            }

            list.add(heap.getHeap().get(0));
        }

        return list;
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        if (k > nums.length) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }

        return minHeap.remove();
    }

    public static int findKthSmallest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        if (k > nums.length) {
            return 0;
        }

        MaxHeap heap = new MaxHeap();

        for (int num : nums) {
            heap.insert(num);

            if (heap.getHeap().size() > k) {
                heap.remove();
            }
        }

        return heap.remove();
    }

    public static int findKthSmallestWithPriorityQueue(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        if (k > nums.length) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.add(num);

            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }

        return maxHeap.remove();
    }
}
