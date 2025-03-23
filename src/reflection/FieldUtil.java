package reflection;

import java.lang.reflect.Field;

public class FieldUtil {

    /**
     * 이 유틸리티는 필드의 값을 조사한 다음에 `null` 이면 기본 값을 적용한다.
     * `String` 이 `null` 이면 `""` (빈 문자)로 변경한다.
     * `Integer` 가 `null` 이면 `0`으로 변경한다.
     */
    public static void nullFieldToDefault(Object target) throws IllegalAccessException {
        Class<?> aClass = target.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.get(target) != null) {
                continue;
            }

            if (field.getType() == String.class) {
                field.set(target, "");
            } else if (field.get(target) == Integer.class) {
                field.set(target, 0);
            }
        }
    }
}
