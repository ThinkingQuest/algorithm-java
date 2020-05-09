package net.thinkingquest.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {15, 4, 18, 9, 8, 12, 5, 3, 19, 20, 21};
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println("Input: " + Arrays.toString(arr));

        new BubbleSort().sort(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    flag = false;
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
