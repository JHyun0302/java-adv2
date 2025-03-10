package network.tcp.autocloseable;

/**
 * 핵심적인 문제들은 해결되었지만 코드 부분에서 보면 아쉬운 부분이 많다
 */
public class ResourceCloseMainV4 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");

            // 부가 예외들 꺼내서 사용 가능
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable throwable : suppressed) {
                System.out.println("suppressedEx: " + throwable);
            }

            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    /**
     * `try-with-resources': try 문이 끝나면 자동으로 `close()` 호출
     * @throws CallException
     * @throws CloseException
     */
    private static void logic() throws CallException, CloseException {
        try (ResourceV2 resource1 = new ResourceV2("resource1");
            ResourceV2 resource2 = new ResourceV2("resource2")){

            resource1.call();
            resource2.callEx(); // CallException

        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        }
    }
}
