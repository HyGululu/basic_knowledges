package shuju;

/**
 * 数据类型扩展
 */
public class Demo3 {
    public static void main(String[] args) {
        //整数拓展：进制  二进制0b  十进制  八进制0  十六进制0x
        int i = 10;
        int i1 = 010;  //八进制0
        int i2 = 0x10; //十六进制0x  0-9  A-F 16  应该是16
        int i3 = 0x11; //十六进制0x  0-9  A-F 16  应该是17

        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println("============浮点数================");

        //浮点型拓展  银行业务怎么表示？  BigDecimal数学工具类
        //float  有限 离散  含有误差 大约 接近但是不等于
        //double
        //最好完全避免使用浮点数进行比较！！
        //最好完全避免使用浮点数进行比较！！
        //最好完全避免使用浮点数进行比较！！

        float f = 0.1f; //0.1
        double d = 1.0 / 10;  //0.1

        System.out.println(f == d);  //false
        System.out.println(f);
        System.out.println(d);

        float d1 = 23232222222233333333f;
        float d2 = d1 + 1;
        System.out.println(d1 == d2);  //true
        System.out.println("==========字符拓展=====");
        //字符拓展
        char c1 = 'a';
        char c3 = 'A';
        char c2 = '中';
        System.out.println(c1);
        System.out.println((int) c1);//强制转换，成数字
        System.out.println(c2);
        System.out.println((int) c2);//强制转换
        System.out.println((int) c3);//强制转换
        //所有的字符本质还是数字
        //编码 Unicode 表：97=a 65=A  2字节 长度0-65536  Excel最长只有2的16次方，也就是65536

        //U0000 UFFFF
        char c4 = '\u0061';
        System.out.println(c4);//a

        //转义字符
        //\t  制表符
        //\n  换行
        System.out.println("Hello\tWorld");
        System.out.println("Hello\nWorld");

        //对象，从内存分析？？
        System.out.println("==================");
        String sa = new String("hello world");
        String sb = new String("hello world");
        System.out.println(sa == sb);//不相等

        String sc = "hello world";
        String sd = "hello world";
        System.out.println(sc == sd);//相等

        //布尔值扩展
        boolean flag = true;
        if (flag==true){}
        if (flag){}  //less is more  代码要精简易读


    }
}
