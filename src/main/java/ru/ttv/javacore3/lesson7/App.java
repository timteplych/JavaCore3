package ru.ttv.javacore3.lesson7;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class App {
    public static void main(String[] args) {
        TestTTV.start(ReflectionTestClass.class, new ReflectionTestClass());
    }
}
