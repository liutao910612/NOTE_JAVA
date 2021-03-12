package com.kevin.note.java.data.structure.sort;

import java.util.Arrays;

/**
 * 归并排序示例
 * 归并排序采用的是分治的思想。
 * (1)归并排序是稳定排序算法：归并排序是否为稳定排序算法主要取决于merge()函数，我们这里使用了一个临时数组来保存排序数据，
 * 所以这里的排序是稳定排序。
 * (2)时间复杂度为O(nlogn)。归并排序的时间复杂度与要排序的数据的有序度无关，所以归并排序的最好情况，最坏情况和平均时间复
 * 杂度均为O(nlogn)。是一种比较稳定的排序算法。
 * (3)尽管每次进行合并操作都会申请临时的额外空间，但是合并完成之后，内存空间就会释放掉。在任意时刻，CPU 只会有一个函数在执
 * 行，也就只会有一个临时的内存空间在使用。临时内存空间最大也不会超过 n 个数据的大小，所以空间复杂度是 O(n)。
 *
 *
 * @Author:Kevin
 * @Date:Created in 20:16 2021/3/10
 */
public class MergeSort {
    public static int[] sort(int[] arrays) {
        int length = arrays.length;
        return mergeSort(arrays, 0, length - 1);
    }

    //递归调用函数
    private static int[] mergeSort(int[] arrays, int p, int r) {

        //递归终止条件
        if (p >= r) {
            return arrays;
        }

        //取p到r之间的中间位置q
        int q = (p + r) / 2;
        if(r == 1){
            q = 1;
        }

        int[] arrayFirst = Arrays.copyOfRange(arrays, p, q);
        int[] arraySecond = Arrays.copyOfRange(arrays, q, r+1);
        //分治递归
        mergeSort(arrayFirst, 0, arrayFirst.length -1);
        mergeSort(arraySecond, 0, arraySecond.length -1);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        return merge(arrays, arrayFirst, arraySecond);
    }

    private static int[] merge(int[] arrays, int[] arrayFirst, int[] arraySecond) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] tmp = new int[arrays.length];
        while (i <= arrayFirst.length - 1 && j <= arraySecond.length - 1) {
            if (arrayFirst[i] < arraySecond[j]) {
                tmp[k++] = arrayFirst[i];
                i++;
            } else {
                tmp[k++] = arraySecond[j];
                j++;
            }
        }

        //判断哪个子数组中有剩余的数据
        int start;
        int end;
        if (j <= arraySecond.length - 1) {
            start = j;
            end = arraySecond.length - 1;
            //将剩余的数据拷贝到临时数组tmp
            while (start <= end) {
                tmp[k++] = arraySecond[start++];
            }
        } else {
            start = i;
            end = arrayFirst.length - 1;
            //将剩余的数据拷贝到临时数组tmp
            while (start <= end) {
                tmp[k++] = arrayFirst[start++];
            }
        }

        arrays = tmp;
        return arrays;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 3, 10, 2, 5, 6, 9})));
    }
}
