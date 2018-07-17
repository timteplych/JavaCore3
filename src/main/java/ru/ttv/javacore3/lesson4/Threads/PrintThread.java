package ru.ttv.javacore3.lesson4.Threads;

import ru.ttv.javacore3.lesson4.Mfu;

public class PrintThread implements Runnable {
    Mfu mfu;

    public PrintThread(Mfu mfu) {
        this.mfu = mfu;
    }

    @Override
    public void run() {
        for(int i=0; i<30; i++){
            mfu.printDocument();
        }
    }
}
