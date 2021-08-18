package com.njupt.stack_queue;

import com.njupt.liner_table.HeaderList;

public class Queue<T> implements MyQueue<T>{
    private HeaderList<T> list;

    Queue(){
        this.list = new HeaderList<T>();
    }

    @Override
    public int size() {
        return this.list.listSize();
    }

    @Override
    public void enQueue(T x) {
        this.list.insertTail(x);
    }

    @Override
    public T deQueue() {
        if(this.list.isEmpty()){
            System.out.println("队列空");
            return null;
        }
        return this.list.deleteByIndex(1);
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new Queue<>();
        System.out.println("队列初始化长度：" + queue.size());
        queue.enQueue(10);
        queue.enQueue(12);
        System.out.println("队列现在的长度："  + queue.size());
        Integer i = queue.deQueue();
        System.out.println(i);
        System.out.println("出队后的长度为：" + queue.size());
    }
}
