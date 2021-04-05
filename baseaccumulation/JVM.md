JVM（JAVA virtual machine）

jvm理解？

jvm8虚拟机有什么变化？

oom？栈溢出StackOverFlowError？怎么分析？

jvm常用调优参数？

内存快照如何抓取？怎么分析dump文件？

jvm类加载器的认识？rt.jar ext application



1、jvm的位置：

​		运行在操作系统上

2、jvm的体系结构

3、类加载器

​		作用：加载class文件  new Student(); （引用放到栈；具体实例放到堆）

​	1、虚拟机自带的加载器

​    2、启动类（根）加载器

​	3、扩展类加载器

​	4、应用程序加载器

4、双亲委派机制

```
classloader等级
1、虚拟机自带的加载器
2、启动类（根）加载器
3、扩展类加载器
4、应用程序加载器
```

5、沙箱安全机制

​	权限，安全隐患	

6、Native

7、PC寄存器

8、方法区

```
静态变量（static、final）Class模板、常量、类信息（构造方法、接口定义）、运行时的常量池存在方法区，
但是 实例变量存在堆内存中，与方法区无关
```

9、栈

10、三种jvm（Hotspot）

11、堆

​		一个

12、新生区、老年区

13、永久区

14、堆内存调优

15、GC

​		1、常用算法

16、JMM



学习方案：

1、百度

2、思维导图



单点登录--SSO





# 内存结构概述

## JMV架构图

![image-20210227191729641](/Users/guhuiyuan/Library/Application Support/typora-user-images/image-20210227191729641.png)

![image-20210227192008410](/Users/guhuiyuan/Library/Application Support/typora-user-images/image-20210227192008410.png)

# 类加载器类加载过程

## 类加载子系统的作用

![image-20210227192124003](/Users/guhuiyuan/Library/Application Support/typora-user-images/image-20210227192124003.png)

## 类加载过程

![image-20210227192821597](/Users/guhuiyuan/Library/Application Support/typora-user-images/image-20210227192821597.png)

### 类加载过程一：加载Loading

### 类加载过程二：链接Linking

验证Verification

准备Preparation

解析Resolution

### 类加载过程三：初始化Initialization

## 类加载器的分类

![image-20210227201159019](/Users/guhuiyuan/Library/Application Support/typora-user-images/image-20210227201159019.png)

# java反编译的命令 javap -v 

jclasslib插件放到idea中



# JVM知识体系

java从编译到执行

javac  编译

java  执行

JVM：

跨语言的平台，任何语言只要能编译成class就能在jvm上运行

是一种规范；虚拟出来的机器（cpu、寄存器……）

The Java® Virtual Machine Specification

https://docs.oracle.com/en/

https://docs.oracle.com/javase/specs/index.html

![image-20210314181515637](/Users/guhuiyuan/Library/Application Support/typora-user-images/image-20210314181515637.png)



常见的JVM实现：Hotspot、Jrockit、J9

Class FIle Format Class文件格式：

二进制字节流

很多方法观察bytezcode：javap -v反编译

常量池的几种主要类型

翻译Java虚拟机规范手册