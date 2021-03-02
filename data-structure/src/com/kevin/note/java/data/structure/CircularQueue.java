package com.kevin.note.java.data.structure;

/**
 * 循环队列
 *
 * @Author:Kevin
 * @Date:Created in 21:07 2021/3/2
 */
public class CircularQueue {
    private String[] items;  //用于存储队列中的数据
    private int n = 0;

    //head表示队头，tail表示队尾
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }

        String item = items[head];
        head = (head + 1) % n;
        return item;
    }
}
