package jichu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
public class AnnotationTest03 {
    //注解可以显示赋值，如果没有默认值，必须给注解赋值
    @MyAnnotation02(name = "ghy",schools = {"郑大","北大"})
    public void test(){

    }

    @MyAnnotation03("")
    public void test02(){

    }
}


@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation02{
    //注解的参数：参数类型+参数名()；
    String name();
    //String name() default "ghy";
    int age() default 0;
    int id() default -1;  //如果默认值为-1，代表不存在，indexof如果找不到就返回-1

    String[] schools() default {"郑大","北大"};
}

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation03{
    String value();
}
