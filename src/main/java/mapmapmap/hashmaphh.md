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