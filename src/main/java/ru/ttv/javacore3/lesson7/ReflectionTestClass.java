package ru.ttv.javacore3.lesson7;

import ru.ttv.javacore3.lesson7.annotations.AfterSuite;
import ru.ttv.javacore3.lesson7.annotations.BeforeSuite;

public class ReflectionTestClass {
    private int count;

    public void doSomething(){
        System.out.println("do something");
    }
    @BeforeSuite
    public void beforeTestTTV(){
        System.out.println("Before test TTV");
    }

    @AfterSuite
    public void afterTestTTV(){
        System.out.println("After test TTV");
    }

}
