package com.examples.interview.question.solution.molecule;

public class MoleculeDemo {

    public static void main(String[] args) {

        H2OMachine h2OMachine = new H2OMachine();

        H2OMachineThread t1 = new H2OMachineThread(h2OMachine,"H");
        H2OMachineThread t2 = new H2OMachineThread(h2OMachine,"O");
        H2OMachineThread t3 = new H2OMachineThread(h2OMachine,"H");
        H2OMachineThread t4 = new H2OMachineThread(h2OMachine,"O");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
