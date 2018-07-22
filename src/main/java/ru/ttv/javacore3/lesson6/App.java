package ru.ttv.javacore3.lesson6;

import java.util.Arrays;

public class App {
    public static void main(String[] args){

        //task#1
        ArrayProcessing arrayProcessing = new ArrayProcessing();
        int[] arr = { 1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] arrResult = arrayProcessing.getSubArray(arr);
        System.out.println(Arrays.toString(arrResult));
    }


}
