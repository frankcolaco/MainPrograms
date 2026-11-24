package com.examples.java.utils.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicByte {

    private AtomicInteger byteRepresentation;

    public AtomicByte(byte value) {
        this.byteRepresentation = new AtomicInteger(value);
    }

    /*
    thread safe method to shift the byte to the right by 1 bit.
    leftmost bit is replaced by 0;
     */
    public void shiftRight() {
        byte currentVal;

        do {
            currentVal = byteRepresentation.byteValue();
        } while (!byteRepresentation.compareAndSet(currentVal, currentVal >>> 1));
    }

    public void shiftLeft() {
        byte currentVal;
        do {
            currentVal = byteRepresentation.byteValue();
        } while (!byteRepresentation.compareAndSet(currentVal, currentVal << 1));
    }

    public void print(){
        byte currentVal = byteRepresentation.byteValue();
        byte mask = (byte) 0b10000000;

        StringBuilder sBuilder = new StringBuilder();

        for(int i=0;i<8;i++){
            sBuilder.append((currentVal & mask) == mask ? "1":"0");
            currentVal = (byte) (currentVal <<1);
        }

        System.out.println(sBuilder.toString());
    }
}
