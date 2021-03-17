Nginx

Nginx功能丰富，可作为HTTP服务器，也可作为反向代理服务器，负载均衡服务器

把请求转发，代理服务器维持配置关联，反向代理
当客户端发出请求到Nginx服务器时，Nginx服务器需将它配置好的规则由客户端发来的请求并转发到后端的LAMP、Tomcat、LNMP上


给服务器加权重，负载均衡（如SpringCloud）

Nginx是一个高性能的，反向代理的，web服务器

官网：http://nginx.org

内存小、单台支持5万个并发连接数（tomcat也就五六百）


## 正向代理

代理客户端，VPN ，比如请求香港服务器，香港服务器请求美国服务器

## 反向代理

代理服务器端，如百度的深圳的服务器、上海的服务器

正向代理和反向代理的区别：
1、正向代理：类似我们想要访问国外的Google服务器，但是由于访问限制，我们需要找一个代理去访问。换句话说，客户端明确知道要访问的服务器的地址，客户端把请求发送给代理，代理转发给服务器，服务器把响应传给代理，最后代理把响应传给客户端。我们可以看到客户端知道服务器是谁，但是服务器并不知道客户端是谁，这就是正向代理，隐藏了客户端的真实信息。
 2、反向代理：类似我们访问淘宝，由于访问量巨大，淘宝会使用许多台服务器（就是分布式服务器）来支持，但是每个客户端的请求到底由哪一台服务器来响应，我们需要一个代理来决定。换句话说，客户端并不知道要把请求发送给哪一台服务器，但是知道发送给哪一个代理，然后代理依据规则（响应时间，负载均衡等）决定把请求转发给哪一台服务器。可以看到，客户端并不知道他访问的服务器是谁，这就是反向代理，隐藏了服务器的真实信息

## 负载均衡

轮询(默认)
weight
ip_hash ，解决session的问题
（Session 放到Tomcat中，多个Tomcat不能session共享，redis做session共享，IP计算，固定ip永远打到对应服务器，session不会丢失，）
动静分离

# linux安装Nginx
安装支持软件
Nginx 的配置及运行需要pcre、zlib软件包的支持，需先安装这些软件的开发包供相应的库和头文件，以此来确保 Nginx 的顺利安装
#yum -y install pcre-devel zlib-devel

创建运行用户、组
Nginx 服务程序默认以noboby身份运行，这里建议大家创建新的用户账号，更准确的控制访问权限、增加灵活性、降低安全风险
#useradd -M -s /sbin/nologin nginx

下载编译安装
配置 Nginx 的编译选项时，将安装目录设为/usr/local/nginx，运行用户和组均设为nginx；启用http_stub_status_module模块以支持状态统计，便于查看服务器的连接信息
#wget http://nginx.org/download/nginx-1.17.0.tar.gz
# tar zxf nginx-1.17.0.tar.gz
# cd nginx-1.17.0
# ./configure --prefix=/usr/local/nginx --user=nginx --group=nginx --with-http_stub_status_module
# make && make install

为主程序 Nginx 创建链接文件
# ln -s /usr/local/sbin/nginx /usr/local/sbin/
# ls -l /usr/local/sbin/nginx
lrwxrwxrwx. 1 root root 21 6月   4 07:31 /usr/local/sbin/nginx -> /usr/local/sbin/nginx

安装好之后，进入默认安装路径到sbin目录下，执行nginx即可启动
# cd /usr/local/nginx/sbin/
# pwd
/usr/local/nginx/sbin
# ./nginx 
# nginx

监听 Nginx 程序的状态
# netstat -anpt | grep nginx
tcp        0      0 0.0.0.0:80                  0.0.0.0:*       

查看系统 Nginx 用户
#ps aux|grep nginx|grep -v grep
查看系统cpu数量
#cat /proc/cpuinfo |grep 'processor'|wc -l
查看pid
#ps aux|grep nginx


使用 Nginx 服务脚本
可编写Nginx服务脚本，使用chkconfig和service工具进行统一管理；

如果修改了Nginx的配置文件，可通过./nginx -s reload命令加载Nginx配置文件。
# ./nginx -s reload

配置nginx
1、选择一台线下服务器作为线下nginx
2、将线上nginx配置文件拷到线下
/etc/nginx/conf.d
3、修改配置文件/etc/nginx/conf.d/集群名_upstream.conf
将server ip和端口改为web站点的线下服务器的ip和端口
4. 加载nginx配置
nginx -t
nginx -s reload 启动nginx

nginx里有epoll
2、nginx命令
nginx -t  检查配置文件
nginx -s reload 启动nginx
修改配置文件后，先执行nginx -t，提示success后再执行nginx -s reload
nginx -c /opt/soft/nginx/main-conf/nginx.conf 指定配置文件

一个站点配置多个域名：server_name后跟多个域名即可，多个域名之间用空格分隔
server {
    listen       80;
    server_name  ops-coffee.cn b.ops-coffee.cn;
}
# 常用命令

./nginx 
./nginx -s stop
检查配置文件 nginx -t
重启nginx：
./nginx -s reload
nginx -s reload

查看机器上是否安装了nginx：
#rpm -qa|grep nginx

修改配置文件后，先执行nginx -t，提示success后再执行nginx -s reload
nginx -c /opt/soft/nginx/main-conf/nginx.conf 指定配置文件

ps.
俄罗斯，第二站点开发的
nginx里有epoll