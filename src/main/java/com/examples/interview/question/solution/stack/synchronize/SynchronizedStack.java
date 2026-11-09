package com.examples.interview.question.solution.stack.synchronize;

import com.examples.interview.question.solution.stack.StackNode;

public class SynchronizedStack<T> {

    StackNode<T> top;

    public synchronized void push(T item){
        if(top == null){
            top = new StackNode<>(item);
        }else{
            StackNode<T>oldHead = top;
            top = new StackNode<>(item);
            top.setNext(oldHead);
        }
    }

    public synchronized T pop(){
        if(top ==null)
            return null;

        StackNode<T> oldHead = top;
        top=top.getNext();
        return oldHead.getItem();
    }
}
