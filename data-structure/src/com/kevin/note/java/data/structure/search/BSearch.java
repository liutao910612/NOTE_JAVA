package com.kevin.note.java.data.structure.search;

/**
 * 二分查找示例
 *
 * @Author:Kevin
 * @Date:Created in 10:44 2021/3/14
 */
public class BSearch {

    /**
     * 这里查找的范围为有序且不存在重复元素的数组，并且是升序排列
     *
     * @param a     需要查找的数据所在数组
     * @param n     数组大小
     * @param value 需要查找的数据
     * @return
     */
    public static int simpleSearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 采用递归实现二分查找
     *
     * @param a
     * @param low
     * @param high
     * @param value
     * @return
     */
    public static int simpleSearchInternally(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1); // 这里是为了防止加法操作的内存溢出和使用移位操作来代替除法
        if (a[mid] == value) {
            return mid;
        }

        if (a[mid] > value) {
            return simpleSearchInternally(a, mid + 1, high, value);
        } else {
            return simpleSearchInternally(a, mid - 1, high, value);
        }
    }

    /**
     * 查找有序数组中，第一个等于给定值的元素的位置（注意这里的处理方法和查找最后一个等于给定值的元素位置一样）
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int searchFirst(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > value) {
                low = mid + 1;
            } else if (a[mid] < value) {
                high = mid - 1;
            } else {

                /**
                 * 如果mid为0，则肯定是第一个。如果mid-1位置上已经部位value了，则亦肯定是第一个。
                 */
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int searchFirstGe(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value <= a[mid]) {
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
            {
                low = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 22, 33, 55, 56, 78};
        int n = a.length;
        System.out.println(simpleSearch(a, n, 7));
        System.out.println(simpleSearchInternally(a, 0, n - 1, 7));
    }
}
