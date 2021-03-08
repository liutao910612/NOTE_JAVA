package com.kevin.note.java.data.structure.sort;

import java.util.Arrays;

/**
 * 插入排序示例
 * (1)插入排序是原地排序：从下面的代码我们可以看出，插入排序并不需要额外的存储空间，所以空间复杂度为O(1)。
 * (2)插入排序是稳定排序算法：对于相同的值，我们可以将后出现的元素插入到先出现的元素的后面，一以此来保证排
 * 序的稳定性。
 *（3）在最好情况下，如果数组是有序的，这个时候我们从尾到头查找插入位置，只需要比较一次就能插入数据，所以这
 * 个时候的时间复杂度为O(n),但是如果数组是倒序的呢？很明显这个时候的时间复杂度为O(n^2)。平均时间复杂度为
 * O(n^2)(注意：数组插入元素的时间复杂度为O(n))。
 *
 * @Author:Kevin
 * @Date:Created in 20:32 2021/3/8
 */
public class InsertionSort {

    public static int[] sort(int[] arrays) {

        if (arrays == null || arrays.length == 0) {
            return null;
        }

        //假设当前第一个数最小，所以从第二个数开始进行插入排序
        int length = arrays.length;
        for (int i = 1; i < length; i++) {
            int value = arrays[i];
            int j = i - 1;
            for (; j < i; j--) {
                if (value < arrays[j]) {
                    arrays[j + 1] = arrays[j];
                } else {
                    break;
                }
            }
            arrays[j + 1] = value;//插入数据
        }
        return arrays;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 3, 10, 2, 5, 6, 9})));
    }
}
