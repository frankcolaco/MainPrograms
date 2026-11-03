package com.examples.interview.question.solution.superman;

public class BillPughSuperman {

    public static void main(String[] args) {
        BillsSuperman superman = BillsSuperman.getInstance();
        superman.fly();
    }


}

class BillsSuperman{

    private static class Holder{
        private static BillsSuperman superman = new BillsSuperman();
    }

    private BillsSuperman(){}

    public static BillsSuperman getInstance(){
        return Holder.superman;
    }

    public void fly(){
        System.out.println("Superman is flying because of Bill Pugh");
    }

}
