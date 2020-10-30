**GC**
JVM在进行GC时候，并不是对这三个区域统一回收，大部分时候，回收都是新生代
新生代
幸存区（from，to）
老年区

GC两种类型
轻GC（普通的GC）
重GC（全局GC）


每次GC都会将Eden的活的对象移到幸存区，一旦Eden被GC后，就会是空的
谁空谁是to

jvm设定GC老年代参数，进入老年代的时间
-XX:MaxTenuringThreshold=15
当一个对象经历了15次GC，就会进入old区

题目：
JVM的内存模型和分区，详细到每个区放什么
堆里面分区有哪些：Eden、from、to、old，说出他们的特点
轻GC和重GC分别在什么时候发生


GC算法：
标记清除法
标记整理（标记压缩）
复制算法：from和to区，相同时，从一个区复制到另一个区
引用计数器：计数器本身也会消耗

复制算法
好处：没有内存的碎片
坏处：浪费了内存空间，多了一半空间永远是空to，
假设对象100%存活（极端情况下）
复制算法适合对象存活率低的情况，Eden from to

标记清除法
标记：扫描活着的对象，进行标记，标记要占内存
清除：扫描对没有标记的对象进行清除，清除后就坑坑洼洼内存碎片
缺点：两次扫描，严重浪费时间，会产生内存碎片
优点：不需要额外的空间

标记压缩法
防止内存碎片
再次扫描，向一端移动存活的对象
缺点：多了个移动成本

总结：
内存效率：复制算法>标记清除算法>标记压缩算法（时间复杂度）
内存整齐度：复制算法=标记压缩算法>标记清除算法
内存利用率:标记压缩算法=标记清除算法>复制算法

找到最合适的算法--**GC分代收集算法**：
年轻代：存活率低，复制算法
老年代：区域大，存活率高，标记清除（内存碎片不是太多）+标记压缩混合实现


参考书《深入理解JVM》

JMM：java memory model
java内存模型