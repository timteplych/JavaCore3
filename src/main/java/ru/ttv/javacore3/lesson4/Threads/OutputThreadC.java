package ru.ttv.javacore3.lesson4.Threads;

import ru.ttv.javacore3.lesson4.OutputCharacacters;

public class OutputThreadC extends Thread {
    OutputCharacacters outputChar;

    public OutputThreadC(OutputCharacacters outputChar){
        this.outputChar = outputChar;
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            outputChar.printC();
        }
    }
}
