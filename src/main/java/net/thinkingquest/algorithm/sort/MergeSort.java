package net.thinkingquest.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] arr) {
        int length = arr.length;
        sort(arr, 0, length - 1);
    }

    private void sort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int midIndex = (startIndex + endIndex) / 2;
        sort(arr, startIndex, midIndex);
        sort(arr, midIndex + 1, endIndex);

        merge(arr, startIndex, midIndex, endIndex);
    }

    private void merge(int[] arr, int startIndex, int midIndex, int endIndex) {
        int[] tmp = new int[endIndex - startIndex + 1];
        int i = startIndex;
        int j = midIndex + 1;
        int tmpIndex = 0;

        while (i <= midIndex && j <= endIndex) {
            if (arr[i] <= arr[j]) {
                tmp[tmpIndex++] = arr[i++];
            } else {
                tmp[tmpIndex++] = arr[j++];
            }
        }

        while (i <= midIndex) {
            tmp[tmpIndex++] = arr[i++];
        }

        while (j <= endIndex) {
            tmp[tmpIndex++] = arr[j++];
        }

        int arrIndex = startIndex;
        for (int k = 0; k < tmp.length; k++) {
            arr[arrIndex++] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {15, 4, 18, 9, 8, 12, 5, 3, 19, 20, 21};
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println("Input: " + Arrays.toString(arr));

        new MergeSort().sort(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }

}
