package net.thinkingquest.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序只能适用于特定场景： 要排序的n个数据，所处范围并不大。
 * 例如：1-10分的评分。  0-900分的高考总分，等场景。
 */
public class CountingSort {

    /**
     * 假设要排序的值在1-9之间
     * @param arr
     */
    public void sort(int[] arr) {
        int[] countArr = new int[10];

        for (int i : arr) {
            countArr[i] = countArr[i] + 1;
        }

        // 此时， countArr 数组中每个元素的值，代表的是下标数字在待排序数组中出现的次数。
        // 例如，假设  countArr[5] = 4, 代表5这个值在待排序数组中出现过4次。
        System.out.println(Arrays.toString(countArr));

        for (int i = 1; i < countArr.length; i++) {
            countArr[i] = countArr[i] + countArr[i - 1];
        }

        // 此时， countArr 数组中每个元素的值，代表的是小于等于下标数字的值在待排序数组中出现的次数。
        // 例如，假设 countArr[5] = 10，代表小于等于5的值，在待排序数组中有10个。
        System.out.println(Arrays.toString(countArr));

        int[] tmp = new int[arr.length];
        for (int num : arr) {
            int count = countArr[num];
            countArr[num] = count - 1;
            tmp[count - 1] = num;
        }

        // 由于count排序不是原地排序。方法要求原地排序，所以赋值回去。
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 2, 6, 7, 4, 5, 1, 8, 9, 1, 5, 7, 5, 4};
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println("Input: " + Arrays.toString(arr));

        new CountingSort().sort(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}
