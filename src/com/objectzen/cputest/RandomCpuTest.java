package com.objectzen.cputest;

public class RandomCpuTest {

    public double performTest1(long duration) {
        double value = 0;
        long startTime = System.currentTimeMillis();
        while( (System.currentTimeMillis() - startTime) < duration) {
            value = Math.random();
            if (value > 0.50) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                long now = System.currentTimeMillis();
                while( (System.currentTimeMillis() - now) < 1000) {
                    value = Math.random();
                }
            }
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        RandomCpuTest cpuTest = new RandomCpuTest();

        int numOfProcessors = Runtime.getRuntime().availableProcessors();
        int numOfThreads = numOfProcessors/2;

        for (int i = 0; i < numOfThreads; i++) {
            new Thread() {
                @Override
                public void run() {
                    cpuTest.performTest1(60000);
                }
            }.start();
        }
        Thread.sleep(60000);
    }
}
