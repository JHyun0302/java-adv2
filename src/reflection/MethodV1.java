package reflection;

import java.lang.reflect.Method;
import reflection.data.BasicData;

/**
 * *getMethods() vs getDeclaredMethods()**
 * - `getMethods()` : 해당 클래스와 상위 클래스에서 상속된 **모든 public 메서드를 반환**
 * - `getDeclaredMethods()` : **해당 클래스에서 선언된 모든 메서드를 반환**하며, 접근 제어자에 관계없이 반환. 상속된 메서드는 포함하지 않음
 */
public class MethodV1 {

    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;

        System.out.println("==== methods() ====");
        Method[] methods = helloClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        System.out.println("==== declaredMethods() ====");
        Method[] declaredMethods = helloClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("declaredMethod = " + method);
        }
    }
}
