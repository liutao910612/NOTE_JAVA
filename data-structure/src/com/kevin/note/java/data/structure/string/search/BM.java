package com.kevin.note.java.data.structure.string.search;

/**
 * @Author:Kevin
 * @Date:Created in 13:45 2021/4/8
 */
public class BM {
    private static final int SIZE = 256;

    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE]; //记录模式串中每个字符最后出现的位置
        generateBC(b, m, bc);
        int i = 0; //i表示主串与模式串对齐的第一个字符串
        while (i < n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) {  //模式串从后往前匹配
                if (a[i + j] != b[j]) {  //坏字符对应模式串中的下标是j
                    break;
                }
            }

            if (j < 0) {
                return i; //匹配成功，返回主串与模式串第一个匹配的字符的位置
            }

            //这里等同于将模式串往后滑动j-bc[(int)a[i+j]]位
            i = i + (j - bc[(int) a[i + j]]);
        }
        return -1;
    }

    /**
     * 生成模式串散列表
     *
     * @param b  模式串
     * @param m  模式串的长度
     * @param bc 散列表
     */
    private void generateBC(char[] b, int m, int[] bc) {

        //初始化散列表
        for (int item : bc) {
            item = -1;
        }

        for (int i = 0; i < m; i++) {
            int ascii = (int) b[i];
            bc[ascii] = i;
        }
    }
}
