package shuju;

public class IntegerDemo {
    public static void main(String[] args) {
        Integer num = Integer.valueOf(12);
        System.out.println(num);

        Integer num1 = 88;
        Integer num2 = 88;
        System.out.println("num1==num2 " + (num1.equals(num2)));

        Integer num3 = 880;
        Integer num4 = 880;
        System.out.println("num3==num4 " + (num3==num4));

        boolean b = Integer.valueOf(12) == Integer.valueOf(12);
        System.out.println("结果是："+b);


    }
}
