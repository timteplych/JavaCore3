package ru.ttv.javacore3.lesson7;

import ru.ttv.javacore3.lesson7.annotations.AfterSuite;
import ru.ttv.javacore3.lesson7.annotations.BeforeSuite;
import ru.ttv.javacore3.lesson7.annotations.Test;

public class ReflectionTestClass {
    private int count;

    public void doSomething(){
        System.out.println("do something");
    }
    @BeforeSuite
    public void beforeTestTTV(){
        System.out.println("Before test TTV");
    }

    @Test(priority = 1)
    public void testTTV_1(){
        System.out.println("test 1");
    }

    @Test(priority = 3)
    public void testTTV_2(){
        System.out.println("test 2");
    }

    @Test(priority = 2)
    public void testTTV_3(){
        System.out.println("test 3");
    }

    @Test(priority = 2)
    public void testTTV_4(){
        System.out.println("test 4");
    }

    @AfterSuite
    public void afterTestTTV(){
        System.out.println("After test TTV");
    }

}
