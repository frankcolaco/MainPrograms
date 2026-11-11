package com.examples.interview.question.solution.molecule;

public class H2OMachineThread extends Thread {

    private H2OMachine h2OMachine;
    private String atom;

    public H2OMachineThread(H2OMachine h2OMachine, String atom) {
        this.atom = atom;
        this.h2OMachine = h2OMachine;
    }

    @Override
    public void run() {
        try {
            if ("H".equals(atom)) {
                h2OMachine.hydrogenAtom();
            } else if ("O".equals(atom)) {
                h2OMachine.oxygenAtom();
            }
        } catch (Exception e) {

        }
    }
}
