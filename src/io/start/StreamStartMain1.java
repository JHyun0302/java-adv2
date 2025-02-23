package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * **new FileOutputStream("temp/hello.dat")**
 * 파일에 데이터를 출력하는 스트림이다.
 * 파일이 없으면 파일을 자동으로 만들고, 데이터를 해당 파일에 저장한다.
 * 폴더를 만들지는 않기 때문에 폴더는 미리 만들어두어야 한다.
 */
public class StreamStartMain1 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());
        fis.close();
    }
}
