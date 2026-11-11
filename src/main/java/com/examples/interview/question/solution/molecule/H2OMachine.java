package com.examples.interview.question.solution.molecule;

import java.util.Arrays;
import java.util.Collections;

public class H2OMachine {

    private Object sync;
    private String[] molecule;
    private int count;

    public H2OMachine() {
        this.molecule = new String[3];
        this.count = 0;
        this.sync = new Object();
    }

    public void hydrogenAtom() throws InterruptedException {

        synchronized (sync) {
            while (Collections.frequency(Arrays.asList(molecule), "H") == 2) {
                wait();
            }
            molecule[count] = "H";
            count++;

            if (count == 3) {
                for (String element : molecule) {
                    System.out.println(element);
                }
                Arrays.fill(molecule, null);
                count = 0;
            }
            sync.notifyAll();
        }

    }

    public void oxygenAtom() throws InterruptedException {

        synchronized (sync) {
            while (Collections.frequency(Arrays.asList(molecule), "O") == 1) {
                wait();
            }
            molecule[count] = "O";
            count++;

            if (count == 3) {
                for (String element : molecule) {
                    System.out.println(element);
                }
                Arrays.fill(molecule, null);
                count = 0;
            }
            sync.notifyAll();
        }
    }
}
