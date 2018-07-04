package ru.ttv.javacore3.lesson1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Timofey Teplykh
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String[] stringArray = {"One","Two","Three"};
        toggleArrayElements(0,2,stringArray);
        System.out.println(Arrays.toString(stringArray));
    }

    //Task #1
    private static <T> void toggleArrayElements(int index1, int index2, T[] array){
        T pool = array[index2];
        array[index2] = array[index1];
        array[index1] = pool;
    }

    //Task #2
    private static <T> ArrayList<T> transformArrayToArrayList(T[] array){
        ArrayList<T> arrayList = new ArrayList<T>(Arrays.asList(array));
        return arrayList;
    }
}
