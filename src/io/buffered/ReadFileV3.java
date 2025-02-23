package io.buffered;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * BufferedInputStream` 은 버퍼의 크기만큼 데이터를 미리 읽어서 버퍼에 보관해둔다.
 * 따라서 `read()` 를 통해 1byte씩 데이터를 조회해도, 성능이 최적화 된다.
 * ---
 * V2보다 V3가 느린 이유 : BufferedXxx 동기화 처리 때문
 * - 아쉽게도 동기화 락이 없는 `BufferedXxx` 클래스는 없다.
 * - 꼭 필요한 상황이라면 `BufferedXxx` 를 참고해서 동기화 락 코드를 제거한 클래스를 직접 만들어 사용하면 된다.
 */
public class ReadFileV3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        BufferedInputStream bis = new BufferedInputStream(fis, BUFFER_SIZE);
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int data;
        while ((data = bis.read()) != -1) {
            fileSize++;
        }
        bis.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File created: " + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
