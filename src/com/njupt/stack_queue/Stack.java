package com.njupt.stack_queue;

import com.njupt.liner_table.HeaderList;

public class Stack<T> implements MyStack<T>{
    private HeaderList<T> list;

    public Stack() {
        this.list = new HeaderList<T>();
    }

    @Override
    public void push(T x) {
        this.list.insertHeader(x);
    }

    @Override
    public T pop() {
        if(this.list.isEmpty()){
            System.out.println("栈空");
            return null;
        }
        return this.list.deleteByIndex(1);
    }

    @Override
    public T top() {
        if(this.list.isEmpty()){
            return null;
        }
        return this.list.getFirst().getNext().getData();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public int size() {
        return this.list.listSize();
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(15);
        System.out.println(stack.size());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.size());
    }
}
