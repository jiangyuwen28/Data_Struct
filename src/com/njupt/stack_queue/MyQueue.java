package com.njupt.stack_queue;

public interface MyQueue<T> {
    public abstract int size();
    public abstract void enQueue(T x);
    public abstract T deQueue();
}
