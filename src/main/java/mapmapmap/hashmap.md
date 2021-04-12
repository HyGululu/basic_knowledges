
了解认识HashMap，集合、散列表、数据结构
HashMap是一个非常重要的集合
HashMap本质上是个散列表，
散列表涉及到散列函数、哈希冲突、扩容方案
同时HashMap作为一个数据结构，需要考虑多线程并发访问的问题，也就是线程安全

学习目录：
哈希函数
哈希冲突解决方案
扩容方案
线程安全
源码解析
其他问题

HashMap是Map集合体系的一部分，
同时继承了serializable接口可以被序列化
继承了Cloneable接口可以被复制
public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable{}
public abstract class AbstractMap<K,V> implements Map<K,V> {}

HashMap不是全能的，就使用其他Map类
如线程安全的ConcurrentHashMap、记录插入顺序的LinkHashMap、给key排序的TreeMap等

发散：散列表？

哈希函数
目标是计算key在数组中的下标
判断一个哈希函数的标准是：散列是否均匀、计算是否简单
HashMap哈希函数的步骤：
1、对key对象的hashcode进行扰动
2、通过取模求得数组下标
扰动是为了让hashcode的随机性更高，第二步取模就不会让所有的key都聚集在一起，提高散列均匀度
扰动可以看hash()方法
static final int hash(Object key) {
        int h;
        // 获取到key的hashcode，在高低位异或运算
        return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
    }
低于16位和高于16位进行异或，高16位保持不变。
取模运算的源码看到putVal()方法，该方法在put()方法中被调用
final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        ……
        //与数组长度-1进行位与运算，得到下标
        //检查table中位置为(n -1 ) & hash 是否为空，如果为空，直接放入（这是放在数组里）
        if ((p = table[i = n - 1 & hash]) == null) {
           ……
    }
onlyIfAbsent  如果当前位置已存在一个值，是否替换，false是替换，true是不替换
evict  表是否在创建模式，如果为false，则表是在创建模式。

HashMap的数组长度为2的整数次幂，修改数组长度有两种情况：
1、初始化时指定长度
2、扩容时的长度增量

默认情况下，如未在HashMap构造器中指定长度，则初始长度是16
扩容大小是原来的两倍
    final HashMap.Node<K, V>[] resize() {
            ……
        if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY  && oldCap >= DEFAULT_INITIAL_CAPACITY) {
                        // 设置为原来的两倍
                        newThr = oldThr << 1;
                    }
             ……
    }

哈希函数小结：
HashMap通过高16位与低16位进行异或运算来让高位参与散列，提高散列效果；
HashMap控制数组的长度为2的整数次幂来简化取模运算，提高性能；
HashMap通过控制初始化的数组长度为2的整数次幂、扩容为原来的2倍来控制数组长度一定为2的整数次幂。

哈希冲突解决方案
指的是两个不同的key经过hash计算之后得到的数组下标是相同的
解决hash冲突的方式很多，如开放定址法、再哈希法、公共溢出表法、链地址法
HashMap采用的是链地址法，jdk1.8之后还增加了红黑树的优化
出现冲突后会在当前节点形成链表，而当链表过长之后，会自动转化成红黑树提高查找效率
红黑树是一个查找效率很高的数据结构，时间复杂度为O(logN)，但红黑树只有在数据量较大时才能发挥它的优势。
关于红黑树的转化，HashMap做了以下限制
当链表的长度>=8且数组长度>=64时，会把链表转化成红黑树。
当链表长度>=8，但数组长度<64时，会优先进行扩容，而不是转化成红黑树。
当红黑树节点数<=6，自动转化成链表
哈希冲突解决方案小结：
HashMap采用链地址法，当发生冲突时会转化为链表，当链表过长会转化为红黑树提高效率。
HashMap对红黑树进行了限制，让红黑树只有在极少数极端情况下进行抗压。

扩容方案
什么时候进行扩容？由HashMap的一个关键参数控制：装载因子，是个阈值
static final float DEFAULT_LOAD_FACTOR = 0.75F
如数组长度是16，装载因子是0.75，那么可容纳的节点数是16*0.75=12
装载因子越大，数组利用率越高，同时发生哈希冲突的概率也就越高；
装载因子越小，数组利用率降低，但发生哈希冲突的概率也降低了

