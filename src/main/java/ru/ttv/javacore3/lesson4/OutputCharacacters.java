package ru.ttv.javacore3.lesson4;

public class OutputCharacacters {
    private boolean printingA = true;
    private boolean printingB = false;
    private boolean printingC = false;

    public synchronized void printA(){
        while (!printingA){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("A");
        printingA = false;
        printingB = true;
        notifyAll();
    }

    public synchronized void printB(){
        while (!printingB){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("B");
        printingB = false;
        printingC = true;
        notifyAll();
    }

    public synchronized void printC(){
        while (!printingC){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("C");
        printingC = false;
        printingA = true;
        notifyAll();
    }
}
