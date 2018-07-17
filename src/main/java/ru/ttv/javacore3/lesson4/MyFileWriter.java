package ru.ttv.javacore3.lesson4;

import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    private FileWriter fw;
    private boolean writePermissionThread1 = true;
    private boolean writePermissionThread2 = false;
    private boolean writePermissionThread3 = false;

    public MyFileWriter(FileWriter fw) {
        this.fw = fw;
    }

    public synchronized void writeThread1(String str) {
        while (!writePermissionThread1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            fw.write(str);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writePermissionThread1 = false;
        writePermissionThread2 = true;
        notifyAll();
    }

    public synchronized void writeThread2(String str) {
        while (!writePermissionThread2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            fw.write(str);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writePermissionThread2 = false;
        writePermissionThread3 = true;
        notifyAll();
    }

    public synchronized void writeThread3(String str) {
        while (!writePermissionThread3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            fw.write(str);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writePermissionThread3 = false;
        writePermissionThread1 = true;
        notifyAll();
    }
}
