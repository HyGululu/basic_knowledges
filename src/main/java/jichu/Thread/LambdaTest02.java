package jichu.Thread;


/**
 * 带参数的Lambda表达式
 *
 * 多线程的Runnable接口：函数式接口
 */
public class LambdaTest02 {
    //3、静态内部类
    static class Love2 implements ILove {
        @Override
        public void love(int a) {
            System.out.println("I Love you2: " + a);
        }
    }

    public static void main(String[] args) {
        ILove love = new Love();
        love.love(2);

        love = new Love2();
        love.love(2);

        //4、局部内部类
        class Love3 implements ILove {
            @Override
            public void love(int a) {
                System.out.println("I Love you3: " + a);
            }
        }
        love = new Love3();
        love.love(2);


        //5、匿名内部类
        love = new ILove() {
            @Override
            public void love(int a) {
                System.out.println("I Love you4: " + a);
            }
        };
        love.love(3);

        //6、Lambda表达式
        love = (int a) -> {
            System.out.println("I Love you5: " + a);
        };
        love.love(520);


        //7、再  简化1,去掉参数类型
        love = (a) -> {
            System.out.println("I Love you6: " + a);
        };
        love.love(5202);


        //8、再  简化2,去掉括号
        love = a -> {
            System.out.println("I Love you7: " + a);
        };
        love.love(521);


        //9、再  简化3,去掉花括号
        love = a ->
                System.out.println("I Love you8: " + a);
        love.love(521521);
        //总结：
            //Lambda表达式只能有一行代码的情况下才能简化成一行，如果有多行，那么就用代码块包裹
            //前提接口是函数式接口
            //多个参数也可以去掉参数类型，要去掉都去掉



    }
}


//1、定义一个接口
interface ILove {
    void love(int a);
}

//2、实现类
class Love implements ILove {
    @Override
    public void love(int a) {
        System.out.println("I Love you1: " + a);
    }
}