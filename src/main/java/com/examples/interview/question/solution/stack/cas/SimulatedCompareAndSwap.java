package com.examples.interview.question.solution.stack.cas;

public class SimulatedCompareAndSwap<T> {

    private T value;

    public SimulatedCompareAndSwap(T initValue){
        this.value= initValue;
    }

    synchronized T getValue(){
        return value;
    }

    private synchronized T compareAndSwap(T expectedValue,T newValue){
        if(value==null){
            if(expectedValue == null){
                value=newValue;
            }
            return null;
        }

        if(value.equals(expectedValue)){
            value=newValue;
            return expectedValue;
        }
        return value;
    }

    /*
    this method uses compareAndSwap() to indicate if the CAS instruction completed successfully or not.
     */
    public synchronized boolean compareAndSet(T expectedValue,T newValue){
        T returnValue = compareAndSwap(expectedValue,newValue);

        if(returnValue ==null && expectedValue==null) return true;
        else if (returnValue==null && expectedValue !=null) return false;
        else{
         return returnValue.equals(expectedValue);
        }
    }
}
