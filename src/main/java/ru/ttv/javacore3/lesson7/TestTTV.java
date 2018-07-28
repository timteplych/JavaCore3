package ru.ttv.javacore3.lesson7;

import ru.ttv.javacore3.lesson7.annotations.AfterSuite;
import ru.ttv.javacore3.lesson7.annotations.BeforeSuite;
import ru.ttv.javacore3.lesson7.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestTTV {
    private static Object object;

    public static void start(Class testClass, Object obj){
        object = obj;
        beginTest(testClass);
    }

    public static void start(String className,Object obj){
        Class testClass = null;
        object = obj;
        try {
            testClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        beginTest(testClass);

    }
    private static void beginTest(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        processBeforeMethod(methods);
        processTests(methods);
        processAfterClass(methods);
    }

    private static void processTests(Method[] methods) {
        Map<Method,Integer> testMethods = new HashMap<>();
        for(Method method: methods){
            if(method.getAnnotation(Test.class) != null){
                Test testAnnotation = method.getAnnotation(Test.class);
                testMethods.put(method,testAnnotation.priority());
            }
        }
        for(int i=1; i<=10; i++) {
            for(Map.Entry<Method,Integer> entry: testMethods.entrySet()){
                if(entry.getValue() == i){
                    try {
                        entry.getKey().invoke(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    private static void processAfterClass(Method[] methods) {
        List<Method> afterMethods = new ArrayList<>();
        for(Method method: methods){
            if(method.getAnnotation(AfterSuite.class) != null){
                afterMethods.add(method);
            }
        }
        if(afterMethods.size() == 0) return;
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

    private static void processBeforeMethod(Method[] methods) {
        List<Method> beforeMethods = new ArrayList<>();
        for(Method method: methods){
            if(method.getAnnotation(BeforeSuite.class) != null){
                beforeMethods.add(method);
            }
        }
        if(beforeMethods.size() == 0) return;
        if(beforeMethods.size() == 1){
            try {
                Method method = beforeMethods.get(0);
                method.invoke(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else throw new RuntimeException();
    }
}
