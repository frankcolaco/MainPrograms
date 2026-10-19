package com.examples.interview.question.solution;

public class ProducerConsumerSemaphoreDemo {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueueWithSemaphore<Integer> queue = new BlockingQueueWithSemaphore<Integer>(5);

        Thread t1 = new Thread(()->{
            try{

                for(int i=0;i<20;i++){
                    queue.enqueue(i);
                    System.out.println("enqued:: "+i);
                }

            }catch(InterruptedException e){

            }
        });

        Thread t2 = new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 2 dequeued: " + queue.dequeue());
                }
            } catch (InterruptedException ie) {

            }
        });

        Thread t3 = new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 3 dequeued: " + queue.dequeue());
                }
            } catch (InterruptedException ie) {

            }
        });

        t1.start();
        Thread.sleep(4000);
        t2.start();
        t2.join();

        t3.start();
        t1.join();
        t3.join();


    }
}

class BlockingQueueWithSemaphore<T>{

    int capacity;
    int size=0;
    int head=0;
    int tail=0;

    T[] array;

    CountingSemaphore semLock = new CountingSemaphore(1,1);
    CountingSemaphore semProducer;
    CountingSemaphore semConsumer;

    @SuppressWarnings("unchecked")
    public BlockingQueueWithSemaphore(int capacity){
        array = (T[]) new Object[capacity];
        this.capacity=capacity;
        this.semProducer = new CountingSemaphore(capacity,capacity);
        this.semConsumer = new CountingSemaphore(capacity,0);
    }

    public T dequeue() throws InterruptedException{
        T item = null;
        semConsumer.acquire();
        semLock.acquire();

        if(head==capacity){
            head=0;
        }

        item = array[head];
        array[head]=null;
        head++;
        size--;

        semLock.release();
        semProducer.release();

        return item;
    }

    public void enqueue(T item) throws InterruptedException{

        semProducer.acquire();
        semLock.acquire();

        if(tail == capacity){
            tail=0;
        }

        array[tail]=item;
        size++;
        tail++;

        semLock.release();
        semConsumer.release();
    }

}
