package ru.ttv.javacore3.lesson7;

import ru.ttv.javacore3.lesson7.annotations.AfterSuite;
import ru.ttv.javacore3.lesson7.annotations.BeforeSuite;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestTTV {
    private static Object object;

    public static void start(Class testClass, Object obj){
        testProcess(testClass);
        object = obj;
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
        processBeforeMethod(testClass);
        processAfterClass(testClass);
    }

    private static void processAfterClass(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        List<Method> afterMethods = new ArrayList<>();
        for(Method method: methods){
            if(method.getAnnotation(AfterSuite.class) != null){
                afterMethods.add(method);

            }
        }
        if(afterMethods.size() == 1){
            try {
                afterMethods.get(0).invoke(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else throw new RuntimeException();
    }

    private static void processBeforeMethod(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        List<Method> beforeMethods = new ArrayList<>();
        for(Method method: methods){
            if(method.getAnnotation(BeforeSuite.class) != null){
                beforeMethods.add(method);

            }
        }
        if(beforeMethods.size() == 1){
            try {
                beforeMethods.get(0).invoke(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else throw new RuntimeException();
    }
}
