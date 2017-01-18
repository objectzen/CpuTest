package com.objectzen.cputest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SquareWaveCpuTest {

    public double performTest1(long duration) {
        double value = 0;
        long startTime = System.currentTimeMillis();
        while( (System.currentTimeMillis() - startTime) < duration) {
            value = Math.random();
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        SquareWaveCpuTest cpuTest = new SquareWaveCpuTest();

        long duration = 10000;
        int numOfThreads = Runtime.getRuntime().availableProcessors() / 2;
        for(int j=0; j < 10; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < numOfThreads; i++) {
                    new Thread() {
                        @Override
                        public void run() {
                            cpuTest.performTest1(duration);
                        }
                    }.start();
                }
                Thread.sleep(duration);
            } else {
                countDownLatch.await(duration, TimeUnit.MILLISECONDS);
            }
        }

    }
}
