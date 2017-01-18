package com.objectzen.cputest;

public class HalfCpuTest {

    public double performTest1(long duration) {
        double value = 0;
        long startTime = System.currentTimeMillis();
        while( (System.currentTimeMillis() - startTime) < duration) {
            value = Math.random();
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        HalfCpuTest cpuTest = new HalfCpuTest();

        int numOfThreads = Runtime.getRuntime().availableProcessors() / 2;
        for (int i = 0; i < numOfThreads; i++) {
            new Thread() {
                @Override
                public void run() {
                    cpuTest.performTest1(30000);
                }
            }.start();
        }
    }
}
