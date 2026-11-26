package com.examples.java.utils.atomic;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;

public class LongAccumAddOpDemo {

    public static void main(String[] args) {

        LongBinaryOperator longBinaryOperator = new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                System.out.println(left + " "+ right);
                return left+right;
            }
        };

        LongAccumulator longAccumulator = new LongAccumulator(longBinaryOperator,0);

        for(int i=0;i<10;i++){
            longAccumulator.accumulate(1);
        }

        System.out.println("Final value= "+longAccumulator.get());
    }
}
