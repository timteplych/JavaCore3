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

    public String getPageByNumber(String pathToFile, int pageNumber){
        if(pageNumber < 1) return null;
        StringBuilder sb = new StringBuilder();
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(pathToFile,"r")){
            randomAccessFile.seek(1800*(pageNumber-1));
            for(int i=1;i<=1800;i++){
                sb.append((char) randomAccessFile.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
