package com.examples;

import java.time.*;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VoidMain {

    public static void main(String[] args) throws InterruptedException {

        Main main = new Main();

        Thread t1 = new Thread(main::runWork);
        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(100);
                main.stop();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}