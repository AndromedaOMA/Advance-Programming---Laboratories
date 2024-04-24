package org.example;

import java.sql.Time;

public class Timekeeper extends Thread {
    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    Timekeeper(Thread thread1, Thread thread2, Thread thread3) {
        this.thread1 = thread1;
        this.thread2 = thread2;
        this.thread3 = thread3;
    }

    private int counter = 0;

    @Override
    public void run() {
        while (true) {
            if (counter == 10) {
                stopRunningThreads();
                interrupt();
                throw new RuntimeException("Jocul s-a terminat");
            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ++counter;
        }
    }

    public void stopRunningThreads() {
        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
    }
}
