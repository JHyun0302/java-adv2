package io.file.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * `Files.copy()` 는 자바에 파일 데이터를 불러오지 않고, 운영체제의 파일 복사 기능을 사용한다.
 * 따라서 다음과 같이 중간 과정이 생략된다.
 * 파일(copy.dat) -> 파일(copy_new.dat)
 */
public class FileCopyMainV3 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        Path source = Path.of("temp/copy.dat");
        Path target = Path.of("temp/copy_new.dat");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
