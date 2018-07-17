package ru.ttv.javacore3.lesson4.Threads;

import ru.ttv.javacore3.lesson4.OutputCharacacters;

public class OutputThreadB extends Thread {
    OutputCharacacters outputChar;

    public OutputThreadB(OutputCharacacters outputChar){
        this.outputChar = outputChar;
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            outputChar.printB();
        }
    }
}
