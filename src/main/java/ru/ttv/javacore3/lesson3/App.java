package ru.ttv.javacore3.lesson3;

import java.io.*;

public class App {

    //File
    //Path
    //FileDescriptor

    //ByteArrayInputStream
        //FileInputStream
    //PipedInputStream
    //SequenceInputStream
    //BufferedInputStream
    //DataInputStream
    //ObjectInputStream
        //InputStreamReader
        //BufferedReader
    //RandomAccessFile

    public static void main(String[] args){
        MyFileReader myFileReader = new MyFileReader();

        //Task #1
        byte[] resultArray = myFileReader.getArrayFileData("C:/JavaProjects/test.txt");
        for(byte result: resultArray){
            System.out.println(result);
        }

    }


}
