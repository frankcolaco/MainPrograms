package com.examples.interview.question.solution;

public class BusyWaitSolUsingLockDemo {

    public static void main(String[] args) {

    }
}

class BlockingQueueWithMutex<T> {

    T[] array;
    Object lock = new Object();
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;


    @SuppressWarnings("unchecked")
    public BlockingQueueWithMutex(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void enqueue(T item) throws InterruptedException {

           //lock.lock();
            while (size == capacity) {
             //   lock.unlock();
            //    lock.lock();
            }
            if (tail == capacity) {
                tail = 0;
            }
            array[tail] = item;
            size++;
            tail++;
          //  lock.unlock();
    }

    public T dequeue() throws InterruptedException {
        T item = null;
        //lock.lock();
            while (size == 0) {
           //     lock.unlock();
           //     lock.lock();
            }
            if (head == capacity) {
                head = 0;
            }
            item = array[head];
            array[head] = null;
            head++;
            size--;

         //   lock.unlock();
        return item;
    }
}
