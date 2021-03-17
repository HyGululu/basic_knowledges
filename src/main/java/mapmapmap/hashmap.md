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