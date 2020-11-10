package com.jasato;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;

public class HermanoMayor implements Runnable {

    private final CountDownLatch countDownLatch;


    public HermanoMayor(int euros) {
        this.countDownLatch = new CountDownLatch(euros);
    }


    @Override
    public void run() {
        System.out.printf("%s => Necesito %s € para el regalo\n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), countDownLatch.getCount());

        try {
            countDownLatch.await();
            System.out.printf("%s => ¡Ya hemos conseguido el dinero!\n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        } catch (InterruptedException e) {
            return;
        }
    }

    public void addMoney(int euros) {
        System.out.printf("%s => %s ha añadido %s euros\n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), Thread.currentThread().getName(), euros);
        for (int i = 0; i < euros; i++) {
            countDownLatch.countDown();
        }
    }
}
