package charset;

import static java.nio.charset.StandardCharsets.*;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EncodingMain1 {

    private static final Charset EUC_KR = Charset.forName("EUC_KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("== ASCII 영문 처리 ==");
        encoding("A", US_ASCII);
        encoding("A", ISO_8859_1);
        encoding("A", EUC_KR);
        encoding("A", UTF_8);
        encoding("A", UTF_16BE); // ASCII 호환 X (BE, LE는 byte의 순서의 차이)

        System.out.println("== 한글 지원 ==");
        encoding("가", EUC_KR);
        encoding("가", MS_949);
        encoding("가", UTF_8); // 3byte
        encoding("가", UTF_16BE); // 2byte
    }

    private static void encoding(String text, Charset charset) {
        byte[] bytes = text.getBytes(charset);
//        byte[] defaultBytes = text.getBytes(); // 문자 집합을 지정하지 않으면 현재 시스템에서 사용하는 기본 문자 집합을 인코딩에 사용한다.
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n", text, charset, Arrays.toString(bytes), bytes.length);
    }
}