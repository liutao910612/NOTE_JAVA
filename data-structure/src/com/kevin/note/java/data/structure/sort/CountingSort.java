package com.kevin.note.java.data.structure.sort;

import java.util.Arrays;

/**
 * 计数排序示例
 * 适用场景：计数排序只适用于数据的范围不是很大的情况，如果数据范围k比要排序的数据n大很多，就不适合用计数排序了。
 *
 * @Author:Kevin
 * @Date:Created in 15:53 2021/3/13
 */
public class CountingSort {

    /**
     * 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数
     *
     * @param a
     * @param n
     */
    public static int[] sort(int[] a, int n) {
        if (n <= 1) {
            return a;
        }

        //查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        //申请一个计数数组c,下标大小[0,max]
        int[] c = new int[max + 1];
        for (int i = 0; i < max; ++i) {
            c[i] = 0;
        }

        //计算每个元素的个数，放入c中
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        //依次累加
        for (int i = 1; i < max; ++i) {
            c[i] = c[i - 1] + c[i];
        }

        //临时数组r，存储排序之后的结果
        int[] r = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 3, 10, 2, 5, 6, 9},11)));
    }
}
