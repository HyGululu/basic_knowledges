对象创建的过程

![img](https://pic2.zhimg.com/80/v2-9cd31ab516bd967e1b8e68736931f8ba_1440w.jpg?source=1940ef5c)



![img](https://pic2.zhimg.com/80/v2-eddc430b991c58039dfc79dd6f3139cc_1440w.jpg?source=1940ef5c)

1、加载类（

​	ClassLoader加载.class文件到内存

​	执行静态代码块和静态初始化语句）

2、执行new，申请一片内存空间

3、调用构造器，创建一个空白对象

4、子类调用父类构造器

5、构造器执行（

​	执行构造代码块和初始化语句

​	构造器内容）

创建一个实例，关键的是得到Class对象

Class对象包含一个类的所有信息（构造器、方法、字段）