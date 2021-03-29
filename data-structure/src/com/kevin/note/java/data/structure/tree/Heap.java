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

    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        int temp;
        while (k > 1) {
            temp = a[1];
            a[1] = a[k];
            a[k] = temp;
            --k;
            heapify(a,k,1);
        }
    }

    private void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    /**
     * 自上往下堆化
     *
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {
        int temp;
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }

            if (i * 2 + 1 <= n && a[i] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }

            if (maxPos == i) {
                break;
            }

            temp = a[i];
            a[i] = a[maxPos];
            a[maxPos] = temp;
        }
    }
}
