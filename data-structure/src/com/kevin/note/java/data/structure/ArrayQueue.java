package com.kevin.note.java.data.structure;

/**
 * 用数组实现的队列
 * @Author:Kevin
 * @Date:Created in 21:29 2021/3/1
 */
public class ArrayQueue {
    private String[] items;  //用于存储队列中的数据
    private int n = 0;

    //head表示队头，tail表示队尾
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item){
        if(tail == n){
            return false;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    public String dequeue(){
        if(head == tail){
            return null;
        }

        String item = items[head];
        head++;
        return item;
    }
}
