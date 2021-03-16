public class HelloDataDemo {
    static boolean bool;
    static byte by;
    static char ch;
    static double d;
    static float f;
    static int i;
    static long l;
    static short sh;
    static String str;

    public static void main(String[] args) {
        /*
        int和Integer 有什么区别，还有Integer缓存的实现
这里考察3个知识点吧：
int 是基本数据类型，interger 是 int 的封装类
int 默认值为 0 ，而interger 默认值为 null， Interger使用需要判空处理
Integer的缓存机制：为了节省内存和提高性能，
Integer类在内部通过使用相同的对象引用实现缓存和重用，
Integer类默认在-128 ~ 127 之间，可以通过 -XX:AutoBoxCacheMax进行修改，
且这种机制仅在自动装箱的时候有用，在使用构造器创建Integer对象时无用。
         */
        Integer num1 = 12;
        Integer num2 = 12;

        Integer num3 = 127;
        Integer num4 = 127;

        System.out.println(num1.equals(num2));
        System.out.println(num3.equals(num4));


        System.out.println("========================");
        //byte
        System.out.println("基本数据类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();
        //short
        System.out.println("基本数据类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();
        //int
        System.out.println("基本数据类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();
        //long
        System.out.println("基本数据类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();
        //float
        System.out.println("基本数据类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();
        //double
        System.out.println("基本数据类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();
        //char
        System.out.println("基本数据类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        //以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE=" + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE=" + (int) Character.MAX_VALUE);
        System.out.println();
        System.out.println("========================");

        System.out.println("============默认值============");
        System.out.println("Boolean :" + bool);
        System.out.println("Byte :" + by);
        System.out.println("Character:" + ch);
        System.out.println("Double :" + d);
        System.out.println("Float :" + f);
        System.out.println("Integer :" + i);
        System.out.println("Long :" + l);
        System.out.println("Short :" + sh);
        System.out.println("String :" + str);
        System.out.println("============默认值============");

        String str = "abcabcabc";
        for (int j = 0; j < str.length(); j++) {
            System.out.println(str.charAt(j));

        }
    }
}
/*
Float和Double的最小值和最大值都是以科学记数法的形式输出的，
结尾的"E+数字"表示E之前的数字要乘以10的多少次方。
比如3.14E3就是3.14 × 103 =3140，3.14E-3 就是 3.14 x 10-3 =0.00314。
 */