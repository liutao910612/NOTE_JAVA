package com.kevin.note.java.data.structure.sort;

import java.util.Arrays;

/**
 * 快速排序示例
 * 快速排序是一种原地不稳定的排序算法
 * 快速排序的时间复杂度T(n)在大部分情况下为O(nlogn)，只有在极端情况下才会退化为O(n^2)。
 *
 * @Author:Kevin
 * @Date:Created in 20:28 2021/3/12
 */
public class QuickSort {

    public static int[] sort(int[] array) {

        recusion(array,0,array.length-1);
        return array;
    }

    public static void recusion(int[] array,int start,int end) {
        if (start > end) {
            return ;
        }

        //获取分区点，将小于分区点和大于分区点的数据分成两个数组
        int pivot = array[end];
        int i = start;
        int temp;
        for (int j = i; j < end; j++) {
            if (array[j] <= pivot) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i = i + 1;
            }
        }
        System.out.println(i);
        temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        recusion(array, start, i-1);
        recusion(array, i+1, end);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 3, 2, 5,4,6,12,44,22,33})));
    }
}
