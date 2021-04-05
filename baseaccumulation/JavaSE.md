JavaSE && JavaEE


JavaEE 号称有十三种核心技术。
一般来讲，初学者应该遵循路径 JDBC -> Servlet -> JSP -> Spring -> 组合框架

1、JDBC：JAVA 操作数据库 
2、Tomcat：常见的免费 web 服务器 
3、Servlet：用于处理用户提交的数据 
4、JSP：可以写 java 代码的 html
 5、Spring 
6、SpringMVC 
7、MyBatis



JavaSe

# Java语言初始，第一个贪吃蛇

准备工作：注册博客，写知识点；markdown语法；doc命令；计算机语言发展史；java诞生（1995）

1995：Java SE、Java ME、Java EE

2006：Hadoop

JDK：开发者工具包；配置环境变量（JavaHome）

JRE：运行环境

# Helloworld

~~~java
public class Hello{
  public static void main(String[] args){
    System.out.println("Hello !");
  }
}
~~~

javac：编译java文件

java：执行class文件

强类型语言，大小写敏感；编译型语言&解释性语言；动态语言&静态语言

IDEA

# 基础语法

注释：行内注释；多行注释；文档注释/***/ :javadoc生成帮助文档

标识符：关键字

数据类型：8个基本数据类型+引用数据类型

（整数：int默认4个字节、long 8个字节、short 2个字节、byte 1个字节；

浮点数：float 4个字节、double 默认8个字节；

字符：char 2个字节；布尔值：boolean 1位）

字符char的类型ASCII、utf-8、unicode；转义符\u0000;\b;\t

金融用的浮点数，bigdecimal

引用数据类型：类、接口、数组

类型转换：自动类型转换（低转高（字节数||子类父类））；强制类型转换

