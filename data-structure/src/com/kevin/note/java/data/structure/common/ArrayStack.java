package com.kevin.note.java.data.structure.common;

/**
 * 使用数组来实现栈
 *
 * @Author:Kevin
 * @Date:Created in 20:34 2021/3/1
 */
public class ArrayStack {
    private String[] items;  //存储栈的数据
    private int count;  //栈中元素的个数
    private int n;  //栈的大小

    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    public boolean push(String item) {

        //栈空间已满
        if (count == n) {
            return false;
        }

        items[count] = item;
        count++;
        return true;
    }

    public String pop() {

        //栈中没有任何元素
        if (count == 0) {
            return null;
        }

        String tmp = items[count - 1];
        count--;
        return tmp;
    }
}
