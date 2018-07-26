package ru.ttv.javacore3.lesson7;

public class TestTTV {
    public static void start(Class testClass){
        testProcess(testClass);
    }

    public static void start(String className){
        Class testClass = null;
        try {
            testClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        testProcess(testClass);

    }
    private static void testProcess(Class testClass) {

    }
}
