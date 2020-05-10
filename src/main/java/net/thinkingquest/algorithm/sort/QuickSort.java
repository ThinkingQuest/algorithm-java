package net.thinkingquest.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] arr) {
        int length = arr.length;
        sort(arr, 0, length - 1);
    }

    private void sort(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex];
        int sortedIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] < pivot) {
                int tmp = arr[sortedIndex];
                arr[sortedIndex] = arr[i];
                arr[i] = tmp;
                sortedIndex++;
            }
        }

        arr[endIndex] = arr[sortedIndex];
        arr[sortedIndex] = pivot;

        if (sortedIndex - 1 > startIndex) {
            sort(arr, startIndex, sortedIndex - 1);
        }

        if (sortedIndex < endIndex) {
            sort(arr, sortedIndex, endIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = {15, 4, 18, 9, 8, 12, 5, 3, 19, 20, 21};
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println("Input: " + Arrays.toString(arr));

        new QuickSort().sort(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}