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
}
