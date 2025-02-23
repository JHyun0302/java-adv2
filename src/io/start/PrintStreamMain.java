package io.start;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamMain {

    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;

        byte[] bytes = "Hello!\n".getBytes(UTF_8);
        printStream.write(bytes); // `OutputStream` 부모 클래스가 제공하는 기능
        printStream.println("Print!"); // `PrintStream` 이 자체적으로 제공하는 추가 기능

    }
}
