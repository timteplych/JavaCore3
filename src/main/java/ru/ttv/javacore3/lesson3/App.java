package ru.ttv.javacore3.lesson3;

import java.io.*;


public class App {
    public static void main(String[] args){
        MyFileReader myFileReader = new MyFileReader();

        //Task #1
        byte[] resultArray = myFileReader.getArrayFileData("C:/JavaProjects/test.txt");
        for(byte result: resultArray){
            System.out.println(result);
        }

        //Task2
        String[] paths = new String[5];
        paths[0] = "C:/JavaProjects/1.txt";
        paths[1] = "C:/JavaProjects/2.txt";
        paths[2] = "C:/JavaProjects/3.txt";
        paths[3] = "C:/JavaProjects/4.txt";
        paths[4] = "C:/JavaProjects/5.txt";
        File resultFile = myFileReader.getJoinedFile(paths);

        //Task 3
        long startTime = System.currentTimeMillis();
        System.out.println(myFileReader.getPageByNumber("C:/JavaProjects/testPageReading.txt",10));
        System.out.println("10th page");
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        System.out.println(myFileReader.getPageByNumber("C:/JavaProjects/testPageReading.txt",100));
        System.out.println("100th page");
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
