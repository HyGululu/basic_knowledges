package jichu;

import java.lang.annotation.*;

/**
 * 测试元注解
 */
public class AnnotationTest02 {

    @MyAnnotaion
    public void test(){

    }

}

//定义一个注解
//Target  表示注解可以用在哪些地方
@Target(value={ElementType.METHOD,ElementType.TYPE})
//Retention  表示注解可以在什么地方还有效
//  runtime>class>sources
@Retention(RetentionPolicy.RUNTIME)
//Documented  表示是否将注解生成在JavaDoc中
@Documented
//Inherited  子类可以继承父类的注解
@Inherited
@interface  MyAnnotaion{}

//自定义注解
//使用@interface自定义注解，自动继承了java.lang.annotation.Annotation接口
//格式  @interface 注解名{定义内容}
