package ru.ttv.javacore3.lesson7;

public class App {
    public static void main(String[] args) {
        TestTTV.start(ReflectionTestClass.class, new ReflectionTestClass());
        TestTTV.start("ru.ttv.javacore3.lesson7.ReflectionTestClass",new ReflectionTestClass());
    }
}
