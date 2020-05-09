package net.thinkingquest.algorithm.sort;

import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int num = arr[j];
            for (; j > 0; j--) {
                if (num < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = num;
        }
    }

    public static void main(String[] args) {
        int[] arr = {15, 4, 18, 9, 8, 12, 5, 3, 19, 20, 21};
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println("Input: " + Arrays.toString(arr));

        new InsertionSort().sort(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}
