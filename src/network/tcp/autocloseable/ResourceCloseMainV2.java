package network.tcp.autocloseable;

/**
 * 문제
 * 1. null 체크
 * - `finally` 코드 블록에서 null 체크
 * 2. 자원 정리중에 예외가 발생하는 문제
 * - `resource1.closeEx()`는 호출되지 않는다.
 * 3. 핵심 예외가 바뀌는 문제
 * - 핵심 예외인 `CallException` 이 아니라 `finally` 블록에서 새로 생성된 `CloseException` 을 받게 된다.
 */
public class ResourceCloseMainV2 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;
        try {
            resource1 = new ResourceV1("resource1");
            resource2 = new ResourceV1("resource2");

            resource1.call();
            resource2.callEx(); // CallException
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        }finally {
            if (resource2 != null) {
                resource2.closeEx(); // CloseException 발생
            }
            if (resource1 != null) {
                resource1.closeEx(); // 이 코드 호출 안됨!
            }
        }
    }
}
