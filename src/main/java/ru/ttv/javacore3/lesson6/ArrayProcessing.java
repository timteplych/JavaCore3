package ru.ttv.javacore3.lesson6;

import java.util.Arrays;

public class ArrayProcessing {
    public int[] getSubArray(int[] arr){
        for(int i=arr.length-1;i>=0; i--){
            if(arr[i]==4){
                System.out.println(i);
                return Arrays.copyOfRange(arr,i+1,arr.length);
            }
        }
        throw new RuntimeException();
    }

    public boolean checkArray(int[] array){
        boolean found = false;
        for(int i=0; i<array.length; i++){
            if(array[i] == 1 || array[i] == 4){
                found = true;
            }
        }
        return found;
    }
}
