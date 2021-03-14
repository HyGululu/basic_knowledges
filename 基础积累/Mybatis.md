前提：

JDBC（简化了JDBC操作、事务）

Mysql

Java基础（封装继承工具类）
Maven

Junit



框架：配置文件，看官网

# 1、简介

## 1、1什么是Mybatis

持久层框架



如何获得Mybatis

Github、中文文档



## 1、2持久化

数据持久化

​	持久化，程序的数据持久状态和瞬时状态转化的过程

​	内存：断电即失

​    数据库（JDBC）、io文件持久化



为什么需要持久化？内存断电即失

​	有些数据对象不想让它丢失

​	内存太贵了



## 1、3持久层

Dao层、Service层、Controller层……

​	完成持久化工作的代码块

​	层界限非常明显

## 1、4为什么需要Mybatis

​	帮助程序将数据存到数据库	

​	方便

​	传统的JDBC代码太复杂了，简化、框架

​	不用Mybatis也可以，但Mybatis更容易上手

​	优点：

​		简单易学、灵活

​		sql和代码分离，提高可维护性

​		提供映射标签，支持对象和数据库的orm字段关系映射

​		提供xml标签，支持编写动态sql

​	最重要的一点：使用的人多

# 2、第一个Mybatis程序

思路：搭建环境--导入Mybatis--编写代码--测试

​	搭建数据库：表、数据准备

​	新建项目：

​		1、新建一个maven项目

​		2、删除src目录，这样就是一个父工程

​		3、导入依赖：Mybatis、mysql驱动、Junit

## 2、2创建一个模块

new model

​	编辑Mybatis核心配置文件：mybatis-config.xml

​		事务管理用的JDBC

​	编写Mybatis工具类，获取sqlSessionFactory对象，链接数据库

​		utils：MybatisUtils

## 2、3编写代码

​    实现类

​	Dao接口

​	接口实现类（mapper.xml）



可能遇到的问题：

​	1、配置文件没有注册

​	2、绑定接口错误

​	3、方法名不对

​	4、返回类型不对

​	5、Maven导出资源问题



Map和模糊查询

Map传递参数直接在sql中取出key就可以

模糊查询怎么写？1、java代码执行的时候，传通配符%% 2、在sql拼接中使用通配符

# 4、配置解析

1、核心配置文件

mybatisconfig.xml

mybatis默认事务管理器JDBC，连接池POOLED

属性优化

别名优化

## 7、映射器mappers

方式一，resource

方式二，class

方式三，package