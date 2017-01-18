package com.objectzen.cputest;

public class StepsCpuTest {

    public double performTest1(long duration) {
        double value = 0;
        long startTime = System.currentTimeMillis();
        while( (System.currentTimeMillis() - startTime) < duration) {
            value = Math.random();
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        StepsCpuTest cpuTest = new StepsCpuTest();

        int numOfProcessors = Runtime.getRuntime().availableProcessors();
        int numOfThreads = numOfProcessors - 2;

        // step up
        for(int j=1; j <= numOfThreads; j++) {
            System.out.printf("Running with %d threads, using %.2f%% CPU.\n", j, (j*100.0/numOfProcessors));
            for (int i = 0; i < j; i++) {
                new Thread() {
                    @Override
                    public void run() {
                        cpuTest.performTest1(10000);
                    }
                }.start();
            }
            Thread.sleep(10000);
        }

        // step down
        for(int j=numOfThreads; j > 0; j--) {
            System.out.printf("Running with %d threads, using %.2f%% CPU.\n", j, (j*100.0/numOfProcessors));
            for (int i = 0; i < j; i++) {
                new Thread() {
                    @Override
                    public void run() {
                        cpuTest.performTest1(10000);
                    }
                }.start();
            }
            Thread.sleep(10000);
        }

    }
}
