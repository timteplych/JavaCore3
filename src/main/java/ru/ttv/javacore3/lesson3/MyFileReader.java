package ru.ttv.javacore3.lesson3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileReader {

    public byte[] getArrayFileData(String pathToFile){
        byte[] masResult = new byte[100];
        try {
            FileInputStream fileInputStream = new FileInputStream(pathToFile);
            fileInputStream.read(masResult);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return masResult;
    }
}
