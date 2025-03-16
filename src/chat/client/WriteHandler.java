package chat.client;

import static util.MyLogger.log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Scanner` 를 통한 콘솔 입력인 `scanner.nextLine()` 코드에서 대기하는 스레드에 다음 예외가 발생하면서, 대기 상태에서 빠져나올 수 있다.
 * `java.util.NoSuchElementException: No line found`
 * 서버가 연결을 끊은 경우에 클라이언트의 자원이 정리되는데, 이때 유용하게 사용된다.
 */
public class WriteHandler implements Runnable{

    private static final String DELIMITER = "|";

    private final DataOutputStream output;
    private final Client client;

    private boolean closed = false;

    public WriteHandler(DataOutputStream output, Client client) {
        this.output = output;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            String username = inputUsername(scanner);
            output.writeUTF("/join" + DELIMITER + username);

            while (true) {
                String toSend = scanner.nextLine(); // 블로킹
                if (toSend.isEmpty()) {
                    continue;
                }

                if (toSend.equals("/exit")) {
                    output.writeUTF(toSend);
                    break;
                }

                // "/"로 시작하면 명령어, 나머지는 일반 메시지
                if (toSend.startsWith("/")) {
                    output.writeUTF(toSend);
                } else {
                    output.writeUTF("/message" + DELIMITER + toSend);
                }
            }
        } catch (IOException | NoSuchElementException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    private static String inputUsername(Scanner scanner) {
        System.out.println("이름을 입력하세요.");
        String username;
        do {
            username = scanner.nextLine();
        } while (username.isEmpty());
        return username;
    }

    public synchronized void close() {
        if (closed) {
            return;
        }

        try {
            System.in.close(); // Scanner 입력 중지 (사용자의 입력을 닫음)
        } catch (IOException e) {
            log(e);
        }
        closed = true;
        log("writeHandler 종료");
    }
}
