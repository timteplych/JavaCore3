package ru.ttv.javacore3.lesson4.Threads;

import ru.ttv.javacore3.lesson4.MyFileWriter;

public class WriteToFileThread2 extends Thread {
    private MyFileWriter myFileWriter;

    public WriteToFileThread2(MyFileWriter myFileWriter) {
        this.myFileWriter = myFileWriter;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            myFileWriter.writeThread2("Thread2 "+i);
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
