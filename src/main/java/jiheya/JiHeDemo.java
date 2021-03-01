package jiheya;

import sun.java2d.pipe.AAShapePipe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class JiHeDemo {



    public static void main(String[] args) {
        //set
    /*
    1) HashSet 实现了 Set 接口，继承了 AbstractSet 类，由哈希表支持，看源码可以发现是一个 HashMap 实例。
    2) HashSet 不保证集合内元素的迭代顺序，特别是不保证迭代顺序永久不变，该集合运行 null 元素存在。
    3) HashSet 中的元素，作为 HashMap 键值对的 Key 存储，而 Value 由一个统一的值保存。
    4) HashSet 默认初始化大小为 16，扩容加载因子为 0.75，扩容大小为原来的一倍。即一个初始化size为16的
   HashSet，元素添加到12个的时候会进行扩容，扩容后的大小为32。
    备注：具体添加、读取、删除等规则需要参考 HashMap 的具体实现。
     */
        //查询速度最快的集合
        HashSet hashSet =new HashSet();
        TreeSet treeSet =new TreeSet();
        LinkedHashSet linkedHashSet =new LinkedHashSet();
        //list
    /*
    1) ArrayList 实现了 List 接口，继承了 AbstractList 类，由一个 Object[] 实例实现，即底层为数组结构；
    2) 默认初始化长度为 10(初始容量)，扩容规则为 0.5倍的原容量加1，即一次扩容后的长度为 16；
    3) 特点：查询速度快，添加、删除相对于LinkedList较慢、线程不同步(不安全)。
     */
        //动态数组;随机访问;非同步的
        ArrayList<String> myArrayList =new ArrayList();
        myArrayList.size();
        myArrayList.add("abc");
        //双向链表;不能随机访问;非同步的:如果多个线程同时访问一个List，则必须自己实现访问同步
        LinkedList linkedList =new LinkedList();
        //线程安全的动态数组;同步的
        Vector vector =new Vector();

        //map
    /*
     HashMap实现了 Map接口，继承了 AbstractMap类，数据结构采用的位桶数组，底层采用链表或红黑树进行存储；
    默认初始化长度为 16，扩容加载因子为 0.75，一旦大于 0.75*16之后，就会调用resize()进行扩容，扩容2倍，即32；
    JDK1.7中，数据结构采用：位桶数组+链表结构；
   JDK1.8中，数据结构采用：位桶数组+(链表/红黑树)；
    支持克隆，无序，线程不同步，非安全。
     */
        //哈希表数据结构
        HashMap hashMap = new HashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        TreeMap treeMap = new TreeMap();
        Hashtable hashtable = new Hashtable();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.reverse();
        stringBuilder.toString();
        stringBuilder.append(1);
        stringBuilder.indexOf("abc");
        stringBuilder.length();
        System.out.println("String Buffer 你好啊");
        StringBuffer stringBuffer = new StringBuffer("大家好，很高兴见到大家！");
        stringBuffer.append("你好啊！");
        stringBuffer.append("我们也很高兴见到你！");
        System.out.println(stringBuffer);
        stringBuffer.reverse();
        System.out.println("reverse反转："+stringBuffer);
        stringBuffer.delete(0,1);
        System.out.println("delete移除："+stringBuffer);
        stringBuffer.insert(3,"哈哈");
        System.out.println("insert插入："+stringBuffer);
        stringBuffer.replace(3,4,"嘿嘿");
        System.out.println("replace替换："+stringBuffer);
        stringBuffer.charAt(1);
        stringBuffer.indexOf("abc");
    }
}
