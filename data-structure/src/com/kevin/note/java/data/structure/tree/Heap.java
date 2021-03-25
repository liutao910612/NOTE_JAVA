package com.kevin.note.java.data.structure.tree;

/**
 * 由于堆是一个完全二叉树，所以我们用数组来存储堆的数据，能够达到最高的效率
 *
 * @Author:Kevin
 * @Date:Created in 21:43 2021/3/25
 */
public class Heap {
    private int[] a; //数组，从下标1开始存储数据
    private int n;//堆中可以存储的最大数据个数
    private int count; //堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count == n) {  //堆满了
            return;
        }

        count++;
        a[count] = data;
        int i = count;
        int temp;
        while (i / 2 > 0 && a[i / 2] < a[i]) {  //自下往上堆化
            temp = a[i / 2];
            a[i / 2] = a[i];
            a[i] = temp;
            i = i / 2;
        }
    }

    public void removeMax() {
        if (count == 0) {  //堆中没有元素
            return;
        }

        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    private void heapify(int[] a, int count, int i) {
    }
}
