public class HelloDataDemo {
    public static void main(String[] args) {
        int i = 12;
        double d = 12d;
        float f= 12f;
        long l=12L;
        byte b = 12;
        char c = 12;
        short s = 12;
        boolean flag =true;


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
        Integer num1 =12;
        Integer num2 =12;

        Integer num3 =127;
        Integer num4 =127;

        System.out.println(num1.equals(num2));
        System.out.println(num3.equals(num4));
    }
}
