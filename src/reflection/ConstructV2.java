package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConstructV2 {

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("reflection.data.BasicData"); // 클래스 정보를 동적으로 조회

        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class); // 생성자를 조회 (매개변수로 `String` 을 사용하는 생성자를 조회)
        constructor.setAccessible(true); // private 생성자를 접근 가능
        Object instance = constructor.newInstance("hello"); // 찾은 생성자를 사용해서 객체를 생성 ("hello"라는 인자를 넘겨준다.)
        System.out.println("instance = " + instance);

        Method method1 = aClass.getDeclaredMethod("call"); // `call` 이라는 이름의 메서드를 동적으로 찾아서 호출
        method1.invoke(instance);
    }
}
