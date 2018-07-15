package ru.ttv.javacore3.lesson4;

public class Mfu {
    private boolean scanning = true;
    private boolean printing = true;

    private int printCount = 0;
    private int scanCount = 0;

    public synchronized void scanDocument(){
        while (!scanning){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        scanCount++;
        System.out.println("Scanned "+scanCount);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        notifyAll();
    }

    public synchronized void printDocument(){
        while (!printing){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        printCount++;
        System.out.println("Printed "+printCount);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyAll();
    }

}
