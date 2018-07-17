package ru.ttv.javacore3.lesson4;

import ru.ttv.javacore3.lesson4.Threads.*;

import java.io.FileWriter;
import java.io.IOException;


public class App {
    public static void main(String[] args){

        Object obj = new Object();

        //Task #1
        OutputCharacacters outputCharacacters = new OutputCharacacters();
        OutputThreadA outputThreadA = new OutputThreadA(outputCharacacters);
        OutputThreadB outputThreadB = new OutputThreadB(outputCharacacters);
        OutputThreadC outputThreadC = new OutputThreadC(outputCharacacters);
        outputThreadA.start();
        outputThreadB.start();
        outputThreadC.start();

        //Task #2
        writeToFile();

        //Task #3
        Mfu mfu = new Mfu();
        Thread scanThread = new Thread(new ScanThread(mfu));
        Thread scanThread1 = new Thread(new ScanThread(mfu));

        Thread printThread = new Thread(new PrintThread(mfu));
        Thread printThread1 = new Thread(new PrintThread(mfu));

        scanThread.start();
        scanThread1.start();
        printThread.start();
        printThread1.start();

    }

    private static void writeToFile() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:/JavaProjects/lesson4.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyFileWriter myFileWriter = new MyFileWriter(fileWriter);

        WriteToFileThread1 writeToFileThread1 = new WriteToFileThread1(myFileWriter);
        WriteToFileThread2 writeToFileThread2 = new WriteToFileThread2(myFileWriter);
        WriteToFileThread3 writeToFileThread3 = new WriteToFileThread3(myFileWriter);

        writeToFileThread1.start();
        writeToFileThread2.start();
        writeToFileThread3.start();
    }


}
