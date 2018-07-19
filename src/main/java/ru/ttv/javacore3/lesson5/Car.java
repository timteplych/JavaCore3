package ru.ttv.javacore3.lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private CountDownLatch start;
    private CountDownLatch finish;

    private Semaphore tunnel;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Semaphore getTunnel() {
        return tunnel;
    }
    public Car(CountDownLatch start, Semaphore tunnel, CountDownLatch finish, Race race, int speed) {
        this.race = race;
        this.speed = speed;
        this.start = start;
        this.tunnel = tunnel;
        this.finish = finish;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            start.countDown();
            start.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (finish.getCount() == CARS_COUNT+1){
            System.out.println(this.name + " WIN");
        }
        finish.countDown();
        try {
            finish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
