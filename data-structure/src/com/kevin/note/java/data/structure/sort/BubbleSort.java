package com.kevin.note.java.data.structure.sort;

import java.util.Arrays;

/**
 * 冒泡排序示例
 * (1)冒泡排序是原地排序：只涉及相邻元素的数据交换，只需要常量级的临时空间，所以空间复杂度为O(1)，
 * 是原地排序。
 * (2)冒泡排序仅仅当两个元素大小不相等的情况下发生交换才会改变先后顺序，所以冒泡排序是稳定的排序算
 * 法。
 * (3)最好情况下，数据全是有序的，我们只需要进行一次冒泡排序，由于这一次需要进行n次比较，所以最好
 * 情况时间复杂度为O(n),而当要排序的数据刚好是倒序的时候，就需要进行n次冒泡排序，所以最坏情况时间
 * 复杂度为O(n^2),平均时间复杂度为O(n^2)
 * @Author:Kevin
 * @Date:Created in 20:53 2021/3/5
 */
public class BubbleSort {

    public static int[] sort(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return arrays;
        }
        int length = arrays.length;
        int temp;
        int exchangeTime = 0;
        for (int i = length; i > -1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (arrays[j + 1] < arrays[j]) {
                    temp = arrays[j + 1];
                    arrays[j + 1] = arrays[j];
                    arrays[j] = temp;
                    exchangeTime++;
                }
            }
            if (exchangeTime == 0) {
                break;
            }
        }
        return arrays;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 3, 10, 2, 5, 6, 9})));
    }
}
