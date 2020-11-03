package jichu;

import java.util.ArrayList;
import java.util.List;

/**
 * 什么是注解，几个内置注解
 */
public class AnnotationTest extends Object{

    //Override  重写的注解
    @Override
    public String toString(){
        return super.toString();
    }

    //Deprecated  不推荐使用，但是可以使用，或者有更好的方式
    @Deprecated
    public static void test(){
        System.out.println("Deprecated 不推荐使用，但是可以使用");
    }

    //SuppressWarnings  镇压警告，平时不建议镇压
    @SuppressWarnings("all")
    public void test02(){
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        test();
    }
}

/**
 *JDK1.5引入
 * */