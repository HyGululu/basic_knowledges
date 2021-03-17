Java集合框架 Collections framework
集合代表一组对象，集合理解成微型数据库，”增删改查“四种操作，搞清楚，时间空间复杂度
两大基类Collection与Map，这两个接口
Collection 表示一组纯数据
Map  表示一组key-value对

常用的三大类集合：Set、List、Map
List ：实现类 ArrayList、LinkedList、Vector、Stack
Set：HashSet、TreeSet、LinkedHashSet、EnumSet
Map：HashMap、HashTable、TreeMap、WeakHashMap

1、List、Set都是继承自Collection接口，Map则不是
2、List特点：元素有放入顺序，元素可重复 ，
Set特点：元素无放入顺序，元素不可重复，重复元素会覆盖掉，
（注意：元素虽然无放入顺序，但是元素在set中的位置是有该元素的HashCode决定的，
其位置其实是固定的，加入Set 的Object必须定义equals()方法 ，
另外list支持for循环，也就是通过下标来遍历，也可以用迭代器，
但是set只能用迭代，因为他无序，无法用下标来取得想要的值。） 
3、Set和List对比： 
Set：检索元素效率低下，删除和插入效率高，插入和删除不会引起元素位置改变。 
List：和数组类似，List可以动态增长，查找元素效率高，插入删除元素效率低，因为会引起其他元素位置改变。 
4、Map适合储存键值对的数据
5、线程安全集合类与非线程安全集合类 :
LinkedList、ArrayList、HashSet是非线程安全的，Vector是线程安全的;
HashMap是非线程安全的，HashTable是线程安全的;


ArrayList线程不安全的两种体现：
数组越界异常 ArrayIndexOutOfBoundsException：在多个线程进行add操作时可能会导致elementData数组越界
元素值覆盖和为空问题：设置值的操作同样会导致线程不安
ArrayList线程安全处理四种方式：
* 1、Collections.synchronizedList
* 2、为list.add()方法加锁synchronized？
* 3、CopyOnWriteArrayList
* 4、使用ThreadLocal？


Set集:继承于Collection的接口;不包括重复元素的
1) Set 集合属于单列集合，不允许包含重复元素；
2) 判断元素是否重复的标准为对象的 equals 方法，存在时返回 false，不存在返回 true；
3) 元素的排序规则，由相应的实现类决定，分为无序、元素大小排序、写入顺序排序；
4) 初始化大小，扩容参考 HashMap。

List集合:继承于Collection的接口;是有序的队列;允许有重复的元素
1) List 集合属于单列、有序的、允许元素重复、可以为 null 的集合；
2) List 接口的实现类主要有三种：ArrayList、LinkedList、Vector。

Map集合:列键值对组成的集合，提供了key到Value的映射
1) Map 集合属于双列Key-value键值对的集合，Key不允许重复，是否允许为 null 根据实现类而定，Value 随意；
2) Map 接口的实现类主要有三种：HashMap、LinkedHashMap、TreeMap、Hashtable、ConcurrentHashMap。


StringBuffer是线程安全，而StringBuilder不是线程安全的
（原因大家肯定也知道，StringBuffer中的方法都加了synchronized关键字）
所以网上很多资料都说，多线程不要用StringBuilder，否则会出现问题
通过一个char数组存储字符串的，
不同的是String类里面的char数组是final修饰的，是不可变的，
而StringBuilder和StringBuffer的char数组是可变的。
StringBuilder的append方法调用了父类的append方法,count += len; 不是一个原子操作
String：
* String类是一个不可变的类，一旦创建就不可以修改。
* String是final类，不能被继承
* String实现了equals()方法和hashCode()方法
StringBuffer：
* 继承自AbstractStringBuilder，是可变类。
* StringBuffer是线程安全的
* 可以通过append方法动态构造数据。
StringBuilder：
* 继承自AbstractStringBuilder，是可变类。
* StringBuilder是非线性安全的。执行效率比StringBuffer高。