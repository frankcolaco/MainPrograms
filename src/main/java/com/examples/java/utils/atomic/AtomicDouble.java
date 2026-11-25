package com.examples.java.utils.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicDouble extends Number{


    private AtomicLong doubleRepresentation = new AtomicLong(0);

    public AtomicDouble(double initVal){
        doubleRepresentation.set(Double.doubleToLongBits(initVal));
    }

    @Override
    public int intValue() {
        return (int)doubleValue();
    }

    @Override
    public long longValue() {
        return (long)doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return Double.longBitsToDouble(doubleRepresentation.get());
    }

    public boolean compareAndSet(double expected, double newValue) {
        return doubleRepresentation.compareAndSet(Double.doubleToLongBits(expected), Double.doubleToLongBits(newValue));
    }

    public double getAndSet(double newValue) {
        return doubleRepresentation.getAndSet(Double.doubleToLongBits(newValue));
    }

    public double getAndAdd(double delta) {

        long currentVal;
        long newVal;
        do {
            currentVal = doubleRepresentation.get();
            newVal = Double.doubleToLongBits((Double.longBitsToDouble(currentVal) + delta));
        } while (!doubleRepresentation.compareAndSet(currentVal, newVal));

        // Note that when we are returning the value of the double, it is possible that
        // another thread updates the double value before the following line executes. The
        // method as a whole doesn't execute atomically.
        return Double.longBitsToDouble(doubleRepresentation.get());
    }
}
