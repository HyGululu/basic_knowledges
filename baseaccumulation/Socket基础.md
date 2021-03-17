Socket基础

基于TCP的Socket传输



TCP：传输控制协议、面向连接的协议，稳定可靠。网页注册账号、转账

UDP：qq

HTTP：基于TCP



TCP/IP协议组：分三层

网络层：IP协议、RARP协议、ICMP协议、ARP协议、BOOTP协议

传输层：TCP协议、UDP协议

应用层：FTP、HTTP、TELENT、SMTP、DNS



TCP和UDP区别

TCP：可靠；面向连接；速度慢；适用传输大量数据

UDP：不可靠；面向无连接；速度快；适用传输少量数据



HTTP协议，建立在请求/相应模型上的

HTTP/1.0，为每一次HTTP请求/响应建立一条新的TCP链接



三次握手过程：

第一次握手：客户端发送syn（syn=j）包给服务器，进入到SYN_SENT状态，等待服务器确认。 SYN（Synchronize Sequence Numbers）：同步序列编号

第二次握手：服务器接收到syn包，必须确认客户的SYN（ack=j+1），同时发送一个syn（syn=k）包，即syn+ack包，服务器进入SYN_RECV状态。ACK（acknowledgement）确认字符

第三次握手：客户端接收到服务器的syn+ack包，向服务器发送确认包ack（ack=k+1），这个包发送完毕，客户端和服务器就进入了establish状态（TCP链接成功），完成三次握手



四次挥手



Socket 是种连接模式

实现客户端和服务器之间的物理连接，并进行数据传输。主要有TCP、UDP两种协议。Socket处于网络协议的传输层。

可以创建TCP连接，或者UDP连接……



HTTP状态码

1XX，信息

2XX，成功

​	200 OK

​	204 Not Content：请求已经成功处理，不需要返回数据

​	206 Partial Content：范围请求，响应报文包含Content-Range指定范围实体内容

3XX，重定向

​	301 Moved Permanently ：永久性重定向

​	302 Found：临时性重定向

​	303 See Other：临时性重定向，需要Get方法获取资源

​	304 Not Modified：请求报文首部包含一些条件，不满足条件，服务器就会返回304

​	307 Temporary Redirect：临时重定向，浏览器不会改Post方法为Get

4XX，客户端错误

​	400 Bad Request：请求报文中存在语法错误

​	401Unauthorized：发送的请求需要认证信息（Basic认证、Digest认证），用户认证失败

​	403 Forbidden：请求被拒绝

​	404 NotFound

5XX，服务器错误

​	500 Internal Server Error :服务器正在执行请求时发生错误

​	503 Service Unavailable：服务器暂时处于超负载或正进行停机维护，无法处理请求