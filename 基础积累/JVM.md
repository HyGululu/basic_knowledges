JVM

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