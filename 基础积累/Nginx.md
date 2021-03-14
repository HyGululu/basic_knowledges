Nginx

服务器

把请求转发，代理服务器维持配置关联，反向代理

给服务器加权重，负载均衡（如SpringCloud）

Nginx是一个高性能的，反向代理的，web服务器

官网：http://nginx.org

内存小、支持5万个并发（tomcat也就五六百）



## 正向代理

代理客户端，VPN ，比如请求香港服务器，香港服务器请求美国服务器

## 反向代理

代理服务器端，如百度的深圳的服务器、上海的服务器

## 负载均衡

轮询、加权轮询、轮重（权重）、

iphash （Session 放到Tomcat中，多个Tomcat不能session共享，redis做session共享，IP计算，固定ip永远打到对应服务器，session不会丢失，）

动静分离

# linux安装Nginx

# 常用命令

./nginx 

./nginx -s stop

./nginx -s reload

