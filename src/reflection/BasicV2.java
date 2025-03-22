package reflection;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import reflection.data.BasicData;

public class BasicV2 {

    public static void main(String[] args) {
        Class<BasicData> basicData = BasicData.class;

        System.out.println("basicData.getName() = " + basicData.getName());
        System.out.println("basicData.getSimpleName() = " + basicData.getSimpleName());
        System.out.println("basicData.getPackage() = " + basicData.getPackage());

        System.out.println("basicData.getSuperclass() = " + basicData.getSuperclass());
        System.out.println("basicData.getInterfaces() = " + Arrays.toString(basicData.getInterfaces()));

        System.out.println("basicData.isInterface() = " + basicData.isInterface());
        System.out.println("basicData.isEnum() = " + basicData.isEnum());
        System.out.println("basicData.isAnnotation() = " + basicData.isAnnotation());

        /**
         * 참고로 수정자는 접근 제어자와 비 접근 제어자(기타 수정자)로 나눌 수 있다.
         * - 접근 제어자: `public` , `protected` , `default` (`package-private` ), `private`
         * - 비 접근 제어자: `static` , `final` , `abstract` , `synchronized` , `volatile` 등
         * `getModifiers()` 를 통해 수정자가 조합된 숫자를 얻고, `Modifier` 를 사용해서 실제 수정자 정보를 확인할 수 있다.
         */
        int modifiers = basicData.getModifiers(); // 수정자 정보
        System.out.println("basicData.getModifiers = " + modifiers);
        System.out.println("isPublic = " + Modifier.isPublic(modifiers));
        System.out.println("Modifier.toString() = " + Modifier.toString(modifiers));
    }
}
