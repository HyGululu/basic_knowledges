package jichu.Thread;


/**
 * 推导lambda表达式
 *避免内部类定义过多，函数式编程
 * 函数式接口：只是包含唯一一个抽象方法
 * 2实现类--》3静态内部类--》4局部内部类（方法里面）--》5匿名内部类--》6lambda表达式
 */
public class LambdaTest {

    //3、静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like Lambda2");
        }
    }


    public static void main(String[] args) {
        ILike iLike = new Like();
        iLike.lambda();

        iLike = new Like2();
        iLike.lambda();


        //4、局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I like Lambda3");
            }
        }

        iLike = new Like3();
        iLike.lambda();


        //5、匿名内部类,没有类的名称，必须借助接口或者父类
        iLike = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like Lambda4");

            }
        };
        iLike.lambda();


        //6、用lambda简化，jdk1.8
        iLike = () -> {
            System.out.println("I like Lambda5");

        };
        iLike.lambda();

    }


}

//1、定义一个函数式接口
interface ILike {
    void lambda();
}

//2、实现类
class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("I like Lambda");
    }
}