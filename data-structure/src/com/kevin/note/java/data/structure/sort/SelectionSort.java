package com.kevin.note.java.data.structure.sort;

import java.util.Arrays;

/**
 * 选择排序示例
 * 选择排序和插入排序的区别：选择排序是找到插入点后，将待插入的元素和插入点的元素交换。插入排序是找到
 * 插入点后，将插入点及其后面的元素进行后移。
 * (1)选择排序是原地排序：从下面的代码可以看出，选择排序的空间复杂度为O(1)。
 * (2)选择排序的最好情况时间复杂度为O(n^2),最好情况时间复杂度为O(n^2)。
 * (3)选择排序不是稳定排序算法。
 *
 * @Author:Kevin
 * @Date:Created in 21:01 2021/3/8
 */
public class SelectionSort {
    public static int[] sort(int[] arrays) {

        if (arrays == null || arrays.length == 0) {
            return null;
        }

        //假设当前第一个数最小，所以从第二个数开始进行选择排序
        int length = arrays.length;
        int min;
        int minIndex ;
        int temp ;
        for (int i = 0; i < length; i++) {
            min = arrays[i];
            minIndex = i;
            for (int j = i+1 ; j < length; j++) {
                if (arrays[j] < min) {
                    min = arrays[j];
                    minIndex = j;
                }
            }

            temp = arrays[i];
            arrays[i] = min;
            arrays[minIndex] = temp;
        }
        return arrays;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 3, 10, 2, 5, 6, 9})));
    }
}
