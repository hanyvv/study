package ch12.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static java.lang.annotation.RetentionPolicy.*;

@Deprecated
@SuppressWarnings("1111")
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd = "220504", hhmmss = "002345"))
public class AnnotationEx5 {
    public static void main(String[] args) {
        Class<AnnotationEx5> cls = AnnotationEx5.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy() = " + anno.testedBy());
        System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss() = " + anno.testDate().hhmmss());
        for (String s : anno.testTools()) {
            System.out.println("testTools = " + s);
        }
        System.out.println();

        Annotation[] annoArr = cls.getAnnotations();

        for (Annotation a : annoArr) {
            System.out.println(a);
        }
    }
}

@Retention(RUNTIME)
@interface TestInfo {
    int count() default 1;

    String testedBy();

    String[] testTools() default "JUnit";

    TestType testType() default TestType.FIRST;

    DateTime testDate();

}

@Retention(RUNTIME)
@interface DateTime {
    String yymmdd();

    String hhmmss();
}

enum TestType {
    FIRST, FINAL
}