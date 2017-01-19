package com.objectzen.cputest;

public class SingleCpuTest {

    public double performTest1(long duration) {
        double value = 0;
        long startTime = System.currentTimeMillis();
        while( (System.currentTimeMillis() - startTime) < duration) {
            value = Math.random();
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        SingleCpuTest cpuTest = new SingleCpuTest();
        cpuTest.performTest1(30000);
    }
}
