package com.examples.interview.question.solution.stack;

public class StackNode<T> {

    private T item;
    private StackNode<T> next;

    public StackNode(T item){
        this.item=item;
    }

    public StackNode<T> getNext(){
        return next;
    }

    public void setNext(StackNode stackNode){
        this.next=stackNode;
    }

    public T getItem(){
        return this.item;
    }


}
