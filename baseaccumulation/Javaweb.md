Javaweb

Java Web包括四大核心知识点：
1.Spring的IOC和AOP等知识点、
2.Spring MVC框架的基本流程、
3.ORM技术（了解 Hibernate与MyBatis的基本开发流程）、
4.Spring MVC+MyBatis、
 Java Web可以延后学习的知识点：JSP、Struts MVC、JS、CSS等前端知识

# 1、基本概念

## 1、1前言

web开发：

web，网页的意思，www.baidu.com

静态web

​	html,css

​	提供给所有人看的数据始终不会发生变化

动态web

​		taobao,几乎所有网站

​		提供给所有人看的数据会变化，每个人不同时间不同地点看到的信息各不相同

​		技术栈：servlet/JSP、ASP、PHP

在java中，动态web资源开发的技术统称为Javaweb

## 1、2web应用程序

可以提供浏览器访问的程序

一个web程序包含：（静态web、动态web）

html、css、js

jsp、servlet

java程序

jar包

配置文件（Properties）

## 1、3静态web

*.html，请求--响应。服务器上有相应资源

轮播图，伪动态：JavaScript，VBScript，无法和数据库交互，无法数据持久化

# 2、web服务器

## 2、1web服务器

IIS（微软的web服务器，ASP，Windows中自带）

tomcat，应用服务器，工作3-5年后，可以手写tomca服务器

tomcat实际上是运行jsp页面的servlet

# 3、Tomcat

官网：https://tomcat.apache.org/download-90.cgi

## 3、4发布一个web网站

将网站，放到服务器tomcat中指定的web应用的文件夹（webapps）下，就可以访问了

# 4、Http

## 4.1什么是HTTP

超文本传输协议：请求-响应协议，运行在tcp之上

文本：html，字符串……

超文本：图片、音乐、视频、定位、地图……

http: 80

Https:443 安全的

## 4.2两个时代

http1.0

​	HTTP/1.0:客户端与web服务器连接后，只能获得一个web资源，断开连接

Http2.0

​	HTTP/1.1:客户端与web服务器连接后，可以获得多个web资源

## 4.3Http请求

客户端--发起请求Request--服务器

1.请求行

请求行中请求方式：GET

请求方式：Get、Post、Head、Delete、Put

get：一次请求能够携带的参数少，大小有限制，会在浏览器url栏显示数据内容，不安全，但是高效

post：一次请求能够携带的参数无限制，大小五限制，不会在浏览器url栏显示数据内容，安全，但是不高效

2.消息头

~~~java
请求
GET /home/xman/data/tipspluslist HTTP/1.1
Accept: text/plain, */*; q=0.01
Accept-Language: zh-cn
Host: www.baidu.com
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1.3 Safari/605.1.15
Referer: https://www.baidu.com/
Accept-Encoding: gzip, deflate, br
Connection: keep-alive
X-Requested-With: XMLHttpRequest
~~~

## 4.4Http响应

~~~java
HTTP/1.1 200 OK
Content-Type: text/html;charset=utf-8
Expires: Sat, 13 Mar 2021 12:08:49 GMT
Connection: keep-alive
Date: Sat, 13 Mar 2021 12:08:49 GMT
Content-Encoding: gzip
Content-Length: 78
Cache-Control: private
Vary: Accept-Encoding
Server: BWS/1.0
~~~

1、响应体

2、响应状态码

200：成功

3xx，请求重定向

4xx：资源不存在

​	400：找不到资源

5xx:服务器代码错误

​	502：网关错误 get back away



常见面试题：

当浏览器中输入地址并回车的一瞬间到页面能够展示回来，经历了什么？

500字的作文



# 5、Maven

为什么用这个技术？

1、在javaweb开发中，需要使用大量的jar包，我们需要手动导入，

2、如何能够让一个东西帮我们导入和配置这个jar包

于是，Maven诞生了

## 5.1Maven项目架构管理工具

目前是方便导入jar包

Maven核心思想：约定大于配置

有约束，不要违反

Maven会规定好如何编写java代码

5.2下载安装maven

官网：https://maven.apache.org，下载完成后解压

5.3配置环境变量

M2_HOME ： maven目录的bin目录

MAVEN_HOME：maven目录

系统环境变量Path：

测试：mvn -version

5.5阿里云镜像

镜像：方便下载使用，加速下载

settings文件推荐国内阿里云镜像

## 5.5本地仓库

settings文件建立一个本地仓库localRepo

5.6在idea中使用maven





