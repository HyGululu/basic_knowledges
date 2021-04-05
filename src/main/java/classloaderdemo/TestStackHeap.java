package classloaderdemo;

/*
对象在内存中实例化的过程
一个小例子来对堆栈进行更深一步的了解

str1 ==str2    true;     ①
str2 ==str3    false;     ②
str3 ==str4    false；    ③
str1 == str5  false;       ④
str1.equals(str5)   true;   ⑤
str1==str6        true;   ⑥

 */
public class TestStackHeap {
    public static void main(String[] args) {
        String str = "a";
        String strr = "bc";

        String str1 = "abc";     //定义字符串变量str1
        String str2 = "abc";      //定义字符串变量str2
        String str3 = new String("abc"); //以new的方式定义字符串变量str3
        String str4 = new String("abc");//以new的方式定义字符串变量str4

        String str5 = str + strr;

        String str6 = "a" + "bc";

        System.out.println(str1==str2);//true
        System.out.println(str2==str3);//false
        System.out.println(str3==str4);//false
        System.out.println(str1==str5);//false
        System.out.println(str1.equals(str5));//true
        System.out.println(str1==str6);//true

    }
}
/*
‘==’比较的是地址
       Str1 和 str2显然指向的是String中常量池中的一个地址
·equals比较的是内容

①  由于地址相同，所以true
②  由于str3 使用的new ，相当于在String类堆中创建了一个堆地址。而str2的地址则是在常量池中。地址对不上，因此false
③  和②的原理是一样的，相当于new了两个对象，也就是各自拥有了自己的地址。因此false。
④  str5使用的是字符串变量的相加。当看String的源码的时候，你会发现str.append()方法。本质上是先new 一个Stringbuilder对象，然后使用这个对象进行append，最后Builder对象toStirng回到String类型。也就是地址发生了变化。
结果：
⑤  比较的是内容，所以为true
⑥  也许看到这个会感到迷茫，一开始我也迷茫。后来一想，这种情况str6则是在常量池中进行的拼接（若存在，则直接指向；若不存在，拼接创建）
 */