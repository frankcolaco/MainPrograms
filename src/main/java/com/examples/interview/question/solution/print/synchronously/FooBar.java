package com.examples.interview.question.solution.print.synchronously;

public class FooBar {

    private int flag = 0;
    private int n;

    public FooBar(int n) {
        this.n = n;

    }

    public void printFoo() {

        for (int i = 1; i <= n; i++) {
            synchronized (this) {
                while(flag ==1){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("Foo");
                flag=1;
                notifyAll();

            }
        }

    }

    public void printBar() {

        for(int i=1;i<=n;i++){
            synchronized (this){
                while(flag==0){
                    try {
                        wait();
                    } catch (InterruptedException e) {

                    }
                }
                System.out.println("Bar");
                flag=0;
                notifyAll();
            }
        }
    }
}
