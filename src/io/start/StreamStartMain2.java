package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain2 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
//        FileOutputStream fos = new FileOutputStream("temp/hello.dat", true); // 기존 문제에 계속 이어서 만듬
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        int data;
        while ((data = fis.read()) != -1) {
            System.out.println(data);
        }
        fis.close();
    }
}
