package annotation.java;

public class DeprecatedClass {

    public void call1() {
        System.out.println("DeprecatedClass.call1");
    }

    @Deprecated
    public void call2() {
        System.out.println("DeprecatedClass.call2");
    }

    /**
     * `since` : 더 이상 사용하지 않게된 버전 정보
     * `forRemoval` : 미래 버전에 코드가 제거될 예정
     */
    @Deprecated(since = "2.4", forRemoval = true)
    public void call3() {
        System.out.println("DeprecatedClass.call3");
    }
}