线程安全
HashMap作为一个集合，主要功能则为CRUD，也就是增删查改数据，那么就肯定涉及到多线程并发访问数据的情况。
jdk1.7及以前扩容时采用的是头插法，这种方式插入速度快，但在多线程环境下会造成链表环，而链表环会在下一次插入时找不到链表尾而发生死循环。
关于这个问题，jdk1.8之后扩容采用了尾插法，解决了这个问题，但并没有解决数据的一致性问题。
那如果结果数据一致性问题呢？解决这个问题有三个方案：
采用Hashtable
调用Collections.synchronizeMap()方法来让HashMap具有多线程能力
采用ConcurrentHashMap

前两个方案的思路是相似的，均是每个方法中，对整个对象进行上锁。
Hashtable是老一代的集合框架，很多的设计均以及落后，他在每一个方法中均加上了synchronize关键字保证线程安全
第二种方法是返回一个SynchronizedMap对象，这个对象默认每个方法会锁住整个对象
public static <K, V> Map<K, V> synchronizedMap(Map<K, V> var0) {
        return new Collections.SynchronizedMap(var0);
    }
可以看到默认锁的就是本身，效果和Hashtable其实是一样的。这种简单粗暴锁整个对象的方式造成的后果是：
锁是非常重量级的，会严重影响性能。
同一时间只能有一个线程进行读写，限制了并发效率

ConcurrentHashMap的设计就是为了解决此问题。
他通过降低锁粒度+CAS的方式来提高效率。
简单来说，ConcurrentHashMap锁的并不是整个对象，而是一个数组的一个节点 ，那么其他线程访问数组其他节点是不会互相影响，极大提高了并发效率；同时ConcurrentHashMap读操作并不需要获取锁

hashmap的原理？
HashMap基于hashing原理，我们通过put()和get()方法储存和获取对象
当我们将键值对传递给put()方法时，它调用对象的hashCode()方法来计算hashcode，让后找到bucket位置来储存值对象
当获取对象时，通过键对象的equals()方法找到正确的键值对，然后返回值对象

碰撞
HashMap使用链表来解决碰撞问题，当发生碰撞了，对象将会储存在链表的下一个节点中
HashMap在每个链表节点中储存键值对对象
当两个不同的键对象的hashcode相同时会发生什么？ 
它们会储存在同一个bucket位置的链表中。键对象的equals()方法用来找到键值对
数组的长度有限制，有限的长度使用哈希，一定的概率会hash相同，hash到同一个值上，形成链表

put操作，根据哈希算法计算数组下标值

计算索引、逻辑判断
扩容
链表
红黑树

Node的源码
static class Node<K,V> implements Map.Entry<K,V>(){
     final int hash;
     final K key;
     V value;
     Node <K,V> next;
     ……
}
新的entry插入方法，java8前是头插法：新来的数据取代原有值，所有原有值顺推到链表里，Java8后用尾部插入
HashMap的扩容机制，数组容量有限，到达一定数量需要扩容，resize
什么时候resize，两个因素：Capacity：HashMap当前长度；Loadfactor：负载因子默认值0.75f；
 比如当前容量大小是100，存入到76个时，判断需要resize
怎么扩容？两步：扩容；rehash
     扩容：创建一个新的entry，长度是原来的数组的2倍
     rehash：遍历原来的entry数组，把所来的entry重新hash到新的数组   长度扩大后hash规则也变动了，所以需要rehash而不是直接复制到新数组
          hash公式，index=hashcode（key）*（length-1）
java8后改成尾插法


HashMap共有4个构造函数:
//默认构造函数。
HashMap()
// 指定“容量大小”的构造函数
HashMap(int capacity)
// 指定“容量大小”和“加载因子”的构造函数
HashMap(int capacity, float loadFactor)
// 包含“子Map”的构造函数
HashMap(Map<? extends K, ? extends V> map)

HashMap的API
void                 clear()
Object               clone()
boolean              containsKey(Object key)
boolean              containsValue(Object value)
Set<Entry<K, V>>     entrySet()
V                    get(Object key)
boolean              isEmpty()
Set<K>               keySet()
V                    put(K key, V value)
void                 putAll(Map<? extends K, ? extends V> map)
V                    remove(Object key)
int                  size()
Collection<V>        values()

存储内容：key value
存储结构：数组+链表+红黑树（jdk8）
存储位置：数组下标
存储大小：数组长度

常见的数据结构
数组和链表组合构成
每个数组里都存了key-value的实例，Java7叫entry；Java8叫node

自定义一个java.util.HashMap的类，包名与类名相同，是否能够编译通过？如果编译通过，加载的是哪一个HashMap类？为什么？
参考答案：可以编译。引用Java的自带的HashMap。Java的双亲委派机制，先加载Java的