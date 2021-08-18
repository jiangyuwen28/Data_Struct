package com.njupt.stack_queue;

/**
 * 定义栈的接口
 */
public interface MyStack<T> {
    public void push(T x);
    public T pop();
    public T top();
    public boolean isEmpty();
    public int size();


}
