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
        try {
            FileInputStream fis = new FileInputStream("c:/JavaProjects/12345.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bfr = new BufferedReader(isr);
            String str;
            while ((str = bfr.readLine()) != null){
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
