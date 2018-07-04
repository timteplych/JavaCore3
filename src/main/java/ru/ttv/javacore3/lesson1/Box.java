package ru.ttv.javacore3.lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitBox;

    public Box(){
        this.fruitBox = new ArrayList<T>();
    }

    public void addFruit(T fruit){
        fruitBox.add(fruit);
    }

    private float getWeight(){
        float totalWeight = 0f;
        for(T fruit: fruitBox){
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<Fruit> fruitBox ){
        return getWeight() == fruitBox.getWeight();
    }

    public void intersperse(Box<T> destinationBox){
        for (T fruit : fruitBox){
            destinationBox.addFruit(fruit);
        }
    }
}
