package io.buffered;

import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 작업이 느린 이유
 * - `write()` 나 `read()` 를 호출할 때마다 OS의 시스템 콜을 통해 파일을 읽거나 쓰는 명령어를 전달한다. 이러한 시스템 콜은 상대적으로 무거운 작업이다.
 * - HDD, SDD 같은 장치들도 하나의 데이터를 읽고 쓸 때마다 필요한 시간이 있다. HDD의 경우 더욱 느린데, 물리적으로 디스크의 회전이 필요하다.
 * - 이러한 무거운 작업을 무려 1000만 번 반복한다.
 */
public class CreateFileV1 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < FILE_SIZE; i++) {
            fos.write(1);
        }
        fos.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File created: " + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}