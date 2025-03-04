package io.strings;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * `PrintStream` 은 우리가 자주 사용해왔던 바로 `System.out` 에서 사용되는 스트림이다.
 * `PrintStream` 과 `FileOutputStream` 을 조합하면 마치 콘솔에 출력하듯이 파일에 출력할 수 있다.
 */
public class PrintStreamEtcMain {

    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp/print.txt");
        PrintStream printStream = new PrintStream(fos);

        printStream.println("hello java!");
        printStream.println(10);
        printStream.println(true);
        printStream.printf("hello %s", "world");
        printStream.close();
    }
}
