package annotation.basic;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import util.MyLogger;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoElement {
    String value();
    int count() default 0;
    String[] tags() default {};

//    MyLogger data(); // 다른 타입은 적용X (직접 만든 type은 선언 불가)
    Class<? extends MyLogger> annoData() default MyLogger.class; // class에 대한 메타데이터 정보는 사용 가능
}
