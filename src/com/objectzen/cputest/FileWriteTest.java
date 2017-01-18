package com.objectzen.cputest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Jim Liao / ObjectZen.com.
 */
public class FileWriteTest {

    private void performWriteTest() {
        try {
            File tmpFile = File.createTempFile("FileWriteTest", "");
            System.out.println(tmpFile.getAbsoluteFile());
            FileWriter writer = new FileWriter(tmpFile);

            for(int i=0; i < 10000; i++) {
                double value = Math.random();
                writer.append(String.format("%f\r\n", value));
                writer.flush();
            }

            tmpFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileWriteTest fileWriteTest = new FileWriteTest();
        fileWriteTest.performWriteTest();
    }

}
