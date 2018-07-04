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

        //Task #1
        toggleArrayElements(0,2,stringArray);
        System.out.println(Arrays.toString(stringArray));

        //Task #2
        System.out.println(transformArrayToArrayList(stringArray));

        //Task #3
        Box<Apple> firstAppleBox = new Box<Apple>();
        for(int i=0; i<=5; i++){
            firstAppleBox.addFruit(new Apple());
        }

        Box<Orange> orangeBox = new Box<Orange>();
        for(int i=0; i<=3; i++){
            orangeBox.addFruit(new Orange());
        }

        Box<Apple> secondAppleBox = new Box<Apple>();
        for(int i=0; i<=5; i++){
            secondAppleBox.addFruit(new Apple());
        }

        if(firstAppleBox.compare(orangeBox)){
            System.out.println("Equals");
        }

        firstAppleBox.intersperse(secondAppleBox);

        if (!firstAppleBox.compare(secondAppleBox)){
            System.out.println("Not equals");
        }

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
