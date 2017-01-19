package com.objectzen.cputest;

public class SingleThreadCpuTest {

    public double performTest1(long duration) {
        double value = 0;
        long startTime = System.currentTimeMillis();
        while( (System.currentTimeMillis() - startTime) < duration) {
            value = Math.random();
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        SingleThreadCpuTest cpuTest = new SingleThreadCpuTest();
        cpuTest.performTest1(30000);
    }
}
