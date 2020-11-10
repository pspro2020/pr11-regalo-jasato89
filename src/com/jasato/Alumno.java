package com.jasato;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Alumno implements Runnable {

    private HermanoMayor hermanoMayor;

    public Alumno(HermanoMayor hermanoMayor) {
        this.hermanoMayor = hermanoMayor;
    }


    @Override
    public void run() {
        int euros;
        try {
            euros = ThreadLocalRandom.current().nextInt(5)+2;
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10)+3);

        } catch (InterruptedException e) {
            return;
        }
        hermanoMayor.addMoney(euros);


    }
}
