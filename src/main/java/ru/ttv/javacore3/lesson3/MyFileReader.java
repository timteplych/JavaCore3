package ru.ttv.javacore3.lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class MyFileReader {

    public byte[] getArrayFileData(String pathToFile){
        byte[] masResult = new byte[100];
        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)){

            fileInputStream.read(masResult);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return masResult;
    }

    public File getJoinedFile(String[] pathArray){
        List<InputStream> arrayListOfStreams = new ArrayList<InputStream>();
        for(String path : pathArray){
            try {
                arrayListOfStreams.add(new FileInputStream(path));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        Enumeration<InputStream> e = Collections.enumeration(arrayListOfStreams);


        File outPutFile = new File("c:/JavaProjects/result12345.txt");
        try ( SequenceInputStream sequenceInputStream = new SequenceInputStream(e);
              FileOutputStream fileOutputStream = new FileOutputStream(outPutFile)){
            int writeData = sequenceInputStream.read();
            while(writeData != -1) {
                fileOutputStream.write(writeData);
                writeData = sequenceInputStream.read();
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return outPutFile;
    }
}
