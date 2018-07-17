package ru.ttv.javacore3.lesson4.Threads;

import ru.ttv.javacore3.lesson4.OutputCharacacters;

public class OutputThreadA extends Thread{
    OutputCharacacters outputChar;

    public OutputThreadA(OutputCharacacters outputChar){
        this.outputChar = outputChar;
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            outputChar.printA();
        }
    }
}
